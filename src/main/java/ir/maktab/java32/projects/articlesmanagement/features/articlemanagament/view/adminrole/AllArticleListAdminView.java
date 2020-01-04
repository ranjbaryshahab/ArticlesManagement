package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view.adminrole;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.adminrole.AllArticleListAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.adminrole.AllArticleListAdminControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole.FindAllArticleByAdminUseCase;

public class AllArticleListAdminView {
    public void allList() {
        AllArticleListAdminController allArticleListAdminController = new AllArticleListAdminControllerImpl();
        try {
            allArticleListAdminController.list().forEach(System.out::println);
        } catch (FindAllArticleByAdminUseCase.FindAllArticleByAdminFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}
