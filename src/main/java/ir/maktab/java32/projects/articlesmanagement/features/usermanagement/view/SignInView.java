package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.view;

import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controller.SignInController;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controllerimpl.SignInControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.model.User;

import java.util.Scanner;

public class SignInView {
    Scanner lineScanner = new Scanner(System.in);

    public void signIn() {
        System.out.println("Please enter username : ");
        String username = lineScanner.nextLine();
        System.out.println("Please enter password : ");
        String password = lineScanner.nextLine();

        SignInController signInController = new SignInControllerImpl();
        User user = signInController.signIn(username, password);
        if (user != null)
            AuthenticationService.getInstance().setLoginUser(user);
    }
}
