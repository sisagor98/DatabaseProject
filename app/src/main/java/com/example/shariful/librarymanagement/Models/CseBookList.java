package com.example.shariful.librarymanagement.Models;

import com.google.gson.annotations.SerializedName;

public class CseBookList {

    @SerializedName("bookname")
    String bookname;
    @SerializedName("writername")
    String writername;
    @SerializedName("edition")
    String edition;
    @SerializedName("amount")
    String amount;
    @SerializedName("response")
    String response;
    @SerializedName("id")
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getWritername() {
        return writername;
    }

    public void setWritername(String writername) {
        this.writername = writername;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
