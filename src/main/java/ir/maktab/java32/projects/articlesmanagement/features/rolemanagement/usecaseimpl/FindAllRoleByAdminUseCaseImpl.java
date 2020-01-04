package ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Role;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.repositories.RoleRepository;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecases.FindAllRoleByAdminUseCase;

import java.util.List;

public class FindAllRoleByAdminUseCaseImpl implements FindAllRoleByAdminUseCase {
    RoleRepository roleRepository = RoleRepository.getInstance();

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
