package ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.domain.Tag;

public interface AddTagByAdminUseCase {
    Tag add(Tag tag) throws AddTagByAdminFailedException;

    class AddTagByAdminFailedException extends Exception {
        public AddTagByAdminFailedException(String message) {
            super(message);
        }
    }
}
