package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.CancelPublishingArticleController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.CancelPublishingArticleControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.FindArticleByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.FindArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.model.Article;

import java.util.Scanner;

public class CancelPublishingArticleView {
    Scanner numberScanner = new Scanner(System.in);
    public void cancel(){
        System.out.println("Please enter article number of list for cancel publishing : ");
        int id = numberScanner.nextInt();
        FindArticleByUserUseCase findArticleByUserUseCase = new FindArticleByUserUseCaseImpl();
        Article article = null;
        try {
            article = findArticleByUserUseCase.findById(id);
        } catch (FindArticleByUserUseCase.FindArticleByUserFailedException e) {
            System.out.println(e.getMessage());
        }
        CancelPublishingArticleController cancelPublishingArticleController = new CancelPublishingArticleControllerImpl();
        cancelPublishingArticleController.cancel(article);
    }
}
