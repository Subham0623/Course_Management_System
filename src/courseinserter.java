import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class courseinserter extends JDialog {

    private JPanel panel1;
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
    ;
    private JPasswordField p2;
    private JPasswordField p3;
    private JPasswordField p4;
    private JPasswordField p5;
    private JPasswordField p6;
    private JPasswordField p1;
    static String cname;
    public courseinserter(JFrame parent) {
        super(parent);
        setTitle("1st year course insert");
        setContentPane(panel1);
        setMinimumSize(new Dimension(800, 700));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                dashboardadm.main(null);
            }
        });
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mo11 = m11.getText();
                String i11 = in11.getText();
                String mo12 = m12.getText();
                String i12 = in12.getText();
                String mo13 = m13.getText();
                String i13 = in13.getText();
                String mo21 = m21.getText();
                String i21 = in21.getText();
                String mo22 = m22.getText();
                String i22 = in22.getText();
                String mo23 = m23.getText();
                String i23 = in23.getText();
                String pass1 = String.valueOf(p1.getPassword());
                String pass2 = String.valueOf(p2.getPassword());
                String pass3 = String.valueOf(p3.getPassword());
                String pass4 = String.valueOf(p4.getPassword());
                String pass5 = String.valueOf(p5.getPassword());
                String pass6 = String.valueOf(p6.getPassword());
                if (m11.getText().equals("") || m12.getText().equals("") || m13.getText().equals("") || m21.getText().equals("") || m22.getText().equals("")||
                        m23.getText().equals("") || in11.getText().equals("") || in12.getText().equals("") || in13.getText().equals("") || in21.getText().equals("") ||
                        in22.getText().equals("") || in23.getText().equals("") ||p1.getPassword().length==0 ||p2.getPassword().length==0||p3.getPassword().length==0||
                        p4.getPassword().length==0 ||p5.getPassword().length==0||p6.getPassword().length==0) {
                    JOptionPane.showMessageDialog(courseinserter.this,
                            "Forgot to fill somewhere please check",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);


                } else {

                    create1y1s(mo11,mo12,mo13,i11,i12,i13);
                    create1y2s(mo21,mo22,mo23,i21,i22,i23);
                    createdatabase1y1s(mo11,mo12,mo13);
                    createdatabase1y2s(mo21,mo22,mo23);
                    registeruser(i11,i12,i13,i21,i22,i23,pass1,pass2,pass3,pass4,pass5,pass6);
                    dispose();
                    courseinserter2.name(cname);
                    courseinserter2 courseinserter2=new courseinserter2(null);

                }

            }
        });
        setVisible(true);

    }
    static void name(String name){
        System.out.println(name);
        cname=name;
    }
    void create1y1s(String mo11,String mo12,String mo13,String i11, String i12, String i13){
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql2 = "INSERT INTO "+cname+"1y1s(`coursename`, `instructor`) VALUES ('"+mo11+"','"+i11+"');";
            stmt.executeUpdate(sql2);
            String sql1 = "INSERT INTO "+cname+"1y1s(`coursename`, `instructor`) VALUES ('"+mo12+"','"+i12+"');";
            stmt.executeUpdate(sql1);
            String sql3 = "INSERT INTO "+cname+"1y1s(`coursename`, `instructor`) VALUES ('"+mo13+"','"+i13+"');";
            stmt.executeUpdate(sql3);
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void create1y2s(String mo21,String mo22,String mo23,String i21, String i22, String i23){
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql2 = "INSERT INTO "+cname+"1y2s(`coursename`, `instructor`) VALUES ('"+mo21+"','"+i21+"');";
            stmt.executeUpdate(sql2);
            String sql1 = "INSERT INTO "+cname+"1y2s(`coursename`, `instructor`) VALUES ('"+mo22+"','"+i22+"');";
            stmt.executeUpdate(sql1);
            String sql3 = "INSERT INTO "+cname+"1y2s(`coursename`, `instructor`) VALUES ('"+mo23+"','"+i23+"');";
            stmt.executeUpdate(sql3);
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        courseinserter courseinserter=new courseinserter(null);
    }
    void createdatabase1y1s(String m11,String m12,String m13){
        String a=cname+"1y1s";
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
            statement.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    void createdatabase1y2s(String m21,String m22,String m23){
        String a=cname+"1y2s";
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/"+a;
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + a );
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
            String sql2 ="CREATE TABLE IF NOT EXISTS "+m23+" ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "fname VARCHAR(200) NOT NULL,"
                    + "lname VARCHAR(200) NOT NULL,"
                    + "username VARCHAR(200) NOT NULL UNIQUE,"
                    + "marks VARCHAR(3)"
                    + ")";
            statement.executeUpdate(sql2);
            statement.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void registeruser(String in11,String in12,String in13,String in21,String in22,String in23,String p1,String p2,String p3,String p4,String p5,String p6){
        final String DB_URL = "jdbc:mysql://localhost/user";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            //1
            String sql = "INSERT INTO `users`(`username`,`password`,`usertype`) VALUES ( ?,?,\"instructor\");";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, in11);
            preparedStatement.setString(2, p1);
            preparedStatement.executeUpdate();
            //2
            String sql2 = "INSERT INTO `users`(`username`,`password`,`usertype`) VALUES ( ?,?,\"instructor\");";
            PreparedStatement preparedStatement1 = con.prepareStatement(sql2);
            preparedStatement1.setString(1, in12);
            preparedStatement1.setString(2, p2);
            preparedStatement1.executeUpdate();
            //3
            String sql3 = "INSERT INTO `users`(`username`,`password`,`usertype`) VALUES ( ?,?,\"instructor\");";
            PreparedStatement preparedStatement3 = con.prepareStatement(sql3);
            preparedStatement3.setString(1, in13);
            preparedStatement3.setString(2, p3);
            preparedStatement3.executeUpdate();
            //4
            String sql4 = "INSERT INTO `users`(`username`,`password`,`usertype`) VALUES ( ?,?,\"instructor\");";
            PreparedStatement preparedStatement4 = con.prepareStatement(sql4);
            preparedStatement4.setString(1, in21);
            preparedStatement4.setString(2, p4);
            preparedStatement4.executeUpdate();
            //5
            String sql5 ="INSERT INTO `users`(`username`,`password`,`usertype`) VALUES ( ?,?,\"instructor\");";
            PreparedStatement preparedStatement5 = con.prepareStatement(sql5);
            preparedStatement5.setString(1, in22);
            preparedStatement5.setString(2, p5);
            preparedStatement5.executeUpdate();
            //6
            String sql6 = "INSERT INTO `users`(`username`,`password`,`usertype`) VALUES ( ?,?,\"instructor\");";
            PreparedStatement preparedStatement6 = con.prepareStatement(sql6);
            preparedStatement6.setString(1, in23);
            preparedStatement6.setString(2, p6);
            preparedStatement6.executeUpdate();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
