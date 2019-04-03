package dev.dhyto.movie_app.data.repository;

import android.util.Log;

import java.util.List;

import dev.dhyto.movie_app.data.entity.mapper.MovieEntityDataMapper;
import dev.dhyto.movie_app.data.network.MovieService;
import dev.dhyto.movie_app.domain.model.Movie;
import io.reactivex.Observable;

public class MovieRepository {

    private static final String LOG_TAG = MovieRepository.class.getSimpleName();


    private MovieService movieService;
    private static MovieRepository sInstance;

    public MovieRepository(MovieService movieService) {
        this.movieService = movieService;
    }

    public MovieService getMovieService() {
        return movieService;
    }

    public synchronized static MovieRepository getInstance(MovieService service) {
        Log.d(LOG_TAG, "Getting the repository");
        if (sInstance == null) {
            sInstance = new MovieRepository(service);
            Log.d(LOG_TAG, "Made new repository");

        }

        return sInstance;
    }

    public Observable<List<Movie>> getNowPlayingMovies() {
        return getMovieService().getNowPlayingMovies().flatMap(
                moviesResponse -> Observable.just(moviesResponse.getResults())
                        .map(MovieEntityDataMapper::transform));
    }
}
