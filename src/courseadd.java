import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class courseadd extends JDialog {
    private JPanel panel1;
    private JTextField courname;
    private JButton create;
    private JButton back;

    public courseadd(JFrame parent) {
        super(parent);
        setTitle("Course add");
        setContentPane(panel1);
        setMinimumSize(new Dimension(500, 500));
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
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cname= courname.getText();
                courseinserter.name(cname);
                System.out.println(cname);
                if(cname!=null){
                    dashboardstd.admincourseinsert(cname);
                    courename(cname);
                    dispose();
                    courseinserter courseinserter=new courseinserter(null);


                }
                else{
                    JOptionPane.showMessageDialog(courseadd.this,
                            "Enter the course name",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
                }
        });
        setVisible(true);
    }
    void courename(String cname){
        course1y1s(cname);
        course1y2s(cname);
        course2y1s(cname);
        course2y2s(cname);
        course3y1s(cname);
        course3y2s(cname);

    }
    void course1y1s(String cname){
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/course","root","");
            Statement s = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS "+cname +"1y1s ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "coursename VARCHAR(200) NOT NULL,"
                    + "instructor VARCHAR(200) NOT NULL"
                    + ")";
            s.executeUpdate(sql);
            s.close();
            c.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    void course1y2s(String cname){
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/course","root","");
            Statement s = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS "+cname +"1y2s ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "coursename VARCHAR(200) NOT NULL,"
                    + "instructor VARCHAR(200) NOT NULL"
                    + ")";
            s.executeUpdate(sql);
            s.close();
            c.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    void course2y1s(String cname){
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/course","root","");
            Statement s = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS "+cname +"2y1s ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "coursename VARCHAR(200) NOT NULL,"
                    + "instructor VARCHAR(200) NOT NULL"
                    + ")";
            s.executeUpdate(sql);
            s.close();
            c.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    void course2y2s(String cname){
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/course","root","");
            Statement s = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS "+cname +"2y2s ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "coursename VARCHAR(200) NOT NULL,"
                    + "instructor VARCHAR(200) NOT NULL"
                    + ")";
            s.executeUpdate(sql);
            s.close();
            c.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    void course3y1s(String cname){
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/course","root","");
            Statement s = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS "+cname +"3y1s ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "coursename VARCHAR(200) NOT NULL,"
                    + "instructor VARCHAR(200) NOT NULL"
                    + ")";
            s.executeUpdate(sql);
            s.close();
            c.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    void course3y2s(String cname){
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/course","root","");
            Statement s = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS "+cname +"3y2s ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "coursename VARCHAR(200) NOT NULL,"
                    + "instructor VARCHAR(200) NOT NULL"
                    + ")";
            s.executeUpdate(sql);
            s.close();
            c.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        courseadd courseadd=new courseadd(null);
    }
}