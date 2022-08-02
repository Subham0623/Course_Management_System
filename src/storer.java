import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class storer {
   protected void newdata(String a, String b, String c,String d){
       credatabase(d);
       final String USERNAME = "root";
       final String PASSWORD = "";
       try {
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/enroller", USERNAME, PASSWORD);
           // Connected to database successfully..
           Statement stmt = conn.createStatement();

           String sql = "INSERT INTO "+d+"student (`fname`, `lname`, `username`) VALUES ('" + a + "','" + b + "','" + c + "');";
           stmt.executeUpdate(sql);



           stmt.close();
           conn.close();
       } catch(Exception e){
           e.printStackTrace();
       }

    }
    private void credatabase(String a){
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/enroller";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS enroller");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS "+a+"student ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "fname VARCHAR(200) NOT NULL,"
                    + "lname VARCHAR(200) NOT NULL,"
                    + "username VARCHAR(200) NOT NULL UNIQUE"
                    + ")";
            statement.executeUpdate(sql);
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS enroller");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql1 = "CREATE TABLE IF NOT EXISTS student ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "fname VARCHAR(200) NOT NULL,"
                    + "lname VARCHAR(200) NOT NULL,"
                    + "username VARCHAR(200) NOT NULL UNIQUE"
                    + ")";
            statement.executeUpdate(sql1);
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void credatabase(){
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/enroller";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS enroller");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS student ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "fname VARCHAR(200) NOT NULL,"
                    + "lname VARCHAR(200) NOT NULL,"
                    + "username VARCHAR(200) NOT NULL UNIQUE"
                    + ")";
            statement.executeUpdate(sql);
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        storer storer=new storer();
    }
}
