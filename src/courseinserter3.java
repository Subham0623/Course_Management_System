import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class courseinserter3 extends JDialog {

    private JTextField m11;
    private JTextField in11;
    private JTextField m12;
    private JTextField in12;
    private JTextField m13;
    private JTextField in13;
    private JTextField m21;
    private JTextField m22;
    private JTextField m23;
    private JTextField in21;
    private JTextField in22;
    private JTextField in23;
    private JButton done;
    private JButton back;
    private JPanel panel1;
    private JPasswordField p1;
    private JPasswordField p2;
    private JPasswordField p3;
    private JPasswordField p4;
    private JPasswordField p5;
    private JPasswordField p6;
    private JTextField m14;
    private JTextField in14;
    private JPasswordField p17;
    private JTextField m24;
    private JTextField in24;
    private JPasswordField p27;
    static String cname;
    public courseinserter3(JFrame parent) {
        super(parent);
        setTitle("3rd year course insert");
        setContentPane(panel1);
        setMinimumSize(new Dimension(800, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mo11 = m11.getText();
                String i11 = in11.getText();
                String mo12 = m12.getText();
                String i12 = in12.getText();
                String mo13 = m13.getText();
                String i13 = in13.getText();
                String mo14 = m14.getText();
                String i14 = in14.getText();
                String mo21 = m21.getText();
                String i21 = in21.getText();
                String mo22 = m22.getText();
                String i22 = in22.getText();
                String mo23 = m23.getText();
                String i23 = in23.getText();
                String mo24 = m24.getText();
                String i24 = in24.getText();
                String pass1 = String.valueOf(p1.getPassword());
                String pass2 = String.valueOf(p2.getPassword());
                String pass3 = String.valueOf(p3.getPassword());
                String pass4 = String.valueOf(p4.getPassword());
                String pass5 = String.valueOf(p5.getPassword());
                String pass6 = String.valueOf(p6.getPassword());
                String pass17 = String.valueOf(p17.getPassword());
                String pass27 = String.valueOf(p27.getPassword());
                if (m11.getText().equals("") || m12.getText().equals("") || m13.getText().equals("")| m14.getText().equals("") || m21.getText().equals("") || m22.getText().equals("")||
                        m23.getText().equals("") ||m24.getText().equals("") || in11.getText().equals("") || in12.getText().equals("") || in13.getText().equals("")
                        || in14.getText().equals("")|| in21.getText().equals("") || in22.getText().equals("") || in23.getText().equals("")
                        || in24.getText().equals("")||p1.getPassword().length==0 ||p2.getPassword().length==0||p3.getPassword().length==0||
                        p4.getPassword().length==0 ||p5.getPassword().length==0||p6.getPassword().length==0||p17.getPassword().length==0||p27.getPassword().length==0) {
                    JOptionPane.showMessageDialog(courseinserter3.this,
                            "Forgot to fill somewhere please check",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);


                } else {

                    create1y1s(mo11, mo12, mo13,mo14, i11, i12, i13,i14);
                    create1y2s(mo21, mo22, mo23,mo24, i21, i22, i23,i24);
                    createdatabase3y1s(mo11,mo12,mo13,mo14);
                    createdatabase3y2s(mo21,mo22,mo23,mo24);
                    registeruser(i11,i12,i13,i14,i21,i22,i23,i24,pass1,pass2,pass3,pass4,pass5,pass6,pass17,pass27);
                    dispose();
                    admincc.main(null);

                }

            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                dashboardadm.main(null);
            }
        });
        setVisible(true);
    }
    static void name(String name){
        cname=name;
    }
    void create1y1s(String mo11,String mo12,String mo13,String mo14,String i11, String i12, String i13, String i14){
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql2 = "INSERT INTO "+cname+"3y1s(`coursename`, `instructor`) VALUES ('"+mo11+"','"+i11+"');";
            stmt.executeUpdate(sql2);
            String sql1 = "INSERT INTO "+cname+"3y1s(`coursename`, `instructor`) VALUES ('"+mo12+"','"+i12+"');";
            stmt.executeUpdate(sql1);
            String sql3 = "INSERT INTO "+cname+"3y1s(`coursename`, `instructor`) VALUES ('"+mo13+"','"+i13+"');";
            stmt.executeUpdate(sql3);
            String sql4 = "INSERT INTO "+cname+"3y1s(`coursename`, `instructor`) VALUES ('"+mo14+"','"+i14+"');";
            stmt.executeUpdate(sql4);
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void create1y2s(String mo21,String mo22,String mo23,String mo24,String i21, String i22, String i23, String i24){
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql2 = "INSERT INTO "+cname+"3y2s(`coursename`, `instructor`) VALUES ('"+mo21+"','"+i21+"');";
            stmt.executeUpdate(sql2);
            String sql1 = "INSERT INTO "+cname+"3y2s(`coursename`, `instructor`) VALUES ('"+mo22+"','"+i22+"');";
            stmt.executeUpdate(sql1);
            String sql3 = "INSERT INTO "+cname+"3y2s(`coursename`, `instructor`) VALUES ('"+mo23+"','"+i23+"');";
            stmt.executeUpdate(sql3);
            String sql4 = "INSERT INTO "+cname+"3y2s(`coursename`, `instructor`) VALUES ('"+mo24+"','"+i24+"');";
            stmt.executeUpdate(sql4);
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        courseinserter3 courseinserter3 =new courseinserter3(null);
    }
        void createdatabase3y1s(String m11,String m12,String m13,String m14){
            String a=cname+"3y1s";
            final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
            final String DB_URL = "jdbc:mysql://localhost/"+a;
            final String USERNAME = "root";
            final String PASSWORD = "";
            try {
                Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
                Statement statement = conn.createStatement();
                statement.executeUpdate("CREATE DATABASE IF NOT EXISTS "+a);
                statement.close();
                conn.close();

                //Second, connect to the database and create the table "users" if cot created
                conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                statement = conn.createStatement();
                String sql = "CREATE TABLE IF NOT EXISTS "+m11+" ("
                        + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                        + "fname VARCHAR(200) NOT NULL,"
                        + "lname VARCHAR(200) NOT NULL,"
                        + "username VARCHAR(200) NOT NULL UNIQUE,"
                        + "marks VARCHAR(3)"
                        + ")";
                statement.executeUpdate(sql);
                String sql1 = "CREATE TABLE IF NOT EXISTS "+m12+" ("
                        + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                        + "fname VARCHAR(200) NOT NULL,"
                        + "lname VARCHAR(200) NOT NULL,"
                        + "username VARCHAR(200) NOT NULL UNIQUE,"
                        + "marks VARCHAR(3)"
                        + ")";
                statement.executeUpdate(sql1);
                String sql2 = "CREATE TABLE IF NOT EXISTS "+m13+" ("
                        + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                        + "fname VARCHAR(200) NOT NULL,"
                        + "lname VARCHAR(200) NOT NULL,"
                        + "username VARCHAR(200) NOT NULL UNIQUE,"
                        + "marks VARCHAR(3)"
                        + ")";
                statement.executeUpdate(sql2);
                String sql3 = "CREATE TABLE IF NOT EXISTS "+m14+" ("
                        + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                        + "fname VARCHAR(200) NOT NULL,"
                        + "lname VARCHAR(200) NOT NULL,"
                        + "username VARCHAR(200) NOT NULL UNIQUE,"
                        + "marks VARCHAR(3)"
                        + ")";
                statement.executeUpdate(sql3);
                statement.close();
                conn.close();


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    void createdatabase3y2s(String m21,String m22,String m23,String m24){
        String a=cname+"3y2s";
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/"+a;
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS "+a );
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS "+m21+" ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "fname VARCHAR(200) NOT NULL,"
                    + "lname VARCHAR(200) NOT NULL,"
                    + "username VARCHAR(200) NOT NULL UNIQUE,"
                    + "marks VARCHAR(3)"
                    + ")";
            statement.executeUpdate(sql);
            String sql1 = "CREATE TABLE IF NOT EXISTS "+m22+" ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "fname VARCHAR(200) NOT NULL,"
                    + "lname VARCHAR(200) NOT NULL,"
                    + "username VARCHAR(200) NOT NULL UNIQUE,"
                    + "marks VARCHAR(3)"
                    + ")";
            statement.executeUpdate(sql1);
            String sql2 = "CREATE TABLE IF NOT EXISTS "+m23+" ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "fname VARCHAR(200) NOT NULL,"
                    + "lname VARCHAR(200) NOT NULL,"
                    + "username VARCHAR(200) NOT NULL UNIQUE,"
                    + "marks VARCHAR(3)"
                    + ")";
            statement.executeUpdate(sql2);
            String sql3 = "CREATE TABLE IF NOT EXISTS "+m24+" ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "fname VARCHAR(200) NOT NULL,"
                    + "lname VARCHAR(200) NOT NULL,"
                    + "username VARCHAR(200) NOT NULL UNIQUE,"
                    + "marks VARCHAR(3)"
                    + ")";
            statement.executeUpdate(sql3);
            statement.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void registeruser(String in11,String in12,String in13,String in14,String in21,String in22,String in23,String in24,String p1,String p2,String p3,String p4,String p5,String p6,String p17, String p27){
        final String DB_URL = "jdbc:mysql://localhost/user";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            //1
            String sql =  "INSERT INTO `users`(`username`,`password`,`usertype`) VALUES ( ?,?,\"instructor\");";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, in11);
            preparedStatement.setString(2, p1);
            //2
            String sql2 =  "INSERT INTO `users`(`username`,`password`,`usertype`) VALUES ( ?,?,\"instructor\");";
            PreparedStatement preparedStatement1 = con.prepareStatement(sql2);
            preparedStatement1.setString(1, in12);
            preparedStatement1.setString(2, p2);
            //3
            String sql3 =  "INSERT INTO `users`(`username`,`password`,`usertype`) VALUES ( ?,?,\"instructor\");";
            PreparedStatement preparedStatement3 = con.prepareStatement(sql3);
            preparedStatement3.setString(1, in13);
            preparedStatement3.setString(2, p3);
            //4
            String sql4 =  "INSERT INTO `users`(`username`,`password`,`usertype`) VALUES ( ?,?,\"instructor\");";
            PreparedStatement preparedStatement4 = con.prepareStatement(sql4);
            preparedStatement4.setString(1, in21);
            preparedStatement4.setString(2, p4);
            //5
            String sql5 =  "INSERT INTO `users`(`username`,`password`,`usertype`) VALUES ( ?,?,\"instructor\");";
            PreparedStatement preparedStatement5 = con.prepareStatement(sql5);
            preparedStatement5.setString(1, in22);
            preparedStatement5.setString(2, p5);
            //6
            String sql6 =  "INSERT INTO `users`(`username`,`password`,`usertype`) VALUES ( ?,?,\"instructor\");";
            PreparedStatement preparedStatement6 = con.prepareStatement(sql6);
            preparedStatement6.setString(1, in23);
            preparedStatement6.setString(2, p6);
            String sql7 =  "INSERT INTO `users`(`username`,`password`,`usertype`) VALUES ( ?,?,\"instructor\");";
            PreparedStatement preparedStatement7 = con.prepareStatement(sql7);
            preparedStatement7.setString(1, in14);
            preparedStatement7.setString(2, p17);
            String sql8 =  "INSERT INTO `users`(`username`,`password`,`usertype`) VALUES ( ?,?,\"instructor\");";
            PreparedStatement preparedStatement8 = con.prepareStatement(sql8);
            preparedStatement8.setString(1, in24);
            preparedStatement8.setString(2, p27);
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

}}
