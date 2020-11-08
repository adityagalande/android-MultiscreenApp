package com.example.multiscreenapp;

public class word {
    private String defaultTranslation;
    private String miwokTranslation;

    public word(String defaultTranslation, String miwokTranslation) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
    }

    public String getdefaultTranslation() {
        return this.defaultTranslation;
    }

    public String getMiwokTranslationTranslation() {
        return this.miwokTranslation;
    }
}
