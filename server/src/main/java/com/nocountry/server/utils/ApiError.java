package com.nocountry.server.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ApiError implements Serializable {
    String message;
    String backMessage;
    String url;
    String method;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    LocalDateTime timeStamp;
}
