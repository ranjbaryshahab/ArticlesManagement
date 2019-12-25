package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.HibernateUtil;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGeneric;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGenericImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.FindAccountByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Service
@SuppressWarnings("Duplicates")
public class FindAccountByUserUseCaseImpl implements FindAccountByUserUseCase {
    CrudGeneric<User, Integer> crudGeneric = new CrudGenericImpl<>(User.class);

    @Override
    public User findById(int id) throws FindAccountByUserFailedException {
        User user;
        try {
            validate(id);
            user = findUser(id);
        } catch (FindAccountByUserFailedException e) {
            throw new FindAccountByUserFailedException(e.getMessage());
        }
        return user;
    }

    private User findUser(int id) {
        User user;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        CrudGenericImpl.setSession(session);
        CrudGenericImpl.getSession().beginTransaction();
        user = crudGeneric.findById(id);
        CrudGenericImpl.getSession().getTransaction().commit();
        CrudGenericImpl.getSession().close();
        return user;
    }

    private void validate(int id) throws FindAccountByUserFailedException {
        if (id <= 0)
            throw new FindAccountByUserFailedException("This id isn't true!");

        if (findUser(id) == null)
            throw new FindAccountByUserFailedException("This id isn't exists!");

    }
}
