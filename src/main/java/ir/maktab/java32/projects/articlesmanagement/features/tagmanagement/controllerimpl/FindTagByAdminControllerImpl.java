package ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Tag;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.controller.FindTagByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecaseimpl.FindTagByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecases.FindTagByAdminUseCase;

public class FindTagByAdminControllerImpl implements FindTagByAdminController {
    @Override
    public Tag findById(int id) {
        FindTagByAdminUseCase findTagByAdminUseCase = new FindTagByAdminUseCaseImpl();
        Tag findTag = null;
        try {
            findTag = findTagByAdminUseCase.findById(id);
        } catch (FindTagByAdminUseCase.FindTagByAdminFailedException e) {
            System.out.println(e.getMessage());
        }
        return findTag;
    }
}
