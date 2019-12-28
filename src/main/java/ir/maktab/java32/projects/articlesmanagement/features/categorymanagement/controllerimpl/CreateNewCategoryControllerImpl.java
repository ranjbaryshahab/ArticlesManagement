package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.controller.CreateNewCategoryController;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecaseimpl.CreateCategoryByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases.CreateCategoryByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Category;

public class CreateNewCategoryControllerImpl implements CreateNewCategoryController {
    @Override
    public Category create(Category category) {
        CreateCategoryByUserUseCase createCategoryByUserUseCase = new CreateCategoryByUserUseCaseImpl();
        Category newCategory = null;
        try {
            newCategory = createCategoryByUserUseCase.create(category);
        } catch (CreateCategoryByUserUseCase.EditCategoryByUserFailedException e) {
            System.out.println(e.getMessage());
        }
        return newCategory;
    }
}
