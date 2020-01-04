package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controller.FindAccountByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl.FindAccountByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.FindAccountByUserUseCase;

public class FindAccountByAdminControllerImpl implements FindAccountByAdminController {
    @Override
    public User findById(int id) {
        User findUser = null;
        FindAccountByUserUseCase findAccountByUserUseCase = new FindAccountByUserUseCaseImpl();
        try {
            findUser = findAccountByUserUseCase.findById(id);
        } catch (FindAccountByUserUseCase.FindAccountByUserFailedException e) {
            System.out.println(e.getMessage());
        }

        return findUser;
    }
}
