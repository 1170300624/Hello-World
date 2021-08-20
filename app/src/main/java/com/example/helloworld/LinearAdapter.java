package com.example.helloworld;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {

    private Context context;

    public LinearAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_linear_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinearAdapter.LinearViewHolder holder, int position) {

        holder.txtV.setText("Hello");

    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        private TextView txtV;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);

            txtV = itemView.findViewById(R.id.tv_tittle);
        }
    }
}
