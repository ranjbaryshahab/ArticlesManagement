package ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.domain.Tag;

public interface FindTagByAdminUseCase {
    Tag findById(int id) throws FindTagByAdminFailedException;

    class FindTagByAdminFailedException extends Exception {
        public FindTagByAdminFailedException(String message) {
            super(message);
        }
    }
}
