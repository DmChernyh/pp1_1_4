package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserDaoJDBCImpl userDaoJDBCImpl = new UserDaoJDBCImpl();
        userDaoJDBCImpl.createUsersTable();
        userDaoJDBCImpl.saveUser("John", "Biggy", (byte)22);
        userDaoJDBCImpl.saveUser("Bob", "Bobby", (byte)23);
        userDaoJDBCImpl.saveUser("Bill", "Bansys", (byte)24);
        userDaoJDBCImpl.saveUser("Nick", "Nolan", (byte)25);
        userDaoJDBCImpl.getAllUsers();
        userDaoJDBCImpl.cleanUsersTable();
        userDaoJDBCImpl.dropUsersTable();

    }


}
