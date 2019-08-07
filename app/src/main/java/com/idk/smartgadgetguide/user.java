package com.idk.smartgadgetguide;

public class user {
    private String name;
    private String pass;
    private String phno;
    private String email;

    public user() {
    }

    public user(String userid, String pin, String phoneno, String email) {
        this.name = userid;
        this.pass = pin;
        this.phno = phoneno;
        this.email = email;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pin) {
        this.pass = pin;
    }

    public String getPhoneno() {
        return phno;
    }

    public void setPhoneno(String phoneno) {
        this.phno = phoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}