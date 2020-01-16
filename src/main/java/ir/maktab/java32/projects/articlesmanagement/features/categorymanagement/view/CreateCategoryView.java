package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.view;

import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.core.share.log.usecaseimpl.LogRecordUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.domain.Log;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.controller.CreateNewCategoryController;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.controllerimpl.CreateNewCategoryControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.domain.Category;

import java.util.Date;
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
        new LogRecordUseCaseImpl().log(new Log(
                null,
                AuthenticationService.getInstance().getLoginUser().getUsername(),
                new Date(),
                AuthenticationService.getInstance().getLoginUser().getUsername() +
                        " add " + newCategory.getTitle() + " category to system"));
        return newCategory;
    }
}
