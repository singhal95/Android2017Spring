package in.championswimmer.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DynamicFragmentActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRed, btnBlue;
    FragmentManager fragManager;
    FragmentTransaction fragTxn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        btnBlue = (Button) findViewById(R.id.btnBlue);
        btnRed = (Button) findViewById(R.id.btnRed);
        btnBlue.setOnClickListener(this);
        btnRed.setOnClickListener(this);

        fragManager = getSupportFragmentManager();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBlue:
                // attach fragment blue
                BlueFragment blueFragment = new BlueFragment();
                fragTxn = fragManager.beginTransaction();
                fragTxn.replace(R.id.flFragContainer, blueFragment);
                fragTxn.commit();
                break;
            case R.id.btnRed:
                // attach fragment red
                RedFragment redFragment = new RedFragment();
                fragManager.beginTransaction().replace(R.id.flFragContainer, redFragment).commit();
                break;
        }
    }
}
