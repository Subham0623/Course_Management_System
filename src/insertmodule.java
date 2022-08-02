import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class insertmodule extends JDialog {
    private JPanel panel1;
    private JTextField modulename;
    private JButton ok;
    private JButton cancle;
    private JTextField instructorname;
    private JPasswordField password;
    static String name;
    public insertmodule(JFrame parent) {
        super(parent);
        setTitle("Add module");
        setContentPane(panel1);
        setMinimumSize(new Dimension(800, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mname=modulename.getText();
                String iname=instructorname.getText();
                String pass=String.valueOf(password.getPassword());
                if(mname.isEmpty()||iname.isEmpty()||password.getPassword().length==0){
                    JOptionPane.showMessageDialog(insertmodule.this,
                            "Fill all the boxes properly",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
                else{
                    addmod(mname,iname);
                    creta(mname);
                    regins(iname,pass);
                    dashboardadm.main(null);

                }

            }
        });
        cancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        setVisible(true);
    }
    void addmod(String moname,String insname){

        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO " + name + "(`coursename`, `instructor`) VALUES ('" + moname + "','" + insname + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    static void namereceiver(String mname){
        name=mname;
        System.out.println(name);
    }
    void regins(String in,String pas){
        final String DB_URL = "jdbc:mysql://localhost/user";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO `users`(`username`,`password`,`usertype`) VALUES ( ?,?,\"instructor\");";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, in);
            preparedStatement.setString(2, pas);
            preparedStatement.executeUpdate();


            //1

            con.close();
            stmt.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    void creta(String moname){
        final String DB_URL = "jdbc:mysql://localhost/"+name;
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql1 = "CREATE TABLE " + moname + " ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "fname VARCHAR(200) NOT NULL,"
                    + "lname VARCHAR(200) NOT NULL,"
                    + "username VARCHAR(200) NOT NULL UNIQUE,"
                    + "marks VARCHAR(3)"
                    + ")";
            stmt.executeUpdate(sql1);



            //1

            con.close();
            stmt.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        insertmodule insertmodule=new insertmodule(null);
    }
}
