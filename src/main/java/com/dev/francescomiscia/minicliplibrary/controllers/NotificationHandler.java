package com.dev.francescomiscia.minicliplibrary.controllers;

/**
 * Created by francescomiscia
 */

import android.app.PendingIntent;
import android.content.Context;
import android.widget.Toast;

import com.dev.francescomiscia.minicliplibrary.R;
import com.dev.francescomiscia.minicliplibrary.events.LocalNotificationScheduler;
import com.dev.francescomiscia.minicliplibrary.events.NotificationSchedulerFactory;
import com.dev.francescomiscia.minicliplibrary.models.NotificationBuilder;
import com.dev.francescomiscia.minicliplibrary.models.SimpleNotification;

import java.util.ArrayList;

public class  NotificationHandler{

    private Context context;
    private static NotificationHandler _instance;

    /**
     * Submits through the {@link com.dev.francescomiscia.minicliplibrary.events.INotificationScheduler}
     * a notification with the given parameters
     * 
     * @param id id of the notification
     * @param title title of the notification {@link String}
     * @param content content of the notification {@link String}
     * @param icon icon name of the notification {@link String}
     * @param delay time delay 
     */
    public void submitNotification(String id, String title, String content, String icon, int delay){
        int iconId = context.getResources().getIdentifier(icon, "drawable", context.getPackageName());
        SimpleNotification notification = NotificationBuilder.getInstance().buildNotification(Integer.valueOf(id), title, content, icon, iconId);
        LocalNotificationScheduler notificationScheduler = (LocalNotificationScheduler) NotificationSchedulerFactory.getInstance().
                makeNotificationScheduler(NotificationSchedulerFactory.NotificationType.LOCAL);
        notificationScheduler.scheduleNotification(notification,delay,context);
    }

    /**
     * Remove a single notification according to the given id
     *
     * @param id the id of the notification
     */
    public void disposeNotification(String id){
        LocalNotificationScheduler notificationScheduler = (LocalNotificationScheduler) NotificationSchedulerFactory.getInstance().
                makeNotificationScheduler(NotificationSchedulerFactory.NotificationType.LOCAL);
        notificationScheduler.removeNotification(Integer.valueOf(id),context);
    }

    /**
     * Shows a {@link Toast} with the given message
     *
     * @param message the message to be displayed
     */
    public void showMessage(String message) {
        Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Sets the {@link android.app.Activity} {@link Context} for this handler
     *
     * @param context the {@link Context} to be set
     */
    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * Singleton
     *
     * @return {@link NotificationHandler}
     */
    public static NotificationHandler getInstance() {
        if(_instance == null) {
            _instance = new NotificationHandler();
        }
        return _instance;
    }

}
