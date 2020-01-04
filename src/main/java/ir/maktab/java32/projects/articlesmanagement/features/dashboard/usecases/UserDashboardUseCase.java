package ir.maktab.java32.projects.articlesmanagement.features.dashboard.usecases;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.UseCase;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.userrole.FindAllArticleByUserUseCase;

@UseCase
public interface UserDashboardUseCase {
    Integer allArticleCount() throws FindAllArticleByUserUseCase.FindAllArticleByUserFailedException;
    Integer publishArticleCount() throws FindAllArticleByUserUseCase.FindAllArticleByUserFailedException;
}
