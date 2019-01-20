package com.example.shariful.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BookCategory extends AppCompatActivity {


    private Button cse_book_list;
    private Button eee_book_list;
    private Button civil_book_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_category);

        cse_book_list = findViewById(R.id.cse_book_list);
        eee_book_list = findViewById(R.id.eee_book_list);
        civil_book_list = findViewById(R.id.civil_book_list);

        cse_book_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookCategory.this,CSE_Book_List.class));
            }
        });
        eee_book_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookCategory.this,EEE_book_list.class));
            }
        });
        civil_book_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookCategory.this,CIVIL_book_list.class));
            }
        });
    }
}
