package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.UserArticleListController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.FindAllArticleByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.FindAllArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.domain.User;

import java.util.List;

public class UserArticleListControllerImpl implements UserArticleListController {
    @Override
    public List<Article> myArticleList(User user) {
        FindAllArticleByUserUseCase findAllArticleByUserUseCase = new FindAllArticleByUserUseCaseImpl();
        return findAllArticleByUserUseCase.findArticleByUser();
    }
}
