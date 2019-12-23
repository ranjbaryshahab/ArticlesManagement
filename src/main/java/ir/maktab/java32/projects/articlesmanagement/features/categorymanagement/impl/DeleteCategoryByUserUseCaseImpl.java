package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.impl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.HibernateUtil;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGeneric;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGenericImpl;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases.DeleteCategoryByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases.FindCategoryByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Service
@SuppressWarnings("Duplicates")
public class DeleteCategoryByUserUseCaseImpl implements DeleteCategoryByUserUseCase {
    CrudGeneric<Category, Integer> crudGeneric = new CrudGenericImpl<>(Category.class);

    @Override
    public void delete(int id) throws DeleteCategoryByUserFailedException {
        try {
            validate(id);
            deleteCategory(id);
        } catch (DeleteCategoryByUserFailedException | FindCategoryByUserUseCase.FindCategoryByUserFailedException e) {
            throw new DeleteCategoryByUserFailedException(e.getMessage());
        }
    }

    private void deleteCategory(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        CrudGenericImpl.setSession(session);
        CrudGenericImpl.getSession().beginTransaction();
        crudGeneric.delete(id);
        CrudGenericImpl.getSession().getTransaction().commit();
        CrudGenericImpl.getSession().close();
    }

    private void validate(int id) throws DeleteCategoryByUserFailedException, FindCategoryByUserUseCase.FindCategoryByUserFailedException {
        FindCategoryByUserUseCase findCategoryByUserUseCase = new FindCategoryByUserUseCaseImpl();
        Category category = findCategoryByUserUseCase.findById(id);
        if (category == null)
            throw new DeleteCategoryByUserFailedException("It wasn't deleted !");
    }
}
