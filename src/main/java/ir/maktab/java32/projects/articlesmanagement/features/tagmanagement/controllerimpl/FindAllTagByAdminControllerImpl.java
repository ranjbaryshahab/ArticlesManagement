package ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.controllerimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Tag;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.controller.FindAllTagByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecaseimpl.FindAllTagByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecases.FindAllTagByAdminUseCase;

import java.util.List;

public class FindAllTagByAdminControllerImpl implements FindAllTagByAdminController {
    @Override
    public List<Tag> findAll() {
        FindAllTagByAdminUseCase findAllTagByAdminUseCase = new FindAllTagByAdminUseCaseImpl();
        return findAllTagByAdminUseCase.findAll();
    }
}
