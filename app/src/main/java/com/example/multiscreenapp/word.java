package com.example.multiscreenapp;

import android.graphics.drawable.Drawable;

public class word {
    private String defaultTranslation;
    private String miwokTranslation;
    private int imageID = no_image_view;
    private static final int no_image_view = -1;

    public word(String defaultTranslation, String miwokTranslation) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
    }

    public word(String defaultTranslation, String miwokTranslation, int imageID) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageID = imageID;
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
}
