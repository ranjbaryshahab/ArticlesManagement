package ir.maktab.java32.projects.articlesmanagement.core.utilities;

public class Menu {
    private static String showDefaultMenu(){
        return """
                +-------------------+
                |   Sign In         |
                |   Sign Up         |
                |   Show Articles   |
                |   Exit            |
                +-------------------+
                """;
    }

    private static String showUserMenu(){
        return """
                +--------------------+
                |    My Articles     |
                |    Edit Article    |
                |    Create Article  |
                |    Change password |
                |    Logout          |
                +--------------------+
                """;
    }


}
