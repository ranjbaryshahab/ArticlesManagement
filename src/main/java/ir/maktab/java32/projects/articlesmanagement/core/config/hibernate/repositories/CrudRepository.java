package ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.repositories;

import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public abstract class CrudRepository<Entity,ID extends Serializable> {
    protected abstract Class<Entity> getEntityClass();

    public Entity save(Entity entity) {
        getSession().beginTransaction();
        getSession().save(entity);
        getSession().getTransaction().commit();
        return entity;
    }

    public Entity update(Entity entity) {
        getSession().beginTransaction();
        getSession().update(entity);
        getSession().getTransaction().commit();
        return entity;
    }

    public void remove(Entity entity) {
        getSession().beginTransaction();
        getSession().remove(entity);
        getSession().getTransaction().commit();
    }

    public void removeById(ID id) {
        Entity entity = findById(id);
        if (entity != null) {
            getSession().beginTransaction();
            getSession().remove(entity);
            getSession().getTransaction().commit();
        }
    }

    public Entity findById(ID id) {
        getSession().beginTransaction();
        Entity entity = getSession().get(getEntityClass(), id);
        getSession().getTransaction().commit();
        return entity;
    }

    public List<Entity> findAll() {
        getSession().beginTransaction();
        Query<Entity> query = getSession()
                .createQuery("from " + getEntityClass().getName(), getEntityClass());
        List<Entity> entities = query.list();
        getSession().getTransaction().commit();
        return entities;
    }

    public List<Entity> findAll(int start, int row) {
        getSession().beginTransaction();
        Query<Entity> query = getSession()
                .createQuery("from " + getEntityClass().getName(), getEntityClass());
        query.setFirstResult(start);
        query.setMaxResults(row);
        List<Entity> entities = query.list();
        getSession().getTransaction().commit();
        return entities;
    }
    protected Session getSession() {
        return HibernateUtil.getSession();
    }
}
