package ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Tag;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.repositories.TagRepository;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecases.FindTagByAdminUseCase;

public class FindTagByAdminUseCaseImpl implements FindTagByAdminUseCase {
    TagRepository tagRepository = TagRepository.getInstance();

    @Override
    public Tag findById(int id) throws FindTagByAdminFailedException {
        return tagRepository.findById(id);
    }
}
