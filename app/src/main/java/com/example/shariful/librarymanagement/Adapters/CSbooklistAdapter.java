package com.example.shariful.librarymanagement.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shariful.librarymanagement.MainActivity;
import com.example.shariful.librarymanagement.Models.CseBookList;
import com.example.shariful.librarymanagement.R;
import com.example.shariful.librarymanagement.fragment.LoginFragment;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

import static com.example.shariful.librarymanagement.retrofit.ApiClient.retrofit;

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
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        final int position = i;

        viewHolder.b.setText(Cs.get(i).getBookname());
        viewHolder.w.setText(Cs.get(i).getWritername());
        viewHolder.e.setText(Cs.get(i).getEdition());
        viewHolder.a.setText(Cs.get(i).getAmount());


        if(!LoginFragment.prefConfig.readLoginStatus()) {
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    // Toast.makeText(context,"Long clicked"+ position + viewHolder.b.getText(),Toast.LENGTH_SHORT).show();
                    deleteItem(position, viewHolder.b.getText(), viewHolder.w.getText());
                    Cs.remove(position);
                    notifyDataSetChanged();
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return Cs.size();
    }

    public void filterList(List<CseBookList> filteredList){
        Cs = filteredList;
        notifyDataSetChanged();

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

    public void deleteItem(int position, CharSequence b, CharSequence w){



        final String bookname = b.toString().trim();
        final String writername = w.toString().trim();

        retrofit2.Call<CseBookList> call = MainActivity.apiInterface.deleteBook(bookname);

        call.enqueue(new Callback<CseBookList>() {
            @Override
            public void onResponse(retrofit2.Call<CseBookList> call, Response<CseBookList> response) {
                Toast.makeText(context,"delete complete",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(retrofit2.Call<CseBookList> call, Throwable t) {
                Toast.makeText(context,"delete complete ",Toast.LENGTH_LONG).show();
            }
        });

    }

}
