package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.userrole;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole.DeleteArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole.FindArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.repositories.ArticleRepository;

@Service
@SuppressWarnings("Duplicates")
public class DeleteArticleByUserUseCaseImpl implements DeleteArticleByUserUseCase {
    private ArticleRepository articleRepository = ArticleRepository.getInstance();
    private User user = AuthenticationService.getInstance().getLoginUser();

    @Override
    public void delete(int id) throws DeleteArticleByUserFailedException {
        FindArticleByUserUseCase findArticleByUserUseCase = new FindArticleByUserUseCaseImpl();
        Article article = null;
        try {
            article = findArticleByUserUseCase.findById(id);
        } catch (FindArticleByUserUseCase.FindArticleByUserFailedException e) {
            throw new DeleteArticleByUserFailedException(e.getMessage());
        }
        if(article.getUser().getUsername().equals(user.getUsername())) {
            try {
                validate(id);
                deleteArticle(id);
            } catch (DeleteArticleByUserFailedException | FindArticleByUserUseCase.FindArticleByUserFailedException e) {
                throw new DeleteArticleByUserFailedException(e.getMessage());
            }
        }else
            throw new DeleteArticleByUserFailedException("You can't delete this article!");
    }

    private void deleteArticle(int id) {
        articleRepository.removeById(id);
    }

    private void validate(int id) throws DeleteArticleByUserFailedException, FindArticleByUserUseCase.FindArticleByUserFailedException {
        Article article = articleRepository.findById(id);
        if (article == null)
            throw new DeleteArticleByUserFailedException("It wasn't deleted !");
    }
}
