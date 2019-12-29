package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.AllArticleListController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.AllArticleListControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.FindAllArticleByUserUseCase;

public class AllArticleListView {
    public void allList() {
        AllArticleListController allArticleListController = new AllArticleListControllerImpl();
        try {
            allArticleListController.list().forEach(System.out::println);
        } catch (FindAllArticleByUserUseCase.FindAllArticleByUserFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}
