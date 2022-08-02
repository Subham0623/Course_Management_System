import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class edit extends JDialog {
    private JPanel panel1;
    private JComboBox module;
    private JComboBox year;
    private JComboBox sem;
    private JButton doneButton;
    private JButton back;
    String aa;


    public edit(JFrame parent) {
        super(parent);
        setTitle("Edit instructor");
        setContentPane(panel1);
        setMinimumSize(new Dimension(800, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jcomboshow();
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String coname=String.valueOf(module.getSelectedItem());
                String y=String.valueOf(year.getSelectedItem());
                String s=String.valueOf(sem.getSelectedItem());
                dispose();
                displayins.datareceiver(coname,y,s);
                dispose();
                displayins.main(null);


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
    protected void jcomboshow() {
        final String DB_URL = "jdbc:mysql://localhost/courses";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("select coursename from course");
            while (resultSet.next()) {
                aa = resultSet.getString(1);
                module.addItem(aa);
            }
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        edit edit=new edit(null);
    }
}
