package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view.userrole;

import ir.maktab.java32.projects.articlesmanagement.core.utilities.Display;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.userrole.FindAllArticlesOfTheFieldByUserController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.userrole.FindAllArticlesOfTheFieldByUserControllerImpl;

import java.util.List;
import java.util.Scanner;

public class FindAllArticlesOfTheFieldByUserView {
    private Scanner scanner = new Scanner(System.in);

    public void findAll() {
        System.out.println(Display.articleSearchMenu());
        System.out.println("Please enter field name for search of above menu : ");
        String fieldName = scanner.nextLine().toLowerCase().substring(3);
        System.out.println("Please enter value for search : ");
        Object value = scanner.nextLine();
        FindAllArticlesOfTheFieldByUserController findAllArticlesOfTheFieldByUserController =
                new FindAllArticlesOfTheFieldByUserControllerImpl();
        System.out.println("Result : ");
        List<Article> articles;
        articles = findAllArticlesOfTheFieldByUserController.findAll(fieldName, value);
        if (articles != null)
            articles.forEach(System.out::println);
    }
}
