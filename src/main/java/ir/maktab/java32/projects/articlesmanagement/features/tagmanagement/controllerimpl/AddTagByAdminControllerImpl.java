package ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Tag;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.controller.AddTagByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecaseimpl.AddTagByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecases.AddTagByAdminUseCase;

public class AddTagByAdminControllerImpl implements AddTagByAdminController {
    @Override
    public Tag add(Tag tag) {
        AddTagByAdminUseCase addTagByAdminUseCase = new AddTagByAdminUseCaseImpl();
        Tag newTag = null;
        try {
            newTag = addTagByAdminUseCase.add(tag);
        } catch (AddTagByAdminUseCase.AddTagByAdminFailedException e) {
            System.out.println(e.getMessage());
        }
        return newTag;
    }
}
