package ir.maktab.java32.projects.articlesmanagement.core.utilities;

public class Display {
    public static String showDefaultMenu() {
        return """
                +-------------------+
                |   Sign In         |
                |   Sign Up         |
                |   Show Articles   |
                |   Exit            |
                +-------------------+
                """;
    }

    public static String showUserMenu() {
        return """
                +----------------------------+
                |    Dashboard               |
                |    My Articles             |
                |    Edit Article            |
                |    Create Article          |
                |    Publish Article         |
                |    Cancel publish Article  |
                |    Change password         |
                |    Logout                  |
                +----------------------------+
                """;
    }
}
