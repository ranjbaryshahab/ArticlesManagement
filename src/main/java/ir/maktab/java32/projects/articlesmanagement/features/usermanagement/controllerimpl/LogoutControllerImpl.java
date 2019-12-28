package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controller.LogoutController;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl.LogoutUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.LogoutByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.User;

public class LogoutControllerImpl implements LogoutController {
    @Override
    public void logout() {
        LogoutByUserUseCase logoutByUserUseCase = new LogoutUserUseCaseImpl();
        User user = logoutByUserUseCase.logout();
        AuthenticationService.getInstance().setLoginUser(user);
    }
}
