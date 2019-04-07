package dev.dhyto.data.repositories;

import android.util.Log;

import java.util.List;

import dev.dhyto.data.entity.mapper.MovieEntityDataMapper;
import dev.dhyto.data.network.MovieService;
import dev.dhyto.domain.models.Movie;
import dev.dhyto.domain.repositories.MovieRepository;
import io.reactivex.Observable;

public class MovieRepositoryImpl implements MovieRepository {

    private static final String LOG_TAG = MovieRepositoryImpl.class.getSimpleName();


    private MovieService movieService;
    private static MovieRepositoryImpl sInstance;

    public MovieRepositoryImpl(MovieService movieService) {
        this.movieService = movieService;
    }

    public MovieService getMovieService() {
        return movieService;
    }

    public synchronized static MovieRepositoryImpl getInstance(MovieService service) {
        Log.d(LOG_TAG, "Getting the repository");
        if (sInstance == null) {
            sInstance = new MovieRepositoryImpl(service);
            Log.d(LOG_TAG, "Made new repository");

        }

        return sInstance;
    }

    @Override
    public Observable<List<Movie>> getNowPlayingMovies() {
        return getMovieService().getNowPlayingMovies().flatMap(
                moviesResponse -> Observable.just(moviesResponse.getResults())
                        .map(MovieEntityDataMapper::transform));
    }
}
