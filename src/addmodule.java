import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class addmodule extends JDialog {
    private JPanel panel1;
    private JTextField coursename;
    private JTextField year;
    private JTextField semester;
    private JButton ok;
    private JButton back;
    String name;
    public addmodule(JFrame parent) {
        super(parent);
        setTitle("Add module");
        setContentPane(panel1);
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
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cn = coursename.getText();
                String ye = year.getText();
                String se = semester.getText();
                boolean a = coursechecker(cn);
                if (a == true) {
                    if (ye.equals("1") || ye.equals("2") || ye.equals("3")) {
                        if (se.equals("1") || se.equals("2")) {
                            namecombine(cn,ye,se);
                            insertmodule.namereceiver(name);
                            insertmodule.main(null);

                        } else {
                            JOptionPane.showMessageDialog(addmodule.this,
                                    "Incorrect semester",
                                    "Try again",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(addmodule.this,
                                "Incorrect year",
                                "Try again",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(addmodule.this,
                            "Incorrect course name",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        setVisible(true);
    }

    boolean coursechecker(String cn) {
        boolean a = false;
        final String DB_URL = "jdbc:mysql://localhost/courses";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM course WHERE coursename=? ";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, cn);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String n = resultSet.getString("coursename");
                if (cn.equals(n)) {
                    a = true;
                }

            }

            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }



    public static void main(String[] args) {
        addmodule addmodule=new addmodule(null);
    }
    void namecombine(String cn, String ye, String se){
        name =cn+ye+"y"+se+"s";
    }
}
