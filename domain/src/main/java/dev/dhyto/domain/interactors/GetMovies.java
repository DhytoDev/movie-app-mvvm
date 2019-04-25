package dev.dhyto.domain.interactors;

import java.util.List;

import dev.dhyto.domain.models.Movie;
import dev.dhyto.domain.repositories.MovieRepository;
import io.reactivex.Observable;

public class GetMovies extends UseCase<List<Movie>, Void> {

    private MovieRepository repository;

    public GetMovies(MovieRepository repository) {
        this.repository = repository;
    }


    @Override
    public Observable<List<Movie>> useCaseObservable(Void params) {
        return repository.getNowPlayingMovies();
    }
}
