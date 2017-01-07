package in.championswimmer.services;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MA";

    Button btnStart, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.btnStart);
        btn2 = (Button) findViewById(R.id.button2);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyIntentService.doNetOperation(MainActivity.this,
                        MyIntentService.ACTION_DOWNLOAD, Uri.parse("http://google.com"));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyIntentService.doNetOperation(MainActivity.this,
                        MyIntentService.ACTION_UPLOAD, Uri.parse("http://facebook.com"));
            }
        });
    }


}
