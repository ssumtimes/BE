package org.sometimes.sometimes.certificationEmail.web.entity;

import jakarta.persistence.Id;
import lombok.*;
import org.sometimes.sometimes.certificationEmail.web.dto.EmailReqDto;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "email_certification", timeToLive = 60 * 3)
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class EmailEntity {

    @Id
    private String id;

    private String verificationCode;


    public static EmailEntity from(EmailReqDto emailReqDto, String verificationCode) {
        return EmailEntity.builder()
                .id(emailReqDto.getEmail())
                .verificationCode(verificationCode)
                .build();
    }
}
