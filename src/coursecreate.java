import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class coursecreate {
    public static boolean BBAcourse1y1sem() {
        boolean hasRegistredUsers = false;
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS course");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS BBA1Y1S("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "coursename VARCHAR(200) NOT NULL,"
                    + "instructor VARCHAR(200) NOT NULL"
                    + ")";
            statement.executeUpdate(sql);
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM BBA1Y1S");
            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0) {
                    hasRegistredUsers = true;
                }

            }

            statement.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasRegistredUsers;
    }
    public static boolean BBAcourse1y2sem(){
        boolean hasRegistredUsers = false;
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS course");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS BBA1Y2S ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "coursename VARCHAR(200) NOT NULL,"
                    +"instructor VARCHAR(200) NOT NULL"
                    + ")";
            statement.executeUpdate(sql);
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM bba1y2s");
            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0) {
                    hasRegistredUsers = true;
                }

            }

            statement.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasRegistredUsers;
    }
    public static boolean BBAcourse2y1sem(){
        boolean hasRegistredUsers = false;
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS course");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS BBA2Y1S ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "coursename VARCHAR(200) NOT NULL,"
                    +"instructor VARCHAR(200) NOT NULL"
                    + ")";
            statement.executeUpdate(sql);
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM bba2y1s");
            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0) {
                    hasRegistredUsers = true;
                }

            }

            statement.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasRegistredUsers;
    }
    public static boolean BBAcourse2y2sem(){
        boolean hasRegistredUsers = false;
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS course");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS BBA2Y2S ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "coursename VARCHAR(200) NOT NULL,"
                    +"instructor VARCHAR(200) NOT NULL"
                    + ")";
            statement.executeUpdate(sql);
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM bba2y2s");
            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0) {
                    hasRegistredUsers = true;
                }

            }

            statement.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasRegistredUsers;
    }
    public static boolean BBAcourse3y1sem(){
        boolean hasRegistredUsers = false;
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS course");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS BBA3Y1S ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "coursename VARCHAR(200) NOT NULL,"
                    +"instructor VARCHAR(200) NOT NULL"
                    + ")";
            statement.executeUpdate(sql);
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM bba3y1s");
            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0) {
                    hasRegistredUsers = true;
                }

            }

            statement.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasRegistredUsers;
    }
    public static boolean BBAcourse3y2sem(){
        boolean hasRegistredUsers = false;
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS course");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS BBA3Y2S ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "coursename VARCHAR(200) NOT NULL,"
                    +"instructor VARCHAR(200) NOT NULL"
                    + ")";
            statement.executeUpdate(sql);
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM bba3y2s");
            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0) {
                    hasRegistredUsers = true;
                }

            }

            statement.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasRegistredUsers;
    }
    public static void main(String[] args) {
        coursecreate coursecreate=new coursecreate();


    }
    public static boolean BITcourse1y1sem() {
        boolean hasRegistredUsers = false;
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS course");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS bit1Y1S ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "coursename VARCHAR(200) NOT NULL,"
                    + "instructor VARCHAR(200) NOT NULL"
                    + ")";
            statement.executeUpdate(sql);
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM bit1Y1S");
            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0) {
                    hasRegistredUsers = true;
                }

            }

            statement.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasRegistredUsers;
    }
    public static boolean BITcourse1y2sem(){
        boolean hasRegistredUsers = false;
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS course");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS bit1Y2S ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "coursename VARCHAR(200) NOT NULL,"
                    +"instructor VARCHAR(200) NOT NULL"
                    + ")";
            statement.executeUpdate(sql);
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM bit1y2s");
            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0) {
                    hasRegistredUsers = true;
                }

            }

            statement.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasRegistredUsers;
    }
    public static boolean BITcourse2y1sem(){
        boolean hasRegistredUsers = false;
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS course");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS bit2Y1S ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "coursename VARCHAR(200) NOT NULL,"
                    +"instructor VARCHAR(200) NOT NULL"
                    + ")";
            statement.executeUpdate(sql);
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM bit2y1s");
            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0) {
                    hasRegistredUsers = true;
                }

            }

            statement.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasRegistredUsers;
    }
    public static boolean BITcourse2y2sem(){
        boolean hasRegistredUsers = false;
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS course");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS bit2Y2S ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "coursename VARCHAR(200) NOT NULL,"
                    +"instructor VARCHAR(200) NOT NULL"
                    + ")";
            statement.executeUpdate(sql);
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM bit2y2s");
            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0) {
                    hasRegistredUsers = true;
                }

            }

            statement.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasRegistredUsers;
    }
    public static boolean BITcourse3y1sem(){
        boolean hasRegistredUsers = false;
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS course");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS bit3Y1S ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "coursename VARCHAR(200) NOT NULL,"
                    +"instructor VARCHAR(200) NOT NULL"
                    + ")";
            statement.executeUpdate(sql);
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM bit3y1s");
            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0) {
                    hasRegistredUsers = true;
                }

            }

            statement.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasRegistredUsers;
    }
    public static boolean BITcourse3y2sem(){
        boolean hasRegistredUsers = false;
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS course");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS bit3Y2S ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "coursename VARCHAR(200) NOT NULL,"
                    +"instructor VARCHAR(200) NOT NULL"
                    + ")";
            statement.executeUpdate(sql);
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM bit3y2s");
            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0) {
                    hasRegistredUsers = true;
                }

            }

            statement.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasRegistredUsers;
    }


    }

