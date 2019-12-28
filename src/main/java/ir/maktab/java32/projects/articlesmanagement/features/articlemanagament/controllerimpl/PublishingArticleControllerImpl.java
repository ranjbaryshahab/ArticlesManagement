package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.PublishingArticleController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.EditArticleByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.EditArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;

import java.util.Date;

public class PublishingArticleControllerImpl implements PublishingArticleController {
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
