package com.example.shariful.librarymanagement.Models;

import com.google.gson.annotations.SerializedName;

public class Login_stu {

    @SerializedName("username")
    String username;
    @SerializedName("password")
    String password;
    @SerializedName("response")
    String response;
    int id;

    public void setResponse(String response) {
        this.response = response;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setReponse(String reponse) {
        this.response = reponse;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
