package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.view;

import ir.maktab.java32.projects.articlesmanagement.core.share.log.usecaseimpl.LogRecordUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.domain.Log;
import ir.maktab.java32.projects.articlesmanagement.domain.Role;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.controllerimpl.EditRoleByAdminControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.controllerimpl.FindRoleByAdminControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.view.FindAllRoleByAdminView;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controllerimpl.FindAccountByAdminControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl.EditAccountByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl.FindAllAccountByAdminUseCaseImpl;

import java.util.Date;
import java.util.Scanner;

public class ChangeRoleAdminView {
    Scanner scannerNum = new Scanner(System.in);

    public void change() {
        new FindAllAccountByAdminUseCaseImpl().findAllUser();
        System.out.println("Please enter user id of list : ");
        User user = new FindAccountByAdminControllerImpl().findById(scannerNum.nextInt());
        new FindAllRoleByAdminView();
        System.out.println("Please enter role id : ");
        Role role = new FindRoleByAdminControllerImpl().findById(scannerNum.nextInt());

        user.getRoles().add(role);
        role.getUsers().add(user);

        new EditAccountByUserUseCaseImpl().updateUser(user);
        new EditRoleByAdminControllerImpl().edit(role);
        new LogRecordUseCaseImpl().log(new Log(
                null,
                user.getUsername(),
                new Date(),
                user.getUsername() + " role is changing"));
    }
}
