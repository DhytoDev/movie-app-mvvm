package dev.dhyto.movie_app.domain;

import io.reactivex.disposables.CompositeDisposable;

public abstract class UseCase<R> {

    private CompositeDisposable compositeDisposable;
    private R repository ;

    public UseCase(R repository) {
        compositeDisposable = new CompositeDisposable();
        this.repository = repository;
    }

    public void dispose() {
        if (!compositeDisposable.isDisposed()) compositeDisposable.dispose();
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    public R getRepository() {
        return repository;
    }
}
