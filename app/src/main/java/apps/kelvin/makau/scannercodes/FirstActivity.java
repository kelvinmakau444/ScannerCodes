package apps.kelvin.makau.scannercodes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.edwardvanraak.materialbarcodescanner.MaterialBarcodeScanner;
import com.edwardvanraak.materialbarcodescanner.MaterialBarcodeScannerBuilder;
import com.google.android.gms.vision.barcode.Barcode;

public class FirstActivity extends AppCompatActivity {
    private Barcode barcodeResult;
    FloatingActionButton newScan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        newScan=(FloatingActionButton) findViewById(R.id.newScan);
        newScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startScan();

            }
        });
    }
    private void startScan() {
        /**
         * Build a new MaterialBarcodeScanner
         */
        final MaterialBarcodeScanner materialBarcodeScanner = new MaterialBarcodeScannerBuilder()
                .withActivity(this)
                .withBackfacingCamera()
                .withEnableAutoFocus(true)
                .withBleepEnabled(true)
                .withCenterTracker()
                .withOnly2DScanning()
                .withBarcodeFormats(Barcode.AZTEC | Barcode.EAN_13 | Barcode.CODE_93)
                // .withBackfacingCamera()
                // .withText("Scanning...")
                .withResultListener(new MaterialBarcodeScanner.OnResultListener() {
                    @Override
                    public void onResult(Barcode barcode) {
                        Intent intent= new Intent(FirstActivity.this,AfterScanActivity.class);
                        intent.putExtra("code",barcode.rawValue);
                        startActivity(intent);
                        Toast.makeText(FirstActivity.this, String.valueOf(barcode.rawValue), Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
        materialBarcodeScanner.startScan();
    }


}
