package com.example.shariful.librarymanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.shariful.librarymanagement.Adapters.CSbooklistAdapter;
import com.example.shariful.librarymanagement.Config.PrefConfig;

public class BookCategoryFragment extends Fragment {

    private PrefConfig prefConfig;

    private TextView rsl;
    private Button cse_book_list;
    private Button eee_book_list;
    private Button civil_book_list;
    private Button rb;
    private Button urb;
    private TextView rsbl;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookcategory, container, false);

        rsl = view.findViewById(R.id.rsl);
        prefConfig = new PrefConfig(getActivity());

        cse_book_list = view.findViewById(R.id.cse_book_list);
        eee_book_list = view.findViewById(R.id.eee_book_list);
        civil_book_list = view.findViewById(R.id.civil_book_list);
        rb = view.findViewById(R.id.rb);
        rsbl = view.findViewById(R.id.rsbl);
        urb = view.findViewById(R.id.urb);

        if (prefConfig.readLoginStatus()) {
            rsl.setVisibility(View.GONE);
            rb.setVisibility(View.GONE);
            urb.setVisibility(View.GONE);
            rsbl.setVisibility(View.GONE);
        }

        urb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),UnRegisterBook.class));
            }
        });

        rsl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RegisterStudentList.class));
            }
        });
        cse_book_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CSE_Book_List.class));
            }
        });
        eee_book_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), EEE_book_list.class));
            }
        });
        civil_book_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CIVIL_book_list.class));
            }
        });
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Register_Book.class));
            }
        });
        rsbl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RegisterStuBookList.class));
            }
        });
        return view;
    }

}
