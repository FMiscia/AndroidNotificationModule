package com.dev.francescomiscia.minicliplibrary.events;

import android.app.PendingIntent;
import android.content.Context;

import com.dev.francescomiscia.minicliplibrary.models.SimpleNotification;

import java.util.ArrayList;

/**
 * Created by francescomiscia
 */

public interface INotificationScheduler {

    /**
     * Send the {@link SimpleNotification} as Notification
     *  @param notification {@link SimpleNotification}
     * @param delay delay between notifications
     * @param  context {@link Context}
     */
    public abstract int scheduleNotification(SimpleNotification notification, int delay, Context context);

    /**
     * Send the {@link ArrayList} of {@link SimpleNotification} as Notification
     *
     * @param notifications {@link ArrayList} of {@link SimpleNotification}
     * @param delay delay between notifications
     * @param context {@link Context}
     *
     * @return  {@link PendingIntent}
     */
    public abstract ArrayList<Integer> scheduleNotifications(ArrayList<SimpleNotification> notifications, int delay, Context context);

    /**
     * Remove the scheduled notification with the given id from the {@link android.app.NotificationManager}
     *
     * @param id {@link PendingIntent}
     * @param context {@link Context}
     *
     */
    public abstract void removeNotification(int id, Context context);

    /**
     * Remove all the scheduled notifications from the {@link android.app.NotificationManager}
     * @param ids {@link ArrayList} of {@link Integer}
     * @param context {@link Context}
     */
    public abstract void removeNotifications(ArrayList<Integer> ids, Context context);

}
