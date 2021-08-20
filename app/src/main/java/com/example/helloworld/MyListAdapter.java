package com.example.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public MyListAdapter(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder{
        public ImageView mLstImg;
        public TextView mLstTxt1, mLstTxt2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;

        if(view == null){
            view = layoutInflater.inflate(R.layout.layout_list_item, null);
            holder = new ViewHolder();
            holder.mLstImg = view.findViewById(R.id.list_image);
            holder.mLstTxt1 = view.findViewById(R.id.list_txt1);
            holder.mLstTxt2 = view.findViewById(R.id.list_text2);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        return view;
    }
}
