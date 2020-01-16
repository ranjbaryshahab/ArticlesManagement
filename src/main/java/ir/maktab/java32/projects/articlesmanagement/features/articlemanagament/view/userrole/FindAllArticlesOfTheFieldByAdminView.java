package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view.userrole;

import ir.maktab.java32.projects.articlesmanagement.core.utilities.Display;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.adminrole.FindAllArticlesOfTheFieldByAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.adminrole.FindAllArticlesOfTheFieldByAdminControllerImpl;

import java.util.List;
import java.util.Scanner;

public class FindAllArticlesOfTheFieldByAdminView {
    private Scanner scanner = new Scanner(System.in);

    public void findAll() {
        System.out.println(Display.articleSearchMenu());
        System.out.println("Please enter field name for search of above menu : ");
        String fieldName = scanner.nextLine().toLowerCase().substring(3);
        System.out.println("Please enter value for search : ");
        Object value = scanner.nextLine();
        FindAllArticlesOfTheFieldByAdminController findAllArticlesOfTheFieldByAdminController =
                new FindAllArticlesOfTheFieldByAdminControllerImpl();
        System.out.println("Result : ");
        List<Article> articles;
        articles = findAllArticlesOfTheFieldByAdminController.findAll(fieldName, value);
        if (articles != null)
            articles.forEach(System.out::println);
    }
}
