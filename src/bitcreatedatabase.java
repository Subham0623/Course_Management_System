import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
abstract class data{
    static void create11() {
    }

}
public class bitcreatedatabase {
    static void create11(String cname) {
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/BIT1y1s";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS BIT1y1s");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS " + cname + " ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "fname VARCHAR(200) NOT NULL,"
                    + "lname VARCHAR(200) NOT NULL,"
                    + "username VARCHAR(200) NOT NULL UNIQUE,"
                    + "marks VARCHAR(10)"
                    + ")";
            statement.executeUpdate(sql);
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void create12(String cname) {
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/BIT1y2s";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS BIT1y2s");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS "+cname+" ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "fname VARCHAR(200) NOT NULL,"
                    + "lname VARCHAR(200) NOT NULL,"
                    + "username VARCHAR(200) NOT NULL UNIQUE,"
                    + "marks VARCHAR(10)"
                    + ")";
            statement.executeUpdate(sql);
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void create21(String cname) {
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/BIT2y1s";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS BIT2y1s");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS "+cname+" ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "fname VARCHAR(200) NOT NULL,"
                    + "lname VARCHAR(200) NOT NULL,"
                    + "username VARCHAR(200) NOT NULL UNIQUE,"
                    + "marks VARCHAR(10)"
                    + ")";
            statement.executeUpdate(sql);
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void create22(String cname) {
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/BIT2y2s";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS BIT2y2s");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS "+cname+" ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "fname VARCHAR(200) NOT NULL,"
                    + "lname VARCHAR(200) NOT NULL,"
                    + "username VARCHAR(200) NOT NULL UNIQUE,"
                    + "marks VARCHAR(10)"
                    + ")";
            statement.executeUpdate(sql);
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void create31(String cname) {
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/BIT3y1s";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS BIT3y1s");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS "+cname+" ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "fname VARCHAR(200) NOT NULL,"
                    + "lname VARCHAR(200) NOT NULL,"
                    + "username VARCHAR(200) NOT NULL UNIQUE,"
                    + "marks VARCHAR(10)"
                    + ")";
            statement.executeUpdate(sql);
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void create32(String cname) {
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/BIT3y2s";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS BIT3y2s");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS "+cname+" ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "fname VARCHAR(200) NOT NULL,"
                    + "lname VARCHAR(200) NOT NULL,"
                    + "username VARCHAR(200) NOT NULL UNIQUE,"
                    + "marks VARCHAR(10)"
                    + ")";
            statement.executeUpdate(sql);
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        bitcreatedatabase bitcreatedatabase = new bitcreatedatabase();

    }
}
