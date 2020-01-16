package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.core.utilities.UserInfo;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.repositories.UserRepository;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.FindAllAccountByAdminUseCase;

import java.util.List;
import java.util.function.Function;

@Service
@SuppressWarnings("Duplicates")
public class FindAllAccountByAdminUseCaseImpl implements FindAllAccountByAdminUseCase {
    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<UserInfo> findAllUserInfo() {
        Function<User, UserInfo> function =
                user -> new UserInfo(user.getId(), user.getUsername(), user.getAddress().getCity());
        return UserRepository.getInstance().findAll(function);
    }
}
