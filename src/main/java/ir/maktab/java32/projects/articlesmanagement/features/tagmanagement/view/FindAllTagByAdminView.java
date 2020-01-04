package ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.view;

import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.controller.FindAllTagByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.controllerimpl.FindAllTagByAdminControllerImpl;

public class FindAllTagByAdminView {
    public void findAll() {
        FindAllTagByAdminController findAllTagByAdminController = new FindAllTagByAdminControllerImpl();
        findAllTagByAdminController.findAll().forEach(System.out::println);
    }
}
