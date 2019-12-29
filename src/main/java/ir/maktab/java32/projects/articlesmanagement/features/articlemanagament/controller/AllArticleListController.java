package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.FindAllArticleByUserUseCase;

import java.util.List;

public interface AllArticleListController {
    List<Article> list() throws FindAllArticleByUserUseCase.FindAllArticleByUserFailedException;
}
