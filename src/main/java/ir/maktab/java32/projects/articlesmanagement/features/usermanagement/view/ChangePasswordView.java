package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.view;

import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controller.ChangePasswordController;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controllerimpl.ChangePasswordControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.model.User;

import java.util.Scanner;

public class ChangePasswordView {
    Scanner lineScanner = new Scanner(System.in);

    public void change() {
        System.out.println("Please enter current password : ");
        String currentPassword = lineScanner.nextLine();
        System.out.println("Please enter new password : ");
        String newPassword = lineScanner.nextLine();
        System.out.println("Please enter confirm password : ");
        String confirmPassword = lineScanner.nextLine();

        User user = AuthenticationService.getInstance().getLoginUser();

        if (user.getPassword().equals(currentPassword)) {
            if (newPassword.equals(confirmPassword)) {
                ChangePasswordController changePasswordController = new ChangePasswordControllerImpl();
                user.setPassword(confirmPassword);
                changePasswordController.change(user);
            } else
                System.out.println("Confirm password is wrong!!");
        } else
            System.out.println("Current password is wrong!!");
    }
}
