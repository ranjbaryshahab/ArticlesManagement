package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.UseCase;
import ir.maktab.java32.projects.articlesmanagement.model.Category;

@UseCase
public interface FindCategoryByUserUseCase {
    Category findById(int id) throws FindCategoryByUserFailedException;

    class FindCategoryByUserFailedException extends Exception {
        public FindCategoryByUserFailedException(String message) {
            super(message);
        }
    }
}
