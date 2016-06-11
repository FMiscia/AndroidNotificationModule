package com.dev.francescomiscia.minicliplibrary.events;

import android.content.Context;

import com.dev.francescomiscia.minicliplibrary.models.NotificationModel;

import java.util.ArrayList;

/**
 * Created by francescomiscia
 */
public class RemoteNotificationScheduler implements INotificationScheduler {

    @Override
    public int scheduleNotification(NotificationModel notificationModel, int delay, Context context) {
        //TODO: to be implemented
        return 0;
    }

    @Override
    public ArrayList<Integer> scheduleNotifications(ArrayList<NotificationModel> notifications, int delay, Context context) {
        //TODO: to be implemented
        return null;
    }

    @Override
    public void removeNotification(int id, Context context) {
        //TODO: to be implemented
    }

    @Override
    public void removeNotifications(ArrayList<Integer> pendingIntents, Context context) {
        //TODO: to be implemented
    }
}
