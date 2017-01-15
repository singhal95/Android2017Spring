package in.championswimmer.permissions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "PERMS";
    public static final int PERM_REQ_CODE = 111;


    Button btnSave;
    EditText etToSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int perm = ContextCompat.checkSelfPermission(
                this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (perm == PackageManager.PERMISSION_DENIED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,  Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Log.d(TAG, "onCreate: should = true");
                Toast.makeText(this, "Give the damn permission", Toast.LENGTH_SHORT).show();
            }

            ActivityCompat.requestPermissions(this, new String[] {
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, PERM_REQ_CODE);
        }

        etToSave = (EditText) findViewById(R.id.etToSave);
        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeToFile("MYFILE", etToSave.getText().toString());
            }
        });
    }


    void writeToFile (String fileName, String data) {

         if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
             Toast.makeText(this, "We do not have permission to write", Toast.LENGTH_SHORT).show();

             return;
         };

        File fileToWrite = new File(
                Environment.getExternalStorageDirectory(),
                fileName
        );

        try {
            FileOutputStream fOutStream = new FileOutputStream(
                    fileToWrite,
                    true
            );
            fOutStream.write(data.getBytes());
            fOutStream.close();
        } catch (IOException e) {
            Log.e(TAG, "writeToFile: ", e);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

//        if (requestCode == PERM_REQ_CODE) {
//            for (int i = 0; i < permissions.length; i++) {
//                if (permissions[i].equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//                    (grantResults[i] == PackageManager.PERMISSION_GRANTED ?
//                        writeToFile();
//                        :
//                        Toast.makeText(this, "Permission to write file denied", Toast.LENGTH_SHORT).show())
//                }
//            }
//        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    String readFromFile (String fileName) {

        return "";
    }
}
