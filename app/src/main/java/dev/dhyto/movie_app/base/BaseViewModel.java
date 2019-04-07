package dev.dhyto.movie_app.base;

import androidx.lifecycle.ViewModel;
import dev.dhyto.domain.interactors.UseCase;
import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel<I extends UseCase> extends ViewModel {
    private I interactor;
    private CompositeDisposable compositeDisposable;

    public BaseViewModel(I interactor) {
        this.interactor = interactor;
        compositeDisposable = new CompositeDisposable();

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
            compositeDisposable.clear();
        }
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    public I getInteractor() {
        return interactor;
    }
}
