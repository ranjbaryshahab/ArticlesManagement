package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controller.SignInController;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl.LoginByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.LoginByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.model.User;

public class SignInControllerImpl implements SignInController {
    @Override
    public User signIn(User user) {
        LoginByUserUseCase loginByUserUseCase = new LoginByUserUseCaseImpl();
        User singIn = null;
        try {
            singIn = loginByUserUseCase.login(user);
        } catch (LoginByUserUseCase.LoginByUserFailedException e) {
            System.out.println(e.getMessage());
        }
        return singIn;
    }
}
