package com.example.shariful.librarymanagement.Models;

import com.google.gson.annotations.SerializedName;

public class Register_stu {

        @SerializedName("username")
        String username;
        @SerializedName("email")
        String email;
        @SerializedName("password")
        String password;
        @SerializedName("department")
        String department;
        @SerializedName("reg")
        String reg;
        @SerializedName("session")
        String session;
        @SerializedName("phone")
        String phone;
        @SerializedName("id")
        int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @SerializedName("response")
        String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
