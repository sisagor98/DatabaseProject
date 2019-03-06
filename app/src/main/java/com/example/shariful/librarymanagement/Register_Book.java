package com.example.shariful.librarymanagement;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.shariful.librarymanagement.Models.RegisterBook;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register_Book extends AppCompatActivity {

    private EditText EditTextusername;
    private EditText EditTextreg;
    private EditText EditTextbookname;
    private EditText EditTextbookid;
    private EditText EditTextdate;
    private Button submit;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__book);
        EditTextusername = findViewById(R.id.editTextUsernamee);
        EditTextreg = findViewById(R.id.editTextRegNumber);
        EditTextbookname = findViewById(R.id.editTextBooknamee);
        EditTextbookid = findViewById(R.id.editTextBookid);
        EditTextdate = findViewById(R.id.editTextdate);

        progressDialog = new ProgressDialog(Register_Book.this);

        submit = findViewById(R.id.submit_register_book);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerbook();
            }
        });


    }
    public void registerbook()
    {
        final String username = EditTextusername.getText().toString().trim();
        final String reg = EditTextreg.getText().toString().trim();
        final String bookname = EditTextbookname.getText().toString().trim();
        final String bookid = EditTextbookid.getText().toString().trim();
        final String date= EditTextdate.getText().toString().trim();

        progressDialog.setMessage("submitting");
        progressDialog.show();

        Call<RegisterBook> call = MainActivity.apiInterface.registerBook(username,reg,bookname,bookid,date);
        call.enqueue(new Callback<RegisterBook>() {
            @Override
            public void onResponse(Call<RegisterBook> call, Response<RegisterBook> response) {
                if(response.isSuccessful())
                {
                    progressDialog.dismiss();
                    if(response.body().getResponse().equals("ok"))
                    {
                        Toast.makeText(Register_Book.this,"submmit sucessful",Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(Register_Book.this," error occured",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterBook> call, Throwable t) {

                progressDialog.dismiss();
                Toast.makeText(Register_Book.this,"submmit not sucessful",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
