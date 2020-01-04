package ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.repositories.TagRepository;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecases.DeleteTagByAdminUseCase;

public class DeleteTagByAdminUseCaseImpl implements DeleteTagByAdminUseCase {
    TagRepository tagRepository = TagRepository.getInstance();
    @Override
    public void delete(int id) throws DeleteTagByAdminFailedException {
        tagRepository.removeById(id);
    }
}
