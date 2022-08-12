package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args)  {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("John", "Biggy", (byte)22);
        userService.saveUser("Bob", "Bobby", (byte)23);
        userService.saveUser("Bill", "Bansys", (byte)24);
        userService.saveUser("Nick", "Nolan", (byte)25);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }


}
