package ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.view;

import ir.maktab.java32.projects.articlesmanagement.domain.Tag;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.controller.FindTagByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.controllerimpl.FindTagByAdminControllerImpl;

import java.util.Scanner;

public class FindTagByAdminView {
    Scanner scanner = new Scanner(System.in);

    public Tag findTag() {
        System.out.println("Please enter tag id : ");
        int tagId = scanner.nextInt();
        FindTagByAdminController findTagByAdminController = new FindTagByAdminControllerImpl();
        return findTagByAdminController.findById(tagId);
    }
}
