package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.UseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;

@UseCase
public interface CreateArticleByAdminUseCase {
    Article create(Article article) throws CreateArticleByAdminFailedException;

    class CreateArticleByAdminFailedException extends Exception {
        public CreateArticleByAdminFailedException(String message) {
            super(message);
        }
    }
}
