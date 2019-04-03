package dev.dhyto.movie_app.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dev.dhyto.movie_app.domain.GetMovies;
import dev.dhyto.movie_app.domain.UseCase;
import dev.dhyto.movie_app.ui.MovieViewModel;

public class MovieViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    private GetMovies useCase;

    public MovieViewModelProviderFactory(GetMovies useCase) {
        this.useCase = useCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
       if(modelClass.isAssignableFrom(MovieViewModel.class)) {
           return (T) new MovieViewModel(useCase);
       }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
