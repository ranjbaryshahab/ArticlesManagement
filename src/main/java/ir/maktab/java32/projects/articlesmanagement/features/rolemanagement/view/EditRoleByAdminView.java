package ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.view;

import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.core.share.log.usecaseimpl.LogRecordUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.domain.Log;
import ir.maktab.java32.projects.articlesmanagement.domain.Role;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.controller.EditRoleByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.controllerimpl.EditRoleByAdminControllerImpl;

import java.util.Date;

public class EditRoleByAdminView {

    public void editRole(Role role) {
        EditRoleByAdminController editRoleByAdminController = new EditRoleByAdminControllerImpl();
        editRoleByAdminController.edit(role);
        new LogRecordUseCaseImpl().log(new Log(
                null,
                AuthenticationService.getInstance().getLoginUser().getUsername(),
                new Date(),
                AuthenticationService.getInstance().getLoginUser().getUsername() +
                        " edit " + role.getTitle() + " role"));
    }
}
