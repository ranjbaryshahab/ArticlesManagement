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

    public static String showAdminMenu() {
        return """
                +-------------------------------+
                |    Dashboard                  |
                |    Articles List              |
                |    Edit Article               |
                |    Publish Article            |
                |    Cancel publish Article     |
                |    Tags List                  |
                |    Create New Tag             |
                |    Add Tag To Article         |
                |    Categories List            |
                |    Create New Category        |
                |    Change Category Of Article |
                |    Change Role Of User        |
                |    Logout                     |
                +-------------------------------+
                """;
    }

    public static String showAdminWriterMenu() {
        return """
                +-------------------------------+
                |      <--Writer Option-->      |
                |    My Dashboard               |
                |    Create new article         |
                |-------------------------------|
                |       <--Admin Option-->      |
                |    Dashboard                  |
                |    Articles List              |
                |    Edit Article               |
                |    Publish Article            |
                |    Cancel publish Article     |
                |    Tags List                  |
                |    Create New Tag             |
                |    Add Tag To Article         |
                |    Categories List            |
                |    Create New Category        |
                |    Change Category Of Article |
                |    Logout                     |
                +-------------------------------+
                """;
    }

    public static String showUserMenu() {
        return """
                +-------------------------------+
                |    Dashboard                  |
                |    My Articles                |
                |    Edit Article               |
                |    Create Article             |
                |    Publish Article            |
                |    Cancel Publish Article     |
                |    Change Password            |
                |    Logout                     |
                +-------------------------------+
                """;
    }

}
