package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.HibernateUtil;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGeneric;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGenericImpl;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases.FindCategoryByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Service
@SuppressWarnings("Duplicates")
public class FindCategoryByUserUseCaseImpl implements FindCategoryByUserUseCase {
    CrudGeneric<Category, Integer> crudGeneric = new CrudGenericImpl<>(Category.class);

    @Override
    public Category findById(int id) throws FindCategoryByUserFailedException {
        Category category;
        try {
            validate(id);
            category = findCategory(id);
        } catch (FindCategoryByUserFailedException e) {
            throw new FindCategoryByUserFailedException(e.getMessage());
        }
        return category;
    }

    private Category findCategory(int id) {
        Category category;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        CrudGenericImpl.setSession(session);
        CrudGenericImpl.getSession().beginTransaction();
        category = crudGeneric.findById(id);
        CrudGenericImpl.getSession().getTransaction().commit();
        CrudGenericImpl.getSession().close();
        return category;
    }

    private void validate(int id) throws FindCategoryByUserFailedException {
        if (id <= 0)
            throw new FindCategoryByUserFailedException("This id isn't true!");

        if (findCategory(id) == null)
            throw new FindCategoryByUserFailedException("This id isn't exists!");

    }
}
