package com.example.shariful.librarymanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shariful.librarymanagement.Models.RegisterBook;
import com.example.shariful.librarymanagement.retrofit.ApiInterface;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class UnRegisterBook extends AppCompatActivity {

    private EditText uUsername,uReg,uBookId;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_un_register_book);

        uUsername = findViewById(R.id.uUserName);
        uUsername = findViewById(R.id.uRegNumber);
        uUsername = findViewById(R.id.uBookid);
        submit = findViewById(R.id.submit_unregister_book);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performUnRegiter();
            }
        });
    }


    public void performUnRegiter()
    {
        final String username = uUsername.getText().toString().trim();
        final String reg = uUsername.getText().toString().trim();
        final String bookid = uUsername.getText().toString().trim();

        retrofit2.Call<RegisterBook> call = MainActivity.apiInterface.unregisterBook(username,reg,bookid);

        call.enqueue(new Callback<RegisterBook>() {
            @Override
            public void onResponse(retrofit2.Call<RegisterBook> call, Response<RegisterBook> response) {
                if(response.isSuccessful())
                {
                    if(response.body().getResponse().equals("ok")){
                        Toast.makeText(UnRegisterBook.this,"UnRegistered successfully",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(UnRegisterBook.this,"Data not found.Incorrect Information",Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(retrofit2.Call<RegisterBook> call, Throwable t) {

                Toast.makeText(UnRegisterBook.this,t.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
