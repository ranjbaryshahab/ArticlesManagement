package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.repositories;

import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.HibernateUtil;
import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.repositories.CrudRepository;
import ir.maktab.java32.projects.articlesmanagement.domain.Category;

public class CategoryRepository extends CrudRepository<Category, Integer> {
    private static CategoryRepository categoryRepository;

    private CategoryRepository() {
        setSession(HibernateUtil.getFirstSession());
    }

    public static CategoryRepository getInstance() {
        if (categoryRepository == null) {
            categoryRepository = new CategoryRepository();
        }
        return categoryRepository;
    }

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }
}
