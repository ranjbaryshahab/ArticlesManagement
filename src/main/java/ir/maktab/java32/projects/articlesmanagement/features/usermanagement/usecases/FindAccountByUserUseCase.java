package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.UseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.User;

@UseCase
public interface FindAccountByUserUseCase {
    User findById(int id) throws FindAccountByUserFailedException;

    class FindAccountByUserFailedException extends Exception {
        public FindAccountByUserFailedException(String message) {
            super(message);
        }
    }
}
