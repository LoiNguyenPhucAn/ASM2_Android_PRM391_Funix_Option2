package com.example.animal;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.animal.databinding.ActivityMainBinding;
import com.example.animal.databinding.AppBarBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    AppBarBinding appBarBinding;
    ActionBarDrawerToggle toggle;
    Toolbar appbarTool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
       View rootView = mainBinding.getRoot();
       setContentView(rootView);

       appbarTool = findViewById(R.id.appbar_tool);

       setSupportActionBar(appbarTool);
       getSupportActionBar().setHomeButtonEnabled(true);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       toggle = new ActionBarDrawerToggle(this,mainBinding.drawer,R.string.Open,R.string.Close);
       toggle.syncState();
       mainBinding.drawer.addDrawerListener(toggle);

        showFrg(new ScreenBG());

    }

    public void showFrg (Fragment frg){
        getSupportFragmentManager().beginTransaction().replace(R.id.host_content_layout,frg,null).commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}