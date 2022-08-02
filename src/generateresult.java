import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class generateresult extends JDialog {
    private JPanel resultgen;
    private JButton Back;
    private JButton ok;
    private JComboBox course;
    private JComboBox year;
    private JComboBox sem;
    String aa;

    public generateresult(JFrame parent) {
            super(parent);
            setTitle("Geneterate result");
            setContentPane(resultgen);
            setMinimumSize(new Dimension(800, 500));
            setModal(true);
            setLocationRelativeTo(parent);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jcomboshow();
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String coname=String.valueOf(course.getSelectedItem());
                String y=String.valueOf(year.getSelectedItem());
                String s=String.valueOf(sem.getSelectedItem());
                if(coname.isEmpty()||y.isEmpty()||s.isEmpty()){
                    JOptionPane.showMessageDialog(generateresult.this,
                            "Fill all the boxes",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
                else{
                               resultdisplay.datareceiver(coname,y,s);
                               dispose();
                               resultdisplay.main(null);

                }
            }
        });
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                dashboardadm.main(null);
            }
        });
        setVisible(true);
    }




    public static void main(String[] args) {
        generateresult generateresult=new generateresult(null);
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
                course.addItem(aa);
            }
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
