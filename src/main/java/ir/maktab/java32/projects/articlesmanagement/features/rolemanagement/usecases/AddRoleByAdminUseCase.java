package ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.domain.Role;

public interface AddRoleByAdminUseCase {
    Role add(Role role) throws AddRoleByAdminFailedException;

    class AddRoleByAdminFailedException extends Exception {
        public AddRoleByAdminFailedException(String message) {
            super(message);
        }
    }
}
