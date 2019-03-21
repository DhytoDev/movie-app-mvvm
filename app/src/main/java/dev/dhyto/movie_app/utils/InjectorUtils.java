package dev.dhyto.movie_app.utils;

import dev.dhyto.movie_app.base.ViewModelProviderFactory;
import dev.dhyto.movie_app.data.MovieRepository;
import dev.dhyto.movie_app.data.network.MovieService;

public class InjectorUtils {

    public static MovieRepository provideRepository() {
        MovieService service = MovieService.ServiceGenerator.instance();
        return MovieRepository.getInstance(service);
    }

    public static ViewModelProviderFactory provideViewModelProviderFactory(){
        MovieRepository repository = provideRepository();
        return new ViewModelProviderFactory(repository);
    }
}
