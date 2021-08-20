package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IntentTestActivity extends AppCompatActivity {

    private Button mBtnBack;
    private TextView mTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_test);
        String editTxt = getIntent().getStringExtra("edit_txt");


        mBtnBack = findViewById(R.id.intent_back);
        mTxt = findViewById(R.id.intent_txt);

        mTxt.setText(editTxt);

        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.activitytest.ACTION_GRID");
                startActivity(intent);
            }
        });
    }
}