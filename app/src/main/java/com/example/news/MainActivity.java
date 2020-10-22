package com.example.news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.news.adapters.NewsAdapter;
import com.example.news.model.News;
import com.example.news.model.NewsResource;
import com.example.news.retrofit.ApiClient;
import com.example.news.retrofit.ApiResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static String API_KEY="ed7374c2452c477886d9843d6a90616b";
    RecyclerView recyclerView;
    ArrayList<News> newsResourcesList;
    NewsAdapter newsAdapter;
    Button technologyBtn,healthBtn,scienceBtn,sportsBtn,generalBtn;

    RecyclerView recyclerList;
    ArrayList<News> arrticles;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // buttons find id
        technologyBtn=findViewById(R.id.technology_btn);
        healthBtn=findViewById(R.id.health_btn);
        scienceBtn=findViewById(R.id.science_btn);
        sportsBtn=findViewById(R.id.sports_btn);
        generalBtn=findViewById(R.id.general_btn);
        /////////////////////////////////////////////////
        recyclerView= findViewById(R.id.recycler);
        RecyclerView.LayoutManager manager= new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(manager);
        newsResourcesList= new ArrayList<>();
        
        ApiClient.getClient().create(ApiResponse.class).getNews("technology",API_KEY).enqueue(new Callback<NewsResource>() {
            @Override
            public void onResponse(Call<NewsResource> call, Response<NewsResource> response) {

                newsResourcesList = response.body().getArticles();
                newsAdapter = new NewsAdapter(newsResourcesList);
                recyclerView.setAdapter(newsAdapter);
            }

            @Override
            public void onFailure(Call<NewsResource> call, Throwable t) {

            }
        });

        technologyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonStyle(technologyBtn.getText().toString());
            }
        });
        healthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonStyle(healthBtn.getText().toString());
            }
        });
        sportsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonStyle(sportsBtn.getText().toString());
            }
        });
        scienceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonStyle(scienceBtn.getText().toString());
            }
        });
        generalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonStyle(generalBtn.getText().toString());
                Toast.makeText(MainActivity.this, generalBtn.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    public void buttonStyle(String name)
    {
        switch (name)
        {
            case "general":
                generalBtn.setBackgroundColor(generalBtn.getContext().getResources().getColor(R.color.white));
                generalBtn.setTextColor(Color.parseColor("#F16529"));
                scienceBtn.setBackgroundColor(scienceBtn.getContext().getResources().getColor(R.color.pinkColor));
                scienceBtn.setTextColor(Color.parseColor("#FFFFFFFF"));
                healthBtn.setTextColor(Color.parseColor("#FFFFFFFF"));
                sportsBtn.setTextColor(Color.parseColor("#FFFFFFFF"));
                technologyBtn.setTextColor(Color.parseColor("#FFFFFFFF"));
                healthBtn.setBackgroundColor(healthBtn.getContext().getResources().getColor(R.color.pinkColor));
                sportsBtn.setBackgroundColor(sportsBtn.getContext().getResources().getColor(R.color.pinkColor));
                technologyBtn.setBackgroundColor(technologyBtn.getContext().getResources().getColor(R.color.pinkColor));
               break;
            case "technology":
                generalBtn.setBackgroundColor(generalBtn.getContext().getResources().getColor(R.color.pinkColor));
                generalBtn.setTextColor(Color.parseColor("#FFFFFFFF"));
                scienceBtn.setBackgroundColor(scienceBtn.getContext().getResources().getColor(R.color.pinkColor));
                scienceBtn.setTextColor(Color.parseColor("#FFFFFFFF"));
                healthBtn.setTextColor(Color.parseColor("#FFFFFFFF"));
                sportsBtn.setTextColor(Color.parseColor("#FFFFFFFF"));
                technologyBtn.setTextColor(Color.parseColor("#F16529"));
                healthBtn.setBackgroundColor(healthBtn.getContext().getResources().getColor(R.color.pinkColor));
                sportsBtn.setBackgroundColor(sportsBtn.getContext().getResources().getColor(R.color.pinkColor));
                technologyBtn.setBackgroundColor(technologyBtn.getContext().getResources().getColor(R.color.white));
                break;
            case "health":
                generalBtn.setBackgroundColor(generalBtn.getContext().getResources().getColor(R.color.pinkColor));
                generalBtn.setTextColor(Color.parseColor("#FFFFFFFF"));
                scienceBtn.setBackgroundColor(scienceBtn.getContext().getResources().getColor(R.color.pinkColor));
                scienceBtn.setTextColor(Color.parseColor("#FFFFFFFF"));
                healthBtn.setTextColor(Color.parseColor("#F16529"));
                sportsBtn.setTextColor(Color.parseColor("#FFFFFFFF"));
                technologyBtn.setTextColor(Color.parseColor("#FFFFFFFF"));
                healthBtn.setBackgroundColor(healthBtn.getContext().getResources().getColor(R.color.white));
                sportsBtn.setBackgroundColor(sportsBtn.getContext().getResources().getColor(R.color.pinkColor));
                technologyBtn.setBackgroundColor(technologyBtn.getContext().getResources().getColor(R.color.pinkColor));
                break;

            case "science":
                generalBtn.setBackgroundColor(generalBtn.getContext().getResources().getColor(R.color.pinkColor));
                generalBtn.setTextColor(Color.parseColor("#FFFFFFFF"));
                scienceBtn.setBackgroundColor(scienceBtn.getContext().getResources().getColor(R.color.white));
                scienceBtn.setTextColor(Color.parseColor("#F16529"));
                healthBtn.setTextColor(Color.parseColor("#FFFFFFFF"));
                sportsBtn.setTextColor(Color.parseColor("#FFFFFFFF"));
                technologyBtn.setTextColor(Color.parseColor("#FFFFFFFF"));
                healthBtn.setBackgroundColor(healthBtn.getContext().getResources().getColor(R.color.pinkColor));
                sportsBtn.setBackgroundColor(sportsBtn.getContext().getResources().getColor(R.color.pinkColor));
                technologyBtn.setBackgroundColor(technologyBtn.getContext().getResources().getColor(R.color.pinkColor));
                break;

            case "sports":
                generalBtn.setBackgroundColor(generalBtn.getContext().getResources().getColor(R.color.pinkColor));
                generalBtn.setTextColor(Color.parseColor("#FFFFFFFF"));
                scienceBtn.setBackgroundColor(scienceBtn.getContext().getResources().getColor(R.color.pinkColor));
                scienceBtn.setTextColor(Color.parseColor("#FFFFFFFF"));
                healthBtn.setTextColor(Color.parseColor("#FFFFFFFF"));
                sportsBtn.setTextColor(Color.parseColor("#F16529"));
                technologyBtn.setTextColor(Color.parseColor("#FFFFFFFF"));
                healthBtn.setBackgroundColor(healthBtn.getContext().getResources().getColor(R.color.pinkColor));
                sportsBtn.setBackgroundColor(sportsBtn.getContext().getResources().getColor(R.color.white));
                technologyBtn.setBackgroundColor(technologyBtn.getContext().getResources().getColor(R.color.pinkColor));
                break;
        }

    }

    public void loadJson(String path,String apikey)
    {


    }


}