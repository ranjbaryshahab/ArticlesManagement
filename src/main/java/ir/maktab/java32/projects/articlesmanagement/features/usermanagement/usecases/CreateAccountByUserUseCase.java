package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.UseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.User;

@UseCase
public interface CreateAccountByUserUseCase {
    User create(User user) throws CreateAccountByUserFailedException;

    class CreateAccountByUserFailedException extends Exception {
        public CreateAccountByUserFailedException(String message) {
            super(message);
        }
    }
}
