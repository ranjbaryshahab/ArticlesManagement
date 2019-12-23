package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.UseCase;
import ir.maktab.java32.projects.articlesmanagement.model.Category;

@UseCase
public interface CreateCategoryByUserUseCase {
    Category create(Category category) throws EditCategoryByUserFailedException;

    class EditCategoryByUserFailedException extends Exception {
        public EditCategoryByUserFailedException(String message) {
            super(message);
        }
    }
}
