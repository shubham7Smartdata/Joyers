package com.sdi.joyers.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.snackbar.Snackbar;
import com.sdi.joyers.R;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MarshMallowPermission {

    public static final int CAMERA_PERMISSION_REQUEST_CODE = 1;
    public static final int EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE = 2;
    public static final int LOCATION_PERMISSION_REQUEST_CODE = 3;
    public static final int CALL_PERMISSION_REQUEST_CODE = 4;
    public static final int READ_PHONE_STATE_PERMISSION_REQUEST_CODE = 5;

    Activity activity;

    Utils util;
    private int isFirstTime = 0;

    public MarshMallowPermission(Activity activity) {
        this.activity = activity;
        util = new Utils(activity);
    }

    @SuppressLint("ResourceType")
    private void showSnackbar(final int mainTextStringId, final int actionStringId, View.OnClickListener listener) {
        Snackbar.make(activity.findViewById(android.R.id.content), activity.getString(mainTextStringId),
                Snackbar.LENGTH_INDEFINITE)

                .setActionTextColor(ContextCompat.getColor(activity, Color.RED))
                .setAction(activity.getString(actionStringId), listener).show();
    }

    @SuppressLint("ResourceType")
    private void showSnackbar2(final int mainTextStringId, final int actionStringId, View.OnClickListener listener) {
        Snackbar snackbar;
        snackbar = Snackbar.make(activity.findViewById(android.R.id.content), activity.getString(mainTextStringId), Snackbar.LENGTH_LONG);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(ContextCompat.getColor(activity, Color.BLACK));
        TextView textView = (TextView) snackBarView.findViewById(R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(activity, Color.WHITE));
        textView.setMaxLines(3);
        snackbar.setActionTextColor(ContextCompat.getColor(activity,Color.YELLOW));
        snackbar.setAction(activity.getString(actionStringId),listener).show();
        snackbar.show();
    }
    public boolean checkPermissionForCamera() {
        int result = ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    public void requestPermissionForCamera() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CAMERA)) {
//            Toast.makeText(activity, "Camera permission needed. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();

            ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission.CAMERA, WRITE_EXTERNAL_STORAGE},
                    CAMERA_PERMISSION_REQUEST_CODE);
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
        }
    }

    public boolean checkPermissionForExternalStorage() {
        int result = ContextCompat.checkSelfPermission(activity, WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPermissionForAudio() {
        int result = ContextCompat.checkSelfPermission(activity, Manifest.permission.RECORD_AUDIO);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    public void requestPermissionForExternalStorage() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, WRITE_EXTERNAL_STORAGE)) {
//            Toast.makeText(activity, "External Storage permission needed. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();

//            ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
//                    EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE);
            snackBarStorage();
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{WRITE_EXTERNAL_STORAGE}, EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE);
        }
    }

    public boolean checkPermissionForLocation() {
        int result = ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

//    boolean isFirstTime = false;
//    public void requestPermissionForLocation() {
//        boolean shouldProvideRationale =
//                ActivityCompat.shouldShowRequestPermissionRationale(activity,
//                        Manifest.permission.ACCESS_FINE_LOCATION);
//        int checkSelfPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION);
//        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_FINE_LOCATION)) {
//            showSnackbar(R.string.location_permission,
//                    android.R.string.ok, new View.OnClickListener() {
//                        @Override
//                        public void onItemClick(View view) {
//                            // Request permission
//                            ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
//                                    LOCATION_PERMISSION_REQUEST_CODE);
//                        }
//                    });
//
//        }  else {
//            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
//        }
//    }

    public void snackBarLocation() {

        Snackbar.make(activity.findViewById(android.R.id.content), "Enable Location Permissions from settings",
                Snackbar.LENGTH_INDEFINITE).setAction("ENABLE",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        intent.addCategory(Intent.CATEGORY_DEFAULT);
                        intent.setData(Uri.parse("package:" + activity.getPackageName()));
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                        activity.startActivity(intent);
                    }
                }).show();


    }

    public void snackBarStorage() {
        Snackbar.make(activity.findViewById(android.R.id.content), "Enable Storage Permissions from settings",
                Snackbar.LENGTH_LONG).setAction("ENABLE",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        intent.addCategory(Intent.CATEGORY_DEFAULT);
                        intent.setData(Uri.parse("package:" + activity.getPackageName()));
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                        activity.startActivity(intent);
                    }
                }).setActionTextColor(Color.GRAY).show();
    }

    public void snackEnablePermission() {
        Snackbar.make(activity.findViewById(android.R.id.content), "Enable Permissions from settings",
                Snackbar.LENGTH_LONG).setAction("ENABLE",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        intent.addCategory(Intent.CATEGORY_DEFAULT);
                        intent.setData(Uri.parse("package:" + activity.getPackageName()));
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                        activity.startActivity(intent);
                    }
                }).setActionTextColor(Color.GRAY).show();
    }

    public boolean checkPermissionForCall() {
        int result = ContextCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    public void requestCallPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CALL_PHONE)) {
            Toast.makeText(activity, "Call permission needed. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, CALL_PERMISSION_REQUEST_CODE);
        }
    }

    public void requestCameraStoragePermission(){
        if (ContextCompat.checkSelfPermission(activity, WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED ||
                ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    WRITE_EXTERNAL_STORAGE) || ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.CAMERA)) {
                snackEnablePermission();
            } else {
                ActivityCompat.requestPermissions(activity, new String[]{WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, MarshMallowPermission.EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE);
            }

        }
    }

    public boolean checkPermissionForPhoneState() {
        int result = ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_PHONE_STATE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

//    public void requestPhoneStatePermission() {
//        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_PHONE_STATE)) {
//            util.setBoolean(Consts.READ_PHONE_STATE_PERMISSION, false);
//            showSnackbar(R.string.read_phone_state_permission,
//                    android.R.string.ok, new View.OnClickListener() {
//                        @Override
//                        public void onItemClick(View view) {
//// Request permission
//                            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_PHONE_STATE},
//                                    READ_PHONE_STATE_PERMISSION_REQUEST_CODE);
//                        }
//                    });
//        } else {
//            if (!util.getBoolean(Consts.READ_PHONE_STATE_PERMISSION, false))
//                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_PHONE_STATE}, READ_PHONE_STATE_PERMISSION_REQUEST_CODE);
//            if (util.getBoolean(Consts.READ_PHONE_STATE_PERMISSION, false)) {
//                showSnackbar(R.string.read_phone_state_permission,
//                        android.R.string.ok, new View.OnClickListener() {
//                            @Override
//                            public void onItemClick(View view) {
//// Request permission
//                                util.setBoolean(Consts.READ_PHONE_STATE_PERMISSION, false);
//                                Intent intent = new Intent();
//                                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//                                intent.addCategory(Intent.CATEGORY_DEFAULT);
//                                intent.setDataX(Uri.parse("package:" + activity.getPackageName()));
//                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//                                intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
//                                activity.startActivity(intent);
//                            }
//                        });
//            }
//            util.setBoolean(Consts.READ_PHONE_STATE_PERMISSION, true);
//        }
//    }


    public void requestPhoneStatePermission(String[] permissionList, final String statusStore, int permissionCode, int message) {

        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permissionList[0])) {
            util.setBoolean(statusStore, true);
            ActivityCompat.requestPermissions(activity, permissionList, permissionCode);
        } else {
            if (!util.getBoolean(statusStore, false))
                ActivityCompat.requestPermissions(activity, permissionList, permissionCode);
            if (util.getBoolean(statusStore, false)) {
                showSnackbar2(message,
                        android.R.string.ok, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
// Request permission
                                Intent intent = new Intent();
                                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                intent.addCategory(Intent.CATEGORY_DEFAULT);
                                intent.setData(Uri.parse("package:" + activity.getPackageName()));
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                                intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                                activity.startActivity(intent);
                            }
                        });
            }
        }
    }

}
