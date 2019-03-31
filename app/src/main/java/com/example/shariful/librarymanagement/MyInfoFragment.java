package com.example.shariful.librarymanagement;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.SaveInfo;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shariful.librarymanagement.Adapters.StudentBookListAdapter;
import com.example.shariful.librarymanagement.Config.PrefConfig;
import com.example.shariful.librarymanagement.Models.RegisterBook;
import com.example.shariful.librarymanagement.Models.Register_stu;
import com.example.shariful.librarymanagement.fragment.LoginFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MyInfoFragment extends Fragment {


    public MyInfoFragment() {
        // Required empty public constructor
    }

    private StudentBookListAdapter adapter;
    List<RegisterBook> registerBooks;
    List<Register_stu> registerStuList;
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
    private PrefConfig prefConfig;

    private TextView userName,Email,Dept,Reg,Phone;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_info, container, false);


        userName = view.findViewById(R.id.userName);
        Email = view.findViewById(R.id.Email);
        Dept = view.findViewById(R.id.Dept);
        Reg = view.findViewById(R.id.Reg);
        Phone = view.findViewById(R.id.Phone);

        prefConfig = new PrefConfig(getActivity());
        final String name = prefConfig.readUsername();

        recyclerView = view.findViewById(R.id.Rinfo);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        progressDialog = new ProgressDialog(getActivity());

        Call<List<RegisterBook>> call = MainActivity.apiInterface.studentBookList(name,"");
        Call<List<Register_stu>> call2 = MainActivity.apiInterface.registeredstulist();

        call2.enqueue(new Callback<List<Register_stu>>() {
            @Override
            public void onResponse(Call<List<Register_stu>> call, Response<List<Register_stu>> response) {
               // Toast.makeText(getActivity()," ok ",Toast.LENGTH_SHORT).show();
                Boolean check = false;
                if(response.isSuccessful())
                {

                    registerStuList = response.body();
                    for(int i=0;i<registerStuList.size();i++)
                    {
                        if(registerStuList.get(i).getUsername().equals(name))
                        {
                            userName.setText(registerStuList.get(i).getUsername());
                            Toast.makeText(getActivity(),registerStuList.get(i).getUsername().toString(),Toast.LENGTH_SHORT).show();
                            Email.setText(registerStuList.get(i).getEmail());
                            Dept.setText(registerStuList.get(i).getDepartment());
                            Reg.setText(registerStuList.get(i).getReg());
                            Phone.setText(registerStuList.get(i).getPhone());
                            check = true;
                        }
                    }
                    if(!check) {
                        userName.setVisibility(View.GONE);
                        Email.setVisibility(View.GONE);
                        Dept.setVisibility(View.GONE);
                        Reg.setVisibility(View.GONE);
                        Phone.setVisibility(View.GONE);
                        Toast.makeText(getActivity(), "You are Loggedin As An Admin", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Register_stu>> call, Throwable t) {

                Toast.makeText(getActivity(),"Error "+ t.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        call.enqueue(new Callback<List<RegisterBook>>() {
            @Override
            public void onResponse(Call<List<RegisterBook>> call, Response<List<RegisterBook>> response) {

                progressDialog.dismiss();
                if(response.isSuccessful()){

                    registerBooks = response.body();
                    adapter = new StudentBookListAdapter(registerBooks,getActivity());
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<RegisterBook>> call, Throwable t) {

               progressDialog.dismiss();
            }
        });

        return view;
    }

}
