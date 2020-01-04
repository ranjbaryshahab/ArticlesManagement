package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.adminrole;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole.FindAllArticleByAdminUseCase;

import java.util.List;

public interface UserArticleListAdminController {
    List<Article> myArticleList(User user) throws FindAllArticleByAdminUseCase.FindAllArticleByAdminFailedException;
}
