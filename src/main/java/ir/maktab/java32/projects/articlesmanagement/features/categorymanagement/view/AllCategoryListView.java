package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.view;

import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.controller.AllCategoryListController;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.controllerimpl.AllCategoryListControllerImpl;

public class AllCategoryListView {
    public void allList() {
        AllCategoryListController allCategoryListController = new AllCategoryListControllerImpl();
        allCategoryListController.allList().forEach(System.out::println);
    }
}
