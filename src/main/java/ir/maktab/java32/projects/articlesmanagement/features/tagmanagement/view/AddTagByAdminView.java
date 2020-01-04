package ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.view;

import ir.maktab.java32.projects.articlesmanagement.domain.Tag;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.controller.AddTagByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.controllerimpl.AddTagByAdminControllerImpl;

import java.util.Scanner;

public class AddTagByAdminView {
    Scanner scanner = new Scanner(System.in);

    public Tag addTag() {
        System.out.println("Please enter title for new tag : ");
        Tag tag = new Tag();
        tag.setTitle(scanner.nextLine());

        AddTagByAdminController addTagByAdminController = new AddTagByAdminControllerImpl();
        addTagByAdminController.add(tag);
        return tag;
    }
}
