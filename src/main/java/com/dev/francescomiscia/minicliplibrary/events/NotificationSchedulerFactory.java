package com.dev.francescomiscia.minicliplibrary.events;

/**
 * Created by francescomiscia
 */

public class NotificationSchedulerFactory {

    private static NotificationSchedulerFactory _instance;

    public enum NotificationType{LOCAL,REMOTE}

    private NotificationSchedulerFactory(){}

    /**
     * Builds an {@link INotificationScheduler} according to type
     *
     * @param type {@link NotificationType}
     * @return {@link INotificationScheduler}
     */
    public INotificationScheduler makeNotificationScheduler(NotificationType type){

        switch(type){
            case LOCAL:
                return new LocalNotificationScheduler();
            case REMOTE:
                return new RemoteNotificationScheduler();
            default :
                return null;
        }
    }

    /**
     * Singleton
     *
     * @return {@link NotificationSchedulerFactory}
     */
    public static NotificationSchedulerFactory getInstance(){
        if(_instance == null){
            _instance = new NotificationSchedulerFactory();
        }
        return _instance;
    }
}
