package com.letscode.starwarsresistancenetwork.exceptions;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ResistanceNetworkHttpError {

    private final LocalDateTime localDateTime = LocalDateTime.now();
    private final String message;
    private final String httpName;
    private final int httpCode;

    public ResistanceNetworkHttpError(String message, String httpName, int httpCode) {
        this.message = message;
        this.httpName = httpName;
        this.httpCode = httpCode;
    }

}
