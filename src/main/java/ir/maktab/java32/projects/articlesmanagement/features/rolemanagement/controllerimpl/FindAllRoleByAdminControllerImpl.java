package ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Role;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.controller.FindAllRoleByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecaseimpl.FindAllRoleByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecases.FindAllRoleByAdminUseCase;

import java.util.List;

public class FindAllRoleByAdminControllerImpl implements FindAllRoleByAdminController {
    @Override
    public List<Role> findAll() {
        FindAllRoleByAdminUseCase findAllRoleByAdminUseCase = new FindAllRoleByAdminUseCaseImpl();
        return findAllRoleByAdminUseCase.findAll();
    }
}
