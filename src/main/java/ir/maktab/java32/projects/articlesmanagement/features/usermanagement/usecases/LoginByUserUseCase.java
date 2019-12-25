package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.UseCase;
import ir.maktab.java32.projects.articlesmanagement.model.User;

@UseCase
public interface LoginByUserUseCase {
    User login(String username, String password) throws LoginByUserFailedException;

    class LoginByUserFailedException extends Exception {

        public LoginByUserFailedException(String message) {
            super(message);
        }
    }
}
