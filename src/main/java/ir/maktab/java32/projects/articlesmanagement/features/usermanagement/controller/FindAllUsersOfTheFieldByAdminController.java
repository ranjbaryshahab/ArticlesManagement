package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controller;

import ir.maktab.java32.projects.articlesmanagement.domain.User;

import java.util.List;

public interface FindAllUsersOfTheFieldByAdminController {
    List<User> findAll(String fieldName, Object value);
}
