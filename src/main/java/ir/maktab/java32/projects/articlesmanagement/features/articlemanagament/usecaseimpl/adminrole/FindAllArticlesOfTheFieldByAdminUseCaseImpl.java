package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.adminrole;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.repositories.ArticleRepository;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole.FindAllArticlesOfTheFieldByAdminUseCase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class FindAllArticlesOfTheFieldByAdminUseCaseImpl implements FindAllArticlesOfTheFieldByAdminUseCase {
    @Override
    public List<Article> findAll(String fieldName, Object value) throws FindAllArticlesOfTheFieldByAdminFailedException {
        List<Article> result;

        switch (fieldName) {
            case "create date" -> {
                List<Article> articleList = ArticleRepository.getInstance().findAll();
                result = new ArrayList<>();
                for (Article article : articleList) {
                    Date birthday = null;
                    try {
                        birthday = new SimpleDateFormat("dd/MM/yyyy").parse((String) value);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (birthday.compareTo(article.getCreateDate()) == 0)
                        result.add(article);
                }
            }
            case "last update date" -> {
                List<Article> articleList = ArticleRepository.getInstance().findAll();
                result = new ArrayList<>();
                for (Article article : articleList) {
                    Date birthday = null;
                    try {
                        birthday = new SimpleDateFormat("dd/MM/yyyy").parse((String) value);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (birthday.compareTo(article.getLastUpdateDate()) == 0)
                        result.add(article);
                }
            }
            case "publish date" -> {
                List<Article> articleList = ArticleRepository.getInstance().findAll();
                result = new ArrayList<>();
                for (Article article : articleList) {
                    Date birthday = null;
                    try {
                        birthday = new SimpleDateFormat("dd/MM/yyyy").parse((String) value);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (birthday.compareTo(article.getPublishDate()) == 0)
                        result.add(article);
                }
            }

            case "title" -> result = ArticleRepository.getInstance().findAll((Predicate<Article>) article -> article.getTitle().contains((String) value));
            case "brief" -> result = ArticleRepository.getInstance().findAll((Predicate<Article>) article -> article.getBrief().contains((String) value));
            case "content" -> result = ArticleRepository.getInstance().findAll((Predicate<Article>) article -> article.getContent().contains((String) value));
            case "published" -> result = ArticleRepository.getInstance().findAll((Predicate<Article>) article -> article.getIsPublished().equals((boolean) value));
            default -> throw new FindAllArticlesOfTheFieldByAdminFailedException("Loading user failed !");
        }
        if (result == null)
            throw new FindAllArticlesOfTheFieldByAdminFailedException("No matches found for the query!");
        return result;
    }
}
