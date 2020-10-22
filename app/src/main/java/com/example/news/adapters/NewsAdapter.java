package com.example.news.adapters;

import android.content.Context;
import android.media.session.MediaController;
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
import com.example.news.model.NewsResource;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private ArrayList<News> newsList;
    public NewsAdapter(ArrayList<News> newsList) {

        this.newsList = newsList;
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
       LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
       View listItems= layoutInflater.inflate(R.layout.news_list_items,parent,false);
       return new ViewHolder(listItems);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        News news= newsList.get(position);
        holder.newsTitle.setText(news.getTitle());
        holder.newsPublishedDate.setText(news.getPublishedAt());
        Picasso.get()
                .load(news.getUrlToImage())
                .into(holder.newsImage);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView newsTitle;
        TextView newsPublishedDate;
        ImageView newsImage;
        ConstraintLayout constraintLayout;
        public ViewHolder(View item){
               super(item);
               this.newsTitle= item.findViewById(R.id.news_title);
               this.newsPublishedDate= item.findViewById(R.id.news_time);
               this.newsImage= item.findViewById(R.id.new_img);

           }

        }


}
