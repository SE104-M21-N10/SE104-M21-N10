package com.example.se104_m21_pmcl_n10quanlysieuthi;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.mToolbar);
        setSupportActionBar(toolbar);

        loginFragment fragment = new loginFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentContainer, fragment,"frgLogin")
                .commit();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.app_bar_search:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.app_bar_color_blue:
                toolbar.setBackgroundColor(getColor(R.color.blue));
                break;
            case R.id.app_bar_color_green:
                toolbar.setBackgroundColor(getColor(R.color.green));
                break;
            case R.id.app_bar_color_red:
                toolbar.setBackgroundColor(getColor(R.color.red));
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }

}