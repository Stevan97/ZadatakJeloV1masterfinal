package com.example.zadatakjelov1masterfinal.async;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.zadatakjelov1masterfinal.R;
import com.example.zadatakjelov1masterfinal.tools.ReviewerTools;

public class MyReceiver extends BroadcastReceiver {

    private static int notificationID = 1;
    private static int position = 0;

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals("Order")) {
            String string = intent.getExtras().getString("Finish");
            int resultCode = intent.getExtras().getInt("RESULT_CODE");

            prepareNotification(resultCode,context, string);
        }
    }

    private void prepareNotification(int resultCode, Context context, String string) {
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);


        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_action_settings);

        Log.i("MY_ANDROID_APP", "NOtif");

        if (resultCode == ReviewerTools.TYPE_NOT_CONNECTED) {
            mBuilder.setSmallIcon(R.drawable.ic_action_about);
            mBuilder.setContentTitle("You've bought: " + string);
            mBuilder.setContentText("You've bought: " + string);

        } else if (resultCode == ReviewerTools.TYPE_MOBILE) {
            mBuilder.setSmallIcon(R.drawable.ic_action_create);
            mBuilder.setContentTitle("You've bought: " + string);
            mBuilder.setContentText("You've bought: " + string);
        } else {
            mBuilder.setSmallIcon(R.drawable.ic_action_create);
            mBuilder.setContentTitle("You've bought: " + string);
            mBuilder.setContentText("You've bought: " + string);
        }


        mBuilder.setLargeIcon(bm);

        mNotificationManager.notify(notificationID, mBuilder.build());

    }

}
