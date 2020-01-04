package ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Role;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.controller.FindRoleByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecaseimpl.FindRoleByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecases.FindRoleByAdminUseCase;

public class FindRoleByAdminControllerImpl implements FindRoleByAdminController {
    @Override
    public Role findById(int id) {
        FindRoleByAdminUseCase findRoleByAdminUseCase = new FindRoleByAdminUseCaseImpl();
        Role findRole = null;
        try {
            findRole = findRoleByAdminUseCase.findById(id);
        } catch (FindRoleByAdminUseCase.FindRoleByAdminFailedException e) {
            System.out.println(e.getMessage());
        }
        return findRole;
    }
}
