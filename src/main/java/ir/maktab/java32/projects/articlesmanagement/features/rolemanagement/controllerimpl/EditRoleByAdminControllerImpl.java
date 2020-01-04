package ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Role;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.controller.EditRoleByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecaseimpl.EditRoleByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecases.EditRoleByAdminUseCase;

public class EditRoleByAdminControllerImpl implements EditRoleByAdminController {
    @Override
    public Role edit(Role role) {
        EditRoleByAdminUseCase editRoleByAdminUseCase = new EditRoleByAdminUseCaseImpl();
        Role editRole = null;

        try {
            editRole = editRoleByAdminUseCase.edit(role);
        } catch (EditRoleByAdminUseCase.EditRoleByAdminFailedException e) {
            System.out.println(e.getMessage());
        }
        return editRole;
    }
}
