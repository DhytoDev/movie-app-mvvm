package dev.dhyto.domain.interactors;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

public abstract class UseCase<T, Params> {
    public abstract Observable<T> useCaseObservable(Params params);
}
