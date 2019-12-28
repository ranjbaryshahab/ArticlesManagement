package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.UseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.User;

import java.util.List;

@UseCase
public interface FindAllAccountByAdminUseCase {
    List<User> findAll();
}
