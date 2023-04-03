package com.demo.challengealkemy.helper;

public class ResponseBase {

    private String message;
    private String headboard;

    public ResponseBase() {
    }
    public ResponseBase(String message, String headboard) {
        this.message = message;
        this.headboard = headboard;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHeadboard() {
        return headboard;
    }

    public void setHeadboard(String headboard) {
        this.headboard = headboard;
    }
}
