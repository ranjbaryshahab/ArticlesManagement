package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view;

import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.UserArticleListController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.UserArticleListControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.domain.User;

public class UserArticleListView {
    public void list(){
        User user = AuthenticationService.getInstance().getLoginUser();
        UserArticleListController userArticleListController = new UserArticleListControllerImpl();
        userArticleListController.myArticleList(user).forEach(System.out::println);
    }
}
