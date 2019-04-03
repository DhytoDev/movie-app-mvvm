package dev.dhyto.movie_app.domain;

import java.util.List;

import dev.dhyto.movie_app.data.repository.MovieRepository;
import dev.dhyto.movie_app.domain.model.Movie;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GetMovies extends UseCase<MovieRepository> {

    public OnMovieListener onMovieListener;

    public GetMovies(MovieRepository repository) {
        super(repository);
    }


    public void getNowPlayingMovies() {
        getCompositeDisposable().add(getRepository().getNowPlayingMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movies -> {
                    onMovieListener.onMovieSuccess(movies);
                }, throwable -> {
                    onMovieListener.onMovieError(throwable.getMessage());
                }));
    }

    public interface OnMovieListener {
        void onMovieSuccess(List<Movie> movies);

        void onMovieError(String message);
    }
}
