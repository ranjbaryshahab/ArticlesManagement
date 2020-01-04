package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.userrole;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.userrole.AllArticleListUserController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.userrole.FindAllArticleByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole.FindAllArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;

import java.util.List;

public class AllArticleListUserControllerImpl implements AllArticleListUserController {
    @Override
    public List<Article> list() throws FindAllArticleByUserUseCase.FindAllArticleByUserFailedException {
        FindAllArticleByUserUseCase findAllArticleByUserUseCase = new FindAllArticleByUserUseCaseImpl();
        return findAllArticleByUserUseCase.findAll();
    }
}
