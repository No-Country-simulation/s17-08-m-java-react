package com.nocountry.server.service.email.impl;

import lombok.Getter;

@Getter
public enum EmailTemplate {

    VALIDATION_ACCOUNT("validation_account");

    private final String templateName;

    EmailTemplate(String templateName) {
        this.templateName = templateName;
    }
}
