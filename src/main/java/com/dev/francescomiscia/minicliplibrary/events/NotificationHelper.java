package com.dev.francescomiscia.minicliplibrary.events;

import com.dev.francescomiscia.minicliplibrary.models.NotificationModel;

import java.util.ArrayList;

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
    public static ArrayList<String> getNotificationIntentContent(NotificationModel model){
        ArrayList<String> notification = new ArrayList<>();
        notification.add(String.valueOf(model.getId()));
        notification.add(model.getTitle());
        notification.add(model.getContent());
        notification.add(model.getIconName());

        return notification;
    }
}
