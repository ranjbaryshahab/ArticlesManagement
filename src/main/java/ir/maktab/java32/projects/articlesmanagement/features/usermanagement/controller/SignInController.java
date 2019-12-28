package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controller;

import ir.maktab.java32.projects.articlesmanagement.domain.User;

public interface SignInController {
    User signIn(String username, String password);
}
