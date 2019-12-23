package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.impl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.HibernateUtil;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGeneric;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGenericImpl;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases.CreateCategoryByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases.FindAllCategoryByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

@Service
@SuppressWarnings("Duplicates")
public class CreateCategoryByUserUseCaseImpl implements CreateCategoryByUserUseCase {
    CrudGeneric<Category, Integer> crudGeneric = new CrudGenericImpl<>(Category.class);

    @Override
    public Category create(Category category) throws EditCategoryByUserFailedException {
        Category savedCategory;
        try {
            validate(category);
            savedCategory = insertCategory(category);
        } catch (EditCategoryByUserFailedException e) {
            throw new EditCategoryByUserFailedException(e.getMessage());
        }

        return savedCategory;
    }

    private Category insertCategory(Category category) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        CrudGenericImpl.setSession(session);
        CrudGenericImpl.getSession().beginTransaction();
        Category savedCategory = crudGeneric.insert(category);
        CrudGenericImpl.getSession().getTransaction().commit();
        CrudGenericImpl.getSession().close();
        return savedCategory;
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
        FindAllCategoryByUserUseCase findAllCategoryByUserUseCase = new FindAllCategoryByUserUseCaseImpl();
        List<Category> categoryList = findAllCategoryByUserUseCase.findAll();
        boolean categoryExist = false;
        for (Category category1 : categoryList) {
            if (category1.getTitle().equals(category.getTitle())) {
                categoryExist = true;
                break;
            }
        }

        if (categoryExist)
            throw new EditCategoryByUserFailedException("This category exists!");
    }
}
