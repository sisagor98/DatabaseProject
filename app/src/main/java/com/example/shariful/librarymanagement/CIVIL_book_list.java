package com.example.shariful.librarymanagement;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.shariful.librarymanagement.Adapters.CSbooklistAdapter;
import com.example.shariful.librarymanagement.Models.CseBookList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CIVIL_book_list extends AppCompatActivity {


    private FloatingActionButton addbookbutton;

    List<CseBookList> mcse;
    CseBookList mcsee;


    private RecyclerView recyclerView;
    private CSbooklistAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil_book_list);
        recyclerView = findViewById(R.id.recycleview_cse);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        addbookbutton = findViewById(R.id.civilbookinsertbutton);
        addbookbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CIVIL_book_list.this,AddCivilBook.class));
                //Toast.makeText(CSE_Book_List.this,"Working",Toast.LENGTH_LONG).show();
            }
        });


        Call<List<CseBookList>> call=MainActivity.apiInterface.civilbooklist();
        call.enqueue(new Callback<List<CseBookList>>() {
            @Override
            public void onResponse(Call<List<CseBookList>> call, Response<List<CseBookList>> response) {
                mcse=response.body();
                if(mcse.size()>0){
                    CSbooklistAdapter adapter=new CSbooklistAdapter(mcse,CIVIL_book_list.this);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<CseBookList>> call, Throwable t) {

                Toast.makeText(CIVIL_book_list.this,"Database Connection failed. "+ t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });


    }

}
