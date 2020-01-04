package ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Tag;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.repositories.TagRepository;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecases.FindAllTagByAdminUseCase;

import java.util.List;

public class FindAllTagByAdminUseCaseImpl implements FindAllTagByAdminUseCase {
    TagRepository tagRepository = TagRepository.getInstance();

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }
}
