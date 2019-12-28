package ir.maktab.java32.projects.articlesmanagement.repositories;

import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.repositories.CrudRepository;
import ir.maktab.java32.projects.articlesmanagement.domain.User;

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

        getSession().beginTransaction();
        List dbPassword = getSession().createQuery("select password from User where username = :username")
                .setParameter("username", user.getUsername())
                .list();
        List users = getSession().createQuery("from User where username= :username")
                .setParameter("username", user.getPassword())
                .list();

        if (!(users.size() == 1 && user.getPassword().equals(dbPassword.get(0)))) {
            return null;
        }

        getSession().getTransaction().commit();
        return users;
    }

}
