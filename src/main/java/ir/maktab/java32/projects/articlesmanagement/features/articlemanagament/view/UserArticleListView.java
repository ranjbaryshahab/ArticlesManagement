package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view;

import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.UserArticleListController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.UserArticleListControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.FindAllArticleByUserUseCase;

public class UserArticleListView {
    public void list(){
        User user = AuthenticationService.getInstance().getLoginUser();
        UserArticleListController userArticleListController = new UserArticleListControllerImpl();
        try {
            userArticleListController.myArticleList(user).forEach(System.out::println);
        } catch (FindAllArticleByUserUseCase.FindAllArticleByUserFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}
