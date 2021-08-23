package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick{

    private AFragment aFragment;
    private BFragment bFragment;
    private Button mBtnAlt;
    private TextView mTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        mBtnAlt = findViewById(R.id.container_alter);
        mTxt = findViewById(R.id.container_text);
        mBtnAlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bFragment == null){
                    bFragment = new BFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container_container, bFragment).commitAllowingStateLoss();
            }
        });

        aFragment = AFragment.newInstance("This is Scarlet-Moon");


        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container_container, aFragment, "a").commitAllowingStateLoss();
    }

    public void setData(String string){
        mTxt.setText(string);
    }


    @Override
    public void onClick(String text) {
        mTxt.setText(text);

    }
}