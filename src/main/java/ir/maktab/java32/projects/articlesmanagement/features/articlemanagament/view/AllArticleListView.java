package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.AllArticleListController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.AllArticleListControllerImpl;

public class AllArticleListView {
    public void allList(){
        AllArticleListController allArticleListController = new AllArticleListControllerImpl();
        allArticleListController.list().forEach(System.out::println);
    }
}
