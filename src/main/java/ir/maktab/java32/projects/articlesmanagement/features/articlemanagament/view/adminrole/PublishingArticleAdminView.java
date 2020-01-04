package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view.adminrole;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.adminrole.FindArticleAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.adminrole.PublishingArticleAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.adminrole.FindArticleAdminControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.adminrole.PublishingArticleAdminControllerImpl;

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
    }
}
