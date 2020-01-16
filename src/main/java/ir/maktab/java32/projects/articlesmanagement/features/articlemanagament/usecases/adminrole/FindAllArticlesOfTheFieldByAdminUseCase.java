package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;

import java.util.List;

public interface FindAllArticlesOfTheFieldByAdminUseCase {
    List<Article> findAll(String fieldName, Object value) throws FindAllArticlesOfTheFieldByAdminFailedException;

class FindAllArticlesOfTheFieldByAdminFailedException extends Exception {
    public FindAllArticlesOfTheFieldByAdminFailedException(String message) {
        super(message);
    }
}
}
