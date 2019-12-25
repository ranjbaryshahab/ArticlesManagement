package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller;

import ir.maktab.java32.projects.articlesmanagement.model.Article;
import ir.maktab.java32.projects.articlesmanagement.model.User;

import java.util.List;

public interface UserArticleListController {
    List<Article> myArticleList(User user);
}
