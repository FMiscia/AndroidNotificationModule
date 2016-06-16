package com.dev.francescomiscia.minicliplibrary.models;

import java.util.UUID;


/**
 * Created by francescomiscia
 */

public class NotificationBuilder {

    private static NotificationBuilder _instance = null;
    private NotificationBuilder(){}

    /**
     * Builds a {@link SimpleNotification} with a uniqueID and the given parameters
     * @param title
     * @param content
     * @param iconName
     * @param icon
     * @return {@link SimpleNotification}
     */
    public SimpleNotification buildNotification(String title, String content, String iconName, int icon){
        return new SimpleNotification(UUID.randomUUID().hashCode(),title,content,iconName,icon);
    }

    /**
     * Builds a {@link SimpleNotification} with the given id
     * @param id
     * @param title
     * @param content
     * @param iconName
     * @param icon
     * @return {@link SimpleNotification}
     */
    public SimpleNotification buildNotification(int id, String title, String content, String iconName, int icon){
        return new SimpleNotification(id,title,content,iconName,icon);
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
