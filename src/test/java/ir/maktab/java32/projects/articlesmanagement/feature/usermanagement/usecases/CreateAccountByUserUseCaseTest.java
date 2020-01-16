package ir.maktab.java32.projects.articlesmanagement.feature.usermanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.domain.Address;
import ir.maktab.java32.projects.articlesmanagement.domain.Role;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl.CreateAccountByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.CreateAccountByUserUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreateAccountByUserUseCaseTest {
    private User user;

    @Mock
    private CreateAccountByUserUseCase createAccountByUserUseCase;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Set<Role> roles = new HashSet<>();
        user = new User(1, "shahab", "000", new Date(), "111", roles, new Address());
        user.getRoles().add(new Role());
    }

    @Test
    public void create() throws CreateAccountByUserUseCase.CreateAccountByUserFailedException {
        createAccountByUserUseCase = mock(CreateAccountByUserUseCaseImpl.class);
        when(createAccountByUserUseCase.create(user)).thenReturn(user);
        assertEquals(createAccountByUserUseCase.create(user),user);
    }
}
