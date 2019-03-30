package com.example.shariful.librarymanagement.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shariful.librarymanagement.Models.RegisterBook;
import com.example.shariful.librarymanagement.R;
import com.example.shariful.librarymanagement.RegisterStuBookList;
import com.example.shariful.librarymanagement.Register_Book;
import com.example.shariful.librarymanagement.StudentBookList;

import java.util.List;

public class RegisterStuBookListAdapter extends RecyclerView.Adapter<RegisterStuBookListAdapter.ViewHolder>{

    List<RegisterBook> registerBooks;
    Context context;

    public RegisterStuBookListAdapter(List<RegisterBook> registerBook, Context context){
        registerBooks = registerBook;
        this.context = context;

    }

    @NonNull
    @Override
    public RegisterStuBookListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.registerstudentbooklist,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final RegisterStuBookListAdapter.ViewHolder viewHolder, int i) {

        viewHolder.username.setText(registerBooks.get(i).getUsername());
        viewHolder.reg.setText(registerBooks.get(i).getReg());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Open(viewHolder.username.getText(),viewHolder.reg.getText());


                //Toast.makeText(context,"On clicked" ,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return registerBooks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView username, reg, textView1, textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.un);
            reg = itemView.findViewById(R.id.r);
        }
    }

    public void Open(CharSequence username, CharSequence reg)
    {
        Intent intent = new Intent(context, StudentBookList.class);

        intent.putExtra("username",username);
        intent.putExtra("reg",reg);
        context.startActivity(intent);
    }
}
