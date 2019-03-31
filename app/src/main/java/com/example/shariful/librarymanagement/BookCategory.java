package com.example.shariful.librarymanagement;

import android.content.ClipData;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.shariful.librarymanagement.Config.PrefConfig;
import com.example.shariful.librarymanagement.Models.Register_stu;
import com.example.shariful.librarymanagement.fragment.LoginFragment;

public class BookCategory extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private PrefConfig prefConfig;

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_category);

        prefConfig = new PrefConfig(BookCategory.this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigition_drawer_open, R.string.navigition_drawer_close);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        if(savedInstanceState==null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.activityContainer,new BookCategoryFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_view);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId())
        {
            case R.id.bookCategory:

                getSupportFragmentManager().beginTransaction().replace(R.id.activityContainer,new BookCategoryFragment()).commit();
                break;
            case R.id.myInfo:
                getSupportFragmentManager().beginTransaction().replace(R.id.activityContainer,new MyInfoFragment()).commit();
                break;

            case R.id.devInfo:

                getSupportFragmentManager().beginTransaction().replace(R.id.activityContainer,new DevInfoFragment()).commit();
                break;

            case R.id.logout:

                prefConfig.writeLoginStatus(false);
                prefConfig.writeLogoutStatus(true);
                finish();
                startActivity(new Intent(BookCategory.this,MainActivity.class));
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}

