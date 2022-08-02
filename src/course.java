import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class course {
    protected static void bitachecker(boolean a){
        if(a==true){

        }
        else{
            bitcourseinsert1y1sem();
        }
    }
    protected static void bitbchecker(boolean b){
        if(b ==true){

        }
        else {
            bitcourseinsert1y2sem();
        }
    }
    protected static void bitcchecker(boolean c){
        if(c ==true){

        }
        else {
            bitcourseinsert2y1sem();
        }
    }
    protected static void bitdchecker(boolean d){
        if(d ==true){

        }
        else{
            bitcourseinsert2y2sem();
        }
    }
    protected static void biteachecker(boolean ea){
        if(ea ==true){

        }
        else{
            bitcourseinsert3y1sem();
        }
    }
    protected static void bitfchecker(boolean f){
        if(f ==true){

        }
        else{
            bitcourseinsert3y2sem();
        }
    }
    private static void bbacourseinsert1y1sem() {
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql2 = "INSERT INTO `bba1y1s`(`coursename`, `instructor`) VALUES (\"English_1\",\"Bipin\");";
            stmt.executeUpdate(sql2);
            String sql1 = "INSERT INTO `bba1y1s`(`coursename`, `instructor`) VALUES (\"Business_Communication\",\"Ram\");";
            stmt.executeUpdate(sql1);
            String sql3 = "INSERT INTO `bba1y1s`(`coursename`, `instructor`) VALUES (\"Business_Mathematics_I\",\"Gita\");";
            stmt.executeUpdate(sql3);



            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void bbacourseinsert1y2sem(){
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql2= "INSERT INTO `bba1y2s`(`coursename`, `instructor`) VALUES (\"English_II\",\"Hari\");";
            stmt.executeUpdate(sql2);
            String sql1= "INSERT INTO `bba1y2s`(`coursename`, `instructor`) VALUES (\"Business_Mathematics_II\",\"Bipin\");";
            stmt.executeUpdate(sql1);
            String sql3= "INSERT INTO `bba1y2s`(`coursename`, `instructor`) VALUES (\"Business_Statistics\",\"Sita\");";
            stmt.executeUpdate(sql3);
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static void bbacourseinsert2y1sem(){
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql2= "INSERT INTO `bba2y1s`(`coursename`, `instructor`) VALUES (\"Micro_Economics\",\"Anupa\");";
            stmt.executeUpdate(sql2);
            String sql1= "INSERT INTO `bba2y1s`(`coursename`, `instructor`) VALUES (\"Macro_Economics\",\"Bipin\");";
            stmt.executeUpdate(sql1);
            String sql3= "INSERT INTO `bba2y1s`(`coursename`, `instructor`) VALUES (\"Psychology\",\"Krish\");";
            stmt.executeUpdate(sql3);
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static void bbacourseinsert2y2sem(){
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql2= "INSERT INTO `bba2y2s`(`coursename`, `instructor`) VALUES (\"Sociology\",\"Susil\");";
            stmt.executeUpdate(sql2);
            String sql1= "INSERT INTO `bba2y2s`(`coursename`, `instructor`) VALUES (\"Nepalese_Society_And_Politics\",\"Sujal\");";
            stmt.executeUpdate(sql1);
            String sql3= "INSERT INTO `bba2y2s`(`coursename`, `instructor`) VALUES (\"Computer_System_And_It_application\",\"Alan\");";
            stmt.executeUpdate(sql3);
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static void bbacourseinsert3y1sem(){
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql2= "INSERT INTO `bba3y1s`(`coursename`, `instructor`) VALUES (\"Principal_of_Management\",\"Ronak\");";
            stmt.executeUpdate(sql2);
            String sql1= "INSERT INTO `bba3y1s`(`coursename`, `instructor`) VALUES (\"Human_Resource_Management\",\"Sandhya\");";
            stmt.executeUpdate(sql1);
            String sql3= "INSERT INTO `bba3y1s`(`coursename`, `instructor`) VALUES (\"Business_Law\",\"Sabin\");";
            stmt.executeUpdate(sql3);
            String sql4= "INSERT INTO `bba3y1s`(`coursename`, `instructor`) VALUES (\"Business_Strategy\",\"Manjil\");";
            stmt.executeUpdate(sql4);
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static void bbacourseinsert3y2sem(){
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql2= "INSERT INTO `bba3y2s`(`coursename`, `instructor`) VALUES (\"Business_ethics_And_Social_Responsibiilities\",\"Swostika\");";
            stmt.executeUpdate(sql2);
            String sql1= "INSERT INTO `bba3y2s`(`coursename`, `instructor`) VALUES (\"Distribution_Management\",\"Srijana\");";
            stmt.executeUpdate(sql1);
            String sql3= "INSERT INTO `bba3y2s`(`coursename`, `instructor`) VALUES (\"Market_Research\",\"Ganga\");";
            stmt.executeUpdate(sql3);
            String sql4= "INSERT INTO `bba3y2s`(`coursename`, `instructor`) VALUES (\"Consumers_Behavior\",\"Jamuna\");";
            stmt.executeUpdate(sql4);
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    protected static void bbaachecker(boolean a){
        if(a==true){

        }
        else{
            bbacourseinsert1y1sem();
        }
    }
    protected static void bbabchecker(boolean b){
        if(b ==true){

        }
        else {
            bbacourseinsert1y2sem();
        }
    }
    protected static void bbacchecker(boolean c){
        if(c ==true){

        }
        else {
            bbacourseinsert2y1sem();
        }
    }
    protected static void bbadchecker(boolean d){
        if(d ==true){

        }
        else{
            bbacourseinsert2y2sem();
        }
    }
    protected static void bbaeachecker(boolean ea){
        if(ea ==true){

        }
        else{
            bbacourseinsert3y1sem();
        }
    }
    protected static void bbafchecker(boolean f){
        if(f ==true){

        }
        else{
            bbacourseinsert3y2sem();
        }
    }
    private static void bitcourseinsert1y1sem() {
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql2 = "INSERT INTO `bit1y1s`(`coursename`, `instructor`) VALUES (\"Digital_Logic\",\"Aaditya\");";
            stmt.executeUpdate(sql2);
            String sql1 = "INSERT INTO `bit1y1s`(`coursename`, `instructor`) VALUES (\"C_Programming\",\"Sujit\");";
            stmt.executeUpdate(sql1);
            String sql3 = "INSERT INTO `bit1y1s`(`coursename`, `instructor`) VALUES (\"Introduction_to_Information_Technology\",\"Bishwas\");";
            stmt.executeUpdate(sql3);



            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void bitcourseinsert1y2sem(){
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql2= "INSERT INTO `bit1y2s`(`coursename`, `instructor`) VALUES (\"Object_Oriented_Programming\",\"Ramesh\");";
            stmt.executeUpdate(sql2);
            String sql1= "INSERT INTO `bit1y2s`(`coursename`, `instructor`) VALUES (\"Basic_Mathematics\",\"Suresh\");";
            stmt.executeUpdate(sql1);
            String sql3= "INSERT INTO `bit1y2s`(`coursename`, `instructor`) VALUES (\"Discrete_Structure\",\"Manish\");";
            stmt.executeUpdate(sql3);
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static void bitcourseinsert2y1sem(){
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql2= "INSERT INTO `bit2y1s`(`coursename`, `instructor`) VALUES (\"Operating_System\",\"Pranaya\");";
            stmt.executeUpdate(sql2);
            String sql1= "INSERT INTO `bit2y1s`(`coursename`, `instructor`) VALUES (\"Database_management_system\",\"Pandit\");";
            stmt.executeUpdate(sql1);
            String sql3= "INSERT INTO `bit2y1s`(`coursename`, `instructor`) VALUES (\"Data_structure_And_Algorithm\",\"Krisha\");";
            stmt.executeUpdate(sql3);
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static void bitcourseinsert2y2sem(){
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql2= "INSERT INTO `bit2y2s`(`coursename`, `instructor`) VALUES (\"Artificial_Intelligence\",\"Sandip\");";
            stmt.executeUpdate(sql2);
            String sql1= "INSERT INTO `bit2y2s`(`coursename`, `instructor`) VALUES (\"System_Analysis_And_Design\",\"Jasmin\");";
            stmt.executeUpdate(sql1);
            String sql3= "INSERT INTO `bit2y2s`(`coursename`, `instructor`) VALUES (\"Network_And_Data_Communication\",\"Anita\");";
            stmt.executeUpdate(sql3);
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static void bitcourseinsert3y1sem(){
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql2= "INSERT INTO `bit3y1s`(`coursename`, `instructor`) VALUES (\"Computer_Graphics\",\"Namrata\");";
            stmt.executeUpdate(sql2);
            String sql1= "INSERT INTO `bit3y1s`(`coursename`, `instructor`) VALUES (\"Information_Security\",\"Akhil\");";
            stmt.executeUpdate(sql1);
            String sql3= "INSERT INTO `bit3y1s`(`coursename`, `instructor`) VALUES (\"Software_Engineering\",\"Nihit\");";
            stmt.executeUpdate(sql3);
            String sql4= "INSERT INTO `bit3y1s`(`coursename`, `instructor`) VALUES (\"Web_Technology\",\"Nabin\");";
            stmt.executeUpdate(sql4);
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static void bitcourseinsert3y2sem(){
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql2= "INSERT INTO `bit3y2s`(`coursename`, `instructor`) VALUES (\"Database_Administration\",\"Bipin\");";
            stmt.executeUpdate(sql2);
            String sql1= "INSERT INTO `bit3y2s`(`coursename`, `instructor`) VALUES (\"Research_Methodology\",\"Anish\");";
            stmt.executeUpdate(sql1);
            String sql3= "INSERT INTO `bit3y2s`(`coursename`, `instructor`) VALUES (\"Net_Centric_Computing\",\"Pukar\");";
            stmt.executeUpdate(sql3);
            String sql4= "INSERT INTO `bit3y2s`(`coursename`, `instructor`) VALUES (\"e_Commerce\",\"Dipendra\");";
            stmt.executeUpdate(sql4);
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
