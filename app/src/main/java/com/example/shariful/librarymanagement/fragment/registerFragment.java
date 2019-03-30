package com.example.shariful.librarymanagement.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shariful.librarymanagement.MainActivity;
import com.example.shariful.librarymanagement.R;
import com.example.shariful.librarymanagement.Models.Register_stu;

import retrofit2.Call;
import retrofit2.Callback;


public class registerFragment extends android.support.v4.app.Fragment {

    private EditText editTextUsername, editTextEmail, editTextPassword;
    private EditText editTextDepartment, editTextReg, editTextSession, editTextPhone;
    private ProgressDialog progressDialog;


    private Button submit;


    public  registerFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_register, container, false);

        editTextEmail = (EditText) view. findViewById(R.id.editTextEmail);
        editTextUsername = (EditText)view. findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) view.findViewById(R.id.editTextPassword);
        editTextDepartment = (EditText) view.findViewById(R.id.editTextDepartment);
        editTextReg = (EditText) view.findViewById(R.id.editTextReg);
        editTextSession = (EditText) view.findViewById(R.id.editTextSession);
        editTextPhone = (EditText) view.findViewById(R.id.editTextPhone);
        progressDialog = new ProgressDialog(getActivity());

        submit = view.findViewById(R.id.submitButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        return  view;
    }

    public void registerUser() {
        final String email = editTextEmail.getText().toString().trim();
        final String username = editTextUsername.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        final String department = editTextDepartment.getText().toString().trim();
        final String reg = editTextReg.getText().toString().trim();
        final String session = editTextSession.getText().toString().trim();
        final String phone = editTextPhone.getText().toString().trim();


        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        if(email.equals("") || username.equals("") || password.equals("") || department.equals("")
                || reg.equals("") || session.equals("") || phone.equals(""))
        {
            progressDialog.dismiss();
            Toast.makeText(getActivity(),"Empty field detected",Toast.LENGTH_SHORT).show();
            return;
        }

        Call<Register_stu> call =MainActivity.apiInterface.registerStudent(username, email, password, department, reg, session, phone);

        call.enqueue(new Callback<Register_stu>() {
            @Override
            public void onResponse(Call<Register_stu> call, retrofit2.Response<Register_stu> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    if (response.body().getResponse().equals("ok")) {
                        Toast.makeText(getActivity(), "Registerd", Toast.LENGTH_LONG).show();
                    }

                }
            }

            @Override
            public void onFailure(Call<Register_stu> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Not Registered"+t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }


}
