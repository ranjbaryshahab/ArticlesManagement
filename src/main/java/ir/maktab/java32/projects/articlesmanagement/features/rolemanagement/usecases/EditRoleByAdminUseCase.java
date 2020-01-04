package ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.domain.Role;

public interface EditRoleByAdminUseCase {
    Role edit(Role role) throws EditRoleByAdminFailedException;

    class EditRoleByAdminFailedException extends Exception {
        public EditRoleByAdminFailedException(String message) {
            super(message);
        }
    }
}
