package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.LoginByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.repositories.UserRepository;

@Service
@SuppressWarnings("unchecked")
public class LoginByUserUseCaseImpl implements LoginByUserUseCase {
    private UserRepository userRepository = UserRepository.getInstance();
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
        return userRepository.userLogin(user).get(0);
    }

    private void validate(User user) throws LoginByUserFailedException {
        if (userRepository.userLogin(user)==null)
            throw new LoginByUserFailedException("Username or password is incorrect !");
    }
}
