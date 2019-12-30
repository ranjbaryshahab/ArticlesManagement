package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.FindAllAccountByAdminUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.repositories.UserRepository;

import java.util.List;

@Service
@SuppressWarnings("Duplicates")
public class FindAllAccountByAdminUseCaseImpl implements FindAllAccountByAdminUseCase {
    private UserRepository userRepository = UserRepository.getInstance();
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
