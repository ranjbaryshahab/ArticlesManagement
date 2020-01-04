package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;

public interface FindArticleByAdminUseCase {
    Article findById(int id) throws FindArticleByAdminFailedException;

    class FindArticleByAdminFailedException extends Exception {
        public FindArticleByAdminFailedException(String message) {
            super(message);
        }
    }
}
