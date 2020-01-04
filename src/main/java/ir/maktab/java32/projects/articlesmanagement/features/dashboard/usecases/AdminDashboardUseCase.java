package ir.maktab.java32.projects.articlesmanagement.features.dashboard.usecases;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole.FindAllArticleByAdminUseCase;

public interface AdminDashboardUseCase {
    Integer allArticleCount() throws FindAllArticleByAdminUseCase.FindAllArticleByAdminFailedException;
    Integer publishArticleCount() throws FindAllArticleByAdminUseCase.FindAllArticleByAdminFailedException;
}
