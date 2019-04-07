package dev.dhyto.movie_app.utils;

import dev.dhyto.domain.interactors.GetMovies;
import dev.dhyto.movie_app.ui.MovieViewModelProviderFactory;
import dev.dhyto.data.repositories.MovieRepositoryImpl;
import dev.dhyto.data.network.MovieService;

public class InjectorUtils {

    public static MovieRepositoryImpl provideRepository() {
        MovieService service = MovieService.ServiceGenerator.instance();
        return MovieRepositoryImpl.getInstance(service);
    }

    public static MovieViewModelProviderFactory provideViewModelProviderFactory(){
        MovieRepositoryImpl repository = provideRepository();
        GetMovies movieInteractor = new GetMovies(repository);
        return new MovieViewModelProviderFactory(movieInteractor);
    }
}
