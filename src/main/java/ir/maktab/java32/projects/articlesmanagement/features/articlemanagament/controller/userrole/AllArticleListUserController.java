package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.userrole;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole.FindAllArticleByUserUseCase;

import java.util.List;

public interface AllArticleListUserController {
    List<Article> list() throws FindAllArticleByUserUseCase.FindAllArticleByUserFailedException;
}
