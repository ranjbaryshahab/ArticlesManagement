package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.controller.AllCategoryListController;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecaseimpl.FindAllCategoryByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases.FindAllCategoryByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.model.Category;

import java.util.List;

public class AllCategoryListControllerImpl implements AllCategoryListController {
    @Override
    public List<Category> allList() {
        FindAllCategoryByUserUseCase findAllCategoryByUserUseCase = new FindAllCategoryByUserUseCaseImpl();
        return findAllCategoryByUserUseCase.findAll();
    }
}
