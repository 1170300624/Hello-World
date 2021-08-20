package com.example.helloworld;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LinearRecyclerActivity extends AppCompatActivity {

    private RecyclerView mRvLn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler);

        mRvLn = findViewById(R.id.rv_linear);

        mRvLn.setLayoutManager(new LinearLayoutManager(LinearRecyclerActivity.this));

        mRvLn.setAdapter(new LinearAdapter(LinearRecyclerActivity.this));


    }
}