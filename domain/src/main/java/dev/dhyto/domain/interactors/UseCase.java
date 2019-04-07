package dev.dhyto.domain.interactors;

public abstract class UseCase<R> {

    private R repository;

    public UseCase(R repository) {
        this.repository = repository;

    }

    public R getRepository() {
        return repository;
    }
}
