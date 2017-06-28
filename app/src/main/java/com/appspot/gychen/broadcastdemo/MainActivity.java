package com.appspot.gychen.broadcastdemo;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartBroadcastButtonClick(View view) {
        Log.d(TAG, "onStartBroadcastButtonClick");
        Intent intent = buildBaseBroadcastIntent();
        sendBroadcast(intent);
    }

    public void onStartPermissionBroadcastButtonClick(View view) {
        Log.d(TAG, "onStartPermissionBroadcastButtonClick");
        Intent intent = buildBaseBroadcastIntent();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{"com.appspot.gychen.PERMISSION_MY_RECEIVER"}, 0);
        }
        sendBroadcast(intent, "com.appspot.gychen.PERMISSION_MY_RECEIVER");
    }

    protected Intent buildBaseBroadcastIntent() {
        Intent intent = new Intent();
        intent.setAction("com.appspot.gychen.START_MY_RECEIVER");
        return intent;
    }
}
