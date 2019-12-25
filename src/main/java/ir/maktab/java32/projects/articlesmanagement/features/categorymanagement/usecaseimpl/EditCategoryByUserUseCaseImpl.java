package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.HibernateUtil;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGeneric;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGenericImpl;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases.EditCategoryByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Service
@SuppressWarnings("Duplicates")
public class EditCategoryByUserUseCaseImpl implements EditCategoryByUserUseCase {
    CrudGeneric<Category, Integer> crudGeneric = new CrudGenericImpl<>(Category.class);

    @Override
    public Category edit(Category category) throws EditCategoryByUserFailedException {
        Category updatedCategory;
        try {
            validate(category);
            updatedCategory = updateCategory(category);
        } catch (EditCategoryByUserFailedException e) {
            throw new EditCategoryByUserFailedException(e.getMessage());
        }

        return updatedCategory;
    }

    private Category updateCategory(Category category) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        CrudGenericImpl.setSession(session);
        CrudGenericImpl.getSession().beginTransaction();
        Category updatedCategory = crudGeneric.update(category);
        CrudGenericImpl.getSession().getTransaction().commit();
        CrudGenericImpl.getSession().close();
        return updatedCategory;
    }

    private void validate(Category category) throws EditCategoryByUserFailedException {
        if (category.getTitle() == null || category.getTitle().isEmpty())
            throw new EditCategoryByUserFailedException("Title is empty!");
        if (category.getTitle().length() > 30)
            throw new EditCategoryByUserFailedException("Title is bigger than 30 characters");
        if (category.getDescription() == null || category.getDescription().isEmpty())
            throw new EditCategoryByUserFailedException("Description is empty!");
        if (category.getDescription().length() > 150)
            throw new EditCategoryByUserFailedException("Description is bigger than 150 characters");
    }
}
