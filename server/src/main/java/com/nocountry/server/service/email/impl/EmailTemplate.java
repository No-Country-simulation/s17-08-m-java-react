package com.nocountry.server.service.email.impl;

import lombok.Getter;

@Getter
public enum EmailTemplate {

    VALIDATION_EMAIL("validation-email");

    private final String templateName;

    EmailTemplate(String templateName) {
        this.templateName = templateName;
    }
}
