package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.view;

import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.controllerimpl.FindAllAccountByAdminControllerImpl;

public class FindAllUserInfo {
    public void findAll(){
        new FindAllAccountByAdminControllerImpl().findAllUserInfo().forEach(System.out::println);
    }
}
