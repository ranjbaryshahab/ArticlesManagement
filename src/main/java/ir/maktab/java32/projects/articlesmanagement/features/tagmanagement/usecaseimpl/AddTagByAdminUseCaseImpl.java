package ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Tag;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.repositories.TagRepository;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecases.AddTagByAdminUseCase;

public class AddTagByAdminUseCaseImpl implements AddTagByAdminUseCase {
    TagRepository tagRepository = TagRepository.getInstance();
    @Override
    public Tag add(Tag tag) throws AddTagByAdminFailedException {
        return tagRepository.save(tag);
    }
}
