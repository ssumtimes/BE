package org.sometimes.sometimes.global.web.enums.userInfoDetail;

public enum Gender {

    MALE("MALE"),
    FEMALE("FEMALE");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;}

    public String getGender() {return gender;}
}
