package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.AllArticleListController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.FindAllArticleByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.FindAllArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;

import java.util.List;

public class AllArticleListControllerImpl implements AllArticleListController {
    @Override
    public List<Article> list() throws FindAllArticleByUserUseCase.FindAllArticleByUserFailedException {
        FindAllArticleByUserUseCase findAllArticleByUserUseCase = new FindAllArticleByUserUseCaseImpl();
        return findAllArticleByUserUseCase.findAll();
    }
}
