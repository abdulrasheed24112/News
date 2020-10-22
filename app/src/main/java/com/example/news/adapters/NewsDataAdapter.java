package com.example.news.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.R;
import com.example.news.model.News;

import java.util.ArrayList;

public class NewsDataAdapter extends RecyclerView.Adapter<NewsDataAdapter.ViewHolder> {
    private ArrayList<News> arrayList;

    public NewsDataAdapter(ArrayList<News> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public NewsDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
       View list = layoutInflater.inflate(R.layout.news_items,parent,false);
       return new ViewHolder(list);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsDataAdapter.ViewHolder holder, int position) {
        News news= arrayList.get(position);
        

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView decs,time;
        ImageView image;
        ConstraintLayout constraintLayout;
        public ViewHolder(View view) {
            super(view);
            this.decs= view.findViewById(R.id.desc);
            this.time= view.findViewById(R.id.time_spam);
            this.image= view.findViewById(R.id.list_image);
            this.constraintLayout=view.findViewById(R.id.cons_layout);
        }
    }

}
