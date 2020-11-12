package com.example.multiscreenapp;

import android.graphics.drawable.Drawable;

public class word {
    private String defaultTranslation;
    private String miwokTranslation;
    private int imageID;

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
}
