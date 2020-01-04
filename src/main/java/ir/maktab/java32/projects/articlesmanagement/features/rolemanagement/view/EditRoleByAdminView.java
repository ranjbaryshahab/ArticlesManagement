package ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.view;

import ir.maktab.java32.projects.articlesmanagement.domain.Role;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.controller.EditRoleByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.controllerimpl.EditRoleByAdminControllerImpl;

public class EditRoleByAdminView {

    public void editRole(Role role) {
        EditRoleByAdminController editRoleByAdminController = new EditRoleByAdminControllerImpl();
        editRoleByAdminController.edit(role);
    }
}
