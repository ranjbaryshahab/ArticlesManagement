package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view.adminrole;

import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.core.share.log.usecaseimpl.LogRecordUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.domain.Category;
import ir.maktab.java32.projects.articlesmanagement.domain.Log;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.adminrole.EditUserArticleAdminControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.adminrole.FindArticleAdminControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.controllerimpl.FindCategoryControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.view.AllCategoryListView;

import java.util.Date;
import java.util.Scanner;

public class ChangeArticleCategoryAdminView {
    Scanner scannerNum = new Scanner(System.in);

    public void change() {
        System.out.println("Please enter article id : ");
        Article article = new FindArticleAdminControllerImpl().find(scannerNum.nextInt());
        new AllCategoryListView().allList();
        System.out.println("Please enter category id : ");
        Category category = new FindCategoryControllerImpl().find(scannerNum.nextInt());
        article.setCategory(category);
        new EditUserArticleAdminControllerImpl().edit(article);
        new LogRecordUseCaseImpl().log(new Log(
                null,
                AuthenticationService.getInstance().getLoginUser().getUsername(),
                new Date(),
                AuthenticationService.getInstance().getLoginUser().getUsername() +
                        article.getTitle() + " category changed"));
    }
}
