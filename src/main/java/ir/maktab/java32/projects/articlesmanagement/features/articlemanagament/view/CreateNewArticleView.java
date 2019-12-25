package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view;

import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.CreateNewArticleController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.CreateNewArticleControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.view.AllCategoryListView;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.view.CreateCategoryView;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.view.FindCategoryView;
import ir.maktab.java32.projects.articlesmanagement.model.Article;
import ir.maktab.java32.projects.articlesmanagement.model.Category;

import java.util.Date;
import java.util.Scanner;

public class CreateNewArticleView {
    Scanner lineScanner = new Scanner(System.in);

    public void create() {
        boolean state = true;
        Article article = new Article();
        System.out.println("Please enter title : ");
        article.setTitle(lineScanner.nextLine());
        System.out.println("Please enter brief : ");
        article.setBrief(lineScanner.nextLine());
        System.out.println("Please enter content : ");
        article.setContent(lineScanner.nextLine());
        System.out.println("Please enter content : ");
        article.setContent(lineScanner.nextLine());
        FindCategoryView findCategoryView = new FindCategoryView();
        Category category = findCategoryView.find();
        if (category == null) {
            System.out.println("This category is not exist, do you Create this category?(yes or no) if type no cancel create category!");
            AllCategoryListView allCategoryListView = new AllCategoryListView();
            allCategoryListView.allList();
            String command = lineScanner.nextLine();
            if (command.equals("yes")) {
                CreateCategoryView createCategoryView = new CreateCategoryView();
                createCategoryView.create();
            } else if (command.equals("no"))
                state = false;
        }
        article.setIsPublished(false);
        article.setCreateDate(new Date());
        article.setLastUpdateDate(new Date());
        article.setPublishDate(null);
        article.setCategory(category);
        article.setUser(AuthenticationService.getInstance().getLoginUser());
        if (state) {
            CreateNewArticleController createNewArticleController = new CreateNewArticleControllerImpl();
            createNewArticleController.create(article);
        }

    }
}
