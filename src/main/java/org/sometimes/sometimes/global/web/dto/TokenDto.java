package org.sometimes.sometimes.global.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TokenDto {

    private String tokenType;
    private String accessToken;
    private String refreshToken;

    public static TokenDto from(String accessToken, String refreshToken) {
        return TokenDto.builder()
                .tokenType("Bearer ")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
