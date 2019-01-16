package com.example.shariful.librarymanagement.fragment;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shariful.librarymanagement.MainActivity;
import com.example.shariful.librarymanagement.R;


public class LoginFragment extends android.support.v4.app.Fragment {

    TextView textView;

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


        textView=view.findViewById(R.id.registerText);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.performRegister();

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
}
