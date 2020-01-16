package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controller.FindAllUsersOfTheFieldByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl.FindAllUsersOfTheFieldByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.FindAllUsersOfTheFieldByAdminUseCase;

import java.util.List;

public class FindAllUsersOfTheFieldByAdminControllerImpl implements FindAllUsersOfTheFieldByAdminController {
    @Override
    public List<User> findAll(String fieldName, Object value) {
        List<User> result = null;
        FindAllUsersOfTheFieldByAdminUseCase findAllUsersOfTheFieldByAdminUseCase =
                new FindAllUsersOfTheFieldByAdminUseCaseImpl();
        try {
            result = findAllUsersOfTheFieldByAdminUseCase.findAll(fieldName, value);
        } catch (FindAllUsersOfTheFieldByAdminUseCase.FindAllUsersOfTheFieldByAdminFailedException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
