package dev.dhyto.domain.repositories;

import java.util.List;

import dev.dhyto.domain.models.Movie;
import io.reactivex.Observable;

public interface MovieRepository {
    Observable<List<Movie>> getNowPlayingMovies();
}
