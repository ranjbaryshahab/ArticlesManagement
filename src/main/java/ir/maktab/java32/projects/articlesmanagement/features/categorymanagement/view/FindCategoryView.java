package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.view;

import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.controller.FindCategoryController;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.controllerimpl.FindCategoryControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.domain.Category;

import java.util.Scanner;

public class FindCategoryView {
    Scanner numberScanner = new Scanner(System.in);

    public Category find() {
        System.out.println("Please enter number of category from list for submit category : ");
        int id = numberScanner.nextInt();
        FindCategoryController findCategoryController = new FindCategoryControllerImpl();
        return findCategoryController.find(id);
    }
}
