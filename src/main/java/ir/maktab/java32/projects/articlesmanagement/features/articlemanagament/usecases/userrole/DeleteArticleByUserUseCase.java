package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.UseCase;

@UseCase
public interface DeleteArticleByUserUseCase {
    void delete(int id) throws DeleteArticleByUserFailedException;

    class DeleteArticleByUserFailedException extends Exception {
        public DeleteArticleByUserFailedException(String message) {
            super(message);
        }
    }
}
