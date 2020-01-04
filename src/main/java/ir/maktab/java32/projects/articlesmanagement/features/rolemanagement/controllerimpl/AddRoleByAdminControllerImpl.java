package ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Role;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.controller.AddRoleByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecaseimpl.AddRoleByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecases.AddRoleByAdminUseCase;

public class AddRoleByAdminControllerImpl implements AddRoleByAdminController {
    @Override
    public Role add(Role role) {
        AddRoleByAdminUseCase addRoleByAdminUseCase = new AddRoleByAdminUseCaseImpl();
        Role addRole= null;
        try {
            addRole = addRoleByAdminUseCase.add(role);
        } catch (AddRoleByAdminUseCase.AddRoleByAdminFailedException e) {
            System.out.println(e.getMessage());
        }
        return addRole;
    }
}
