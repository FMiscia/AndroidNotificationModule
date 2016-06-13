package com.dev.francescomiscia.minicliplibrary.events;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.unity3d.player.UnityPlayer;

import java.util.ArrayList;

/**
 * Created by francescomiscia
 */

public class LocalNotificationReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Notification notification =  (Notification) intent.getParcelableExtra(LocalNotificationScheduler.notificationIntentKey);
        ArrayList<String> notificationContent = intent.getStringArrayListExtra(LocalNotificationScheduler.notificationDataKey);
        if (NotificationHelper.isOnForeground(context)) {
            UnityPlayer.UnitySendMessage("Main Camera","setMessage",notificationContent.get(2));
            UnityPlayer.UnitySendMessage("Main Camera","setIcon",notificationContent.get(3));
        } else{
            ((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE)).
                    notify(intent.getIntExtra(LocalNotificationScheduler.notificationIntentIdKey, 0),
                            notification);
        }

    }


}
