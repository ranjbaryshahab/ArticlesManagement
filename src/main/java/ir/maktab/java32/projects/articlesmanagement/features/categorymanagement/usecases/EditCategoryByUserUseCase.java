package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.UseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Category;

@UseCase
public interface EditCategoryByUserUseCase {
    Category edit(Category category) throws EditCategoryByUserFailedException;

    class EditCategoryByUserFailedException extends Exception {
        public EditCategoryByUserFailedException(String message) {
            super(message);
        }
    }
}
