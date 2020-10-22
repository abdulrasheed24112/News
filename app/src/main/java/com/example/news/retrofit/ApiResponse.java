package com.example.news.retrofit;

import com.example.news.model.NewsResource;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiResponse {

    @GET("top-headlines")
    Call<NewsResource> getNews(@Query("category")String category,@Query("apiKey") String ApiKey);

}
