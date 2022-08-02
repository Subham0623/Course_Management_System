import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Locale;

public class selectcourseins extends JDialog {
    private JPanel panel1;
    private JButton back;
    private JButton close;
    private JButton insertMarks;
    private JComboBox coursename;
    static String iname;
    String cname;
    public selectcourseins(JFrame parent) {
        super(parent);
        setTitle("Select module");
        setContentPane(panel1);
        setMinimumSize(new Dimension(800, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jshow();
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                dashboardins.main(null);
            }
        });

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        insertMarks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name= String.valueOf(coursename.getSelectedItem());
                databasenamechecker(name);
                dispose();
                insertmarks.namereceive(iname,name,cname);
                insertmarks.main(null);
            }
        });
        setVisible(true);
    }

    private void databasenamechecker(String name) {
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            //Retrieving the data
            ResultSet rs = stmt.executeQuery("Show tables");
            while (rs.next()) {
                String aa=rs.getString(1);
                checker(aa,name);


            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
private void checker(String aa,String name){
        String na;
        final String DB_URL = "jdbc:mysql://localhost/course";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from " + aa);
            while (rs.next()) {
                na =  rs.getString("coursename");
                if(na.toLowerCase(Locale.ROOT).equals(name.toLowerCase(Locale.ROOT))){
                    cname=aa;
                }
            }

            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

}
    public static void main(String[] args) {
        selectcourseins selectcourseins=new selectcourseins(null);
    }
    static void namereceive(String insname){

        iname=insname;

    }
    protected void jshow() {
        String course;
        final String DB_URL = "jdbc:mysql://localhost/insdetail";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            //First, connect to MYSQL server and create the database if not created
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM insdet WHERE instructor=?");
            preparedStatement.setString(1, iname);
            ResultSet resuSet = preparedStatement.executeQuery();
            while(resuSet.next()){
                course = resuSet.getString("coursename");
                coursename.addItem(course);

            }
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}







