package com.example.se104_m21_pmcl_n10quanlysieuthi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.frag_cont,new loginFragment()).commit();

        BottomNavigationView bottomNavigationView=findViewById(R.id.navBar);
        bottomNavigationView.setOnNavigationItemSelectedListener((new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectFrag=null;
                switch(item.getItemId()){
                    case R.id.homeItem:
                        selectFrag=new homeFragment();
                        break;
                    case R.id.loginItem:
                        selectFrag=new loginFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_cont,selectFrag).commit();
                return true;
            }
        }));    }
}