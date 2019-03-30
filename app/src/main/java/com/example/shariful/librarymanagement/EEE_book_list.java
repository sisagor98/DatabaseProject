package com.example.shariful.librarymanagement;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shariful.librarymanagement.Adapters.CSbooklistAdapter;
import com.example.shariful.librarymanagement.Config.PrefConfig;
import com.example.shariful.librarymanagement.Models.CseBookList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EEE_book_list extends AppCompatActivity {

    private FloatingActionButton addeeebookbutton;

    List<CseBookList> mcse;
    private RecyclerView recyclerView;
    private CSbooklistAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eee_book_list);


        EditText editTextSearch = findViewById(R.id.editTextSearchEee);
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

        PrefConfig prefConfig = new PrefConfig(EEE_book_list.this);
        addeeebookbutton= findViewById(R.id.eeebookinsertbutton);

        if(!prefConfig.readLoginStatus()) {
            addeeebookbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(EEE_book_list.this, AddEeeBook.class));
                    //Toast.makeText(EEE_book_list.this,"Working",Toast.LENGTH_LONG).show();
                }
            });
        }
        else{
            addeeebookbutton.hide();
        }

        recyclerView = findViewById(R.id.recycleview_eee);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




        Call<List<CseBookList>> call=MainActivity.apiInterface.eeebooklist();
        call.enqueue(new Callback<List<CseBookList>>() {
            @Override
            public void onResponse(Call<List<CseBookList>> call, Response<List<CseBookList>> response) {
                mcse=response.body();
                if(mcse.size()>0){
                    adapter=new CSbooklistAdapter(mcse,EEE_book_list.this);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<CseBookList>> call, Throwable t) {

                Toast.makeText(EEE_book_list.this,"Database Connection failed. "+ t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });


    }

    public void filter(String Text)
    {
        List<CseBookList> filteredListEee = new ArrayList<>();
        for(CseBookList item : mcse){
            if(item.getBookname().toLowerCase().contains(Text.toLowerCase())){
                filteredListEee.add(item);
            }
        }
        adapter.filterList(filteredListEee);
    }
}
