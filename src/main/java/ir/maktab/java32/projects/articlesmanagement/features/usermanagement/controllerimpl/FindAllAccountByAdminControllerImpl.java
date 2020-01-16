package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.core.utilities.UserInfo;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controller.FindAllAccountByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl.FindAllAccountByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.FindAllAccountByAdminUseCase;

import java.util.List;

public class FindAllAccountByAdminControllerImpl implements FindAllAccountByAdminController {
    @Override
    public List<User> findAllUser() {
        FindAllAccountByAdminUseCase findAllAccountByAdminUseCase = new FindAllAccountByAdminUseCaseImpl();
        return findAllAccountByAdminUseCase.findAllUser();
    }

    @Override
    public List<UserInfo> findAllUserInfo() {
        FindAllAccountByAdminUseCase findAllAccountByAdminUseCase = new FindAllAccountByAdminUseCaseImpl();
        return findAllAccountByAdminUseCase.findAllUserInfo();
    }
}
