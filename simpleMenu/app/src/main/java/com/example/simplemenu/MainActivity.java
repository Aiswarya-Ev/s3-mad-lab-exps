package com.example.simplemenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.t1:
                Toast.makeText(getApplicationContext(), "t1 select", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.t2:
                Toast.makeText(getApplicationContext(),"t2 selet",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.t3:
                Toast.makeText(getApplicationContext(),"t3 selet",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.t4:
                Toast.makeText(getApplicationContext(),"t4 selet",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.ts1:
                Toast.makeText(getApplicationContext(),"sub 1 selet",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.ts2:
                Toast.makeText(getApplicationContext(),"sub 2 selet",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}