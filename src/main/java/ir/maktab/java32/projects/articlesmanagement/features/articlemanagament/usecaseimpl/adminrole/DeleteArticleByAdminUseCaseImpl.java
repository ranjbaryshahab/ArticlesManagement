package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.adminrole;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.repositories.ArticleRepository;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole.DeleteArticleByAdminUseCase;

@Service
@SuppressWarnings("Duplicates")
public class DeleteArticleByAdminUseCaseImpl implements DeleteArticleByAdminUseCase {
    private ArticleRepository articleRepository = ArticleRepository.getInstance();
    @Override
    public void delete(int id) throws DeleteArticleByAdminFailedException {
            try {
                validate(id);
                deleteArticle(id);
            } catch (DeleteArticleByAdminFailedException e) {
                throw new DeleteArticleByAdminFailedException(e.getMessage());
            }
        }

    private void deleteArticle(int id) {
        articleRepository.removeById(id);
    }

    private void validate(int id) throws DeleteArticleByAdminFailedException {
        Article article = articleRepository.findById(id);
        if (article == null)
            throw new DeleteArticleByAdminFailedException("It wasn't deleted !");
    }
}
