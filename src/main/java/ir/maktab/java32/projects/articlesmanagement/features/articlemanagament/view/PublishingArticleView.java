package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.PublishingArticleController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.PublishingArticleControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.FindArticleByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.FindArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;

import java.util.Scanner;

public class PublishingArticleView {
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
        PublishingArticleController publishingArticleController = new PublishingArticleControllerImpl();
        publishingArticleController.publish(article);
    }
}
