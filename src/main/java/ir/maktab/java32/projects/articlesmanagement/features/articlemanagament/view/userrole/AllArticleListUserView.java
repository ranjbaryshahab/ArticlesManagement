package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view.userrole;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.userrole.AllArticleListUserController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.userrole.AllArticleListUserControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole.FindAllArticleByUserUseCase;

public class AllArticleListUserView {
    public void allList() {
        AllArticleListUserController allArticleListController = new AllArticleListUserControllerImpl();
        try {
            allArticleListController.list().forEach(System.out::println);
        } catch (FindAllArticleByUserUseCase.FindAllArticleByUserFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}
