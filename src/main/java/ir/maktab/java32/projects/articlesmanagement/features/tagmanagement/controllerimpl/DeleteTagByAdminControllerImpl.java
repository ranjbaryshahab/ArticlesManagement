package ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.controller.DeleteTagByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecaseimpl.DeleteTagByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecases.DeleteTagByAdminUseCase;

public class DeleteTagByAdminControllerImpl implements DeleteTagByAdminController {
    @Override
    public void delete(int id) {
        DeleteTagByAdminUseCase deleteTagByAdminUseCase = new DeleteTagByAdminUseCaseImpl();
        try {
            deleteTagByAdminUseCase.delete(id);
        } catch (DeleteTagByAdminUseCase.DeleteTagByAdminFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}
