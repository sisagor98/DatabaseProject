package com.example.shariful.librarymanagement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SearchEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.SearchManager;
import com.example.shariful.librarymanagement.Adapters.CSbooklistAdapter;
import com.example.shariful.librarymanagement.Config.PrefConfig;
import com.example.shariful.librarymanagement.Models.CseBookList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CSE_Book_List extends AppCompatActivity {


    private FloatingActionButton addbookbutton;

    List<CseBookList> mcse;



    private RecyclerView recyclerView;
    private CSbooklistAdapter adapter;
    private EditText editTextSearch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse__book__list);

        addbookbutton = findViewById(R.id.csebookinsertbutton);

        PrefConfig prefConfig = new PrefConfig(CSE_Book_List.this);

        if(!prefConfig.readLoginStatus()) {
            addbookbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(CSE_Book_List.this, AddCseBook.class));
                    //Toast.makeText(CSE_Book_List.this,"Working",Toast.LENGTH_LONG).show();
                }
            });
        }
        else{
            addbookbutton.hide();
        }

        recyclerView = findViewById(R.id.recycleview_cse);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        editTextSearch = findViewById(R.id.editTextSearch);
        editTextSearch.requestFocus();

        if(!editTextSearch.getText().equals("")) {
            editTextSearch.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if(!s.toString().equals(""))
                        filter(s.toString());
                }
            });
        }

        Call<List<CseBookList>> call=MainActivity.apiInterface.csebooklist();
        call.enqueue(new Callback<List<CseBookList>>() {
            @Override
            public void onResponse(Call<List<CseBookList>> call, Response<List<CseBookList>> response) {
                mcse=response.body();
                if(mcse.size()>0){
                    adapter=new CSbooklistAdapter(mcse,CSE_Book_List.this);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<List<CseBookList>> call, Throwable t) {

                Toast.makeText(CSE_Book_List.this,"Database Connection failed. "+ t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    public void filter(String Text)
    {
        //Toast.makeText(CSE_Book_List.this,"Ok",Toast.LENGTH_SHORT).show();
        List<CseBookList> filteredList = new ArrayList<>();
        if(filteredList.isEmpty()) {
            for (CseBookList item : mcse) {
                if (item.getBookname().toLowerCase().contains(Text.toLowerCase())) {
                    filteredList.add(item);
                }
            }
        }
        adapter.filterList(filteredList);
    }
}

