package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view.userrole;

import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.userrole.EditUserArticleUserController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.userrole.FindArticleUserController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.userrole.EditUserArticleUserControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.userrole.FindArticleUserControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.view.CreateCategoryView;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;

import java.util.Date;
import java.util.Scanner;

public class EditUserArticleUserView {
    Scanner numberScanner = new Scanner(System.in);
    Scanner lineScanner = new Scanner(System.in);
    Scanner lineScanner1 = new Scanner(System.in);

    public void edit() {
        EditUserArticleUserController editUserArticleController = new EditUserArticleUserControllerImpl();
        FindArticleUserController findArticleController = new FindArticleUserControllerImpl();
        System.out.println("Please enter article number for edit :");
        int id = numberScanner.nextInt();
        Article article = findArticleController.find(id);

        System.out.println("Please enter title (If you submit [*] it will not be changed) : ");
        String title = lineScanner.nextLine();
        if (!title.equals("*")) {
            article.setTitle(title);
        }

        System.out.println("Please enter brief (If you submit [*] it will not be changed) : ");
        String brief = lineScanner.nextLine();
        if (!brief.equals("*")) {
            article.setBrief(brief);
        }

        System.out.println("Please enter content (If you submit [*] it will not be changed) : ");
        String content = lineScanner.nextLine();

        if (!content.equals("*")) {
            article.setContent(content);
        }

        System.out.println("Please enter category (If you submit [*] it will not be changed and if you submit [new] you can create new category and it was changed) : ");
        String category = lineScanner1.nextLine();
        if (category.equals("new")) {
            CreateCategoryView createCategoryView = new CreateCategoryView();
            createCategoryView.create();
        } else if (!category.equals("*")) {
            article.setContent(category);
        }

        article.setLastUpdateDate(new Date());
        article.setUser(AuthenticationService.getInstance().getLoginUser());
        editUserArticleController.edit(article);
        System.out.println("This category was updated!");
    }
}
