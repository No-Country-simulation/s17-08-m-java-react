package com.nocountry.server.service.email;

import com.nocountry.server.model.entity.User;

public interface ISendEmailService {

        void sendValidationEmail(User user);
}
