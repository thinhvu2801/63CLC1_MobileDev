package com.vuminhthinh.a63131330_thigiuaki;

public class Food {
    private String name;
    private String description;
    private int imageResourceId;

    public Food(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
