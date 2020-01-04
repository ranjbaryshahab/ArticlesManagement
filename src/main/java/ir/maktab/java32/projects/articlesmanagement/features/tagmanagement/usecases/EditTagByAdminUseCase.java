package ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.domain.Tag;

public interface EditTagByAdminUseCase {
    Tag edit(Tag tag) throws EditTagByAdminFailedException;

    class EditTagByAdminFailedException extends Exception {
        public EditTagByAdminFailedException(String message) {
            super(message);
        }
    }
}
