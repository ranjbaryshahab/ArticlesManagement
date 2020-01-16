package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.view;

import ir.maktab.java32.projects.articlesmanagement.core.utilities.Display;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controller.FindAllUsersOfTheFieldByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controllerimpl.FindAllUsersOfTheFieldByAdminControllerImpl;

import java.util.List;
import java.util.Scanner;

public class FindAllUsersOfTheField {
    private Scanner scanner = new Scanner(System.in);

    public void findAll() {
        System.out.println(Display.userSearchMenu());
        System.out.println("Please enter field name for search of above menu : ");
        String fieldName = scanner.nextLine().toLowerCase().substring(3);
        if(fieldName.equals("birthday"))
            System.out.println("for example(23/4/1996) : ");
        System.out.println("Please enter value for search : ");
        Object value = scanner.nextLine();
        FindAllUsersOfTheFieldByAdminController findAllUsersOfTheFieldByAdminController =
                new FindAllUsersOfTheFieldByAdminControllerImpl();
        System.out.println("Result : ");
        List<User> users;
        users = findAllUsersOfTheFieldByAdminController.findAll(fieldName, value);
        if (users != null)
            users.forEach(System.out::println);
    }
}
