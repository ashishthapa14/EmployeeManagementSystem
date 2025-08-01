package com.project.ems.exception;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ErrorInfo {
//    private String
    private String errorMessage;
    private LocalDateTime timeStamp;
    private Integer errorCode;
}
