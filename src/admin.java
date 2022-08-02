import java.sql.*;

public class admin {
//    declaring a static boolean function name connectToDatabase
    public static boolean connectToDatabase() {
//        defining a boolean variable hasRegistredUsers and storing false in it
        boolean hasRegistredUsers = false;
//        defining a final String variable MYSQL_SERVER_URL  and storing jdbc:mysql://localhost/
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        //        defining a final String variable DB_URL and storing dbc:mysql://localhost/user
        final String DB_URL = "jdbc:mysql://localhost/user";
        //        defining a final String variable USERNAME  and storing root in it
        final String USERNAME = "root";
        //        defining a final String variable PASSWORD and storing nothing in it
        final String PASSWORD = "";
//        running a try block
        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
//            Over here we are checking if database name user exist or not if it doesnt exist we are creating it
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS user");
//closing stmt and con
            stmt.close();
            con.close();

            //Second, connect to the database and create the table "users" if cot created
            con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = con.createStatement();
//            Over here we are checking if database name user exist or not if it doesnt exist we are creating it
            String sql = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT( 10 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "username VARCHAR(200) NOT NULL UNIQUE,"
                    + "password VARCHAR(200) NOT NULL,"
                    + "usertype VARCHAR(200) NOT NULL"
                    + ")";
//            executing the sql query
            stmt.executeUpdate(sql);
            stmt = con.createStatement();
//
            ResultSet resultSet = stmt.executeQuery("SELECT COUNT(*) FROM users");

            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0) {
                    hasRegistredUsers = true;
                }
            }
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  hasRegistredUsers;
    }
    public static void insert(){

        final String DB_URL = "jdbc:mysql://localhost/user";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"admin\",\"admin\",\"admin\");";
            stmt.executeUpdate(sql);
            String sql1= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Hari\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql1);
            String sql2= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Nischal\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql2);
            String sql3= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Sita\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql3);
            String sql4= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Anupa\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql4);
            String sql5= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Anamika\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql5);
            String sql6= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Krish\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql6);
            String sql7= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Susil\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql7);
            String sql8= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Sujal\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql8);
            String sql9= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Alan\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql9);
            String sql10= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Ronak\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql10);
            String sql11= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Sandhya\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql11);
            String sql12= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Sabin\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql12);
            String sql13= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Manjil\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql13);
            String sql14= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Swostika\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql14);
            String sql15= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Srijana\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql15);
            String sql16= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Ganga\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql16);
            String sql17= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Jamuna\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql17);
            String sql18= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Bipin\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql18);
            String sql19= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Ram\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql19);
            String sql20= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Gita\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql20);
            String sql21= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Aaditya\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql21);
            String sql22= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Sujit\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql22);
            String sql23= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Bishwas\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql23);
            String sql24= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Ramesh\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql24);
            String sql25= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Suresh\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql25);
            String sql26= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Manish\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql26);
            String sql27= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Pranaya\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql27);
            String sql28= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Pandit\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql28);
            String sql29= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Krisha\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql29);
            String sql30= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Sandip\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql30);
            String sql31= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Jasmin\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql31);
            String sql32= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Anita\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql32);
            String sql33= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Namrata\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql33);
            String sql34= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Akhil\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql34);
            String sql35= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Nihit\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql35);
            String sql36= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Nabin\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql36);
            String sql37= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Bimal\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql37);
            String sql38= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Anish\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql38);
            String sql39= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Pukar\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql39);
            String sql40= "INSERT INTO `users`(`username`, `usertype`, `password`) VALUES (\"Dipendra\",\"instructor\",\"123\");";
            stmt.executeUpdate(sql40);

            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
public static void checker(){
    boolean a= admin.connectToDatabase();
    if(a==true){

    }
    else{
        insert();
    }
}

    public static void main(String[] args) {
        admin admin = new admin();
    }
        }
