package com.dev.francescomiscia.minicliplibrary.models;

import java.util.UUID;


/**
 * Created by francescomiscia
 */

public class NotificationBuilder {

    private static NotificationBuilder _instance = null;
    private static int counterId = 0;
    private NotificationBuilder(){}

    /**
     * Build a {@link NotificationModel} with a uniqueID and the given parameters
     * @param title
     * @param content
     * @param iconName
     * @param icon
     * @return {@link NotificationModel}
     */
    public NotificationModel buildNotification(String title, String content, String iconName, int icon){
        return new NotificationModel(UUID.randomUUID().hashCode(),title,content,iconName,icon);
    }

    /**
     * Singleton
     *
     * @return {@Link NotificationBuilder}
     */
    public static NotificationBuilder getInstance(){
        if(_instance == null){
            _instance = new NotificationBuilder();
        }

        return _instance;
    }

}
