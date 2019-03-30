package com.example.shariful.librarymanagement.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shariful.librarymanagement.Models.Register_stu;
import com.example.shariful.librarymanagement.R;
import com.example.shariful.librarymanagement.RegisterStuBookList;
import com.example.shariful.librarymanagement.RegisterStudentList;
import com.example.shariful.librarymanagement.StudentBookList;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

public class RSLAdapter extends RecyclerView.Adapter<RSLAdapter.ViewHolder> {

    List<Register_stu> rs;
    Context context;

    public RSLAdapter(List<Register_stu> rs, Context context) {
        this.rs = rs;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.registerstudentadapter,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.username.setText(rs.get(i).getUsername());
        viewHolder.department.setText(rs.get(i).getDepartment());
        viewHolder.reg.setText(rs.get(i).getReg());
        viewHolder.phone.setText(rs.get(i).getPhone());

    }

    @Override
    public int getItemCount() {
        return rs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView username;
        private TextView department;
        private TextView reg;
        private TextView phone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.username);
            department = itemView.findViewById(R.id.dept);
            reg = itemView.findViewById(R.id.reg);
            phone = itemView.findViewById(R.id.phone);
        }
    }
}
