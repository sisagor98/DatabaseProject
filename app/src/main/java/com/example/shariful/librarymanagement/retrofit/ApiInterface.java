package com.example.shariful.librarymanagement.retrofit;

import com.example.shariful.librarymanagement.CSE_Book_List;
import com.example.shariful.librarymanagement.Models.CseBookList;
import com.example.shariful.librarymanagement.Models.Login_stu;
import com.example.shariful.librarymanagement.Models.Register_stu;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("login.php")
    Call<Login_stu> loginStudent (@Query("username") String username,@Query("password") String password);

    @GET("register_stu.php")
    Call<Register_stu> registerStudent (@Query("username") String username,
                                        @Query("email") String email,
                                        @Query("password") String password,
                                        @Query("department") String department,
                                        @Query("reg") String reg,
                                        @Query("session") String session,
                                        @Query("phone") String phone);

    @GET("cse_book_list.php")
    Call<List<CseBookList>> csebooklist();
    @GET("eee_book_list.php")
    Call<List<CseBookList>> eeebooklist();
    @GET("civil_book_list.php")
    Call<List<CseBookList>> civilbooklist();

}
