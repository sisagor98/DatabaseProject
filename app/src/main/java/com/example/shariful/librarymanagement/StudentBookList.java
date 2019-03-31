package com.example.shariful.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shariful.librarymanagement.Adapters.RegisterStuBookListAdapter;
import com.example.shariful.librarymanagement.Adapters.StudentBookListAdapter;
import com.example.shariful.librarymanagement.Models.RegisterBook;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentBookList extends AppCompatActivity {

    List<RegisterBook> rb;
    private RecyclerView recyclerView;
    private StudentBookListAdapter adapter;

    private TextView us, reg;



    private String uname,r;
    private RegisterStuBookListAdapter registerStuBookListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_book_list);

        us = findViewById(R.id.us);
        reg = findViewById(R.id.reg);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!=null){
            uname = (String) bundle.get("username");
            us.setText(uname);
            //Toast.makeText(StudentBookList.this,username,Toast.LENGTH_SHORT).show();
            r = (String) bundle.get("reg");
            reg.setText(r);
        }

        recyclerView = findViewById(R.id.rcv);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        showRegStuBookList();
    }

    public void showRegStuBookList()
    {
        final String username = uname.toString().trim();
        final String reg = r.toString().trim();


        Call<List<RegisterBook>> call = MainActivity.apiInterface.studentBookList(username,reg);

        call.enqueue(new Callback<List<RegisterBook>>() {
            @Override
            public void onResponse(Call<List<RegisterBook>> call, Response<List<RegisterBook>> response) {

                rb = response.body();
                if(rb.size()>0)
                {
                    adapter = new StudentBookListAdapter(rb,StudentBookList.this);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<RegisterBook>> call, Throwable t) {

                Toast.makeText(StudentBookList.this,"Error Occured",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
