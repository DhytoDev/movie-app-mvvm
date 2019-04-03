package dev.dhyto.movie_app.utils;

import dev.dhyto.movie_app.ui.MovieViewModelProviderFactory;
import dev.dhyto.movie_app.data.repository.MovieRepository;
import dev.dhyto.movie_app.data.network.MovieService;
import dev.dhyto.movie_app.domain.GetMovies;

public class InjectorUtils {

    public static MovieRepository provideRepository() {
        MovieService service = MovieService.ServiceGenerator.instance();
        return MovieRepository.getInstance(service);
    }

    public static MovieViewModelProviderFactory provideViewModelProviderFactory(){
        MovieRepository repository = provideRepository();
        GetMovies movieInteractor = new GetMovies(repository);
        return new MovieViewModelProviderFactory(movieInteractor);
    }
}
