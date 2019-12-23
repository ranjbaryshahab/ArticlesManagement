package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.impl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.HibernateUtil;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGeneric;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGenericImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.DeleteAccountByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.FindAccountByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Service
@SuppressWarnings("Duplicates")
public class DeleteAccountByUserUseCaseImpl implements DeleteAccountByUserUseCase {
    CrudGeneric<User, Integer> crudGeneric = new CrudGenericImpl<>(User.class);

    @Override
    public void delete(int id) throws DeleteAccountByUserFailedException {
        try {
            validate(id);
            deleteUser(id);
        } catch (DeleteAccountByUserFailedException e) {
            throw new DeleteAccountByUserFailedException(e.getMessage());
        } catch (FindAccountByUserUseCase.FindAccountByUserFailedException e) {
            e.printStackTrace();
        }
    }

    private void deleteUser(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        CrudGenericImpl.setSession(session);
        CrudGenericImpl.getSession().beginTransaction();
        crudGeneric.delete(id);
        CrudGenericImpl.getSession().getTransaction().commit();
        CrudGenericImpl.getSession().close();
    }

    private void validate(int id) throws DeleteAccountByUserFailedException, FindAccountByUserUseCase.FindAccountByUserFailedException {
        FindAccountByUserUseCase findAccountByUserUseCase = new FindAccountByUserUseCaseImpl();
        User user = findAccountByUserUseCase.findById(id);
        if (user == null)
            throw new DeleteAccountByUserFailedException("It wasn't deleted !");
    }
}
