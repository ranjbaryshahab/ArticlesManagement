package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.adminrole;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.adminrole.AllArticleListAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.adminrole.FindAllArticleByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole.FindAllArticleByAdminUseCase;

import java.util.List;

public class AllArticleListAdminControllerImpl implements AllArticleListAdminController {
    @Override
    public List<Article> list() throws FindAllArticleByAdminUseCase.FindAllArticleByAdminFailedException {
        FindAllArticleByAdminUseCase findAllArticleByAdminUseCase = new FindAllArticleByAdminUseCaseImpl();
        return findAllArticleByAdminUseCase.findAll();
    }
}
