package views;

import conf.Database;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        Database.connect(
                "localhost",
                3306,
                "root",
                "",
                "lib-manager"
        );
        Database.close();
      }

}