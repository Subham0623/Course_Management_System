import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends JDialog {
    private JTextField username;
    private JPasswordField password;
    private JButton logIn;
    private JButton signUp;
    private JComboBox utype;
    private JPanel loginPanel;


    public login(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(800, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String uname = username.getText();
                String pass = String.valueOf(password.getPassword());
                String us= String.valueOf(utype.getSelectedItem());
                user =  getAuthenticatedUser(uname, pass,us);
                if (user != null) {
                    dispose();

                    if(user.utype.toUpperCase().equals("STUDENT")){
                        dashboardstd dashboardstd=new dashboardstd(null);

                    }
                    else if(user.utype.toUpperCase().equals("INSTRUCTOR")){
                        dashboardins.insname(user.name);
                        dashboardins dashboardins=new dashboardins(null);
                    }
                    else{
                        dashboardadm dashboardadm=new dashboardadm(null);
                    }

                } else {
                    JOptionPane.showMessageDialog(login.this,
                            "Email or Password Invalid",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                student.crea();
                Signup Signup = new Signup(null);

            }
        });
        setVisible(true);
    }

    public User user;

        private User getAuthenticatedUser(String uname, String pass, String us) {

            User user = null;

            final String DB_URL = "jdbc:mysql://localhost/user";
            final String USERNAME = "root";
            final String PASSWORD = "";

            student.crea();

            if (us.toUpperCase().equals("ADMIN") || us.toUpperCase().equals("INSTRUCTOR")) {

                try {

                    Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                    // Connected to database successfully..
                    Statement stmt = conn.createStatement();
                    String sql = "SELECT * FROM users WHERE username=? AND password=? AND usertype=?";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, uname);
                    preparedStatement.setString(2, pass);
                    preparedStatement.setString(3, us);


                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        user = new User();
                        user.name = resultSet.getString("username");
                        user.utype = resultSet.getString("usertype");
                        user.pass = resultSet.getString("password");

                    }

                    stmt.close();
                    conn.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {

                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/student", USERNAME, PASSWORD);
                    // Connected to database successfully..
                    Statement stmt = conn.createStatement();

                    String sql = "SELECT * FROM users WHERE username=? AND password=? AND usertype=?";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, uname);
                    preparedStatement.setString(2, pass);
                    preparedStatement.setString(3, us);


                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        user = new User();
                        user.name
                                = resultSet.getString("username");
                        user.utype = resultSet.getString("usertype");
                        user.pass = resultSet.getString("password");
                    }


                    stmt.close();
                    conn.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            return user;
        }


    public static void main(String[] args) {

        login login=new login(null);

        User user = login.user;


        if (user != null) {


        }
        else {
            System.out.println("Authentication canceled");
        }
    }
}





