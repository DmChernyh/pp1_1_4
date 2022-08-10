package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    // реализуйте настройку соеденения с БД


    Connection con = Util.connect("test");


    public static Connection connect(String db) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + db +
                            "?characterEncoding=utf8", "root", "1234");
        } catch (ClassNotFoundException e) {
            System.out.println("Драйвер не найден");
            System.exit(1);
        } catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.exit(1);
        }
        return con;
    }
}
//    try{
//        String url = "jdbc:mysql://localhost/test";
//        String username = "root";
//        String password = "1234";
//        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//        try (Connection conn = DriverManager.getConnection(url, username, password)){
//
//            System.out.println("Connection to Store DB succesfull!");
//        }
//    }
//         catch(Exception ex){
//        System.out.println("Connection failed...");
//
//        System.out.println(ex);
//    }

//    public Util() throws SQLException {
//        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?");
//    }
//    Connection con = Util.connect("test");
//
//    public static Connection connect (String db) {
//        Connection con = null;
//        return  con;
//    }

