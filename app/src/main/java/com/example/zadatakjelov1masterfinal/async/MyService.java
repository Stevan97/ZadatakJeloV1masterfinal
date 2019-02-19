package com.example.zadatakjelov1masterfinal.async;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import com.example.zadatakjelov1masterfinal.tools.ReviewerTools;

public class MyService extends Service {


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        int status = intent.getExtras().getInt("STATUS");
        String string = intent.getExtras().getString("Finish");

        if (status == ReviewerTools.TYPE_WIFI) {
            new MyAsyncTask(getApplicationContext(), string).execute(status);
            Toast.makeText(getApplicationContext(), "Check Notification!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "You Need Internet Connection!", Toast.LENGTH_SHORT).show();
        }

        stopSelf();
        return START_NOT_STICKY;
    }
}
