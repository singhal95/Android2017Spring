package in.championswimmer.permissions2;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "PERM";

    EditText etToSave;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etToSave = (EditText) findViewById(R.id.editText);
        btnSave = (Button) findViewById(R.id.button);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Permman.askForPermission(
                        MainActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        new Permman.OnPermissionResultListener() {
                            @Override
                            public void onGranted(String forPerm) {
                                writeToFile("MYFILE", etToSave.getText().toString());
                            }

                            @Override
                            public void onDenied(String forPerm) {
                                Toast.makeText(MainActivity.this,
                                        "We have no permission",
                                        Toast.LENGTH_SHORT)
                                        .show();

                            }
                        }
                );
            }
        });
    }

    void writeToFile (String fileName, String data) {
        Log.d(TAG, "writeToFile: ");

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        Permman.onPermResult(requestCode, permissions, grantResults);

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
