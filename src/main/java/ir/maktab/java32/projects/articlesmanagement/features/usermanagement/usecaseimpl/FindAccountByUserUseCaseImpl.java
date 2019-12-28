package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.FindAccountByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.repositories.UserRepository;

@Service
@SuppressWarnings("Duplicates")
public class FindAccountByUserUseCaseImpl implements FindAccountByUserUseCase {
    private UserRepository userRepository = UserRepository.getInstance();
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
        return userRepository.findById(id);
    }

    private void validate(int id) throws FindAccountByUserFailedException {
        if (id <= 0)
            throw new FindAccountByUserFailedException("This id isn't true!");

        if (findUser(id) == null)
            throw new FindAccountByUserFailedException("This id isn't exists!");

    }
}
