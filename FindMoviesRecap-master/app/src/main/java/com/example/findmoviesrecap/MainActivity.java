package com.example.findmoviesrecap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.findmoviesrecap.model.Movie;
import com.example.findmoviesrecap.model.MovieResponse;
import com.example.findmoviesrecap.rest.ApiClient;
import com.example.findmoviesrecap.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName() + "#";
    public static final String API_KEY = "insert yours";
    private MovieAdapter movieAdapter;
    private RecyclerView recyclerView;
    private List<Movie> movies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<MovieResponse> movieResponseCall = apiInterface.getTopRatedMovies(API_KEY);
        movieResponseCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                movies = response.body().getMovies();
                movieAdapter = new MovieAdapter(movies, getApplicationContext());
                recyclerView.setAdapter(movieAdapter);
                Log.d(TAG, "onResponse: called ");
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: called" + t.toString());

            }
        });


    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
