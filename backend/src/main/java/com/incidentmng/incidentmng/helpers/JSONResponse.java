package com.incidentmng.incidentmng.helpers;


import java.io.Serializable;
import java.time.LocalDateTime;

public class JSONResponse implements Serializable {
    String message;
    LocalDateTime timestamp;

    public JSONResponse(String message) {
        this.message = message;
        timestamp = LocalDateTime.now();

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
