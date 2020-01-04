package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.adminrole;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.adminrole.CreateNewArticleAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.adminrole.CreateArticleByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole.CreateArticleByAdminUseCase;

public class CreateNewArticleAdminControllerImpl implements CreateNewArticleAdminController {
    @Override
    public Article create(Article article) {
        CreateArticleByAdminUseCase createArticleByUserUseCase = new CreateArticleByAdminUseCaseImpl();
        Article newArticle = null;
        try {
            newArticle = createArticleByUserUseCase.create(article);
        } catch (CreateArticleByAdminUseCase.CreateArticleByAdminFailedException e) {
            System.out.println(e.getMessage());
        }
        return newArticle;
    }
}
