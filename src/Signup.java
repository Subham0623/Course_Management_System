import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Signup extends JDialog {
    private JTextField fname;
    private JTextField lname;
    private JTextField uname;
    private JPasswordField pass;
    private JTextField email;
    private JButton signup;
    private JComboBox gender;
    private JPanel signupPanel;
    private JButton backButton;

    public Signup(JFrame parent) {
        super(parent);
        setTitle("Create a new account");
        setContentPane(signupPanel);
        setMinimumSize(new Dimension(800, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registeruser();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                login.main(null);
            }
        });
        setVisible(true);
    }

    private void registeruser(){
            String finame = fname.getText();
            String laname = lname.getText();
            String gen = String.valueOf(gender.getSelectedItem());
            String mail = email.getText();
            String usname = uname.getText();
            String password = String.valueOf(pass.getPassword());
        if (finame.isEmpty() || laname.isEmpty() || mail.isEmpty() || usname.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter all fields",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

            user = register(finame, laname, gen, mail, usname, password);
            if (user != null) {

                dispose();
                login.main(null);
            } else {
                JOptionPane.showMessageDialog(Signup.this, "Failed to register new user", "Try again", JOptionPane.ERROR_MESSAGE);
            }
        }

    public User user;
    private User register(String finame, String laname, String gen, String mail, String usname, String password){
        final String DB_URL = "jdbc:mysql://localhost/student?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO `users`(`fname`, `lname`,`gender`, `email`,`username`,`password`,`usertype`) VALUES (?, ?, ?, ?, ?,?,\"student\");";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, finame);
            preparedStatement.setString(2, laname);
            preparedStatement.setString(3, gen);
            preparedStatement.setString(4, mail);
            preparedStatement.setString(5, usname);
            preparedStatement.setString(6, password);
            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0) {
                user = new User();
                user.name = finame;
                user.lname = laname;
                user.mail = mail;
                user.pass = password;
            }

            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return user;

    }

    public static void main(String[] args) {


        Signup Signup=new Signup(null);
        User user = Signup.user;
        if (user != null) {
            System.out.println("Successful registration of: " + user.name);

        }
        else {
            System.out.println("Registration canceled");
        }



}
}
