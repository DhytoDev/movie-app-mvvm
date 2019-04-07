package dev.dhyto.domain.interactors;

import java.util.List;

import dev.dhyto.domain.models.Movie;
import dev.dhyto.domain.repositories.MovieRepository;
import io.reactivex.Observable;

public class GetMovies extends UseCase<MovieRepository> {

    public GetMovies(MovieRepository repository) {
        super(repository);
    }

    public Observable<List<Movie>> getNowPlayingMovies() {
        return getRepository().getNowPlayingMovies();
    }

}
