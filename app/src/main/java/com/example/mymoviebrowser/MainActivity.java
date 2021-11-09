package com.example.mymoviebrowser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements MovieFragment.OnMovieSelected {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void movieSelected(Movie movie) {
        Log.d("Main Activity", movie.getName());

        int display_mode = getResources().getConfiguration().orientation;

        if(display_mode == Configuration.ORIENTATION_PORTRAIT) {

            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("movie", movie);
            startActivity(intent);
        }else{
            DetailsFragment df = (DetailsFragment) getSupportFragmentManager().findFragmentByTag("details");
            if(df == null){
                FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
                df = DetailsFragment.newInstance(movie);
                fts.add(R.id.container, df, "details");
                fts.commit();
            }else{
                df.setMovie(findViewById(R.id.container),movie);
            }
        }
    }
}