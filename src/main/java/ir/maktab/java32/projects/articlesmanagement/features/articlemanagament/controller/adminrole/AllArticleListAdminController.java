package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.adminrole;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole.FindAllArticleByAdminUseCase;

import java.util.List;

public interface AllArticleListAdminController {
    List<Article> list() throws FindAllArticleByAdminUseCase.FindAllArticleByAdminFailedException;
}
