package com.dev.francescomiscia.minicliplibrary.events;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.unity3d.player.UnityPlayer;

/**
 * Created by francescomiscia
 */

public class LocalNotificationReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        ((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE)).
                notify(intent.getIntExtra(LocalNotificationScheduler.notificationIntentIdKey,0),
                        (Notification) intent.getParcelableExtra(LocalNotificationScheduler.notificationIntentKey));
    }
}
