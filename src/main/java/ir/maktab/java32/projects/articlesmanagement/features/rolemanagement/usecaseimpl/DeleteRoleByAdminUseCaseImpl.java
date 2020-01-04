package ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Role;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.repositories.RoleRepository;
import ir.maktab.java32.projects.articlesmanagement.features.rolemanagement.usecases.DeleteRoleByAdminUseCase;

public class DeleteRoleByAdminUseCaseImpl implements DeleteRoleByAdminUseCase {
    RoleRepository roleRepository = RoleRepository.getInstance();

    @Override
    public void delete(int id) throws DeleteRoleByAdminFailedException {
        validate(id);
        roleRepository.removeById(id);
    }

    private void validate(int id) throws DeleteRoleByAdminFailedException {
        Role role = roleRepository.findById(id);
        if (role == null)
            throw new DeleteRoleByAdminFailedException("It wasn't deleted !");
    }
}
