package org.sometimes.sometimes.global.web.enums.userInfoDetail;

public enum ImportantInPartner {

    FACE("FACE"), // 외모
    HEIGHT("HEIGHT"), // 키
    FORM("FORM"), // 체형
    PERSONALITY("PERSONALITY"), // 성격
    VALUES("VALUES"), // 가치관
    JOB("JOB"), // 직업
    EARNING("EARNING"), // 소득
    ASSET("ASSET"), // 자산
    HOM_ENVIRONMENT("HOM_ENVIRONMENT"), // 가정환경
    EDUCATION("EDUCATION"), // 학력
    AGE("AGE"), // 나이
    RESIDENCE("RESIDENCE"), // 거주지
    DRINKING("DRINKING"), // 음주
    SMOKING("SMOKING"), // 흡연
    RELIGION("RELIGION"); // 종교

    private final String importantInPartner;

    ImportantInPartner(String importantInPartner) {
        this.importantInPartner = importantInPartner;
    }

    public String getImportantInPartner() {
        return importantInPartner;
    }
}
