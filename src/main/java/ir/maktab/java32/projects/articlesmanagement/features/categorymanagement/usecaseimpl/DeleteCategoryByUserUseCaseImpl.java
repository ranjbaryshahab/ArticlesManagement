package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.domain.Category;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases.DeleteCategoryByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases.FindCategoryByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.repositories.CategoryRepository;

@Service
@SuppressWarnings("Duplicates")
public class DeleteCategoryByUserUseCaseImpl implements DeleteCategoryByUserUseCase {
    CategoryRepository categoryRepository = CategoryRepository.getInstance();
    @Override
    public void delete(int id) throws DeleteCategoryByUserFailedException {
        try {
            validate(id);
            deleteCategory(id);
        } catch (DeleteCategoryByUserFailedException | FindCategoryByUserUseCase.FindCategoryByUserFailedException e) {
            throw new DeleteCategoryByUserFailedException(e.getMessage());
        }
    }

    private void deleteCategory(int id) {
        categoryRepository.removeById(id);
    }

    private void validate(int id) throws DeleteCategoryByUserFailedException, FindCategoryByUserUseCase.FindCategoryByUserFailedException {
        FindCategoryByUserUseCase findCategoryByUserUseCase = new FindCategoryByUserUseCaseImpl();
        Category category = findCategoryByUserUseCase.findById(id);
        if (category == null)
            throw new DeleteCategoryByUserFailedException("It wasn't deleted !");
    }
}
