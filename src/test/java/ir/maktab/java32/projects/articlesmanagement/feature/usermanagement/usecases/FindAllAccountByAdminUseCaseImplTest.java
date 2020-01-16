package ir.maktab.java32.projects.articlesmanagement.feature.usermanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.domain.Address;
import ir.maktab.java32.projects.articlesmanagement.domain.Role;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl.FindAllAccountByAdminUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.CreateAccountByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.FindAllAccountByAdminUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindAllAccountByAdminUseCaseImplTest {
    private User user1;
    private User user2;
    private User user3;

    @Mock
    private FindAllAccountByAdminUseCase findAllAccountByAdminUseCase;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Set<Role> roles = new HashSet<>();
        user1 = new User(1, "shahab", "000", new Date(), "111", roles, new Address());
        user1.getRoles().add(new Role());
        user2 = new User(2, "mahdi", "000", new Date(), "111", roles, new Address());
        user2.getRoles().add(new Role());
        user3 = new User(3, "ali", "000", new Date(), "111", roles, new Address());
        user3.getRoles().add(new Role());
    }

    @Test
    public void findAll() throws CreateAccountByUserUseCase.CreateAccountByUserFailedException {
        List<User> users = Arrays.asList(user1, user2, user3);
        findAllAccountByAdminUseCase = mock(FindAllAccountByAdminUseCaseImpl.class);
        when(findAllAccountByAdminUseCase.findAllUser()).thenReturn(users);
        Assertions.assertTrue(findAllAccountByAdminUseCase.findAllUser().size() != 0);
    }
}
