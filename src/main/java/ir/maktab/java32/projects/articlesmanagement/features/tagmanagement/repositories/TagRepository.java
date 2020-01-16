package ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.repositories;

import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.HibernateUtil;
import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.repositories.CrudRepository;
import ir.maktab.java32.projects.articlesmanagement.domain.Tag;

public class TagRepository extends CrudRepository<Tag, Integer> {
    private static TagRepository tagRepository;

    private TagRepository() {
        setSession(HibernateUtil.getFirstSession());
    }

    public static TagRepository getInstance() {
        if (tagRepository == null) {
            tagRepository = new TagRepository();
        }
        return tagRepository;
    }

    @Override
    protected Class<Tag> getEntityClass() {
        return Tag.class;
    }
}
