package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.repositories;

import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.HibernateUtil;
import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.repositories.CrudRepository;
import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import org.hibernate.query.Query;

import java.util.List;

public class ArticleRepository extends CrudRepository<Article, Integer> {
    private static ArticleRepository articleRepository;
    private ArticleRepository() {
        setSession(HibernateUtil.getFirstSession());
    }

    public static ArticleRepository getInstance() {
        if (articleRepository == null) {
            articleRepository = new ArticleRepository();
        }
        return articleRepository;
    }

    @Override
    protected Class<Article> getEntityClass() {
        return Article.class;
    }

    public List<Article> findAllByUser() {
        User user = AuthenticationService.getInstance().getLoginUser();
        getSession().beginTransaction();
        Query<Article> query = getSession().createQuery("from Article where user.username= :username",Article.class);
        query.setParameter("username", user.getUsername());
        List<Article> articles = query.list();
        getSession().getTransaction().commit();
        return articles;
    }
}
