package com.example.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class HttpError {
    private String path;
    private int status;
    private String message;
    private String timestamp;
}
