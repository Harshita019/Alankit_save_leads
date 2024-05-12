package com.example.alankit_leads;

public class data {

    String Userid, Userpass, Lastlogin;

    public data(String userid, String userpass, String lastlogin) {
        Userid = userid;
        Userpass = userpass;
        Lastlogin = lastlogin;
    }

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }

    public String getUserpass() {
        return Userpass;
    }

    public void setUserpass(String userpass) {
        Userpass = userpass;
    }

    public String getLastlogin() {
        return Lastlogin;
    }

    public void setLastlogin(String lastlogin) {
        Lastlogin = lastlogin;
    }
}
