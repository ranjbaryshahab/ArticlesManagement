package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.DeleteArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.FindArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.repositories.ArticleRepository;

@Service
@SuppressWarnings("Duplicates")
public class DeleteArticleByUserUseCaseImpl implements DeleteArticleByUserUseCase {
    private ArticleRepository articleRepository = ArticleRepository.getInstance();
    private User user = AuthenticationService.getInstance().getLoginUser();

    @Override
    public void delete(int id) throws DeleteArticleByUserFailedException {
        try {
            validate(id);
            deleteArticle(id);
        } catch (DeleteArticleByUserFailedException | FindArticleByUserUseCase.FindArticleByUserFailedException e) {
            throw new DeleteArticleByUserFailedException(e.getMessage());
        }
    }

    private void deleteArticle(int id) {
        articleRepository.removeById(id);
    }

    private void validate(int id) throws DeleteArticleByUserFailedException, FindArticleByUserUseCase.FindArticleByUserFailedException {
        Article article = articleRepository.findById(id);
        if (article == null)
            throw new DeleteArticleByUserFailedException("It wasn't deleted !");
        if (article.getUser().getUsername().equals(user.getUsername()))
            throw new DeleteArticleByUserFailedException("You can't delete this article!");

    }
}
