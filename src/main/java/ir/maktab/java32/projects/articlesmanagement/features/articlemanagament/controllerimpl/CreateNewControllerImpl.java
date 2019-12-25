package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.CreateNewArticleController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.CreateArticleByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.CreateArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.model.Article;

public class CreateNewControllerImpl implements CreateNewArticleController {
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
