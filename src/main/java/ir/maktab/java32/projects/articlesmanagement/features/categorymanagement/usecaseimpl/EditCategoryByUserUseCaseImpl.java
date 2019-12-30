package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.domain.Category;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases.EditCategoryByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.repositories.CategoryRepository;

@Service
@SuppressWarnings("Duplicates")
public class EditCategoryByUserUseCaseImpl implements EditCategoryByUserUseCase {
    CategoryRepository categoryRepository = CategoryRepository.getInstance();
    @Override
    public Category edit(Category category) throws EditCategoryByUserFailedException {
        Category updatedCategory;
        try {
            validate(category);
            updatedCategory = updateCategory(category);
        } catch (EditCategoryByUserFailedException e) {
            throw new EditCategoryByUserFailedException(e.getMessage());
        }

        return updatedCategory;
    }

    private Category updateCategory(Category category) { ;
        return categoryRepository.update(category);
    }

    private void validate(Category category) throws EditCategoryByUserFailedException {
        if (category.getTitle() == null || category.getTitle().isEmpty())
            throw new EditCategoryByUserFailedException("Title is empty!");
        if (category.getTitle().length() > 30)
            throw new EditCategoryByUserFailedException("Title is bigger than 30 characters");
        if (category.getDescription() == null || category.getDescription().isEmpty())
            throw new EditCategoryByUserFailedException("Description is empty!");
        if (category.getDescription().length() > 150)
            throw new EditCategoryByUserFailedException("Description is bigger than 150 characters");
    }
}
