package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.domain.User;

import java.util.List;

public interface FindAllUsersOfTheFieldByAdminUseCase {
    List<User> findAll(String fieldName,Object value) throws FindAllUsersOfTheFieldByAdminFailedException;

class FindAllUsersOfTheFieldByAdminFailedException extends Exception {
    public FindAllUsersOfTheFieldByAdminFailedException(String message) {
        super(message);
    }
}
}
