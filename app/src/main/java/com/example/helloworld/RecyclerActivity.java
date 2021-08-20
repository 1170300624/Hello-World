package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



public class RecyclerActivity extends AppCompatActivity {

    private Button mLn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        mLn = findViewById(R.id.rcl_linear);

        mLn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerActivity.this, LinearRecyclerActivity.class);
                startActivity(intent);
            }
        });
    }
}