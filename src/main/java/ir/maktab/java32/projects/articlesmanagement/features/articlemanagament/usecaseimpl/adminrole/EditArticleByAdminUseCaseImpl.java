package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.adminrole;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.repositories.ArticleRepository;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole.EditArticleByAdminUseCase;

@Service
@SuppressWarnings({"Duplicates", "unchecked"})
public class EditArticleByAdminUseCaseImpl implements EditArticleByAdminUseCase {
    private ArticleRepository articleRepository = ArticleRepository.getInstance();
    @Override
    public Article edit(Article article) throws EditArticleByAdminFailedException {
        Article editArticle;
            try {
                validate(article);
                editArticle = updateArticle(article);
            } catch (EditArticleByAdminFailedException e) {
                throw new EditArticleByAdminFailedException(e.getMessage());
            }
            return editArticle;
    }

    private Article updateArticle(Article article) {
        return articleRepository.update(article);
    }

    private void validate(Article article) throws EditArticleByAdminFailedException {
        if (article.getTitle() == null || article.getTitle().isEmpty())
            throw new EditArticleByAdminFailedException("Title is empty");

        if (article.getTitle().length() > 30)
            throw new EditArticleByAdminFailedException("Title is bigger than 30 characters");

        if (article.getBrief() == null || article.getBrief().isEmpty())
            throw new EditArticleByAdminFailedException("Brief is empty");

        if (article.getBrief().length() > 15)
            throw new EditArticleByAdminFailedException("Brief is bigger than 30 characters");

        if (article.getContent() == null || article.getContent().isEmpty())
            throw new EditArticleByAdminFailedException("Content is empty");

        if (article.getContent().length() > 254)
            throw new EditArticleByAdminFailedException("Content is bigger than 254 characters");
    }

}
