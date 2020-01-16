package ir.maktab.java32.projects.articlesmanagement;

import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.core.utilities.Menu;
import ir.maktab.java32.projects.articlesmanagement.domain.Role;
import ir.maktab.java32.projects.articlesmanagement.domain.User;

public class ArticlesManagementApplication {
    public static void main(String[] args) {
        while (!Menu.command.equals("exit")) {
            System.out.println("Please choose of menu and type it: ");
            User login = AuthenticationService.getInstance().getLoginUser();
            boolean writer = false;
            boolean admin = false;

            if (login == null) {
                Menu.defaultMenu();
            } else {
                for (Role role : login.getRoles()) {
                    if (role.getTitle().equals("Admin")) {
                        admin = true;
                        break;
                    }
                }

                for (Role role : login.getRoles()) {
                    if (role.getTitle().equals("Writer")) {
                        writer = true;
                        break;
                    }
                }


                if (admin && writer)
                    Menu.adminWriterMenu();
                else if (writer)
                    Menu.userMenu();
                else if (admin)
                    Menu.adminMenu();
            }
        }
    }
}
