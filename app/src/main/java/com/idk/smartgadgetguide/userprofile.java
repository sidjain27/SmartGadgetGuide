package com.idk.smartgadgetguide;

public class userprofile {
    public String userphno;
    public String useremail;
    public String username;

    public userprofile(){
    }

    public userprofile(String userphno, String useremail, String username) {
        this.userphno = userphno;
        this.useremail = useremail;
        this.username = username;
    }

    public String getUserphno() {
        return userphno;
    }

    public void setUserAge(String userphno) {
        this.userphno = userphno;
    }

    public String getUserEmail() {
        return useremail;
    }

    public void setUserEmail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }
}