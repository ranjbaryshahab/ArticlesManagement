package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view.adminrole;

import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.core.share.log.usecaseimpl.LogRecordUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.domain.Log;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.adminrole.FindArticleAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.adminrole.PublishingArticleAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.adminrole.FindArticleAdminControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.adminrole.PublishingArticleAdminControllerImpl;

import java.util.Date;
import java.util.Scanner;

public class PublishingArticleAdminView {
    Scanner numberScanner = new Scanner(System.in);

    public void publish() {
        System.out.println("Please enter number of article list for publish : ");
        int id = numberScanner.nextInt();
        FindArticleAdminController findArticleAdminController = new FindArticleAdminControllerImpl();
        Article article = null;
        article = findArticleAdminController.find(id);
        PublishingArticleAdminController publishingArticleAdminController = new PublishingArticleAdminControllerImpl();
        publishingArticleAdminController.publish(article);

        new LogRecordUseCaseImpl().log(new Log(
                null,
                AuthenticationService.getInstance().getLoginUser().getUsername(),
                new Date(),
                AuthenticationService.getInstance().getLoginUser().getUsername() +
                        article.getTitle() + " was published"));
    }
}
