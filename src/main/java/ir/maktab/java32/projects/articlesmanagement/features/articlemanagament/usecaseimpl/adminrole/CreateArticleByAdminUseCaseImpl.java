package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.adminrole;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.repositories.ArticleRepository;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole.CreateArticleByAdminUseCase;

@Service
@SuppressWarnings("Duplicates")
public class CreateArticleByAdminUseCaseImpl implements CreateArticleByAdminUseCase {
    private ArticleRepository articleRepository = ArticleRepository.getInstance();

    @Override
    public Article create(Article article) throws CreateArticleByAdminFailedException {
        Article saveArticle;
        try {
            validate(article);
            saveArticle = insertArticle(article);
        } catch (CreateArticleByAdminFailedException e) {
            throw new CreateArticleByAdminFailedException(e.getMessage());
        }

        return saveArticle;
    }

    private Article insertArticle(Article article) {
        return articleRepository.save(article);
    }


    private void validate(Article article) throws CreateArticleByAdminFailedException {
        if (article.getTitle() == null || article.getTitle().isEmpty())
            throw new CreateArticleByAdminFailedException("Title is empty");

        if (article.getTitle().length() > 30)
            throw new CreateArticleByAdminFailedException("Title is bigger than 30 characters");

        if (article.getBrief() == null || article.getBrief().isEmpty())
            throw new CreateArticleByAdminFailedException("Brief is empty");

        if (article.getBrief().length() > 15)
            throw new CreateArticleByAdminFailedException("Brief is bigger than 30 characters");

        if (article.getContent() == null || article.getContent().isEmpty())
            throw new CreateArticleByAdminFailedException("Content is empty");

        if (article.getContent().length() > 254)
            throw new CreateArticleByAdminFailedException("Content is bigger than 254 characters");
    }
}
