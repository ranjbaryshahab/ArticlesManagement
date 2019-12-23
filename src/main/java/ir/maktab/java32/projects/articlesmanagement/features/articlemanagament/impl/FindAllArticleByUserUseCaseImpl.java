package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.impl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.HibernateUtil;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGeneric;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGenericImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.FindAllArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.model.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

@Service
@SuppressWarnings("Duplicates")
public class FindAllArticleByUserUseCaseImpl implements FindAllArticleByUserUseCase {
    CrudGeneric<Article, Integer> crudGeneric = new CrudGenericImpl<>(Article.class);

    @Override
    public List<Article> findAll() {
        List<Article> articleList;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        CrudGenericImpl.setSession(session);
        CrudGenericImpl.getSession().beginTransaction();
        articleList = crudGeneric.findAll();
        CrudGenericImpl.getSession().getTransaction().commit();
        CrudGenericImpl.getSession().close();
        return articleList;
    }

}
