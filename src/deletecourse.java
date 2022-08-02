import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class deletecourse extends JDialog{
    private JPanel deletecou;
    private JTextField coursename;
    private JButton delete;
    private JButton back;

    public deletecourse(JFrame parent) {
        super(parent);
        setTitle("Delete course");
        setContentPane(deletecou);
        setMinimumSize(new Dimension(800, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a= coursename.getText();
                if(a.isEmpty()){
                    JOptionPane.showMessageDialog(deletecourse.this,
                            "Please enter course name",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
                else{
                    boolean b;
                    b=coursechecker(a);
                    if(b==true){
                        deletec(a);
                        deletecd(a);
                        deletecdatabase1(a);
                        deletecdatabase2(a);
                        deletecdatabase3(a);
                        deletecdatabase4(a);
                        deletecdatabase5(a);
                        deletecdatabase6(a);
                        dispose();
                        deletesucess.main(null);
                    }

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
    void deletec(String name){
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
    void deletecd(String name){
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();
            String sql = "DROP TABLE " + name+"1y1s";
           stmt.executeUpdate(sql);
            String sql1 = "DROP TABLE " + name+"1y2s";
            stmt.executeUpdate(sql1);
            String sql2 = "DROP TABLE " + name+"2y1s";
            stmt.executeUpdate(sql2);
            String sql3 = "DROP TABLE " + name+"2y2s";
            stmt.executeUpdate(sql3);
            String sql4 = "DROP TABLE " + name+"3y1s";
            stmt.executeUpdate(sql4);
            String sql5 = "DROP TABLE " + name+"3y2s";
            stmt.executeUpdate(sql5);

            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
    void deletecdatabase1(String name){
        final String DB_URL = "jdbc:mysql://localhost/"+ name+"1y1s";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();
            String sql = "DROP DATABASE " + name+"1y1s";
            stmt.executeUpdate(sql);


            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    void deletecdatabase2(String name){
        final String DB_URL = "jdbc:mysql://localhost/"+ name+"1y2s";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();
            String sql1 = "DROP DATABASE " + name+"1y2s";
            stmt.executeUpdate(sql1);
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    void deletecdatabase3(String name){
        final String DB_URL = "jdbc:mysql://localhost/"+ name+"2y1s";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();
            String sql2 = "DROP DATABASE " + name+"2y1s";
            stmt.executeUpdate(sql2);
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    void deletecdatabase4(String name){
        final String DB_URL = "jdbc:mysql://localhost/"+ name+"2y2s";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();
            String sql3 = "DROP DATABASE " + name+"2y2s";
            stmt.executeUpdate(sql3);
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    void deletecdatabase5(String name){
        final String DB_URL = "jdbc:mysql://localhost/"+ name+"3y1s";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();
            String sql4 = "DROP DATABASE " + name+"3y1s";
            stmt.executeUpdate(sql4);
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    void deletecdatabase6(String name){
        final String DB_URL = "jdbc:mysql://localhost/"+ name+"3y2s";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();
            String sql5 = "DROP DATABASE " + name+"3y2s";
            stmt.executeUpdate(sql5);
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        deletecourse deletecourse = new deletecourse(null);
    }
}
