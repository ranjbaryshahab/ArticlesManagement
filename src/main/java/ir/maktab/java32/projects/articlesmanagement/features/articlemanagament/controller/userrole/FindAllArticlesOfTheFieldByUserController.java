package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.userrole;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;

import java.util.List;

public interface FindAllArticlesOfTheFieldByUserController {
    List<Article> findAll(String fieldName, Object value);
}
