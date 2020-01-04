package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view.adminrole;

import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.adminrole.UserArticleListAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.adminrole.UserArticleListAdminControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole.FindAllArticleByAdminUseCase;

public class UserArticleListAdminView {
    public void list(){
        User user = AuthenticationService.getInstance().getLoginUser();
        UserArticleListAdminController userArticleListAdminController = new UserArticleListAdminControllerImpl();
        try {
            userArticleListAdminController.myArticleList(user).forEach(System.out::println);
        } catch (FindAllArticleByAdminUseCase.FindAllArticleByAdminFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}
