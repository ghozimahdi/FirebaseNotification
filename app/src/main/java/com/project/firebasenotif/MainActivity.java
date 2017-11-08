package com.project.firebasenotif;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private BroadcastReceiver mRegistrationBroadcastReceiver;
    private String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.txt);

        displayFirebaseRegId();

        SharedPreferences prefi = getApplicationContext().getSharedPreferences(Config.SHARED_PREF, 0);
        String regId = prefi.getString("event", null);

        Log.e(TAG, "Firebase notif intent: " + regId);
    }

    private void displayFirebaseRegId() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences(Config.SHARED_PREF, 0);
        String regId = pref.getString("regId", null);

        Log.e(TAG, "Firebase reg id: " + regId);

        if (!TextUtils.isEmpty(regId))
            text.setText("Firebase Reg Id: " + regId);
        else
            text.setText("Firebase Reg Id is not received yet!");
    }
}
