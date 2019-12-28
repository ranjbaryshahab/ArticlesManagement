package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controller.ChangePasswordController;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl.EditAccountByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.EditAccountByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.User;

public class ChangePasswordControllerImpl implements ChangePasswordController {
    @Override
    public User change(User user) {
        EditAccountByUserUseCase editAccountByUserUseCase = new EditAccountByUserUseCaseImpl();
        User changePassword = null;
        try {
            changePassword = editAccountByUserUseCase.edit(user);
        } catch (EditAccountByUserUseCase.EditAccountByUserFailedException e) {
            System.out.println(e.getMessage());
        }
        return changePassword;
    }
}
