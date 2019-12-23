package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.impl;


import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.LogoutByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.model.User;

@Service
public class LogoutUserUseCaseImpl implements LogoutByUserUseCase {
    @Override
    public User logout(User user) {
        return null;
    }
}
