package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.UseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.User;

@UseCase
public interface EditAccountByUserUseCase {
    User edit(User user) throws EditAccountByUserFailedException;

    class EditAccountByUserFailedException extends Exception {

        public EditAccountByUserFailedException(String message) {
            super(message);
        }

    }
}
