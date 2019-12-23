package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.impl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.HibernateUtil;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGeneric;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGenericImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.FindArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.model.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Service
@SuppressWarnings("Duplicates")
public class FindArticleByUserUseCaseImpl implements FindArticleByUserUseCase {
    CrudGeneric<Article, Integer> crudGeneric = new CrudGenericImpl<>(Article.class);

    @Override
    public Article findById(int id) throws FindArticleByUserFailedException {
        Article article;
        try {
            validate(id);
            article = findArticle(id);
        } catch (FindArticleByUserFailedException e) {
            throw new FindArticleByUserFailedException(e.getMessage());
        }
        return article;
    }

    private Article findArticle(int id) {
        Article article;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        CrudGenericImpl.setSession(session);
        CrudGenericImpl.getSession().beginTransaction();
        article = crudGeneric.findById(id);
        CrudGenericImpl.getSession().getTransaction().commit();
        CrudGenericImpl.getSession().close();
        return article;
    }

    private void validate(int id) throws FindArticleByUserFailedException {
        if (id <= 0)
            throw new FindArticleByUserFailedException("This id isn't true!");

        if (findArticle(id) == null)
            throw new FindArticleByUserFailedException("This id isn't exists!");

    }
}
