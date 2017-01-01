package in.championswimmer.fragments;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCounter = (TextView) findViewById(R.id.tvCounter);
    }


    public void shiftCounter (int shiftAmt) {
        tvCounter.setText(String.valueOf(
                Integer.valueOf(tvCounter.getText().toString()) + shiftAmt
        ));
    }


}
