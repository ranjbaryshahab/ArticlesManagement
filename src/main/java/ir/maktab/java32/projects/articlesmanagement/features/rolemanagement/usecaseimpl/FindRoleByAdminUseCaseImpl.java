package ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Role;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.repositories.RoleRepository;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecases.FindRoleByAdminUseCase;

public class FindRoleByAdminUseCaseImpl implements FindRoleByAdminUseCase {
    RoleRepository roleRepository = RoleRepository.getInstance();

    @Override
    public Role findById(int id) throws FindRoleByAdminFailedException {
        validate(id);
        return findRoleById(id);
    }

    private Role findRoleById(int id) {
        return roleRepository.findById(id);
    }

    private void validate(int id) throws FindRoleByAdminFailedException {
        if (id <= 0)
            throw new FindRoleByAdminFailedException("This id isn't true!");

        if (findRoleById(id) == null)
            throw new FindRoleByAdminFailedException("This id isn't exists!");
    }
}
