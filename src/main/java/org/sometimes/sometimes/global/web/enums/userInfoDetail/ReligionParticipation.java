package org.sometimes.sometimes.global.web.enums.userInfoDetail;

public enum ReligionParticipation {

    NO("NO"), // 종교 없음
    LOW("LOW"), // 낮음 (가끔, 관심이 있음)
    MIDDLE("MIDDLE"), // 보통
    HIGH("HIGH"); // 높음 (매주, 독실함)

    private final String participation;

    ReligionParticipation(String participation) {
        this.participation = participation;
    }

    public String getParticipation() {
        return participation;
    }
}
