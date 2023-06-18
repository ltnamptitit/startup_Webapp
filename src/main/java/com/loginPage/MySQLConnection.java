package com.loginPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

class MySQLConnection {
  public static void main(String string) throws ClassNotFoundException {
    Connection con = null;

    String url = "jdbc:mysql://localhost:3306/hoang";
    String username = "root";
    String password = "hoangvnpro123@@";

    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(url, username, password);

      System.out.println("Connected!");

    } catch (SQLException ex) {
        throw new Error("Error ", ex);
    } finally {
      try {
        if (con != null) {
            con.close();
        }
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }
    }
  }
}