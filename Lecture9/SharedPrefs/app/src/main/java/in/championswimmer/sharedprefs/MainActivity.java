package in.championswimmer.sharedprefs;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Storage";

    EditText etToSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etToSave = (EditText) findViewById(R.id.etToSave);

        SharedPreferences sPref = getSharedPreferences("MYPREF", MODE_PRIVATE);
        String savedText = sPref.getString("text", "");
        etToSave.setText(savedText);

        Log.d(TAG, "data: " + Environment.getDataDirectory().getAbsolutePath());
        Log.d(TAG, "root: " + Environment.getRootDirectory().getAbsolutePath());
        Log.d(TAG, "dl cache: " + Environment.getDownloadCacheDirectory().getAbsolutePath());
        Log.d(TAG, "ext storage: " + Environment.getExternalStorageDirectory().getAbsolutePath());
        Log.d(TAG, "ext storage music: " +
                Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_MUSIC).getAbsolutePath());

        Log.d(TAG, "filesDir: " + getFilesDir());
        Log.d(TAG, "cacheDir: " + getCacheDir());
        Log.d(TAG, "externalCache: " + getExternalCacheDir());
        Log.d(TAG, "externalFiles Music: " + getExternalFilesDir(null));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            File[] extDirs = getExternalFilesDirs(null);
            for (File f: extDirs) {
                Log.d(TAG, "extDirs: " + f.getAbsolutePath());
            }
        }

    }

    @Override
    protected void onStop() {
        String textToSave = etToSave.getText().toString();

        SharedPreferences sPref = getSharedPreferences("MYPREF", MODE_PRIVATE);
        sPref.edit().putString("text", textToSave).apply();

        super.onStop();


    }
}
