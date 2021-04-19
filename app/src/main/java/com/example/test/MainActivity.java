package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 0, 0, "Russian");
        menu.add(1, 1, 1, "English");
        menu.add(2, 2, 2, "Programming");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == 0){
            Intent intent = new Intent(MainActivity.this, RussianActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == 1){
            Intent intent = new Intent(MainActivity.this, EnglishActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == 2){
            Intent intent = new Intent(MainActivity.this, ProgrammingActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}