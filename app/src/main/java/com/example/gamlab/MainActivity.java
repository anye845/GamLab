package com.example.gamlab;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.parse.ParseObject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;


    public class MainActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ParseObject firstObject = new  ParseObject("FirstClass");
            firstObject.put("message","Hey ! First message from android. Parse is now connected");
            firstObject.saveInBackground(e -> {
                if (e != null){
                    Log.e("MainActivity", e.getLocalizedMessage());
                }else{
                    Log.d("MainActivity","Object saved.");
                }
            });
        }
    }
