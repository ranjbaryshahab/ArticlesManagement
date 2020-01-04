package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.UseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;

@UseCase
public interface FindArticleByUserUseCase {
    Article findById(int id) throws FindArticleByUserFailedException;

    class FindArticleByUserFailedException extends Exception {
        public FindArticleByUserFailedException(String message) {
            super(message);
        }
    }
}
