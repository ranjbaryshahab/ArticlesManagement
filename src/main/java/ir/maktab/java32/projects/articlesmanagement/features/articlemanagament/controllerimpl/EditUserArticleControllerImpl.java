package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.EditUserArticleController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.EditArticleByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.EditArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;

public class EditUserArticleControllerImpl implements EditUserArticleController {
    @Override
    public Article edit(Article article) {
        EditArticleByUserUseCase editArticleByUserUseCase = new EditArticleByUserUseCaseImpl();
        Article editArticle = null;
        try {
            editArticle = editArticleByUserUseCase.edit(article);
        } catch (EditArticleByUserUseCase.EditArticleByUserFailedException e) {
            System.out.println(e.getMessage());
        }
        return editArticle;
    }
}
