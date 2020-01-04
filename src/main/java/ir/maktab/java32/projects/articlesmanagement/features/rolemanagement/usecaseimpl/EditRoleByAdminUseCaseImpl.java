package ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Role;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.repositories.RoleRepository;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecases.EditRoleByAdminUseCase;

public class EditRoleByAdminUseCaseImpl implements EditRoleByAdminUseCase {
    RoleRepository roleRepository = RoleRepository.getInstance();

    @Override
    public Role edit(Role role) throws EditRoleByAdminFailedException {
        validate(role);
        return roleRepository.update(role);
    }

    private void validate(Role role) throws EditRoleByAdminFailedException {
        if (role.getTitle().length() > 30)
            throw new EditRoleByAdminFailedException("Title is bigger than 30 characters");
    }
}
