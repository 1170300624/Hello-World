package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button mBtnLst;
    private Button mBtnGrd;
    private Button mBtnItt;
    private Button mBtnDlg;
    private Button mBtnRcl;
    private EditText mEdt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnLst = findViewById(R.id.main_list);
        mBtnGrd = findViewById(R.id.main_grid);
        mBtnItt = findViewById(R.id.main_intent);
        mBtnDlg = findViewById(R.id.main_dialog);
        mBtnRcl = findViewById(R.id.main_recycler);
        mEdt = findViewById(R.id.main_edit);

        mBtnLst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
        mBtnGrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GridActivity.class);
                startActivity(intent);
            }
        });

        String editTxt = "Scarlet";
        mBtnItt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IntentTestActivity.class);
                intent.putExtra("edit_txt", editTxt);
                startActivity(intent);
            }
        });
        mBtnDlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
        mBtnRcl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(intent);
            }
        });

    }


}