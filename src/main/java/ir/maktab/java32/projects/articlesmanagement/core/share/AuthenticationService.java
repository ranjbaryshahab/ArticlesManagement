package ir.maktab.java32.projects.articlesmanagement.core.share;

import ir.maktab.java32.projects.articlesmanagement.domain.User;

public final class AuthenticationService {

    private static AuthenticationService authenticationService;
    private User loginUser;

    public static synchronized AuthenticationService getInstance() {
        if (authenticationService == null)
            authenticationService = new AuthenticationService();
        return authenticationService;
    }

    private AuthenticationService() {
    }

    public void setLoginUser(User user) {
        this.loginUser = user;
    }

    public User getLoginUser() {
        return loginUser;
    }
}
