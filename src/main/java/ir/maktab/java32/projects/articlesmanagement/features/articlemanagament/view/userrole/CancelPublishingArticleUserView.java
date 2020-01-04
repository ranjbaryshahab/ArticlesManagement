package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view.userrole;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.userrole.CancelPublishingArticleUserController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.userrole.CancelPublishingArticleUserControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.userrole.FindArticleByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole.FindArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;

import java.util.Scanner;

public class CancelPublishingArticleUserView {
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
        CancelPublishingArticleUserController cancelPublishingArticleController = new CancelPublishingArticleUserControllerImpl();
        cancelPublishingArticleController.cancel(article);
    }
}
