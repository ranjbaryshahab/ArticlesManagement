package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.impl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.HibernateUtil;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGeneric;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGenericImpl;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases.FindAllCategoryByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

@Service
@SuppressWarnings("Duplicates")
public class FindAllCategoryByUserUseCaseImpl implements FindAllCategoryByUserUseCase {
    CrudGeneric<Category, Integer> crudGeneric = new CrudGenericImpl<>(Category.class);

    @Override
    public List<Category> findAll() {
        List<Category> categoryList;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        CrudGenericImpl.setSession(session);
        CrudGenericImpl.getSession().beginTransaction();
        categoryList = crudGeneric.findAll();
        CrudGenericImpl.getSession().getTransaction().commit();
        CrudGenericImpl.getSession().close();
        return categoryList;
    }
}
