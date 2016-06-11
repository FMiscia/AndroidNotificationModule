package com.dev.francescomiscia.minicliplibrary.controllers;

/**
 * Created by francescomiscia
 */

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.dev.francescomiscia.minicliplibrary.R;
import com.dev.francescomiscia.minicliplibrary.events.LocalNotificationScheduler;
import com.dev.francescomiscia.minicliplibrary.events.NotificationSchedulerFactory;
import com.dev.francescomiscia.minicliplibrary.models.NotificationBuilder;
import com.dev.francescomiscia.minicliplibrary.models.NotificationModel;

import java.util.ArrayList;

public class  NotificationHandler{

    private Context context;
    private static NotificationHandler _instance;
    private static ArrayList<Integer> pendingNotifications;

    static {
      pendingNotifications = new ArrayList<>();
    }

    /**
     * Empty private constructor
     */
    private NotificationHandler(){}

    /**
     * Sets the {@link android.app.Activity} {@link Context} for this handler
     *
     * @param context the {@link Context} to be set
     */
    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * Submits through the {@link com.dev.francescomiscia.minicliplibrary.events.INotificationScheduler} the notifications
     *
     * @param delay time delay
     */
    public void submitNotifications(int delay){
        pendingNotifications.clear();
        LocalNotificationScheduler notificationScheduler = (LocalNotificationScheduler) NotificationSchedulerFactory.getInstance().
                makeNotificationScheduler(NotificationSchedulerFactory.NotificationType.LOCAL);
        pendingNotifications.addAll(notificationScheduler.scheduleNotifications(getSampleNotifications(),delay,this.context));
    }

    /**
     * Removes through the {@link com.dev.francescomiscia.minicliplibrary.events.INotificationScheduler} the submitted notifications
     */
    public void disposeNotifications(){
        LocalNotificationScheduler notificationScheduler = (LocalNotificationScheduler) NotificationSchedulerFactory.getInstance().
                makeNotificationScheduler(NotificationSchedulerFactory.NotificationType.LOCAL);
        notificationScheduler.removeNotifications(pendingNotifications,context);
    }

    /**
     * Remove a single notification according to the given id
     *
     * @param id the id of the notification
     */
    public void disposeNotification(int id){
        LocalNotificationScheduler notificationScheduler = (LocalNotificationScheduler) NotificationSchedulerFactory.getInstance().
                makeNotificationScheduler(NotificationSchedulerFactory.NotificationType.LOCAL);
        notificationScheduler.removeNotification(id,context);
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
     * Generate a sample set of notifications
     *
     * @return bundle of notifications {@link ArrayList} of {@link NotificationModel}
     */
    public ArrayList<NotificationModel> getSampleNotifications(){
        ArrayList<NotificationModel> notifications = new ArrayList<>();
        notifications.add(NotificationBuilder.getInstance().buildNotification("First","First beer","beer1", R.drawable.beer1));
        notifications.add(NotificationBuilder.getInstance().buildNotification("Second","Second beer","beer2", R.drawable.beer2));
        notifications.add(NotificationBuilder.getInstance().buildNotification("Third","Third beer","beer3", R.drawable.beer3));
        notifications.add(NotificationBuilder.getInstance().buildNotification("Fourth","Fourth beer","beer4", R.drawable.beer4));
        notifications.add(NotificationBuilder.getInstance().buildNotification("Fifth","Fifth beer","beer5", R.drawable.beer5));

        return notifications;
    }

    /**
     * Gives the pending notifications
     *
     * @return pending notifications id {@link ArrayList}
     */
    public static ArrayList<Integer> getPendingNotifications() {
        return pendingNotifications;
    }

    /**
     * Sets the pending notifications
     *
     * @param pendingNotifications {@link ArrayList}
     */
    public static void setPendingNotifications(ArrayList<Integer> pendingNotifications) {
        NotificationHandler.pendingNotifications = pendingNotifications;
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
