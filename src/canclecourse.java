import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class canclecourse extends JDialog {
    private JPanel cnaclecou;
    private JTextField coursename;
    private JButton cancleCourse;
    private JButton back;

    public canclecourse(JFrame parent) {
        super(parent);
        setTitle("Cancle course");
        setContentPane(cnaclecou);
        setMinimumSize(new Dimension(500, 400));
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
        cancleCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cname=coursename.getText();
                boolean a;
                a=coursechecker(cname);
                if(a==true){
                    canclec(cname);
                    dispose();
                    canclesucess.name(cname);
                    canclesucess.main(null);
                }
                else{
                    JOptionPane.showMessageDialog(canclecourse.this,
                            "Incorrect coursename",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        setVisible(true);
    }
    boolean coursechecker(String cname){
        boolean a=false;
        final String DB_URL = "jdbc:mysql://localhost/courses";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();
            String sql = "SELECT coursename FROM course WHERE coursename=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, cname);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String n=resultSet.getString("coursename");
                if(cname.equals(n)){
                    a=true;
                }

            }
            stmt.close();
            conn.close();

            }catch(Exception e){
                e.printStackTrace();
            }
        return a;
    }
    void canclec(String name){
        final String DB_URL = "jdbc:mysql://localhost/courses";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM `course` WHERE coursename=?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
           preparedStatement.execute();

            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        canclecourse canclecourse=new canclecourse(null);
    }
}
