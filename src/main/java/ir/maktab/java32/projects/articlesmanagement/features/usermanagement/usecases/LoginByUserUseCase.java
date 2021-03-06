package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.UseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.User;

@UseCase
public interface LoginByUserUseCase {
    User login(User user) throws LoginByUserFailedException;

    class LoginByUserFailedException extends Exception {

        public LoginByUserFailedException(String message) {
            super(message);
        }
    }
}
