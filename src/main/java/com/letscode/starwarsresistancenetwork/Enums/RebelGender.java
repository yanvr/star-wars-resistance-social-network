package com.letscode.starwarsresistancenetwork.Enums;

public enum RebelGender {
    MALE("M"), FEMALE("F"), DROID("D");

    private final String gender;

    RebelGender(String gender) {
        this.gender = gender;
    }

    String getGender(){
        return gender;
    }
}
