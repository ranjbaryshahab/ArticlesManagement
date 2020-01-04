package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.userrole;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.userrole.CancelPublishingArticleUserController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.userrole.EditArticleByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole.EditArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;

public class CancelPublishingArticleUserControllerImpl implements CancelPublishingArticleUserController {
    @Override
    public void cancel(Article article) {
        EditArticleByUserUseCase editArticleByUserUseCase = new EditArticleByUserUseCaseImpl();
        try {
            article.setIsPublished(false);
            editArticleByUserUseCase.edit(article);
        } catch (EditArticleByUserUseCase.EditArticleByUserFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}
