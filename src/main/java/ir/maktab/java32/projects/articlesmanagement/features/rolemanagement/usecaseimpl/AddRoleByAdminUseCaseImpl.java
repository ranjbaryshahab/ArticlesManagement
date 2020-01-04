package ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Role;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.repositories.RoleRepository;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecases.AddRoleByAdminUseCase;

public class AddRoleByAdminUseCaseImpl implements AddRoleByAdminUseCase {
    RoleRepository roleRepository = RoleRepository.getInstance();

    @Override
    public Role add(Role role) throws AddRoleByAdminFailedException {
        validate(role);
        return roleRepository.save(role);
    }

    private void validate(Role role) throws AddRoleByAdminFailedException {
        if (role.getTitle().length() > 30)
            throw new AddRoleByAdminFailedException("Title is bigger than 30 characters");
    }
}
