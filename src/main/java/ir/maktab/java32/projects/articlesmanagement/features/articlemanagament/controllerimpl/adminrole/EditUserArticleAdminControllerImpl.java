package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.adminrole;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.adminrole.EditUserArticleAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.adminrole.EditArticleByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole.EditArticleByAdminUseCase;

public class EditUserArticleAdminControllerImpl implements EditUserArticleAdminController {
    @Override
    public Article edit(Article article) {
        EditArticleByAdminUseCase editArticleByAdminUseCase = new EditArticleByAdminUseCaseImpl();
        Article editArticle = null;
        try {
            editArticle = editArticleByAdminUseCase.edit(article);
        } catch (EditArticleByAdminUseCase.EditArticleByAdminFailedException e) {
            System.out.println(e.getMessage());
        }
        return editArticle;
    }
}
