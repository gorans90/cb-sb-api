package com.carbook.enums;

/**
 * Created by simic_000 on 5/14/2017.
 */
public enum Gender {
    MALE ("MALE"), FEMALE("FEMALE"), OTHER("OTHER");

    private final String text;

    /**
     * @param text
     */
    private Gender(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
