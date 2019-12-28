package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.domain.Category;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases.FindCategoryByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.repositories.CategoryRepository;

@Service
@SuppressWarnings("Duplicates")
public class FindCategoryByUserUseCaseImpl implements FindCategoryByUserUseCase {

    CategoryRepository categoryRepository = CategoryRepository.getInstance();

    @Override
    public Category findById(int id) throws FindCategoryByUserFailedException {
        Category category;
        try {
            validate(id);
            category = findCategory(id);
        } catch (FindCategoryByUserFailedException e) {
            throw new FindCategoryByUserFailedException(e.getMessage());
        }
        return category;
    }

    private Category findCategory(int id) {
        return categoryRepository.findById(id);
    }

    private void validate(int id) throws FindCategoryByUserFailedException {
        if (id <= 0)
            throw new FindCategoryByUserFailedException("This id isn't true!");

        if (findCategory(id) == null)
            throw new FindCategoryByUserFailedException("This id isn't exists!");

    }
}
