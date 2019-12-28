package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.FindAllArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.repositories.ArticleRepository;

import java.util.List;

@Service
@SuppressWarnings("unchecked")
public class FindAllArticleByUserUseCaseImpl implements FindAllArticleByUserUseCase {
    private ArticleRepository articleRepository = ArticleRepository.getInstance();

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public List<Article> findArticleByUser() {
            return articleRepository.findAllByUser();
    }
}
