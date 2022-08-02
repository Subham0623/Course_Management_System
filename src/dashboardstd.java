import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class dashboardstd extends JDialog {
    private  JComboBox course;
    private JButton OK;
    private JPanel dashstd;

    String a;

    public dashboardstd(JFrame parent) {
        super(parent);
        setTitle("Course Select");
        setContentPane(dashstd);
        setMinimumSize(new Dimension(400, 400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jcomboshow();

        OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cour=String.valueOf(course.getSelectedItem());

                dispose();
                if(cour.equals("BBA")){
                    BBA.creater();
                    BBA BBA = new BBA(null);



                }
                else if(cour.equals("BIT")){
                    BIT.creater();
                    BIT BIT = new BIT(null);

                }
                else{
                    extraclasses.modulename(cour);
                    extraclasses extraclasses=new extraclasses(null);

                }

            }
        });
        setVisible(true);
    }
    static boolean createcourse(){
        boolean a = true;
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/courses";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            //First, connect to MYSQL server and create the database if not created
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS courses");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS course ("
                    + "id INT( 10 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "coursename VARCHAR(200) NOT NULL UNIQUE"
                    + ")";
            statement.executeUpdate(sql);
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM course");

            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers == 0) {
                    a=false;

                }
            }
            statement.close();
            statement.close();

        }catch(Exception e){
            e.printStackTrace();
        }
return a;

    }
    static void courseinsert(){
        final String DB_URL = "jdbc:mysql://localhost/courses";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql= "INSERT INTO `course`( `coursename`) VALUES (\"BBA\");";
            stmt.executeUpdate(sql);
            String sql1= "INSERT INTO `course`( `coursename`) VALUES (\"BIT\");";
            stmt.executeUpdate(sql1);

            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    static void admincourseinsert(String name){
        new coursecreate();
        final String DB_URL = "jdbc:mysql://localhost/courses";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            if(name!=null){
                String sql= "INSERT INTO `course`( `coursename`) VALUES ('"+name+"');";
                stmt.executeUpdate(sql);
            }

            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {

        dashboardstd dashboardstd=new dashboardstd(null);
        boolean a= dashboardstd. createcourse();

        if(a==false){
            dashboardstd.courseinsert();
        }
    }
    protected void jcomboshow(){
        final String DB_URL = "jdbc:mysql://localhost/courses";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("select coursename from course");
            while (resultSet.next()){

                a=resultSet.getString(1);
                course.addItem(a);
        }
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
