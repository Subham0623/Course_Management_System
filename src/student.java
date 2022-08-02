import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class student {
    static void crea(){
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/student";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            //First, connect to MYSQL server and create the database if not created
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS student");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT( 10 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "fname VARCHAR(200) NOT NULL,"
                    + "lname VARCHAR(200) NOT NULL,"
                    + "gender VARCHAR(200),"
                    + "email VARCHAR(200) NOT NULL UNIQUE,"
                    + "username VARCHAR(200) NOT NULL UNIQUE,"
                    + "password VARCHAR(200) NOT NULL,"
                    + "usertype VARCHAR(200) NOT NULL"
                    + ")";
            statement.executeUpdate(sql);



            statement.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

}}
