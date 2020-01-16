package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.adminrole;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;

import java.util.List;

public interface FindAllArticlesOfTheFieldByAdminController {
    List<Article> findAll(String fieldName, Object value);
}
