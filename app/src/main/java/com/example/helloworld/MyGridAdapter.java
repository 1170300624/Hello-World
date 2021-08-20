package com.example.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyGridAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public MyGridAdapter(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 16;
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
        public ImageView mGrdImg1, mGrdImg2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        MyGridAdapter.ViewHolder holder = null;

        if(view == null){
            view = layoutInflater.inflate(R.layout.layout_grid_item, null);
            holder = new MyGridAdapter.ViewHolder();
            holder.mGrdImg1 = view.findViewById(R.id.grid_image1);
            holder.mGrdImg2 = view.findViewById(R.id.grid_image2);

            view.setTag(holder);
        }
        else {
            holder = (MyGridAdapter.ViewHolder) view.getTag();
        }

        return view;
    }
}
