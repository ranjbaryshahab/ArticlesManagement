package ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.domain.Role;

import java.util.List;

public interface FindAllRoleByAdminUseCase {
    List<Role> findAll();
}
