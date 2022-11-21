package com.example.simplesharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();

    }
    public void c(View view){
        t=findViewById(R.id.t1);
        a=Integer.parseInt(t.getText().toString());
        a=a+1;
        t.setText(""+a);
    }
    public void savedata(){
        SharedPreferences sharedPreferences=getSharedPreferences("value",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("value",a);
        editor.apply();

    }
    public void load(){
        SharedPreferences sharedPreferences=getSharedPreferences("value",MODE_PRIVATE);
        a=sharedPreferences.getInt("value",MODE_PRIVATE);
        t=findViewById(R.id.t1);
        t.setText(""+a);
    }
   protected void onPause() {

       super.onPause();
       savedata();
   }
}