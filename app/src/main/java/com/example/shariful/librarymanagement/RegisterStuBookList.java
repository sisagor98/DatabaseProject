package com.example.shariful.librarymanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.shariful.librarymanagement.Adapters.RegisterStuBookListAdapter;
import com.example.shariful.librarymanagement.Models.RegisterBook;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterStuBookList extends AppCompatActivity {

    List<RegisterBook> registerBooks;

    private RecyclerView recyclerView;
    private RegisterStuBookListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_stu_book_list);

        recyclerView = findViewById(R.id.rc);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final Call<List<RegisterBook>> registerbook = MainActivity.apiInterface.registerStuBookList();

        registerbook.enqueue(new Callback<List<RegisterBook>>() {
            @Override
            public void onResponse(Call<List<RegisterBook>> call, Response<List<RegisterBook>> response) {
                if(response.isSuccessful()) {
                    //Toast.makeText(RegisterStuBookList.this,"ok",Toast.LENGTH_SHORT).show();
                    registerBooks = response.body();
                }
                /*String s = registerBooks.get(0).getUsername().toString();
                Toast.makeText(RegisterStuBookList.this,s,Toast.LENGTH_LONG).show();*/
                adapter = new RegisterStuBookListAdapter(registerBooks,RegisterStuBookList.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<RegisterBook>> call, Throwable t) {

                Toast.makeText(RegisterStuBookList.this,"Database Connection failed. "+ t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
