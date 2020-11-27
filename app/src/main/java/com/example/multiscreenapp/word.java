package com.example.multiscreenapp;

public class word {
    private String defaultTranslation;
    private String miwokTranslation;
    private static final int no_image_view = -1;
    private int imageID = no_image_view;
    private int musicID;

    public word(String defaultTranslation, String miwokTranslation, int musicID) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.musicID = musicID;
    }

    public word(String defaultTranslation, String miwokTranslation, int imageID, int musicID) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageID = imageID;
        this.musicID = musicID;
    }

    public String getDefaultTranslation() {
        return this.defaultTranslation;
    }

    public String getMiwokTranslationTranslation() {
        return this.miwokTranslation;
    }

    public int getImageID() { return this.imageID; }

    public boolean hasImage(){
        return imageID != no_image_view;
    }

    //Return audio resource id of word
    public int getAudioResourceID() {
        return this.musicID;
    }
}
