package com.example.shariful.librarymanagement.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shariful.librarymanagement.Models.RegisterBook;
import com.example.shariful.librarymanagement.R;
import com.example.shariful.librarymanagement.StudentBookList;

import java.util.List;

public class StudentBookListAdapter extends RecyclerView.Adapter<StudentBookListAdapter.ViewHolder> {


    private List<RegisterBook> rs;
    Context context;

    public StudentBookListAdapter(List<RegisterBook>rs, Context context){

        this.rs = rs;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentBookListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.studentbooklistadapter,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentBookListAdapter.ViewHolder viewHolder, int i) {

        viewHolder.bookname.setText(rs.get(i).getBookname());
        viewHolder.bookid.setText(rs.get(i).getBookid());
        viewHolder.date.setText(rs.get(i).getDate());
    }

    @Override
    public int getItemCount() {
        return rs.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView bookname;
        private TextView bookid;
        private TextView date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bookname = itemView.findViewById(R.id.bn);
            bookid = itemView.findViewById(R.id.bi);
            date = itemView.findViewById(R.id.date);
        }
    }

}
