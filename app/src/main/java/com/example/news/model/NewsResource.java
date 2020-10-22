package com.example.news.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NewsResource {
    @SerializedName("articles")
    @Expose
   private ArrayList<News> articles;

    public NewsResource(ArrayList<News> articles) {
        this.articles = articles;
    }

    public ArrayList<News> getArticles() {
        return articles;
    }
}
