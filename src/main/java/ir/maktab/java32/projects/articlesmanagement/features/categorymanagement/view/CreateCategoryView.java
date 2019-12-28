package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.view;

import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.controller.CreateNewCategoryController;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.controllerimpl.CreateNewCategoryControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.domain.Category;

import java.util.Scanner;

public class CreateCategoryView {
    Scanner lineScanner = new Scanner(System.in);

    public Category create() {
        CreateNewCategoryController createNewCategoryController = new CreateNewCategoryControllerImpl();
        Category newCategory = new Category();

        System.out.println("Please enter title : ");
        newCategory.setTitle(lineScanner.nextLine());

        System.out.println("Please enter description : ");
        newCategory.setDescription(lineScanner.nextLine());

        newCategory = createNewCategoryController.create(newCategory);
        return newCategory;
    }
}
