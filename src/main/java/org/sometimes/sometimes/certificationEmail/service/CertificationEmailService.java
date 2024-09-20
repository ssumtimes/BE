package org.sometimes.sometimes.certificationEmail.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sometimes.sometimes.certificationEmail.repository.EmailRepository;
import org.sometimes.sometimes.certificationEmail.web.dto.EmailReqDto;
import org.sometimes.sometimes.certificationEmail.web.entity.EmailEntity;
import org.sometimes.sometimes.global.web.advice.exception.CustomDataIntegrityViolationException;
import org.sometimes.sometimes.global.web.advice.exception.CustomNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;


@Service
@RequiredArgsConstructor
@Slf4j
public class CertificationEmailService {

    private final JavaMailSender mailSender;
    private final EmailService emailService;
    private final EmailRepository emailRepository;

    private final String verificationCode = generateRandomNumber(100000, 999999);

    @Value("${email.address}")
    private String emailAddress;

    private final long EXPIRE_TIME = 60*5;

    public void joinEmail(EmailReqDto emailReqDto) {

        String title = "[썸타임즈 인증] 쇼핑몰 가입 인증번호";
        String content =
                "<div style=\"font-family: Arial, sans-serif; font-size: 14px; color: #333;\">" +
                        "<h2 style=\"color: #2E86C1;\">썸타임즈 가입 인증번호</h2>" +
                        "<p>회원가입 창으로 돌아가 인증 번호를 정확히 입력해주세요.</p>" +
                        "<div style=\"margin: 20px 0; padding: 10px; border: 1px solid #2E86C1; display: inline-block;\">" +
                        "<span style=\"font-size: 24px; font-weight: bold;\">" + verificationCode + "</span>" +
                        "</div>" +
                        "<p>감사합니다!</p>" +
                        "</div>";

        mailSend(emailReqDto, title, content);
    }

    @Transactional
    public void mailSend(EmailReqDto emailReqDto, String title, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(emailAddress);
            helper.setTo(emailReqDto.getEmail());
            helper.setSubject(title);
            helper.setText(content, true);
            mailSender.send(message);
            emailService.setEmailInfo(emailReqDto, verificationCode);
        } catch (MessagingException e) {
            log.info(e.getMessage());
        }
    }

    // min과 max 사이의 랜덤한 정수를 반환하는 메서드
    private String generateRandomNumber(int min, int max) {
        Random random = new Random();
        int randomNum = random.nextInt(max - min + 1) + min;

        return Integer.toString(randomNum);
    }

    public void checkAuthNum(String email, String verificationCode) {
        EmailEntity emailEntity = emailRepository.findById(email)
                .orElseThrow(() -> new CustomNotFoundException("일치하는 이메일이 없습니다."));

        String storedVerificationCode = emailEntity.getVerificationCode();

        if(storedVerificationCode == null) {
            throw new CustomNotFoundException("인증번호가 없습니다.");
        }

        if(!storedVerificationCode.equals(verificationCode)) {
            throw new CustomDataIntegrityViolationException("인증번호가 일치하지 않습니다.");
        }
    }

}
