package dev.dhyto.movie_app.ui;


import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import dev.dhyto.movie_app.base.BaseViewModel;
import dev.dhyto.movie_app.data.MovieRepository;
import dev.dhyto.movie_app.data.model.Movie;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MovieViewModel extends BaseViewModel {
    private MutableLiveData<Boolean> showLoading;
    private MutableLiveData<String> errorMessage;

    public MovieViewModel(MovieRepository repository) {
        super(repository);
        showLoading = new MutableLiveData<>();
        errorMessage = new MutableLiveData<>();
    }


    public LiveData<List<Movie>> getNowPlayingMovies() {
        showLoading.setValue(true);

        MutableLiveData<List<Movie>> moviesLiveData = new MutableLiveData<>();

        getCompositeDisposable().add(
                getRepository().getNowPlayingMovies()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(movies -> {
                                    if (movies != null && movies.size() > 0)
                                        moviesLiveData.setValue(movies);
                                    showLoading.setValue(false);
                                }, throwable -> {
                                    errorMessage.setValue(throwable.getMessage());
                                    showLoading.setValue(false);
                                }
                        )

        );
        return moviesLiveData;
    }

    public LiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public LiveData<Boolean> getShowLoading() {
        return showLoading;
    }
}
