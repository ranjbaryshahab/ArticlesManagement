package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view.userrole;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.userrole.PublishingArticleUserController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.userrole.PublishingArticleUserControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.userrole.FindArticleByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole.FindArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;

import java.util.Scanner;

public class PublishingArticleUserView {
    Scanner numberScanner = new Scanner(System.in);

    public void publish() {
        System.out.println("Please enter number of article list for publish : ");
        int id = numberScanner.nextInt();
        FindArticleByUserUseCase findArticleByUserUseCase = new FindArticleByUserUseCaseImpl();
        Article article = null;
        try {
            article = findArticleByUserUseCase.findById(id);
        } catch (FindArticleByUserUseCase.FindArticleByUserFailedException e) {
            System.out.println(e.getMessage());
        }
        PublishingArticleUserController publishingArticleController = new PublishingArticleUserControllerImpl();
        publishingArticleController.publish(article);
    }
}
