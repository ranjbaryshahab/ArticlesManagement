package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl;


import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.LogoutByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.User;

@Service
public class LogoutUserUseCaseImpl implements LogoutByUserUseCase {
    @Override
    public User logout() {
        return null;
    }
}
