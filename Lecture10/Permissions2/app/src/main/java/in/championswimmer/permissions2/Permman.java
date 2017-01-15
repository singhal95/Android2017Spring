package in.championswimmer.permissions2;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by championswimmer on 15/01/17.
 */

public class Permman {

    interface OnPermissionResultListener {
        void onGranted(String forPerm);
        void onDenied(String forPerm);
    }

    private static OnPermissionResultListener sOprl;

    static void askForPermission (Activity act, String perm, OnPermissionResultListener oprl) {

        sOprl = oprl;
        ActivityCompat.requestPermissions(act,
                new String[]{perm},
                111);

    }

    static void onPermResult (int reqCode, String[] perms, int[] resCodes) {

        if (reqCode == 111) {
            if (resCodes[0] == PackageManager.PERMISSION_GRANTED) {
                sOprl.onGranted(null);
            } else {
                sOprl.onDenied(null);
            }
        }
    }
}
