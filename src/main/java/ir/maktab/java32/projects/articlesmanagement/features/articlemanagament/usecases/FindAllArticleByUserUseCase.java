package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.UseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;

import java.util.List;

@UseCase
public interface FindAllArticleByUserUseCase {
    List<Article> findAll() throws FindAllArticleByUserFailedException;
    List<Article> findAllArticleByUser() throws FindAllArticleByUserFailedException;

    class FindAllArticleByUserFailedException extends Exception {
        public FindAllArticleByUserFailedException(String message) {
            super(message);
        }
    }
}
