package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.userrole;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.userrole.FindArticleUserController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.userrole.FindArticleByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole.FindArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;

public class FindArticleUserControllerImpl implements FindArticleUserController {
    @Override
    public Article find(int id) {
        FindArticleByUserUseCase findArticleByUserUseCase = new FindArticleByUserUseCaseImpl();
        Article article = null;
        try {
            article = findArticleByUserUseCase.findById(id);
        } catch (FindArticleByUserUseCase.FindArticleByUserFailedException e) {
            System.out.println(e.getMessage());
        }
        return article;
    }
}
