package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.domain.Category;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases.CreateCategoryByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases.FindAllCategoryByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.repositories.CategoryRepository;

import java.util.List;

@Service
@SuppressWarnings("Duplicates")
public class CreateCategoryByUserUseCaseImpl implements CreateCategoryByUserUseCase {
    CategoryRepository categoryRepository = CategoryRepository.getInstance();
    @Override
    public Category create(Category category) throws EditCategoryByUserFailedException {
        Category savedCategory;
        try {
            validate(category);
            savedCategory = insertCategory(category);
        } catch (EditCategoryByUserFailedException e) {
            throw new EditCategoryByUserFailedException(e.getMessage());
        }

        return savedCategory;
    }

    private Category insertCategory(Category category) {
        return categoryRepository.save(category);
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
        FindAllCategoryByUserUseCase findAllCategoryByUserUseCase = new FindAllCategoryByUserUseCaseImpl();
        List<Category> categoryList = findAllCategoryByUserUseCase.findAll();
        boolean categoryExist = false;
        for (Category category1 : categoryList) {
            if (category1.getTitle().equals(category.getTitle())) {
                categoryExist = true;
                break;
            }
        }

        if (categoryExist)
            throw new EditCategoryByUserFailedException("This category exists!");
    }
}
