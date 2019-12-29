package ir.maktab.java32.projects.articlesmanagement.features.dashboard.impl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.domain.Article;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl.FindAllArticleByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.FindAllArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.dashboard.usecases.UserDashboardUseCase;

@Service
public class UserArticleUseCaseImpl implements UserDashboardUseCase {
    private FindAllArticleByUserUseCase findAllArticleByUserUseCase = new FindAllArticleByUserUseCaseImpl();

    @Override
    public Integer allArticleCount() throws FindAllArticleByUserUseCase.FindAllArticleByUserFailedException {
        return findAllArticleByUserUseCase.findAllArticleByUser().size();
    }

    @Override
    public Integer publishArticleCount() throws FindAllArticleByUserUseCase.FindAllArticleByUserFailedException {
        int count=0;
        for (Article article :findAllArticleByUserUseCase.findAllArticleByUser()) {
            if(article.getIsPublished())
                count++;
        }

        return count;
    }

}
