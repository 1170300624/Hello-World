package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

public class GridActivity extends AppCompatActivity {

    private GridView mGr;
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        mGr = findViewById(R.id.Gr_1);
        mBtn = findViewById(R.id.grid_back);

        mGr.setAdapter(new MyGridAdapter(GridActivity.this));
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GridActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}