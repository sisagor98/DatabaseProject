package com.example.shariful.librarymanagement.retrofit;

import com.example.shariful.librarymanagement.Register_stu;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("register_stu.php")
    Call<Register_stu> registerStudent (@Query("username") String username,
                                        @Query("email") String email,
                                        @Query("password") String password,
                                        @Query("department") String department,
                                        @Query("reg") String reg,
                                        @Query("session") String session,
                                        @Query("phone") String phone);
}
