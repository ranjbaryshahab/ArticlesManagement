package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.repositories;

import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.repositories.CrudRepository;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepository extends CrudRepository<User, Integer> {
    private static UserRepository userRepository;

    private UserRepository() {

    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    public List<User> userLogin(User user) {

        if (!getSession().getTransaction().isActive())
            getSession().getTransaction().begin();

        Query query = getSession().createQuery("from User where username= :username and password=:password");
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
        List<User> users = query.list();

        if (users.size() != 1)
            return null;

        getSession().getTransaction().commit();
        return users;
    }

}
