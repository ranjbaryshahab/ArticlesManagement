package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controller.SignInController;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl.LoginByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.LoginByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.User;

public class SignInControllerImpl implements SignInController {
    @Override
    public User signIn(String username,String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        LoginByUserUseCase loginByUserUseCase = new LoginByUserUseCaseImpl();
        User singIn = null;
        try {
            singIn = loginByUserUseCase.login(user);
        } catch (LoginByUserUseCase.LoginByUserFailedException e) {
            System.out.println(e.getMessage()+"3");
        }
        return singIn;
    }
}
