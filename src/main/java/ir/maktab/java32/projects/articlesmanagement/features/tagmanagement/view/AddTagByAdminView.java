package ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.view;

import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.core.share.log.usecaseimpl.LogRecordUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.domain.Log;
import ir.maktab.java32.projects.articlesmanagement.domain.Tag;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.controller.AddTagByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.controllerimpl.AddTagByAdminControllerImpl;

import java.util.Date;
import java.util.Scanner;

public class AddTagByAdminView {
    Scanner scanner = new Scanner(System.in);

    public Tag addTag() {
        System.out.println("Please enter title for new tag : ");
        Tag tag = new Tag();
        tag.setTitle(scanner.nextLine());

        AddTagByAdminController addTagByAdminController = new AddTagByAdminControllerImpl();
        addTagByAdminController.add(tag);
        new LogRecordUseCaseImpl().log(new Log(
                null,
                AuthenticationService.getInstance().getLoginUser().getUsername(),
                new Date(),
                AuthenticationService.getInstance().getLoginUser().getUsername() +
                        " add " + tag.getTitle() + " tag to system"));
        return tag;
    }
}
