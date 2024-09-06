package com.nocountry.server.service.email.impl;

import com.nocountry.server.model.entity.Token;
import com.nocountry.server.model.entity.User;
import com.nocountry.server.repository.TokenRepository;
import com.nocountry.server.service.email.IEmailService;
import com.nocountry.server.service.email.ISendEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class SendEmailServiceImpl implements ISendEmailService {

    @Value("${spring.mailing.frontend.activation-url}")
    private String activationURL;
    private final IEmailService emailService;
    private final TokenRepository tokenRepository;

    @Override
    public void sendValidationEmail(User user) {
        String token = generateAndSaveActivationToken(user);

        emailService.sendEmail(user.getEmail(), user.fullName(), activationURL,
                token, "Account activation", EmailTemplate.VALIDATION_ACCOUNT);
    }

    private String generateAndSaveActivationToken(User user) {
        String generatedToken = generateActivationCode();

        Token token = Token.builder()
                .token(generatedToken)
                .user(user)
                .createdAt(LocalDateTime.now())
                .expiredAt(LocalDateTime.now().plusMinutes(10))
                .build();

        tokenRepository.save(token);
        return generatedToken;
    }

    private String generateActivationCode() {
        final int CODE_LENGTH = 6;
        final String ACTIVATION_CODE_CHARSET = "012345679";

        StringBuilder codeBuilder = new StringBuilder();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < CODE_LENGTH; i++) {
            int randomIndex = random.nextInt(ACTIVATION_CODE_CHARSET.length());
            codeBuilder.append(ACTIVATION_CODE_CHARSET.charAt(randomIndex));
        }
        return codeBuilder.toString();
    }
}