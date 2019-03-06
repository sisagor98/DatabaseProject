package com.example.shariful.librarymanagement;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shariful.librarymanagement.Config.PrefConfig;
import com.example.shariful.librarymanagement.Models.CseBookList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCseBook extends AppCompatActivity {

    public static PrefConfig prefConfig;

    private Button submit;
    private EditText editBookname;
    private EditText editWritername;
    private EditText editEdition;
    private EditText editAmount;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcsebook);

        submit = findViewById(R.id.addbookButton);
//        prefConfig = new PrefConfig(AddCseBook.this);
//        if(!prefConfig.readAdminLoginStatus()){
//            submit.setVisibility(View.INVISIBLE);
//        }
        editBookname = findViewById(R.id.editTextBookname);
        editWritername = findViewById(R.id.editTextWritername);
        editEdition = findViewById(R.id.editTextEdition);
        editAmount = findViewById(R.id.editTextAmount);
        progressDialog = new ProgressDialog(AddCseBook.this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addbook();
            }
        });

    }

    public void addbook(){
        final String bookname = editBookname.getText().toString().trim();
        final String writername = editWritername.getText().toString().trim();
        final String edition = editEdition.getText().toString().trim();
        final String amount = editAmount.getText().toString().trim();

        progressDialog.setMessage("Loading..");
        progressDialog.show();

        if(bookname.equals("") || writername.equals("") || edition.equals("") || amount.equals("")){
            progressDialog.dismiss();
            Toast.makeText(AddCseBook.this,"Empty field detected",Toast.LENGTH_SHORT).show();
            return;
        }


        Call<CseBookList> addbook = MainActivity.apiInterface.addcsebook(bookname,writername,edition,amount);

        addbook.enqueue(new Callback<CseBookList>() {
            @Override
            public void onResponse(Call<CseBookList> call, Response<CseBookList> response) {
                if(response.isSuccessful()){
                    progressDialog.dismiss();
                    if(response.body().getResponse().equals("ok")){
                        Toast.makeText(AddCseBook.this,"Book Listed",Toast.LENGTH_LONG).show();
                    }
                    else if(response.body().getResponse().equals("exist")){
                        Toast.makeText(AddCseBook.this,"Book exist",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(AddCseBook.this,"Error",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CseBookList> call, Throwable t) {

                progressDialog.dismiss();
                Toast.makeText(AddCseBook.this,"Error Occured",Toast.LENGTH_LONG).show();
            }
        });
    }
}



