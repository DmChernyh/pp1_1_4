package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Connection con = Util.connect("test");
    Statement stmt = null;
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {

        try {
            stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Users (id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(30), " +
                    "lastname VARCHAR(30), " +
                    "age INT)");
//            System.out.println("Таблицы созданы");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DROP TABLE IF EXISTS Users");
//            System.out.println("Таблицы удалены");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            PreparedStatement pstmt = null;
            pstmt = con.prepareStatement("INSERT INTO users (name, lastname, age) VALUES (?,?,?)");
                pstmt.setString(1, name);
                pstmt.setString(2, lastName);
                pstmt.setByte(3, age);
                pstmt.executeUpdate();
            System.out.println("User с именем " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }

    public void removeUserById(long id) {
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Users WHERE id=" +id);
//            System.out.println("юзер удален");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM Users");
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge( resultSet.getByte(4));
                users.add(user);
                System.out.println(user.toString());
            }


        } catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        return users;
    }

    public void cleanUsersTable() {
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("TRUNCATE TABLE Users");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
