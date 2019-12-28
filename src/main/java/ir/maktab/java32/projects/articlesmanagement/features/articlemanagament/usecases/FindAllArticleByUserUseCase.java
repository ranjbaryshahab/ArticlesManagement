package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.UseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;

import java.util.List;

@UseCase
public interface FindAllArticleByUserUseCase {
    List<Article> findAll();
    List<Article> findArticleByUser();
}
