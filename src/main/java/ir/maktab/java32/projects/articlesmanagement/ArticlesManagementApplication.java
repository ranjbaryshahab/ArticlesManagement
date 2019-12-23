package ir.maktab.java32.projects.articlesmanagement;

import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.impl.CreateAccountByUserUseCaseImpl;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.CreateAccountByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.model.User;

import java.util.Date;

public class ArticlesManagementApplication {
    public static void main(String[] args) {
        CreateAccountByUserUseCase createAccountByUserUseCase = new CreateAccountByUserUseCaseImpl();

        try {
            createAccountByUserUseCase.create(new User(null,"shahab","001",new Date(),"000"));
        } catch (CreateAccountByUserUseCase.CreateAccountByUserFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}
