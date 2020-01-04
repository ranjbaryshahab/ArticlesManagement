package ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Tag;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.repositories.TagRepository;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecases.EditTagByAdminUseCase;

public class EditTagByAdminUseCaseImpl implements EditTagByAdminUseCase {
    TagRepository tagRepository = TagRepository.getInstance();

    @Override
    public Tag edit(Tag tag) throws EditTagByAdminFailedException {
        return tagRepository.update(tag);
    }
}
