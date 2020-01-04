package ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecases;

public interface DeleteTagByAdminUseCase {
    void delete(int id) throws DeleteTagByAdminFailedException;

    class DeleteTagByAdminFailedException extends Exception {
        public DeleteTagByAdminFailedException(String message) {
            super(message);
        }
    }
}
