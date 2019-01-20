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

public class CSE_Book_List extends AppCompatActivity {


    private FloatingActionButton addbookbutton;

    List<CseBookList> mcse;
    CseBookList mcsee;


    private RecyclerView recyclerView;
    private CSbooklistAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse__book__list);

        addbookbutton = findViewById(R.id.csebookinsertbutton);
        addbookbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CSE_Book_List.this,AddCseBook.class));
                //Toast.makeText(CSE_Book_List.this,"Working",Toast.LENGTH_LONG).show();
            }
        });

        recyclerView = findViewById(R.id.recycleview_cse);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




        Call<List<CseBookList>> call=MainActivity.apiInterface.csebooklist();
        call.enqueue(new Callback<List<CseBookList>>() {
            @Override
            public void onResponse(Call<List<CseBookList>> call, Response<List<CseBookList>> response) {
                mcse=response.body();
                if(mcse.size()>0){
                    CSbooklistAdapter adapter=new CSbooklistAdapter(mcse,CSE_Book_List.this);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<CseBookList>> call, Throwable t) {

                Toast.makeText(CSE_Book_List.this,"Database Connection failed. "+ t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });


    }

}
