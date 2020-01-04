package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.userrole;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.userrole.EditUserArticleUserController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.userrole.EditArticleByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole.EditArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;

public class EditUserArticleUserControllerImpl implements EditUserArticleUserController {
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
