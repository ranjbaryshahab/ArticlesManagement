package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.adminrole;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.adminrole.CancelPublishingArticleAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.adminrole.EditArticleByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole.EditArticleByAdminUseCase;

public class CancelPublishingArticleAdminControllerImpl implements CancelPublishingArticleAdminController {
    @Override
    public void cancel(Article article) {
        EditArticleByAdminUseCase editArticleByAdminUseCase = new EditArticleByAdminUseCaseImpl();
        try {
            article.setIsPublished(false);
            editArticleByAdminUseCase.edit(article);
        } catch (EditArticleByAdminUseCase.EditArticleByAdminFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}
