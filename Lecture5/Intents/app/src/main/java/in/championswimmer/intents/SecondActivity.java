package in.championswimmer.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    EditText tvName;
    Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvName = (EditText) findViewById(R.id.tvName);
        btnClose = (Button) findViewById(R.id.btnClose);

        Intent gotIntent = getIntent();
        String name = gotIntent.getStringExtra("name");

        tvName.setText(name);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.putExtra("return", tvName.getText().toString());

                setResult(RESULT_OK, i);
                finish();
            }
        });

    }
}
