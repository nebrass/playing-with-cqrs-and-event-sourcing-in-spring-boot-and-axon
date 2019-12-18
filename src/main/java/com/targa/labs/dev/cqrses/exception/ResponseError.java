package com.targa.labs.dev.cqrses.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ResponseError {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;
    private String message;

    private ResponseError() {
        timestamp = LocalDateTime.now();
    }

    ResponseError(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.message = ex.getMessage();
    }

    ResponseError(HttpStatus status, String message) {
        this();
        this.status = status;
        this.message = message;
    }
}
