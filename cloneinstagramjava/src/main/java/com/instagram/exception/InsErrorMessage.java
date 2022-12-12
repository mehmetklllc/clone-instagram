package com.instagram.exception;

import lombok.Data;

import java.util.Date;

@Data
public class InsErrorMessage {
    private Date timestamp;
    private String message;
    private Object data;

    public InsErrorMessage(Date timestamp, String message,Object data) {
        this.message = message;
        this.timestamp = timestamp;
        this.data = data;
    }
}
