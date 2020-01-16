package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controller;

import ir.maktab.java32.projects.articlesmanagement.core.utilities.UserInfo;
import ir.maktab.java32.projects.articlesmanagement.domain.User;

import java.util.List;

public interface FindAllAccountByAdminController {
    List<User> findAllUser();
    List<UserInfo> findAllUserInfo();
}
