package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.adminrole;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.adminrole.FindArticleAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.adminrole.FindArticleByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole.FindArticleByAdminUseCase;

public class FindArticleAdminControllerImpl implements FindArticleAdminController {
    @Override
    public Article find(int id) {
        FindArticleByAdminUseCase findArticleByAdminUseCase = new FindArticleByAdminUseCaseImpl();
        Article article = null;
        try {
            article = findArticleByAdminUseCase.findById(id);
        } catch (FindArticleByAdminUseCase.FindArticleByAdminFailedException e) {
            System.out.println(e.getMessage());
        }
        return article;
    }
}
