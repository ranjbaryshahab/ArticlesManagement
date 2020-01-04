package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.userrole;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.userrole.PublishingArticleUserController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.userrole.EditArticleByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole.EditArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;

import java.util.Date;

public class PublishingArticleUserControllerImpl implements PublishingArticleUserController {
    @Override
    public void publish(Article article) {
        EditArticleByUserUseCase editArticleByUserUseCase = new EditArticleByUserUseCaseImpl();
        try {
            article.setIsPublished(true);
            article.setPublishDate(new Date());
            editArticleByUserUseCase.edit(article);
        } catch (EditArticleByUserUseCase.EditArticleByUserFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}
