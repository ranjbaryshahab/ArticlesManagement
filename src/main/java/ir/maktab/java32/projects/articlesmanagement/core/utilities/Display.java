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
                +--------------------------------+
                |    Dashboard                   |
                |    Articles List               |
                |    Edit Article                |
                |    Publish Article             |
                |    Cancel publish Article      |
                |    Tags List                   |
                |    Create New Tag              |
                |    Add Tag To Article          |
                |    Categories List             |
                |    Create New Category         |
                |    Change Category Of Article  |
                |    Change Role Of User         |
                |    Show All User Information   |
                |    Find All users of the field |
                |    Logout                      |
                +--------------------------------+
                """;
    }

    public static String showAdminWriterMenu() {
        return """
                +-----------------------------------------+
                |      <--Writer Option-->                |
                |    My Dashboard                         |
                |    Create new article                   |
                |    Find All My Articles Of The Field    |
                |-----------------------------------------|
                |       <--Admin Option-->                |
                |    Dashboard                            |
                |    Articles List                        |
                |    Edit Article                         |
                |    Publish Article                      |
                |    Cancel publish Article               |
                |    Tags List                            |
                |    Create New Tag                       |
                |    Add Tag To Article                   |
                |    Categories List                      |
                |    Create New Category                  |
                |    Create New Category                  |
                |    Change Category Of Article           |
                |    Show All User Information            |
                |    Find All Articles Of The Field       |
                |    Logout                               |
                +-----------------------------------------+
                """;
    }

    public static String showUserMenu() {
        return """
                +-----------------------------------+
                |    Dashboard                      |
                |    My Articles                    |
                |    Edit Article                   |
                |    Create Article                 |
                |    Publish Article                |
                |    Find All Articles Of The Field |
                |    Cancel Publish Article         |
                |    Change Password                |
                |    Logout                         |
                +-----------------------------------+
                """;
    }

    public static String userSearchMenu() {
        return """
                +-------------------------------+
                |    By username                |
                |    By password                |
                |    By birthday                |
                |    By birth day               |
                |    By birth month             |
                |    By birth year              |
                |    By national code           |
                |    By country                 |
                |    By city                    |
                |    By street                  |
                |    By postal code             |
                +-------------------------------+
                """;
    }

    public static String articleSearchMenu() {
        return """
                +-------------------------------+
                |    By title                   |
                |    By brief                   |
                |    By content                 |
                |    By category title          |
                +-------------------------------+
                """;
    }

}
