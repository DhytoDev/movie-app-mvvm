package dev.dhyto.movie_app.ui;


import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import dev.dhyto.domain.interactors.GetMovies;
import dev.dhyto.domain.models.Movie;
import dev.dhyto.movie_app.base.BaseViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MovieViewModel extends BaseViewModel<GetMovies> {
    private MutableLiveData<Boolean> showLoading;
    private MutableLiveData<String> errorMessage;
    private MutableLiveData<List<Movie>> nowPlayingMoviesData;


    public MovieViewModel(GetMovies interactor) {
        super(interactor);
        showLoading = new MutableLiveData<>();
        errorMessage = new MutableLiveData<>();
        nowPlayingMoviesData = new MutableLiveData<>();
        getNowPlayingMovies();
    }


    public void getNowPlayingMovies() {
        showLoading.setValue(true);
        getCompositeDisposable().add(getInteractor().getNowPlayingMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movies -> {
                    showLoading.setValue(false);
                    nowPlayingMoviesData.postValue(movies);
                }, throwable -> {
                    showLoading.setValue(false);
                    errorMessage.setValue(throwable.getMessage());
                }));
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
