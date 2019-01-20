package com.example.shariful.librarymanagement.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shariful.librarymanagement.Models.CseBookList;
import com.example.shariful.librarymanagement.R;

import java.util.List;

public class CSbooklistAdapter extends RecyclerView.Adapter<CSbooklistAdapter.ViewHolder> {
    List<CseBookList> Cs;
    Context context;

    public CSbooklistAdapter(List<CseBookList> cs, Context context) {
        Cs = cs;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_adapter,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {


        viewHolder.b.setText(Cs.get(i).getBookname());
        viewHolder.w.setText(Cs.get(i).getWritername());
        viewHolder.e.setText(Cs.get(i).getEdition());
        viewHolder.a.setText(Cs.get(i).getAmount());
    }

    @Override
    public int getItemCount() {
        return Cs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView b;
        public TextView w;
        public TextView e;
        public TextView a;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            b = itemView.findViewById(R.id.b);
            w = itemView.findViewById(R.id.w);
            e = itemView.findViewById(R.id.e);
            a = itemView.findViewById(R.id.a);
        }
    }
}
