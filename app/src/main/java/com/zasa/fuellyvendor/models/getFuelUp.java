package com.zasa.fuellyvendor.models;

public class getFuelUp {
    private String id;
    private String Status;
    private String Message;

    public getFuelUp(String id, String status, String message) {
        this.id = id;
        Status = status;
        Message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
