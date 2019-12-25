package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl;

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
    public User login(String username, String password) throws LoginByUserFailedException {
        User userLogin;
        try {
            validate(username, password);
            userLogin = userLogin(username, password);
        } catch (LoginByUserFailedException e) {
            throw new LoginByUserFailedException(e.getMessage());
        }
        return userLogin;
    }

    private User userLogin(String username, String password) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        CrudGenericImpl.setSession(session);
        CrudGenericImpl.getSession().beginTransaction();
        Query query = session.createQuery("from User where username=:username and password=:password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<User> loginUser = query.list();
        CrudGenericImpl.getSession().getTransaction().commit();
        CrudGenericImpl.getSession().close();
        if(loginUser==null){
            return null;
        }
        return loginUser.get(0);
    }

    private void validate(String username, String password) throws LoginByUserFailedException {
        if (userLogin(username, password) == null)
            throw new LoginByUserFailedException("Username or password is incorrect !");
    }
}
