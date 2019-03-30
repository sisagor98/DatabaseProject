package com.example.shariful.librarymanagement.Models;

import com.google.gson.annotations.SerializedName;

public class RegisterBook {
    @SerializedName("username")
    private String username;
    @SerializedName("reg")
    private String reg;
    @SerializedName("bookname")
    private String bookname;
    @SerializedName("bookid")
    private String bookid;
    @SerializedName("date")
    private String date;
    @SerializedName("id")
    private String id;
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

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
