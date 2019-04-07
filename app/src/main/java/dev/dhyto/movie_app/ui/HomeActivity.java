package dev.dhyto.movie_app.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import dev.dhyto.movie_app.R;
import dev.dhyto.domain.models.Movie;
import dev.dhyto.movie_app.utils.InjectorUtils;

public class HomeActivity extends AppCompatActivity {

    private static final String LOG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_movies);

        MovieViewModelProviderFactory factory = InjectorUtils.provideViewModelProviderFactory();
        MovieViewModel viewModel = ViewModelProviders.of(this, factory).get(MovieViewModel.class);


        viewModel.getNowPlayingMoviesData().observe(this, movies -> {

            if (movies != null && movies.size() > 0) {
                for (Movie movie : movies) {
                    Log.d(LOG, movie.getTitle());
                }
            }
        });

        viewModel.getShowLoading().observe(this, this::showLoading);
        viewModel.getErrorMessage().observe(this, this::printErrorMessage);
    }

    private void showLoading(Boolean aBoolean) {
        if (aBoolean) {
            Log.d(LOG, "show loading");
        } else {
            Log.d(LOG, "hide loading");
        }
    }

    private void printErrorMessage(String message) {
        Log.d(LOG + "error : ", message);
    }
}
