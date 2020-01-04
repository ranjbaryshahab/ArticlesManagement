package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.userrole;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole.CreateArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.repositories.ArticleRepository;

@Service
@SuppressWarnings("Duplicates")
public class CreateArticleByUserUseCaseImpl implements CreateArticleByUserUseCase {
    private ArticleRepository articleRepository = ArticleRepository.getInstance();

    @Override
    public Article create(Article article) throws CreateArticleByUserFailedException {
        Article saveArticle;
        try {
            validate(article);
            saveArticle = insertArticle(article);
        } catch (CreateArticleByUserFailedException e) {
            throw new CreateArticleByUserFailedException(e.getMessage());
        }

        return saveArticle;
    }

    private Article insertArticle(Article article) {
        return articleRepository.save(article);
    }


    private void validate(Article article) throws CreateArticleByUserFailedException {
        if (article.getTitle() == null || article.getTitle().isEmpty())
            throw new CreateArticleByUserFailedException("Title is empty");

        if (article.getTitle().length() > 30)
            throw new CreateArticleByUserFailedException("Title is bigger than 30 characters");

        if (article.getBrief() == null || article.getBrief().isEmpty())
            throw new CreateArticleByUserFailedException("Brief is empty");

        if (article.getBrief().length() > 15)
            throw new CreateArticleByUserFailedException("Brief is bigger than 30 characters");

        if (article.getContent() == null || article.getContent().isEmpty())
            throw new CreateArticleByUserFailedException("Content is empty");

        if (article.getContent().length() > 254)
            throw new CreateArticleByUserFailedException("Content is bigger than 254 characters");
    }
}
