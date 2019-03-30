package com.example.shariful.librarymanagement.retrofit;

import com.example.shariful.librarymanagement.CSE_Book_List;
import com.example.shariful.librarymanagement.Models.CseBookList;
import com.example.shariful.librarymanagement.Models.Login_stu;
import com.example.shariful.librarymanagement.Models.RegisterBook;
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
    @GET("registerbook.php")
    Call<RegisterBook> registerBook(@Query("username") String username,
                                    @Query("reg") String reg,
                                    @Query("bookname") String bookname,
                                    @Query("bookid") String bookid,
                                    @Query("date") String date);
    @GET("unregisterbook.php")
    Call<RegisterBook> unregisterBook(@Query("username") String username,
                                    @Query("reg") String reg,
                                    @Query("bookid") String bookid);

    @GET("student_book_list.php")
    Call<List<RegisterBook>> studentBookList(@Query("username") String username,
                                    @Query("reg") String reg);
    @GET("register_stu_booklist.php")
    Call<List<RegisterBook>> registerStuBookList();

    @GET("registered_stu_list.php")
    Call<List<Register_stu>> registeredstulist();

    @GET("deletebook.php")
    Call<CseBookList>deleteBook(@Query("bookname")String bookname);


    @GET("cse_book_list.php")
    Call<List<CseBookList>> csebooklist();
    @GET("eee_book_list.php")
    Call<List<CseBookList>> eeebooklist();
    @GET("civil_book_list.php")
    Call<List<CseBookList>> civilbooklist();

    @GET("addcsebook.php")
    Call<CseBookList> addcsebook(@Query("bookname") String bookname,
                                 @Query("writername") String writername,
                                 @Query("edition") String edition,
                                 @Query("amount") String amount);
    @GET("addeeebook.php")
    Call<CseBookList> addeeebook(@Query("bookname") String bookname,
                                 @Query("writername") String writername,
                                 @Query("edition") String edition,
                                 @Query("amount") String amount);
    @GET("addcivilbook.php")
    Call<CseBookList> addcivilbook(@Query("bookname") String bookname,
                                 @Query("writername") String writername,
                                 @Query("edition") String edition,
                                 @Query("amount") String amount);

}
