package org.sometimes.sometimes.certificationEmail.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class CertificationEmailConfig {

    @Value("${email.address}")
    private String emailAddress;

    @Value("${email.password}")
    private String password;

    @Bean
    public JavaMailSender mailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(emailAddress);
        mailSender.setPassword(password);

        Properties javaMailProperties = getProperties();

        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;
    }

    private static Properties getProperties() {
        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.debug", "true");
        javaMailProperties.put("mail.smtp.ssl.trust", "smtp.naver.com");
        javaMailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        return javaMailProperties;
    }
}
