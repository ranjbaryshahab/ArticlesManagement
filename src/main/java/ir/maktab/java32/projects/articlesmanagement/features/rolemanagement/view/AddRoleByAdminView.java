package ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.view;

import ir.maktab.java32.projects.articlesmanagement.domain.Role;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.controller.AddRoleByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.controllerimpl.AddRoleByAdminControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl.FindAllAccountByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.FindAllAccountByAdminUseCase;

import java.util.Scanner;

public class AddRoleByAdminView {
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);

    public void addRole() {
        FindAllAccountByAdminUseCase findAllAccountByAdminUseCase = new FindAllAccountByAdminUseCaseImpl();
        System.out.println("please enter title for new role : ");
        Role role = new Role();
        role.setTitle(scannerString.nextLine());

        AddRoleByAdminController addRoleByAdminController = new AddRoleByAdminControllerImpl();
        addRoleByAdminController.add(role);
    }
}
