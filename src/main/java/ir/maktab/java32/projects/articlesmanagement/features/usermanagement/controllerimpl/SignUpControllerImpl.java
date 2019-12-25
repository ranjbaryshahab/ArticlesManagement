package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controller.SignUpController;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl.CreateAccountByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.CreateAccountByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.model.User;

public class SignUpControllerImpl implements SignUpController {
    @Override
    public User signUp(User user) {
        CreateAccountByUserUseCase createAccountByUserUseCase = new CreateAccountByUserUseCaseImpl();
        User singUp = null;
        try {
            singUp = createAccountByUserUseCase.create(user);
        } catch (CreateAccountByUserUseCase.CreateAccountByUserFailedException e) {
            System.out.println(e.getMessage());
        }
        return singUp;
    }
}
