package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view.userrole;

import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.userrole.UserArticleListUserController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.userrole.UserArticleListUserControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole.FindAllArticleByUserUseCase;

public class UserArticleListUserView {
    public void list(){
        User user = AuthenticationService.getInstance().getLoginUser();
        UserArticleListUserController userArticleListController = new UserArticleListUserControllerImpl();
        try {
            userArticleListController.myArticleList(user).forEach(System.out::println);
        } catch (FindAllArticleByUserUseCase.FindAllArticleByUserFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}
