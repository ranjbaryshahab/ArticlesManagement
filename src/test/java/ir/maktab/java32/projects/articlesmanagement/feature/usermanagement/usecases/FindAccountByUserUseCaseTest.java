package ir.maktab.java32.projects.articlesmanagement.feature.usermanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.domain.Address;
import ir.maktab.java32.projects.articlesmanagement.domain.Role;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl.FindAccountByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.FindAccountByUserUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FindAccountByUserUseCaseTest {
    private User firstUser;
    private User secondUser;


    @Mock
    private FindAccountByUserUseCase findAccountByUserUseCase;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Set<Role> roles = new HashSet<>();
        firstUser = new User(1, "shahab", "000", new Date(), "111", roles, new Address());
        firstUser.getRoles().add(new Role());
        secondUser = new User(2, "hadi", "000", new Date(), "111", roles, new Address());
        secondUser.getRoles().add(new Role());
    }

    @Test
    public void findById() throws FindAccountByUserUseCase.FindAccountByUserFailedException {
        findAccountByUserUseCase = mock(FindAccountByUserUseCaseImpl.class);
        when(findAccountByUserUseCase.findById(2)).thenReturn(secondUser);
        assertEquals(findAccountByUserUseCase.findById(2),secondUser);
    }
}

