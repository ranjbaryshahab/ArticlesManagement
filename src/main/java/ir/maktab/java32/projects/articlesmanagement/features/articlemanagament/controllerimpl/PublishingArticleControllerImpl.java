package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.PublishingArticleController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.EditArticleByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.EditArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.model.Article;

public class PublishingArticleControllerImpl implements PublishingArticleController {
    @Override
    public Article publish(Article article) {
        EditArticleByUserUseCase editArticleByUserUseCase = new EditArticleByUserUseCaseImpl();
        Article editArticle = null;
        try {
            article.setIsPublished(true);
            editArticle = editArticleByUserUseCase.edit(article);
        } catch (EditArticleByUserUseCase.EditArticleByUserFailedException e) {
            System.out.println(e.getMessage());
        }
        return editArticle;
    }
}
