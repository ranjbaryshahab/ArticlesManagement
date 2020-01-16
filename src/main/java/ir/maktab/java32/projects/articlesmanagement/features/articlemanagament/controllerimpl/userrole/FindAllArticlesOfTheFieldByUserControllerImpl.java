package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.userrole;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.userrole.FindAllArticlesOfTheFieldByUserController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.userrole.FindAllArticlesOfTheFieldByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole.FindAllArticlesOfTheFieldByUserUseCase;

import java.util.List;

public class FindAllArticlesOfTheFieldByUserControllerImpl implements FindAllArticlesOfTheFieldByUserController {
    @Override
    public List<Article> findAll(String fieldName, Object value) {
        List<Article> articleList = null;
        FindAllArticlesOfTheFieldByUserUseCase findAllArticlesOfTheFieldByUserUseCase =
                new FindAllArticlesOfTheFieldByUserUseCaseImpl();
        try {
            articleList = findAllArticlesOfTheFieldByUserUseCase.findAll(fieldName, value);
        } catch (FindAllArticlesOfTheFieldByUserUseCase.FindAllArticlesOfTheFieldByUserFailedException e) {
            System.out.println(e.getMessage());
        }

        return articleList;
    }
}
