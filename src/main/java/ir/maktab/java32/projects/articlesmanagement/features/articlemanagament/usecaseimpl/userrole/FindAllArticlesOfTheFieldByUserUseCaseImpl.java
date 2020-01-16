package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.userrole;

import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.repositories.ArticleRepository;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole.FindAllArticlesOfTheFieldByUserUseCase;

import java.util.List;
import java.util.function.Predicate;

public class FindAllArticlesOfTheFieldByUserUseCaseImpl implements FindAllArticlesOfTheFieldByUserUseCase {
    @Override
    public List<Article> findAll(String fieldName, Object value) throws FindAllArticlesOfTheFieldByUserFailedException {
        List<Article> result;

        switch (fieldName) {
            case "title" -> result = ArticleRepository.getInstance().findAll((Predicate<Article>) article -> article.getTitle().contains((String) value) && article.getUser().getUsername().equals(AuthenticationService.getInstance().getLoginUser().getUsername()));
            case "brief" -> result = ArticleRepository.getInstance().findAll((Predicate<Article>) article -> article.getBrief().contains((String) value) && article.getUser().getUsername().equals(AuthenticationService.getInstance().getLoginUser().getUsername()));
            case "content" -> result = ArticleRepository.getInstance().findAll((Predicate<Article>) article -> article.getContent().contains((String) value) && article.getUser().getUsername().equals(AuthenticationService.getInstance().getLoginUser().getUsername()));
            case "category title" -> result = ArticleRepository.getInstance().findAll((Predicate<Article>) article -> article.getCategory().getTitle().contains((String) value) && article.getUser().getUsername().equals(AuthenticationService.getInstance().getLoginUser().getUsername()));
            default -> throw new FindAllArticlesOfTheFieldByUserFailedException("Loading user failed !");
        }
        if (result == null)
            throw new FindAllArticlesOfTheFieldByUserFailedException("No matches found for the query!");
        return result;
    }
}
