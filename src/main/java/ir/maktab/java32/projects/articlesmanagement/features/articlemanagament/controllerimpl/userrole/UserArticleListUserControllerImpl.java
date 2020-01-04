package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.userrole;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.userrole.UserArticleListUserController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.userrole.FindAllArticleByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole.FindAllArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.domain.User;

import java.util.List;

public class UserArticleListUserControllerImpl implements UserArticleListUserController {
    @Override
    public List<Article> myArticleList(User user) throws FindAllArticleByUserUseCase.FindAllArticleByUserFailedException {
        FindAllArticleByUserUseCase findAllArticleByUserUseCase = new FindAllArticleByUserUseCaseImpl();
        return findAllArticleByUserUseCase.findAllArticleByUser();
    }
}
