package ir.maktab.java32.projects.articlesmanagement.core.share;

import java.io.Serializable;
import java.util.List;

public interface CrudGeneric<EntityType, PK extends Serializable> {
    EntityType insert(EntityType entityType);

    EntityType update(EntityType entityType);

    void delete(PK id);

    List<EntityType> findAll();

    EntityType findById(PK id);
}
