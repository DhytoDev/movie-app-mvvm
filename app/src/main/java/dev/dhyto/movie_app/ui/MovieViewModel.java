package dev.dhyto.movie_app.ui;


import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import dev.dhyto.movie_app.base.BaseViewModel;
import dev.dhyto.movie_app.domain.GetMovies;
import dev.dhyto.movie_app.domain.model.Movie;

public class MovieViewModel extends BaseViewModel<GetMovies> implements GetMovies.OnMovieListener {
    private MutableLiveData<Boolean> showLoading;
    private MutableLiveData<String> errorMessage;
    private MutableLiveData<List<Movie>> nowPlayingMoviesData;


    public MovieViewModel(GetMovies interactor) {
        super(interactor);
        showLoading = new MutableLiveData<>();
        errorMessage = new MutableLiveData<>();
        nowPlayingMoviesData = new MutableLiveData<>();
        getInteractor().onMovieListener = this;
        getNowPlayingMovies();
    }


    public void getNowPlayingMovies() {
        showLoading.setValue(true);
        getInteractor().getNowPlayingMovies();
    }

    @Override
    public void onMovieSuccess(List<Movie> movies) {
        showLoading.setValue(false);
        nowPlayingMoviesData.postValue(movies);

    }

    @Override
    public void onMovieError(String message) {
        showLoading.setValue(false);
        errorMessage.setValue(message);
    }

    public LiveData<Boolean> getShowLoading() {
        return showLoading;
    }

    public LiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public LiveData<List<Movie>> getNowPlayingMoviesData() {
        return nowPlayingMoviesData;
    }
}
