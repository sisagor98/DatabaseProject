package com.example.shariful.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.shariful.librarymanagement.Adapters.RSLAdapter;
import com.example.shariful.librarymanagement.Models.Register_stu;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterStudentList extends AppCompatActivity {
    List<Register_stu> registerStuList;
    Register_stu registerStu;

    private RecyclerView recyclerView;
    private RSLAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student_list2);

        recyclerView = findViewById(R.id.rslrecyleview);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Call<List<Register_stu>> call = MainActivity.apiInterface.registeredstulist();

        call.enqueue(new Callback<List<Register_stu>>() {
            @Override
            public void onResponse(Call<List<Register_stu>> call, Response<List<Register_stu>> response) {
                if(response.isSuccessful()){
                    registerStuList = response.body();
                    if(registerStuList.size()>0)
                    {
                        adapter = new RSLAdapter(registerStuList,RegisterStudentList.this);
                        recyclerView.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Register_stu>> call, Throwable t) {

                Toast.makeText(RegisterStudentList.this,""+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
