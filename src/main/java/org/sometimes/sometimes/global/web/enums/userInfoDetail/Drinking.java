package org.sometimes.sometimes.global.web.enums.userInfoDetail;

public enum Drinking {

    NO("NO"), // 안합니다
    FEW_TIME("FEW_TIME"), // 가끔 합니다
    ENJOY("ENJOY"); // 즐겨합니다

    private final String drinking;

    Drinking(String drinking) {
        this.drinking = drinking;
    }

    public String getDrinking() {
        return drinking;
    }
}
