package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.UseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;

@UseCase
public interface CreateArticleByUserUseCase {
    Article create(Article article) throws CreateArticleByUserFailedException;

    class CreateArticleByUserFailedException extends Exception {
        public CreateArticleByUserFailedException(String message) {
            super(message);
        }
    }
}
