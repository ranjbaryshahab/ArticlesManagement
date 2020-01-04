package ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.domain.Role;

public interface FindRoleByAdminUseCase {
    Role findById(int id) throws FindRoleByAdminFailedException;

    class FindRoleByAdminFailedException extends Exception {
        public FindRoleByAdminFailedException(String message) {
            super(message);
        }
    }
}
