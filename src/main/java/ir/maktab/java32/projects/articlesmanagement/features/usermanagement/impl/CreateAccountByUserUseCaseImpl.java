package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.impl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.HibernateUtil;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGeneric;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGenericImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.CreateAccountByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.FindAllAccountByAdminUseCase;
import ir.maktab.java32.projects.articlesmanagement.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

@Service
@SuppressWarnings("Duplicates")
public class CreateAccountByUserUseCaseImpl implements CreateAccountByUserUseCase {
    CrudGeneric<User, Integer> crudGeneric = new CrudGenericImpl<>(User.class);

    @Override
    public User create(User user) throws CreateAccountByUserFailedException {
        User savedUser;
        validate(user);
        savedUser = createAccount(user);
        return savedUser;
    }

    public User createAccount(User user) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        CrudGenericImpl.setSession(session);
        CrudGenericImpl.getSession().beginTransaction();
        User savedUser = crudGeneric.insert(user);
        CrudGenericImpl.getSession().getTransaction().commit();
        CrudGenericImpl.getSession().close();
        return savedUser;
    }

    public void validate(User user) throws CreateAccountByUserFailedException {
        if (user.getUsername() == null || user.getUsername().isEmpty())
            throw new CreateAccountByUserFailedException("Username is empty!");

        FindAllAccountByAdminUseCase findAllAccountByAdminUseCase =
                new FindAllAccountByAdminUseCaseImpl();
        List<User> userList = findAllAccountByAdminUseCase.findAll();
        boolean userExist=false;
        for(User user1 : userList){
            if(user1.getUsername().equals(user.getUsername())){
                userExist =true;
                break;
            }
        }
        if (userExist)
            throw new CreateAccountByUserFailedException("This username exists!");

        if (user.getUsername().length() > 25)
            throw new CreateAccountByUserFailedException("Username is bigger than 30 characters!");

        if (user.getNationalCode() == null || user.getNationalCode().isEmpty())
            throw new CreateAccountByUserFailedException("NationalCode is empty!");

        if (user.getNationalCode().length() > 25)
            throw new CreateAccountByUserFailedException("NationalCode is bigger than 30 characters!");

        if (user.getPassword() == null || user.getPassword().isEmpty())
            throw new CreateAccountByUserFailedException("Password is empty!");
    }
}
