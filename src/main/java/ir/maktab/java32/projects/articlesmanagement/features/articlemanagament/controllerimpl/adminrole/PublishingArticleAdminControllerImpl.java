package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.adminrole;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.adminrole.PublishingArticleAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.adminrole.EditArticleByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole.EditArticleByAdminUseCase;

import java.util.Date;

public class PublishingArticleAdminControllerImpl implements PublishingArticleAdminController {
    @Override
    public void publish(Article article) {
        EditArticleByAdminUseCase editArticleByAdminUseCase = new EditArticleByAdminUseCaseImpl();
        try {
            article.setIsPublished(true);
            article.setPublishDate(new Date());
            editArticleByAdminUseCase.edit(article);
        } catch (EditArticleByAdminUseCase.EditArticleByAdminFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}
