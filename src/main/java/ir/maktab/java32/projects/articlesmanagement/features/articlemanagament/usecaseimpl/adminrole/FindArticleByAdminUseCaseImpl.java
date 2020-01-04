package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.adminrole;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.repositories.ArticleRepository;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole.FindArticleByAdminUseCase;

@Service
@SuppressWarnings("Duplicates")
public class FindArticleByAdminUseCaseImpl implements FindArticleByAdminUseCase {
    private ArticleRepository articleRepository = ArticleRepository.getInstance();
    @Override
    public Article findById(int id) throws FindArticleByAdminFailedException {
        Article article;
        try {
            validateById(id);
            article = findArticleById(id);
        } catch (FindArticleByAdminFailedException e) {
            throw new FindArticleByAdminFailedException(e.getMessage());
        }
        return article;
    }

    private Article findArticleById(int id) {
        return articleRepository.findById(id);
    }

    private void validateById(int id) throws FindArticleByAdminFailedException {
        if (id <= 0)
            throw new FindArticleByAdminFailedException("This id isn't true!");

        if (findArticleById(id) == null)
            throw new FindArticleByAdminFailedException("This id isn't exists!");
    }
}
