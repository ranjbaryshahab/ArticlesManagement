package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.userrole;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.userrole.CreateNewArticleUserController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.userrole.CreateArticleByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole.CreateArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;

public class CreateNewArticleUserControllerImpl implements CreateNewArticleUserController {
    @Override
    public Article create(Article article) {
        CreateArticleByUserUseCase createArticleByUserUseCase = new CreateArticleByUserUseCaseImpl();
        Article newArticle = null;
        try {
            newArticle = createArticleByUserUseCase.create(article);
        } catch (CreateArticleByUserUseCase.CreateArticleByUserFailedException e) {
            System.out.println(e.getMessage());
        }
        return newArticle;
    }
}
