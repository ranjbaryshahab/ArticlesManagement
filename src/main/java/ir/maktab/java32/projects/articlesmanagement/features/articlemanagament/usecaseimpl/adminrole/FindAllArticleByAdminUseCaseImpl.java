package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.adminrole;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.repositories.ArticleRepository;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole.FindAllArticleByAdminUseCase;

import java.util.List;

@Service
@SuppressWarnings("unchecked")
public class FindAllArticleByAdminUseCaseImpl implements FindAllArticleByAdminUseCase {
    private ArticleRepository articleRepository = ArticleRepository.getInstance();

    @Override
    public List<Article> findAll() throws FindAllArticleByAdminFailedException {
        validate();
        return articleRepository.findAll();
    }


    private void validate() throws FindAllArticleByAdminFailedException {
        if (articleRepository.findAll() == null)
            throw new FindAllArticleByAdminFailedException("You're article list is empty!");
    }


}
