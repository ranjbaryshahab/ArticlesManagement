package ir.maktab.java32.projects.articlesmanagement;

import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.core.utilities.Menu;

public class ArticlesManagementApplication {
    public static void main(String[] args) {
        while (!Menu.command.equals("exit")) {
            System.out.println("Please choose of menu and type it: ");
            if (AuthenticationService.getInstance().getLoginUser() == null) {
                Menu.defaultMenu();
            } else if (AuthenticationService.getInstance().getLoginUser() != null) {
                Menu.userMenu();
            }
        }
    }
}
