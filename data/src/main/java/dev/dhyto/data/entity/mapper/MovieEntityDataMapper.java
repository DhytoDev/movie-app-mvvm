package dev.dhyto.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import dev.dhyto.data.entity.MovieEntity;
import dev.dhyto.domain.models.Movie;

public class MovieEntityDataMapper {

    public static Movie toMovie(MovieEntity movieEntity) {
        Movie movie = null;
        if (movieEntity != null) {
            movie = new Movie();
            movie.setId(movieEntity.getId());
            movie.setOverview(movieEntity.getOverview());
            movie.setPopularity(movieEntity.getPopularity());
            movie.setReleaseDate(movieEntity.getReleaseDate());
            movie.setTitle(movieEntity.getTitle());
            movie.setVoteAverage(movieEntity.getVoteAverage());
            movie.setVoteCount(movieEntity.getVoteCount());
            movie.setBackdropPath(movieEntity.getBackdropPath());
            movie.setPosterPath(movieEntity.getPosterPath());
        }

        return movie;
    }

    public static List<Movie> transform(List<MovieEntity> movieEntities) {
        final List<Movie> movies = new ArrayList<>();

        for (MovieEntity movieEntity : movieEntities) {
            final Movie movie = toMovie(movieEntity);
            if(movie != null) {
                movies.add(movie);
            }
        }

        return movies;
    }
}
