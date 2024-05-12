package com.example.alankit_leads;

public class Post {

    String Rescode, Status, Message;

    public Post(String rescode, String status, String message) {
        Rescode = rescode;
        Status = status;
        Message = message;
    }

    public String getRescode() {
        return Rescode;
    }

    public void setRescode(String rescode) {
        Rescode = rescode;
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
