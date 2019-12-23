package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.UseCase;

@UseCase
public interface DeleteCategoryByUserUseCase {
    void delete(int id) throws DeleteCategoryByUserFailedException;

    class DeleteCategoryByUserFailedException extends Exception {
        public DeleteCategoryByUserFailedException(String message) {
            super(message);
        }
    }
}
