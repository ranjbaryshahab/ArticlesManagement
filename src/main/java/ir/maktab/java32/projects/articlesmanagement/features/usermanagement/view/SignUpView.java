package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.view;

import ir.maktab.java32.projects.articlesmanagement.core.share.log.usecaseimpl.LogRecordUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.domain.Address;
import ir.maktab.java32.projects.articlesmanagement.domain.Log;
import ir.maktab.java32.projects.articlesmanagement.domain.Role;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.addressmanagement.view.AddAddressByUserView;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.controllerimpl.FindRoleByAdminControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controller.SignUpController;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controllerimpl.SignUpControllerImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SignUpView {
    Scanner lineScanner = new Scanner(System.in);

    public void signUp() {
        System.out.println("Please enter username : ");
        String username = lineScanner.nextLine();
        System.out.println("Please enter nationalCode : ");
        String nationalCode = lineScanner.nextLine();
        System.out.println("Please enter birthday for example(23/4/1996) ");
        String birthdayString = lineScanner.nextLine();
        Date birthday = null;
        try {
            birthday = new SimpleDateFormat("dd/MM/yyyy").parse(birthdayString);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        AddAddressByUserView addAddressByUserView = new AddAddressByUserView();
        Address address = addAddressByUserView.add();
        User user = new User(null, username, nationalCode, birthday, nationalCode,null,address);
        SignUpController signUpController = new SignUpControllerImpl();
        Role role = new FindRoleByAdminControllerImpl().findById(2);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        signUpController.signUp(user);
        new LogRecordUseCaseImpl().log(new Log(
                null,
                        user.getUsername(),
                        new Date(),
                        user.getUsername() + " is singing up"));
    }
}
