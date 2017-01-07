package in.championswimmer.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/**
 * Created by championswimmer on 07/01/17.
 */

public class MyIntentService extends IntentService {

    public static final String TAG = "mis";


    public static final String ACTION_DOWNLOAD = "download";
    public static final String ACTION_UPLOAD = "upload";


    public MyIntentService() {
        super("MIS");
    }

    public static void doNetOperation (Context ctx, String action, Uri data) {
        Intent i = new Intent(ctx, MyIntentService.class);
        i.setAction(action);
        i.setData(data);
        ctx.startService(i);
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        String action = intent.getAction();
        if (action.equals(ACTION_DOWNLOAD)) {
            downloadFromUrl(intent.getDataString());
        }

        if (action.equals(ACTION_UPLOAD)) {
            uploadToUrl(intent.getDataString());
        }

    }

    void downloadFromUrl (String url) {
        Log.d(TAG, "downloadFromUrl: " + url);
        loopWithLog(5, "download");
    }

    void uploadToUrl (String url) {
        Log.d(TAG, "uploadToUrl: " + url);
        loopWithLog(10, "upload");
    }

    public void loopWithLog (int duration, String action) {
        for (int i = 0; i < duration; i++) {
            loopOneSec();
            Log.d(TAG, "loopWithLog: " + i + action);
        }
    }

    public void loopOneSec () {
        long startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < 1000);
    }
}
