import java.util.ArrayList;

public class Authentication {

    public static boolean registerUser(String username, String password, String name, ArrayList<User> users) {
        for (User user : users) {
            if (user.username.equals(username)) {
                return false;
            }
        }

        User newUser = new User(username, password, name);
        users.add(newUser);
        return true;
    }


    public static User login(String username, String password, ArrayList<User> users) {
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                return user;
            }
        }
        return null;
    }
}
