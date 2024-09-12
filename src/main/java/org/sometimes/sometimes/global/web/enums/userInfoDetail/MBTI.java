package org.sometimes.sometimes.global.web.enums.userInfoDetail;

public enum MBTI {

    INTJ("INTJ"), // 전략가형
    INTP("INTP"), // 논리학자형
    ENTJ("ENTJ"), // 통솔자형
    ENTP("ENTP"), // 발명가형
    INFJ("INFJ"), // 옹호자형
    INFP("INFP"), // 중재자형
    ENFJ("ENFJ"), // 선도자형
    ENFP("ENFP"), // 활동가형
    ISTJ("ISTJ"), // 현실주의자형
    ISFJ("ISFJ"), // 수호자형
    ESTJ("ESTJ"), // 경영자형
    ESFJ("ESFJ"), // 집정관형
    ISTP("ISTP"), // 장인형
    ISFP("ISFP"), // 모험가형
    ESTP("ESTP"), // 사업가형
    ESFP("ESFP"); // 연예인형

    private final String mbti;

    MBTI(String mbti) {
        this.mbti = mbti;
    }

    public String getMbti() {
        return mbti;
    }
}
