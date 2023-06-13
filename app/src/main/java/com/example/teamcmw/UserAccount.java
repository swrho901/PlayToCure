package com.example.teamcmw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UserAccount {

    public UserAccount() {
    }

    public String getIdToken(){return IdToken;}
    public void setIdToken(String IdToken){this.IdToken=IdToken;}
    private String IdToken;


    public String getEmailId(){return emailId;}
    public void setEmailId(String emailId){this.emailId=emailId;}
    private String emailId;


    public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}
    private String password;



}