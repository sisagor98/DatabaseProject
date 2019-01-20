package com.example.shariful.librarymanagement.fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shariful.librarymanagement.BookCategory;
import com.example.shariful.librarymanagement.Config.PrefConfig;
import com.example.shariful.librarymanagement.MainActivity;
import com.example.shariful.librarymanagement.Models.Login_stu;
import com.example.shariful.librarymanagement.R;
import com.example.shariful.librarymanagement.retrofit.ApiClient;
import com.example.shariful.librarymanagement.retrofit.ApiInterface;

import retrofit2.Callback;
import retrofit2.Response;


public class LoginFragment extends android.support.v4.app.Fragment {

    TextView textView;

    private EditText editTextusername;
    private EditText editTextpassword;
    private Button loginButton;
    private ProgressDialog loginProgessDialog;

    public  static PrefConfig prefConfig;

    public interface Listeners{
        void performRegister();
    }

    Listeners mListener;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);

        prefConfig=new PrefConfig(getActivity());
        if(prefConfig.readLoginStatus()){
            getActivity().finish();
            startActivity(new Intent(getActivity(),BookCategory.class));
        }

        editTextusername = view.findViewById(R.id.editTextUsernameLogin);
        editTextpassword = view.findViewById(R.id.editTextPasswordLogin);
        loginButton = view.findViewById(R.id.buttonLogin);
        loginProgessDialog = new ProgressDialog(getActivity());

        textView=view.findViewById(R.id.registerText);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.performRegister();

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MainActivity mainActivity= (MainActivity) context;
        mListener= (Listeners) mainActivity;
    }


    public void performLogin(){
        final String username = editTextusername.getText().toString().trim();
        final String password = editTextpassword.getText().toString().trim();

        loginProgessDialog.setMessage("Logging...");
        loginProgessDialog.show();

        retrofit2.Call<Login_stu> call = MainActivity.apiInterface.loginStudent(username,password);
        call.enqueue(new Callback<Login_stu>() {
            @Override
            public void onResponse(retrofit2.Call<Login_stu> call, Response<Login_stu> response) {
                if(response.isSuccessful()){
                    loginProgessDialog.dismiss();
                    if (response.body().getResponse().equals("ok")) {
                        LoginFragment.prefConfig.writeLoginStatus(true);
                        Toast.makeText(getActivity(), "Login Successful", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getActivity(), BookCategory.class) );
                    }
                    if(response.body().getResponse().equals("failed")){
                        Toast.makeText(getActivity(),"Login Faied,Enter correct user name and password",Toast.LENGTH_LONG).show();                    }
                }
            }

            @Override
            public void onFailure(retrofit2.Call<Login_stu> call, Throwable t) {
                loginProgessDialog.dismiss();
                Toast.makeText(getActivity(),"Error Occured,Try Again",Toast.LENGTH_LONG).show();
            }
        });
    }
}
