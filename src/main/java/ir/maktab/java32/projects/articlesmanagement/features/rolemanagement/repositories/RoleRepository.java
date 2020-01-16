package ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.repositories;

import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.HibernateUtil;
import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.repositories.CrudRepository;
import ir.maktab.java32.projects.articlesmanagement.domain.Role;

public class RoleRepository extends CrudRepository<Role, Integer> {
    private static RoleRepository roleRepository;

    private RoleRepository() {
        setSession(HibernateUtil.getFirstSession());
    }

    public static RoleRepository getInstance() {
        if (roleRepository == null) {
            roleRepository = new RoleRepository();
        }
        return roleRepository;
    }

    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }
}
