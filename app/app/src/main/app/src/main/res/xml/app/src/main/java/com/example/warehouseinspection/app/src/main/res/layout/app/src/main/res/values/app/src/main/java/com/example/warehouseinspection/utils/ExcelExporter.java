package com.example.warehouseinspection.utils;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExcelExporter {
    public static File exportToCsv(Context ctx, List<String[]> rows, String filename) throws IOException {
        File folder = new File(ctx.getExternalFilesDir(null), "exports");
        if (!folder.exists()) folder.mkdirs();
        File csvFile = new File(folder, filename + ".csv");
        FileWriter fw = new FileWriter(csvFile);
        for (String[] row : rows) {
            for (int i = 0; i < row.length; i++) {
                String cell = row[i] == null ? "" : row[i].replace("\"", "\"\"");
                if (cell.contains(",") || cell.contains("\"")) cell = "\"" + cell + "\"";
                fw.append(cell);
                if (i < row.length - 1) fw.append(",");
            }
            fw.append("\n");
        }
        fw.flush();
        fw.close();
        return csvFile;
    }

    public static Uri getShareableUri(Context ctx, File file) {
        return FileProvider.getUriForFile(ctx, ctx.getPackageName() + ".fileprovider", file);
    }
}
