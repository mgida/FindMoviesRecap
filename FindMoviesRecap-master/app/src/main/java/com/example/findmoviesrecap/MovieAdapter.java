package com.example.findmoviesrecap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findmoviesrecap.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    List<Movie> mMovies;
    private Context context;

    public MovieAdapter(List<Movie> mMovies, Context context) {
        this.mMovies = mMovies;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
        MovieViewHolder movieViewHolder = new MovieViewHolder(view);
        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.mName.setText(mMovies.get(position).getName());
        holder.mDate.setText(mMovies.get(position).getDate());
        holder.mRate.setText(mMovies.get(position).getRate());


    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        TextView mName;
        TextView mDate;
        TextView mRate;


        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.tv_movie_name);
            mDate = itemView.findViewById(R.id.tv_movie_date);
            mRate = itemView.findViewById(R.id.tv_movie_rate);
        }


    }


}
