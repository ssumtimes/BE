package org.sometimes.sometimes.global.web.enums.userInfoDetail;

public enum Earning {

    BELOW_4000("BELOW_4000"), // 4천만 원 미만
    FROM_4000_TO_6000("FROM_4000_TO_6000"), // 4천만 원 이상 ~ 6천만 원 미만
    FROM_6000_TO_8000("FROM_6000_TO_8000"), // 6천만 원 이상 ~ 8천만 원 미만
    FROM_8000_TO_10000("FROM_8000_TO_10000"), // 8천만 원 이상 ~ 1억 원 미만
    ABOVE_10000("ABOVE_10000"); // 1억 원 이상

    private final String earning;

    Earning(String earning) {
        this.earning = earning;
    }

    public String getEarning() {
        return earning;
    }
}
