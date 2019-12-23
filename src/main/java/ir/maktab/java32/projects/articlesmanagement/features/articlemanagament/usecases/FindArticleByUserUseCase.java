package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.UseCase;
import ir.maktab.java32.projects.articlesmanagement.model.Article;

@UseCase
public interface FindArticleByUserUseCase {
    Article findById(int id) throws FindArticleByUserFailedException;

    class FindArticleByUserFailedException extends Exception {
        public FindArticleByUserFailedException(String message) {
            super(message);
        }
    }
}
