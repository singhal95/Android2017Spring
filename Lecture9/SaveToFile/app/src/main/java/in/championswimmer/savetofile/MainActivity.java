package in.championswimmer.savetofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;

public class MainActivity extends AppCompatActivity {

    EditText etToSave;
    Button btnSave;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etToSave = (EditText) findViewById(R.id.etToSave);
        btnSave = (Button) findViewById(R.id.btnSave);
        textView = (TextView) findViewById(R.id.textView);

        textView.setText(readFromFile("MYFILE"));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeToFile("MYFILE",
                        etToSave.getText().toString());
            }
        });
    }

    String readFromFile (String fileName) {
        File filesDir = getFilesDir();
        FileInputStream fInStr = null;

        File fileToRead = new File(filesDir, fileName);


        try {
            fInStr = new FileInputStream(fileToRead);
            InputStreamReader iStrRd = new InputStreamReader(fInStr);
            StringBuilder sBuilder = new StringBuilder();
            char[] charBuf = new char[10];
            boolean end = false;
            while (!end) {
                if (iStrRd.read(charBuf) == -1 ) {
                    end = true;
                    break;
                };
                sBuilder.append(charBuf);
            }
            return sBuilder.toString();



        } catch (IOException e) {
            e.printStackTrace();
        }


        return "";
    }

    void writeToFile (String fileName, String data) {
        File filesDir = getFilesDir();
        FileOutputStream fOutStr = null;

        File fileToWrite = new File(filesDir, fileName);
        try {
            fOutStr = new FileOutputStream(fileToWrite);
            fOutStr.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
