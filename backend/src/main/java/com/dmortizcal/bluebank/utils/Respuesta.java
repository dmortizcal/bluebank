package com.dmortizcal.bluebank.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Respuesta extends ResponseEntity<String> {
    public Respuesta(HttpStatus status) {
        super(status);
    }

    public static Message mensage(String message) {
        Message m = new Message();
        m.setTimestamp(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT));
        m.setStatus(200);
        m.setMessage(message);

        return m;
    }


    static class Message {

        private String timestamp;
        private int status;
        private String message;

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
