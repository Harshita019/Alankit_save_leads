package com.example.alankit_leads;

import java.util.ArrayList;

public class UserResponse {
    String rescode, Status, Message;
    private ArrayList<data> dataArrayList = null;

    public UserResponse(String rescode, String status, String message, ArrayList<data> dataArrayList) {
        this.rescode = rescode;
        Status = status;
        Message = message;
        this.dataArrayList = dataArrayList;
    }

    public String getRescode() {
        return rescode;
    }

    public void setRescode(String rescode) {
        this.rescode = rescode;
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

    public ArrayList<data> getDataArrayList() {
        return dataArrayList;
    }

    public void setDataArrayList(ArrayList<data> dataArrayList) {
        this.dataArrayList = dataArrayList;
    }
}
