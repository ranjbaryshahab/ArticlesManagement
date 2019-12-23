package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.impl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.HibernateUtil;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGenericImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.LoginByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

@Service
@SuppressWarnings("unchecked")
public class LoginByUserUseCaseImpl implements LoginByUserUseCase {
    @Override
    public User login(User user) throws LoginByUserFailedException {
        User userLogin;
        try {
            validate(user);
            userLogin = userLogin(user);
        } catch (LoginByUserFailedException e) {
            throw new LoginByUserFailedException(e.getMessage());
        }
        return userLogin;
    }

    private User userLogin(User user) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        CrudGenericImpl.setSession(session);
        CrudGenericImpl.getSession().beginTransaction();
        Query query = session.createQuery("from User where username=:username and password=:password");
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
        List<User> loginUser = query.list();
        CrudGenericImpl.getSession().getTransaction().commit();
        CrudGenericImpl.getSession().close();
        return loginUser.get(0);
    }

    private void validate(User user) throws LoginByUserFailedException {
        if (userLogin(user) == null)
            throw new LoginByUserFailedException("Username or password is incorrect !");
    }
}
