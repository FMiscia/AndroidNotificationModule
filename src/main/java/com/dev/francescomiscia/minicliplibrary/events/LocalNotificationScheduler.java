package com.dev.francescomiscia.minicliplibrary.events;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import com.dev.francescomiscia.minicliplibrary.models.NotificationModel;
import com.unity3d.player.UnityPlayer;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by francescomiscia
 */

public class LocalNotificationScheduler implements INotificationScheduler {

    public final static String notificationIntentKey = "IncomingNotification";
    public final static String notificationIntentIdKey = "NotificationID";
    public final static String notificationDataKey = "NotificationData";
    public static int requestCodeCounter;
    static {
        requestCodeCounter = 0;
    }

    @Override
    public int scheduleNotification(NotificationModel notificationModel, int delay, Context context) {

        //Let's create the pending intent for the Notification
        Intent resultIntent = new Intent(context, UnityPlayer.currentActivity.getClass());
        resultIntent.putStringArrayListExtra(LocalNotificationScheduler.notificationDataKey,
                NotificationHelper.buildIntentNotificationContent(notificationModel));
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent((int)System.currentTimeMillis(),PendingIntent.FLAG_UPDATE_CURRENT);

        //Notification building
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(notificationModel.getIcon())
                        .setContentTitle(notificationModel.getTitle())
                        .setContentText(notificationModel.getContent())
                        .setAutoCancel(true)
                        .setContentIntent(resultPendingIntent);
        Notification notification = mBuilder.build();

        //Alarm manager creation. The intent will contain the notification and the notification data to be broadcasted
        Intent alarmIntent = new Intent(context, LocalNotificationReceiver.class);
        alarmIntent.putExtra(notificationIntentIdKey,notificationModel.getId());
        alarmIntent.putExtra(notificationIntentKey,notification);
        alarmIntent.putStringArrayListExtra(LocalNotificationScheduler.notificationDataKey,
                NotificationHelper.buildIntentNotificationContent(notificationModel));
        PendingIntent pendingAlarmIntent = PendingIntent.getBroadcast(context,notificationModel.getId(),alarmIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MILLISECOND,delay);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingAlarmIntent);
        return notificationModel.getId();
    }

    @Override
    public ArrayList<Integer> scheduleNotifications(ArrayList<NotificationModel> notifications, int delay, Context context) {
        ArrayList<Integer> ids = new ArrayList<>();
        int counter = 0;
        for(NotificationModel notification : notifications){
            ids.add(scheduleNotification(notification,delay*counter++,context));
        }

        return ids;
    }

    @Override
    public void removeNotification(int id, Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(PendingIntent.getBroadcast(context,id,new Intent(context, LocalNotificationReceiver.class),PendingIntent.FLAG_UPDATE_CURRENT));
    }

    @Override
    public void removeNotifications(ArrayList<Integer> pendingIntents, Context context) {
        for(int id : pendingIntents){
            this.removeNotification(id,context);
        }
    }

}
