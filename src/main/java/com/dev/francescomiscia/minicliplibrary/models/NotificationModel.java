package com.dev.francescomiscia.minicliplibrary.models;

/**
 * Created by francescomiscia
 */

public class NotificationModel{

    private int id;
    private String title;
    private String content;
    private String iconName;
    private int icon;

    /**
     * Constructor
     *
     * @param id
     * @param title
     * @param content
     * @param iconName
     * @param icon
     */
    public NotificationModel(int id, String title, String content, String iconName, int icon){
        this.id = id;
        this.title = title;
        this.content = content;
        this.iconName = iconName;
        this.icon = icon;
    }

    public int getId(){
        return id;
    }

    /**
     * Gets the {@link NotificationModel} title
     * @return title {@link String}
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the  {@link NotificationModel} title
     *
     * @param title {@link String}
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the {@link NotificationModel} content
     *
     * @return content {@link String}
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the  {@link NotificationModel} content
     *
     * @param content {@link String}
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the {@link NotificationModel} iconName
     *
     * @return iconName {@link String}
     */
    public String getIconName() {
        return iconName;
    }

    /**
     * Sets the  {@link NotificationModel} iconName
     *
     * @param iconName {@link String}
     */
    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    /**
     * Gets the {@link NotificationModel} icon
     *
     * @return iconName
     */
    public int getIcon() {
        return icon;
    }

    /**
     * Sets the  {@link NotificationModel} icon
     *
     * @param icon
     */
    public void setIcon(int icon) {
        this.icon = icon;
    }

}
