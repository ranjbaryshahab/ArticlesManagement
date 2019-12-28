package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.controller.FindCategoryController;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecaseimpl.FindCategoryByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases.FindCategoryByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Category;

public class FindCategoryControllerImpl implements FindCategoryController {
    @Override
    public Category find(int id) {
        FindCategoryByUserUseCase findCategoryByUserUseCase = new FindCategoryByUserUseCaseImpl();
        Category category = null;
        try {
            category = findCategoryByUserUseCase.findById(id);
        } catch (FindCategoryByUserUseCase.FindCategoryByUserFailedException e) {
            System.out.println(e.getMessage());
        }
        return category;
    }
}
