package com.example.news.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit getClient()
    {
        Retrofit retrofit=null;
        if (retrofit==null)
        {
            retrofit= new Retrofit.Builder()
                    .baseUrl("https://newsapi.org/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
return retrofit;

    }

}
