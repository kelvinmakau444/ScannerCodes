package apps.kelvin.makau.scannercodes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AfterScanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_scan);
        try{
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
