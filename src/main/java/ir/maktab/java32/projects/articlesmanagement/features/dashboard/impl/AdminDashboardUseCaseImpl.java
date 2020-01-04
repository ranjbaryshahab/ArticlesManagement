package ir.maktab.java32.projects.articlesmanagement.features.dashboard.impl;

import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.adminrole.FindAllArticleByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole.FindAllArticleByAdminUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.dashboard.usecases.AdminDashboardUseCase;

public class AdminDashboardUseCaseImpl implements AdminDashboardUseCase {

    @Override
    public Integer allArticleCount() throws FindAllArticleByAdminUseCase.FindAllArticleByAdminFailedException {
        return new FindAllArticleByAdminUseCaseImpl().findAll().size();
    }

    @Override
    public Integer publishArticleCount() throws FindAllArticleByAdminUseCase.FindAllArticleByAdminFailedException {
        int count = 0;
        for (Article article : new FindAllArticleByAdminUseCaseImpl().findAll()) {
            if (article.getIsPublished())
                count++;
        }

        return count;
    }
}
