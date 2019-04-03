package dev.dhyto.movie_app.base;

import androidx.lifecycle.ViewModel;
import dev.dhyto.movie_app.domain.UseCase;

public class BaseViewModel<I extends UseCase> extends ViewModel {
   private I interactor ;

    public BaseViewModel(I interactor) {
        this.interactor = interactor;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        interactor.dispose();
    }

    public I getInteractor() {
        return interactor;
    }
}
