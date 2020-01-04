package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;

import java.util.List;

public interface FindAllArticleByAdminUseCase {
    List<Article> findAll() throws FindAllArticleByAdminFailedException;
    class FindAllArticleByAdminFailedException extends Exception {
        public FindAllArticleByAdminFailedException(String message) {
            super(message);
        }
    }
}
