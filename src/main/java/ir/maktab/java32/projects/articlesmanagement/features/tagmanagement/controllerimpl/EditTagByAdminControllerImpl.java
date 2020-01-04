package ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Tag;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.controller.EditTagByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecaseimpl.EditTagByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecases.EditTagByAdminUseCase;

public class EditTagByAdminControllerImpl implements EditTagByAdminController {
    @Override
    public Tag edit(Tag tag) {
        EditTagByAdminUseCase editTagByAdminUseCase = new EditTagByAdminUseCaseImpl();
        Tag editTag = null;
        try {
            editTag = editTagByAdminUseCase.edit(tag);
        } catch (EditTagByAdminUseCase.EditTagByAdminFailedException e) {
            System.out.println(e.getMessage());
        }
        return editTag;
    }
}
