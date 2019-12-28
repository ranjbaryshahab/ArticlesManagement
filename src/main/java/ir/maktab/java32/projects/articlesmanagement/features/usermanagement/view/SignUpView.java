package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.view;

import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controller.SignUpController;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controllerimpl.SignUpControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.domain.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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
        User user = new User(null, username, nationalCode, birthday, nationalCode);
        SignUpController signUpController = new SignUpControllerImpl();
        signUpController.signUp(user);
    }
}
