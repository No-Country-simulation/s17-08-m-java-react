package com.nocountry.server.service.email;

import com.nocountry.server.service.email.impl.EmailTemplate;

public interface IEmailService {

    void sendEmail(String toUser, String username,
                   String confirmationUrl, String activationCode,
                   String subject, EmailTemplate emailTemplate);
}
