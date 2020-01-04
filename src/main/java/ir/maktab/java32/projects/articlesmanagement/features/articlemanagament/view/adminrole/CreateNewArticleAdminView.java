package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view.adminrole;

import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.domain.Category;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.adminrole.CreateNewArticleAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.adminrole.CreateNewArticleAdminControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.view.AllCategoryListView;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.view.CreateCategoryView;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.view.FindCategoryView;

import java.util.Date;
import java.util.Scanner;

public class CreateNewArticleAdminView {
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
        System.out.println("Please enter category : ");
        AllCategoryListView allCategoryListView = new AllCategoryListView();
        allCategoryListView.allList();
        FindCategoryView findCategoryView = new FindCategoryView();
        Category category = findCategoryView.find();
        if (category == null) {
            System.out.println("This category is not exist, do you Create this category?(yes or no) if type no cancel create category!");
            String command = lineScanner.nextLine();
            if (command.equals("yes")) {
                CreateCategoryView createCategoryView = new CreateCategoryView();
                category =createCategoryView.create();
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
            CreateNewArticleAdminController createNewArticleAdminController = new CreateNewArticleAdminControllerImpl();
            createNewArticleAdminController.create(article);
        }

    }
}
