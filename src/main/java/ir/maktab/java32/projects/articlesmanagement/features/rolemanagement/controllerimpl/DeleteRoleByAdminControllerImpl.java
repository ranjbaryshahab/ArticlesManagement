package ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.controller.DeleteRoleByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecaseimpl.DeleteRoleByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecases.DeleteRoleByAdminUseCase;

public class DeleteRoleByAdminControllerImpl implements DeleteRoleByAdminController {

    @Override
    public void delete(int id) {
        DeleteRoleByAdminUseCase deleteRoleByAdminUseCase = new DeleteRoleByAdminUseCaseImpl();
        try {
            deleteRoleByAdminUseCase.delete(id);
        } catch (DeleteRoleByAdminUseCase.DeleteRoleByAdminFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}
