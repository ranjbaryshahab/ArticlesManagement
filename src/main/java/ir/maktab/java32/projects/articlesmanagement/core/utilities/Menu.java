package ir.maktab.java32.projects.articlesmanagement.core.utilities;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view.*;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controller.LogoutController;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controllerimpl.LogoutControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.view.ChangePasswordView;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.view.SignInView;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.view.SignUpView;

import java.util.Scanner;

public class Menu {
    public static Scanner optionScanner = new Scanner(System.in);
    public static String command = "";

    public static void defaultMenu() {
        System.out.println(Display.showDefaultMenu());
        command = optionScanner.nextLine().toLowerCase();
        switch (command) {
            case "sign in" -> {
                SignInView signInView = new SignInView();
                signInView.signIn();
            }
            case "sign up" -> {
                SignUpView signUpView = new SignUpView();
                signUpView.signUp();
            }
            case "show articles" -> {
                AllArticleListView allArticleListView = new AllArticleListView();
                allArticleListView.allList();
            }
        }
    }

    public static void userMenu() {
        System.out.println(Display.showUserMenu());
        command = optionScanner.nextLine().toLowerCase();
        switch (command) {
            case "my articles" -> {
                UserArticleListView userArticleListView = new UserArticleListView();
                userArticleListView.list();
            }
            case "edit article" -> {
                EditUserArticleView editUserArticleView = new EditUserArticleView();
                editUserArticleView.edit();
            }
            case "create article" -> {
                CreateNewArticleView createNewArticleView = new CreateNewArticleView();
                createNewArticleView.create();
            }
            case "change password" -> {
                ChangePasswordView changePasswordView = new ChangePasswordView();
                changePasswordView.change();
            }
            case "publish article" -> {
                PublishingArticleView publishingArticleView = new PublishingArticleView();
                publishingArticleView.publish();
            }
            case "cancel publish article" -> {
                CancelPublishingArticleView cancelPublishingArticleView = new CancelPublishingArticleView();
                cancelPublishingArticleView.cancel();
            }
            case "logout" -> {
                LogoutController logoutController = new LogoutControllerImpl();
                logoutController.logout();
            }
        }
    }
}
