package com.example.warehouseinspection;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    EditText etAgencyName, etAgencyCode, etCounty, etProvince, etVisitDate, etArea, etCapacity;
    CheckBox cbSafety, cbStockMatch, cbLayout, cbInfoRegistry, cbUnifiedBoard, cbLicense,
            cbEInvoice, cbInvoicePrint, cbExtinguisher, cbTariffBoard, cbCCTV,
            cbConveyor, cbScale, cbPallet, cbComputer, cbPrinter, cbFax, cbWarehouseInsurance,
            cbGoodsInsurance, cbNonMandatoryFertilizerPurchase, cbNonMandatoryFertilizerRegistry,
            cbBulkFertilizerUnload;
    RadioGroup rgOwnership;
    Button btnSave;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		// find views
        etAgencyName = findViewById(R.id.etAgencyName);
        etAgencyCode = findViewById(R.id.etAgencyCode);
        etProvince = findViewById(R.id.etProvince);
        etCounty = findViewById(R.id.etCounty);
        etVisitDate = findViewById(R.id.etVisitDate);
        etArea = findViewById(R.id.etArea);
        etCapacity = findViewById(R.id.etCapacity);

        cbSafety = findViewById(R.id.cbSafety);
        // ... برای مختصر نشدن کد، فرض شده تمام cbها با idهای مناسب در XML وجود دارند
        cbNonMandatoryFertilizerPurchase = findViewById(R.id.cbNonMandatoryFertilizerPurchase);
        cbNonMandatoryFertilizerRegistry = findViewById(R.id.cbNonMandatoryFertilizerRegistry);
        cbBulkFertilizerUnload = findViewById(R.id.cbBulkFertilizerUnload);

        rgOwnership = findViewById(R.id.rgOwnership);
        btnSave = findViewById(R.id.btnSave);

        prefs = getSharedPreferences("warehouse_prefs", MODE_PRIVATE);

        btnSave.setOnClickListener(v -> {
            SharedPreferences.Editor e = prefs.edit();
            e.putString("agency_name", etAgencyName.getText().toString());
            e.putString("agency_code", etAgencyCode.getText().toString());
            e.putString("province", etProvince.getText().toString());
            e.putString("county", etCounty.getText().toString());
            e.putString("visit_date", etVisitDate.getText().toString());
            e.putString("area", etArea.getText().toString());
            e.putString("capacity", etCapacity.getText().toString());
            e.apply();
            Toast.makeText(MainActivity.this, "اطلاعات ذخیره شد (local)", Toast.LENGTH_SHORT).show();
        });
    }
}
