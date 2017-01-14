package in.championswimmer.asynctask;

import android.os.AsyncTask;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "AA";
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                MyTask task = new MyTask();
                task.execute(10);
            }
        });

    }

    class MyTask extends AsyncTask<Integer, Float, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Integer... params) {
            for (int i = 0; i < params[0]; i ++) {
                loopOneSec();
                publishProgress((float) i / (float) params[0]);
            }
            return "Completed";
        }

        @Override
        protected void onProgressUpdate(Float... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

    static void loopOneSec () {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 1000);
    }
}
