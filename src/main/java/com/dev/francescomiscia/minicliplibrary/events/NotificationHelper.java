package com.dev.francescomiscia.minicliplibrary.events;

import android.app.ActivityManager;
import android.content.Context;

import com.dev.francescomiscia.minicliplibrary.models.NotificationModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by francescomiscia
 */

public class NotificationHelper {

    /**
     * Given a {@link NotificationModel} it return an {@link ArrayList} of its content with the following order:
     *  - Id
     *  - Title
     *  - Content
     *  - Icon Name
     *
     * @param model {@link NotificationModel}
     * @return {@link ArrayList} of {@link String}
     */
    public static ArrayList<String> buildIntentNotificationContent(NotificationModel model){
        ArrayList<String> notification = new ArrayList<>();
        notification.add(String.valueOf(model.getId()));
        notification.add(model.getTitle());
        notification.add(model.getContent());
        notification.add(model.getIconName());

        return notification;
    }


    /**
     * Checks whether or not the current application is on foreground
     *
     * @param context {@link Context}
     *
     * @return true if the application is on foreground
     */
    public static boolean isOnForeground(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        if (appProcesses == null) {
            return false;
        }
        final String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND && appProcess.processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }
}
