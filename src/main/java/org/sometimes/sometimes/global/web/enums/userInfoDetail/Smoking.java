package org.sometimes.sometimes.global.web.enums.userInfoDetail;

public enum Smoking {

    NO("NO"), // 안합니다
    FEW_TIME("FEW_TIME"), // 가끔 합니다
    ENJOY("ENJOY"); // 즐겨합니다

    private final String smoking;

    Smoking(String smoking) {
        this.smoking = smoking;
    }

    public String getSmoking() {
        return smoking;
    }
}
