package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole;

public interface DeleteArticleByAdminUseCase {
    void delete(int id) throws DeleteArticleByAdminFailedException;

    class DeleteArticleByAdminFailedException extends Exception {
        public DeleteArticleByAdminFailedException(String message) {
            super(message);
        }
    }
}
