package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view.adminrole;

import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.core.share.log.usecaseimpl.LogRecordUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.domain.Log;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.adminrole.EditUserArticleAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controller.adminrole.FindArticleAdminController;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.adminrole.EditUserArticleAdminControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.adminrole.FindArticleAdminControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.view.CreateCategoryView;

import java.util.Date;
import java.util.Scanner;

public class EditUserArticleAdminView {
    Scanner numberScanner = new Scanner(System.in);
    Scanner lineScanner = new Scanner(System.in);
    Scanner lineScanner1 = new Scanner(System.in);

    public void edit() {
        EditUserArticleAdminController editUserArticleAdminController = new EditUserArticleAdminControllerImpl();
        FindArticleAdminController findArticleAdminController = new FindArticleAdminControllerImpl();
        System.out.println("Please enter article number for edit :");
        int id = numberScanner.nextInt();
        Article article = findArticleAdminController.find(id);

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
            new LogRecordUseCaseImpl().log(new Log(
                    null,
                    AuthenticationService.getInstance().getLoginUser().getUsername(),
                    new Date(),
                    AuthenticationService.getInstance().getLoginUser().getUsername() +
                            article.getTitle() + " was edited"));
        } else if (!category.equals("*")) {
            article.setContent(category);
        }

        article.setLastUpdateDate(new Date());
        article.setUser(AuthenticationService.getInstance().getLoginUser());
        editUserArticleAdminController.edit(article);
        System.out.println("This category was updated!");
    }
}
