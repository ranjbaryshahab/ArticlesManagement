package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.EditAccountByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.repositories.UserRepository;

@Service
@SuppressWarnings("Duplicates")
public class EditAccountByUserUseCaseImpl implements EditAccountByUserUseCase {
    private UserRepository userRepository = UserRepository.getInstance();
    @Override
    public User edit(User user) throws EditAccountByUserFailedException {
        User editUser;
        try {
            validate(user);
            editUser = updateUser(user);
        } catch (EditAccountByUserFailedException e) {
            throw new EditAccountByUserFailedException(e.getMessage());
        }
        return editUser;
    }

    public User updateUser(User user) {
        return userRepository.update(user);
    }

    public void validate(User user) throws EditAccountByUserFailedException {
        if (user.getUsername() == null || user.getUsername().isEmpty())
            throw new EditAccountByUserFailedException("Username is empty!");

        if (user.getUsername().length() > 25)
            throw new EditAccountByUserFailedException("Username is bigger than 30 characters!");

        if (user.getNationalCode() == null || user.getNationalCode().isEmpty())
            throw new EditAccountByUserFailedException("NationalCode is empty!");

        if (user.getNationalCode().length() > 25)
            throw new EditAccountByUserFailedException("NationalCode is bigger than 30 characters!");

        if (user.getPassword() == null || user.getPassword().isEmpty())
            throw new EditAccountByUserFailedException("Password is empty!");
    }

}
