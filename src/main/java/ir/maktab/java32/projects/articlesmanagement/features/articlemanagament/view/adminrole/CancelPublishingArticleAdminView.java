package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view.adminrole;

import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.core.share.log.usecaseimpl.LogRecordUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.domain.Log;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.userrole.CancelPublishingArticleUserController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.userrole.CancelPublishingArticleUserControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.adminrole.FindArticleByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole.FindArticleByAdminUseCase;

import java.util.Date;
import java.util.Scanner;

public class CancelPublishingArticleAdminView {
    Scanner numberScanner = new Scanner(System.in);
    public void cancel(){
        System.out.println("Please enter article number of list for cancel publishing : ");
        int id = numberScanner.nextInt();
        FindArticleByAdminUseCase findArticleByAdminUseCase = new FindArticleByAdminUseCaseImpl();
        Article article = null;
        try {
            article = findArticleByAdminUseCase.findById(id);
        } catch (FindArticleByAdminUseCase.FindArticleByAdminFailedException e) {
            System.out.println(e.getMessage());
        }
        CancelPublishingArticleUserController cancelPublishingArticleController = new CancelPublishingArticleUserControllerImpl();
        cancelPublishingArticleController.cancel(article);
        new LogRecordUseCaseImpl().log(new Log(
                null,
                AuthenticationService.getInstance().getLoginUser().getUsername(),
                new Date(),
                AuthenticationService.getInstance().getLoginUser().getUsername() +
                        article.getTitle() + " was cancel published"));
    }
}
