package ir.maktab.java32.projects.articlesmanagement.features.dashboard.view;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.adminrole.FindAllArticleByAdminUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.dashboard.impl.AdminDashboardUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.dashboard.usecases.AdminDashboardUseCase;

public class AdminDashboardView {
    public void dashboard() {
        AdminDashboardUseCase adminDashboardUseCase = new AdminDashboardUseCaseImpl();
        try {
            System.out.println("User article count equal to: " + adminDashboardUseCase.allArticleCount());
            System.out.println("User publish article count equal to: " + adminDashboardUseCase.publishArticleCount());
        } catch (FindAllArticleByAdminUseCase.FindAllArticleByAdminFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}
