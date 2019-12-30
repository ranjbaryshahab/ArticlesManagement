package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.domain.Category;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases.FindAllCategoryByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.repositories.CategoryRepository;

import java.util.List;

@Service
@SuppressWarnings("Duplicates")
public class FindAllCategoryByUserUseCaseImpl implements FindAllCategoryByUserUseCase {
    CategoryRepository categoryRepository = CategoryRepository.getInstance();
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
