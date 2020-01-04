package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.UseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;

@UseCase
public interface EditArticleByUserUseCase {
    Article edit(Article article) throws EditArticleByUserFailedException;

    class EditArticleByUserFailedException extends Exception {
        public EditArticleByUserFailedException(String message) {
            super(message);
        }
    }
}
