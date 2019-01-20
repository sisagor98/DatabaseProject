package com.example.shariful.librarymanagement;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shariful.librarymanagement.Config.PrefConfig;
import com.example.shariful.librarymanagement.fragment.LoginFragment;
import com.example.shariful.librarymanagement.fragment.registerFragment;
import com.example.shariful.librarymanagement.retrofit.ApiClient;
import com.example.shariful.librarymanagement.retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity implements LoginFragment.Listeners {

    public static ApiInterface apiInterface;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);


        //buttonRegister.setOnClickListener(this);

        LoginFragment loginFragment = new LoginFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, loginFragment).commit();


    }

    @Override
    public void performRegister() {
        registerFragment registerFragment = new registerFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, registerFragment).addToBackStack(null).commit();

    }


}
