package com.example.helloworld;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AFragment extends Fragment {

    private TextView mTxt;
    private Button mBtnAlt;
    private Button mBtnAltTxt;
    private Button mBtnMsg;
    private BFragment bFragment;
    private IOnMessageClick listener;

    public interface IOnMessageClick{
        void onClick(String text);
    }


    //private Activity mActivity;

    public static AFragment newInstance(String title){
        AFragment fragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_a, container, false);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTxt = view.findViewById(R.id.frag_a_txt);
        mBtnAlt = view.findViewById(R.id.frag_a_alter);
        mBtnAltTxt = view.findViewById(R.id.frag_a_edit);
        mBtnMsg = view.findViewById(R.id.frag_a_message);

        mBtnAlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bFragment == null){
                    bFragment = new BFragment();
                }
                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                if (fragment != null){
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.container_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                }
                else {
                    getFragmentManager().beginTransaction().replace(R.id.container_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                }

            }
        });
        mBtnAltTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTxt.setText("Endless Feast");
            }
        });

        mBtnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick("Undead Corporation");
            }
        });

        if (getArguments() != null){
            mTxt.setText(getArguments().getString("title"));
        }

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (IOnMessageClick) context;
        }catch (ClassCastException e){

        }
        //mActivity = (Activity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
