package dev.dhyto.movie_app.base;

import android.content.Context;

import androidx.lifecycle.ViewModel;
import dev.dhyto.movie_app.data.MovieRepository;
import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel extends ViewModel {
    private MovieRepository repository;
    private CompositeDisposable compositeDisposable ;

    public BaseViewModel(MovieRepository repository) {
        this.repository = repository;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }

    protected MovieRepository getRepository() {
        return repository;
    }

    protected CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }
}
