package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;

import java.util.List;

public interface FindAllArticlesOfTheFieldByUserUseCase {
    List<Article> findAll(String fieldName, Object value) throws FindAllArticlesOfTheFieldByUserFailedException;

class FindAllArticlesOfTheFieldByUserFailedException extends Exception {
    public FindAllArticlesOfTheFieldByUserFailedException(String message) {
        super(message);
    }
}
}
