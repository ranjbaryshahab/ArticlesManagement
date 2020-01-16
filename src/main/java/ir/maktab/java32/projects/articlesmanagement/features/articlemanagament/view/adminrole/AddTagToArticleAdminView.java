package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.view.adminrole;

import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.core.share.log.usecaseimpl.LogRecordUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.domain.Log;
import ir.maktab.java32.projects.articlesmanagement.domain.Tag;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.adminrole.EditUserArticleAdminControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.controllerimpl.adminrole.FindArticleAdminControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.controllerimpl.EditTagByAdminControllerImpl;
import ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.controllerimpl.FindTagByAdminControllerImpl;

import java.util.Date;
import java.util.Scanner;

public class AddTagToArticleAdminView {
    Scanner numScanner = new Scanner(System.in);

    public void addTag() {
        System.out.println("Please enter article id: ");
        Article article = new FindArticleAdminControllerImpl().find(numScanner.nextInt());
        System.out.println("Please enter tag id for add: ");
        Tag tag = new FindTagByAdminControllerImpl().findById(numScanner.nextInt());
        article.getTags().add(tag);
        tag.getArticles().add(article);
        new EditUserArticleAdminControllerImpl().edit(article);
        new EditTagByAdminControllerImpl().edit(tag);
        System.out.println(tag.getTitle() + " add to " + article.getTags() + " successfully !");
        new LogRecordUseCaseImpl().log(new Log
                (null,
                        AuthenticationService.getInstance().getLoginUser().getUsername(),
                        new Date(),
                tag.getTitle() + " add to " + article.getTags()));
    }
}
