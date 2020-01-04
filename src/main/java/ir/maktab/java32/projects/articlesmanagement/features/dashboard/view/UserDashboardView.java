package ir.maktab.java32.projects.articlesmanagement.features.dashboard.view;

import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole.FindAllArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.dashboard.impl.UserDashboardUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.dashboard.usecases.UserDashboardUseCase;

public class UserDashboardView {
    public void dashboard() {
        UserDashboardUseCase userDashboardUseCase = new UserDashboardUseCaseImpl();
        try {
            System.out.println("User article count equal to: " + userDashboardUseCase.allArticleCount());
            System.out.println("User publish article count equal to: " + userDashboardUseCase.publishArticleCount());
        } catch (FindAllArticleByUserUseCase.FindAllArticleByUserFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}
