package com.codingblocks.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    public static final String TAG = "MainAct";

    EditText etNum1, etNum2;
    Button btnAdd;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        tvResult = (TextView) findViewById(R.id.tvResult);
        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + v.getId());
                addAndShow();
            }
        };

        btnAdd.setOnClickListener(ocl);


        //our logic goes here

        Log.d(TAG, "onCreate: ");
    }

    void addAndShow () {
        int a = Integer.valueOf(etNum1.getText().toString());
        int b = Integer.valueOf(etNum2.getText().toString());

        tvResult.setText(String.valueOf(a + b));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
        //our logic goes here

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        //our logic goes here

    }

    @Override
    protected void onPause() {
        //our logic goes here

        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        //our logic goes here

        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        //our logic goes here

        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
