package adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hw4.R;

import java.util.Date;
import java.util.List;
import java.util.Calendar;

import models.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>
{
    Context context;
    List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies)
    {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(movieView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Movie movie= movies.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        TextView overview;
        ImageView poster;
        View v;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            title = itemView.findViewById(R.id.TVtitle);
            overview = itemView.findViewById(R.id.overview);
            poster = itemView.findViewById(R.id.poster);
        }

        public void bind(Movie movie)
        {
            Date currentTime = Calendar.getInstance().getTime();
            if (currentTime.getHours() >= 18 || currentTime.getHours() < 6) {
                title.setTextColor(0xff0000ff);
                overview.setTextColor(0xff00ffff);
                v.setBackgroundColor(0xff000000);
            }
            title.setText(movie.getTitle());
            overview.setText(movie.getOverview());
            String imageUrl;

            if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            {
                imageUrl = movie.getBackdropPath();
                if (imageUrl.equals("https://image.tmdb.org/t/p/w342/null"))
                {
                    imageUrl = movie.getPosterPath();
                }
            }
            else
            {
                imageUrl = movie.getPosterPath();
            }
            Glide.with(context).load(imageUrl).into(poster);
        }
    }

}
