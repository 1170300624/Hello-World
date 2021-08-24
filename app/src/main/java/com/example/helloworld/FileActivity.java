package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class FileActivity extends AppCompatActivity {

    private EditText editText;
    private Button btn, btn0;
    private TextView txt, txt0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        editText = findViewById(R.id.file_edit);
        btn = findViewById(R.id.file_button);
        btn0 = findViewById(R.id.file_button_read);
        txt = findViewById(R.id.file_txt);
        txt0 = findViewById(R.id.file_txt_show);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editText.getText().toString();
                txt.setText(input);
                System.out.println(input);
                Log.d("TAG", input);
                try {
                    if (txt.getText() != null){
                        save(input);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String output;
                try {
                    output = load();
                    txt0.setText(output);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }

    private void save(String input) throws IOException {

        FileOutputStream output;
        output = openFileOutput("data", Context.MODE_PRIVATE);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(output);
        BufferedWriter writer = new BufferedWriter(outputStreamWriter);
        writer.write(input);
        writer.close();
        outputStreamWriter.close();
        output.close();

    }

    private String load() throws IOException {
        
        String output = new String(), line;
        FileInputStream input;
        input = openFileInput("SP_data");
        InputStreamReader inputStreamReader = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        while ((line = reader.readLine()) != null){
            output += line;
        }
        reader.close();
        inputStreamReader.close();
        input.close();
        return output;
    }
}