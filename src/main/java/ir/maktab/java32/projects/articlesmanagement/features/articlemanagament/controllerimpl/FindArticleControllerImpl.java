package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.FindArticleController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.FindArticleByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.FindArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;

public class FindArticleControllerImpl implements FindArticleController {
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
