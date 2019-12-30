package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.FindArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.repositories.ArticleRepository;

@Service
@SuppressWarnings("Duplicates")
public class FindArticleByUserUseCaseImpl implements FindArticleByUserUseCase {
    private ArticleRepository articleRepository = ArticleRepository.getInstance();
    private User user = AuthenticationService.getInstance().getLoginUser();
    @Override
    public Article findById(int id) throws FindArticleByUserFailedException {
        Article article;
        try {
            validateById(id);
            article = findArticleById(id);
        } catch (FindArticleByUserFailedException e) {
            throw new FindArticleByUserFailedException(e.getMessage());
        }
        return article;
    }

    private Article findArticleById(int id) {
        return articleRepository.findById(id);
    }

    private void validateById(int id) throws FindArticleByUserFailedException {
        if (id <= 0)
            throw new FindArticleByUserFailedException("This id isn't true!");

        if (findArticleById(id) == null)
            throw new FindArticleByUserFailedException("This id isn't exists!");
    }
}
