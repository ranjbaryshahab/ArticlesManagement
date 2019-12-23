package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.UseCase;

@UseCase
public interface DeleteAccountByUserUseCase {
    void delete(int id) throws DeleteAccountByUserFailedException;

    class DeleteAccountByUserFailedException extends Exception {

        public DeleteAccountByUserFailedException(String message) {
            super(message);
        }

    }
}
