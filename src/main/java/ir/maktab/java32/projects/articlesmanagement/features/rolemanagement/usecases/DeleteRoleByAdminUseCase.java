package ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecases;

public interface DeleteRoleByAdminUseCase {
    void delete(int id) throws DeleteRoleByAdminFailedException;

    class DeleteRoleByAdminFailedException extends Exception {
        public DeleteRoleByAdminFailedException(String message) {
            super(message);
        }
    }
}
