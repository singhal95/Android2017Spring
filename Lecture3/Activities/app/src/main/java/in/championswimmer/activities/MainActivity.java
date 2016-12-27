package in.championswimmer.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etVar1, etVar2;
    Button btnAdd;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etVar1 = (EditText) findViewById(R.id.etVar1);
        etVar2 = (EditText) findViewById(R.id.etVar2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(this);
        //btnAdd.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

//        switch (v.getId()) {
//            case R.id.btnAdd:
//                break;
//            case R.id.
//        }

//        if (v instanceof Button) {
//
//        }
//
//        Button b = (Button) v;
//        String txt = b.getText().toString();
//
//        ((Button) v).getText();

        Toast t = Toast.makeText(this, "Numbers are added", Toast.LENGTH_SHORT);

        t.show();

        int a = Integer.valueOf(etVar1.getText().toString());
        int b = Integer.valueOf(etVar2.getText().toString());

        int c = a + b;

        tvResult.setText(String.valueOf(c));
    }
}
