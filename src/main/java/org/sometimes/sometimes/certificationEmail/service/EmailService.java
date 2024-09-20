package org.sometimes.sometimes.certificationEmail.service;

import lombok.RequiredArgsConstructor;

import org.sometimes.sometimes.certificationEmail.repository.EmailRepository;
import org.sometimes.sometimes.certificationEmail.web.dto.EmailReqDto;
import org.sometimes.sometimes.certificationEmail.web.entity.EmailEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailRepository emailRepository;

    public void setEmailInfo(EmailReqDto emailReqDto, String verificationCode) {
        emailRepository.save(EmailEntity.from(emailReqDto, verificationCode));
    }

}
