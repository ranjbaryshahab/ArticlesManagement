package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.adminrole;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.adminrole.FindAllArticlesOfTheFieldByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.adminrole.FindAllArticlesOfTheFieldByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole.FindAllArticlesOfTheFieldByAdminUseCase;

import java.util.List;

public class FindAllArticlesOfTheFieldByAdminControllerImpl implements FindAllArticlesOfTheFieldByAdminController {
    @Override
    public List<Article> findAll(String fieldName, Object value) {
        List<Article> articleList = null;
        FindAllArticlesOfTheFieldByAdminUseCase findAllArticlesOfTheFieldByAdminUseCase =
                new FindAllArticlesOfTheFieldByAdminUseCaseImpl();
        try {
            articleList = findAllArticlesOfTheFieldByAdminUseCase.findAll(fieldName, value);
        } catch (FindAllArticlesOfTheFieldByAdminUseCase.FindAllArticlesOfTheFieldByAdminFailedException e) {
            System.out.println(e.getMessage());
        }

        return articleList;
    }
}
