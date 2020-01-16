package ir.maktab.java32.projects.articlesmanagement.core.utilities;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view.adminrole.*;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view.userrole.*;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.view.AllCategoryListView;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.view.CreateCategoryView;
import ir.maktab.java32.projects.articlesmanagement.features.dashboard.view.AdminDashboardView;
import ir.maktab.java32.projects.articlesmanagement.features.dashboard.view.UserDashboardView;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.view.AddTagByAdminView;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.view.FindAllTagByAdminView;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controllerimpl.LogoutControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.view.*;

import java.util.Scanner;

public class Menu {
    public static Scanner optionScanner = new Scanner(System.in);
    public static String command = "";

    public static void defaultMenu() {
        System.out.println(Display.showDefaultMenu());
        command = optionScanner.nextLine().toLowerCase();
        switch (command) {
            case "sign in" -> new SignInView().signIn();
            case "sign up" -> new SignUpView().signUp();
            case "show articles" -> new AllArticleListUserView().allList();
        }
    }

    public static void userMenu() {
        System.out.println(Display.showUserMenu());
        command = optionScanner.nextLine().toLowerCase();
        switch (command) {
            case "dashboard" -> new UserDashboardView().dashboard();
            case "my articles" -> new UserArticleListUserView().list();
            case "edit article" -> new EditUserArticleUserView().edit();
            case "create article" -> new CreateNewArticleUserView().create();
            case "change password" -> new ChangePasswordView().change();
            case "publish article" -> new PublishingArticleUserView().publish();
            case "cancel publish article" -> new CancelPublishingArticleUserView().cancel();
            case "find all articles of the field" -> new FindAllArticlesOfTheFieldByUserView().findAll();
            case "logout" -> new LogoutControllerImpl().logout();
        }
    }

    public static void adminWriterMenu() {
        System.out.println(Display.showAdminWriterMenu());
        command = optionScanner.nextLine().toLowerCase();
        switch (command) {
            case "dashboard" -> new AdminDashboardView().dashboard();
            case "my dashboard" -> new UserDashboardView().dashboard();
            case "my articles" -> new UserArticleListUserView().list();
            case "create article" -> new CreateNewArticleUserView().create();
            case "articles list" -> new AllArticleListAdminView().allList();
            case "edit article" -> new EditUserArticleAdminView().edit();
            case "add tag to article" -> new AddTagToArticleAdminView().addTag();
            case "change category of article" -> new ChangeArticleCategoryAdminView().change();
            case "create new tag" -> new AddTagByAdminView().addTag();
            case "tags list" -> new FindAllTagByAdminView().findAll();
            case "create new category" -> new CreateCategoryView().create();
            case "categories list" -> new AllCategoryListView().allList();
            case "publish article" -> new PublishingArticleAdminView().publish();
            case "cancel publish article" -> new CancelPublishingArticleAdminView().cancel();
            case "show all users information" -> new FindAllUserInfo().findAll();
            case "find all my articles of the field" -> new FindAllArticlesOfTheFieldByUserView().findAll();
            case "find all articles of the field" -> new FindAllArticlesOfTheFieldByAdminView().findAll();
            case "logout" -> new LogoutControllerImpl().logout();
        }
    }

    public static void adminMenu() {
        System.out.println(Display.showAdminMenu());
        command = optionScanner.nextLine().toLowerCase();
        switch (command) {
            case "dashboard" -> new AdminDashboardView().dashboard();
            case "articles list" -> new AllArticleListAdminView().allList();
            case "edit article" -> new EditUserArticleAdminView().edit();
            case "add tag to article" -> new AddTagToArticleAdminView().addTag();
            case "change category of article" -> new ChangeArticleCategoryAdminView().change();
            case "create new tag" -> new AddTagByAdminView().addTag();
            case "tags list" -> new FindAllTagByAdminView().findAll();
            case "create new category" -> new CreateCategoryView().create();
            case "categories list" -> new AllCategoryListView().allList();
            case "publish article" -> new PublishingArticleAdminView().publish();
            case "cancel publish article" -> new CancelPublishingArticleAdminView().cancel();
            case "change role of user" -> new ChangeRoleAdminView().change();
            case "show all users information" -> new FindAllUserInfo().findAll();
            case "find all users of the field" -> new FindAllArticlesOfTheFieldByAdminView().findAll();
            case "logout" -> new LogoutControllerImpl().logout();
        }
    }
}
