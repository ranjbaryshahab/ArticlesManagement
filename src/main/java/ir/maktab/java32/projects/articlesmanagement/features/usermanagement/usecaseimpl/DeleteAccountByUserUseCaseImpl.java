package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.DeleteAccountByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.FindAccountByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.repositories.UserRepository;

@Service
@SuppressWarnings("Duplicates")
public class DeleteAccountByUserUseCaseImpl implements DeleteAccountByUserUseCase {
    private UserRepository userRepository = UserRepository.getInstance();
    @Override
    public void delete(int id) throws DeleteAccountByUserFailedException {
        try {
            validate(id);
            deleteUser(id);
        } catch (DeleteAccountByUserFailedException e) {
            throw new DeleteAccountByUserFailedException(e.getMessage());
        } catch (FindAccountByUserUseCase.FindAccountByUserFailedException e) {
            e.printStackTrace();
        }
    }

    private void deleteUser(int id) {
        userRepository.removeById(id);
    }

    private void validate(int id) throws DeleteAccountByUserFailedException, FindAccountByUserUseCase.FindAccountByUserFailedException {
        FindAccountByUserUseCase findAccountByUserUseCase = new FindAccountByUserUseCaseImpl();
        User user = findAccountByUserUseCase.findById(id);
        if (user == null)
            throw new DeleteAccountByUserFailedException("It wasn't deleted !");
    }
}
