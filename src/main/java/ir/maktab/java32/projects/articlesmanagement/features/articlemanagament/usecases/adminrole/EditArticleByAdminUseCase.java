package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;

public interface EditArticleByAdminUseCase {
    Article edit(Article article) throws EditArticleByAdminFailedException;

    class EditArticleByAdminFailedException extends Exception {
        public EditArticleByAdminFailedException(String message) {
            super(message);
        }
    }
}
