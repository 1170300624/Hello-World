package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class FileActivity extends AppCompatActivity {

    private EditText editText;
    private Button btn;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        editText = findViewById(R.id.file_edit);
        btn = findViewById(R.id.file_button);
        txt = findViewById(R.id.file_txt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editText.getText().toString();
                txt.setText(input);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        try {
            String input;
            if (txt.getText() != null){
                input = txt.getText().toString();
            }
            else {
                input = "null";
            }
            System.out.println(input);
            Log.d("TAG", input);
            save(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save(String input) throws IOException {

        FileOutputStream outPut;
        outPut = openFileOutput("data", Context.MODE_PRIVATE);
        outPut.write(input.getBytes());
        outPut.close();

    }
}