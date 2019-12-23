package ir.maktab.java32.projects.articlesmanagement.core.share;

import org.hibernate.Session;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class CrudGenericImpl<EntityType, PK extends Serializable> implements CrudGeneric<EntityType, PK> {

    private static Session session;
    private Class<EntityType> clazz;

    public CrudGenericImpl(Class<EntityType> clazz) {
        this.clazz = clazz;
    }

    public static void setSession(Session session) {
        CrudGenericImpl.session = session;
    }

    public static Session getSession() {
        return session;
    }

    @Override
    public EntityType insert(EntityType entityType) {
        session.saveOrUpdate(entityType);
        return entityType;
    }

    @Override
    public EntityType update(EntityType entityType) {
        session.update(entityType);
        return entityType;
    }

    @Override
    public void delete(PK id) {
        session.delete(findById(id));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<EntityType> findAll() {
        List<EntityType> result;
        Query query = session.createQuery("from " + clazz.getSimpleName());
        result = query.getResultList();
        return result;
    }

    @Override
    public EntityType findById(PK id) {
        return session.get(clazz, id);
    }

}
