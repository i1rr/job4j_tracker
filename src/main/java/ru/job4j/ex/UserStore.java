package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User target = null;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                target = user;
                break;
            }
        } if (target == null) {
            throw new UserNotFoundException("User not found");
        }
        return target;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 4) {
            throw new UserInvalidException("Invalid user");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr", true)
        };
        try {
            User user = findUser(users, "Petr");

        if (validate(user)) {
            System.out.println("This user has the access");
        }
        } catch (UserInvalidException uIe) {
            uIe.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}
