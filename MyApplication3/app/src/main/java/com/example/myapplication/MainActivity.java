package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=findViewById(R.id.editTextTextPersonName);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(t.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Empty box",Toast.LENGTH_LONG).show();
                    t.setError("Enter Result");
                }
                else
                {
                    if(Integer.parseInt(t.getText().toString())==8)
                    {
                        Toast.makeText(getApplicationContext(),"You Win",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"You Lose",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}