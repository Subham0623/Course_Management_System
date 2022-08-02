import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class instructorname {
    protected boolean createdatabase(){
        boolean hasRegistredUsers=false;
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/insdetail";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS insdetail");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS insdet ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "coursename VARCHAR(200) NOT NULL,"
                    + "instructor VARCHAR(200) NOT NULL"
                    + ")";
            statement.executeUpdate(sql);
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM insdet");
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
    protected void insterdatabase() {
        final String DB_URL = "jdbc:mysql://localhost/insdetail";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql2 = "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"English_1\",\"Bipin\");";
            stmt.executeUpdate(sql2);
            String sql1 = "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Business_Communication\",\"Ram\");";
            stmt.executeUpdate(sql1);
            String sql3 = "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Business_Mathematics_I\",\"Gita\");";
            stmt.executeUpdate(sql3);
            String sql= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"English_II\",\"Hari\");";
            stmt.executeUpdate(sql);
            String sql4= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Business_Mathematics_II\",\"Bipin\");";
            stmt.executeUpdate(sql4);
            String sql5= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Business_Statistics\",\"Sita\");";
            stmt.executeUpdate(sql5);
            String sql6= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Micro_Economics\",\"Anupa\");";
            stmt.executeUpdate(sql6);
            String sql7= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Macro_Economics\",\"Bipin\");";
            stmt.executeUpdate(sql7);
            String sql8= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Psychology\",\"Krish\");";
            stmt.executeUpdate(sql8);
            String sql9= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Sociology\",\"Susil\");";
            stmt.executeUpdate(sql9);
            String sql10= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Nepalese_Society_And_Politics\",\"Sujal\");";
            stmt.executeUpdate(sql10);
            String sql11= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Computer_System_And_It_application\",\"Alan\");";
            stmt.executeUpdate(sql11);
            String sql12= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Principal_of_Management\",\"Ronak\");";
            stmt.executeUpdate(sql12);
            String sql13= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Human_Resource_Management\",\"Sandhya\");";
            stmt.executeUpdate(sql13);
            String sql14= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Business_Law\",\"Sabin\");";
            stmt.executeUpdate(sql14);
            String sql15= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Business_Strategy\",\"Manjil\");";
            stmt.executeUpdate(sql15);
            String sql16= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Business_ethics_And_Social_Responsibiilities\",\"Swostika\");";
            stmt.executeUpdate(sql16);
            String sql17= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Distribution_Management\",\"Srijana\");";
            stmt.executeUpdate(sql17);
            String sql18= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Market_Research\",\"Ganga\");";
            stmt.executeUpdate(sql18);
            String sql19= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Consumers_Behavior\",\"Jamuna\");";
            stmt.executeUpdate(sql19);
            String sql20 = "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Digital_Logic\",\"Aaditya\");";
            stmt.executeUpdate(sql20);
            String sql21 = "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"C_Programming\",\"Sujit\");";
            stmt.executeUpdate(sql21);
            String sql22 = "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Introduction_to_Information_Technology\",\"Bishwas\");";
            stmt.executeUpdate(sql22);
            String sql23= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Object_Oriented_Programming\",\"Ramesh\");";
            stmt.executeUpdate(sql23);
            String sql24= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Basic_Mathematics\",\"Suresh\");";
            stmt.executeUpdate(sql24);
            String sql25= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Discrete_Structure\",\"Manish\");";
            stmt.executeUpdate(sql25);
            String sql26= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Operating_System\",\"Pranaya\");";
            stmt.executeUpdate(sql26);
            String sql27= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Database_management_system\",\"Pandit\");";
            stmt.executeUpdate(sql27);
            String sql28= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Data_structure_And_Algorithm\",\"Krisha\");";
            stmt.executeUpdate(sql28);
            String sql29= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Artificial_Intelligence\",\"Sandip\");";
            stmt.executeUpdate(sql29);
            String sql30= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"System_Analysis_And_Design\",\"Jasmin\");";
            stmt.executeUpdate(sql30);
            String sql31= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Network_And_Data_Communication\",\"Anita\");";
            stmt.executeUpdate(sql31);
            String sql32= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Computer_Graphics\",\"Namrata\");";
            stmt.executeUpdate(sql32);
            String sql33= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Information_Security\",\"Akhil\");";
            stmt.executeUpdate(sql33);
            String sql34= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Software_Engineering\",\"Nihit\");";
            stmt.executeUpdate(sql34);
            String sql35= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Web_Technology\",\"Nabin\");";
            stmt.executeUpdate(sql35);
            String sql36= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Database_Administration\",\"Bipin\");";
            stmt.executeUpdate(sql36);
            String sql37= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Research_Methodology\",\"Anish\");";
            stmt.executeUpdate(sql37);
            String sql38= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"Net_Centric_Computing\",\"Pukar\");";
            stmt.executeUpdate(sql38);
            String sql39= "INSERT INTO `insdet`(`coursename`, `instructor`) VALUES (\"e_Commerce\",\"Dipendra\");";
            stmt.executeUpdate(sql39);
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        instructorname instructorname = new instructorname();
    }
}
