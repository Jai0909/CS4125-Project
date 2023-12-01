package com.kiss.carrentalsystem.response;

public class DefaultResponse {

    String message;
    Boolean status;

    public DefaultResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public boolean isSuccess() {
    return true;}
}
