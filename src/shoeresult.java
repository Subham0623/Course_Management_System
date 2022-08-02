import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class shoeresult extends JDialog {
    private JPanel panel1;
    private JTable table1;
    private JButton doneButton;
    private JButton closeButton;
    private JLabel mar;
    private JLabel pa;
    static String cname, mname;
    int fail=0;
    double ma = 0;

    public shoeresult(JFrame parent) {
        super(parent);
        setTitle("Display result");
        setContentPane(panel1);
        setMinimumSize(new Dimension(800, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        credatabases();
        table();
        createUIComponents();
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
dispose();
dashboardadm.main(null);
            }
        });
        setVisible(true);
    }
static void namereceiver(String a,String b){
cname=a;

mname=b;

}
    public static void main(String[] args) {
        shoeresult shoeresult=new shoeresult(null);
    }
    String header[]={"Username","Module name","Marks"};
    private void createUIComponents() {
        // TODO: place custom component creation code here
        credatabases();
        table();
        DefaultTableModel model = new DefaultTableModel(0, 4);
        model.addRow(header);
        model.setColumnIdentifiers(header);
        table1 = new JTable(model);
        try {

            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/result" , "root", "");
            Statement s = c.createStatement();

            ResultSet rs = s.executeQuery("select * from " + cname+"result" );
            while (rs.next()) {
                Object[] row = {rs.getString("username"),rs.getString("modulename"),rs.getString("marks")};
                model.addRow(row);
                String a=rs.getString("username");




            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        deletecdatabase();
    }
    private String table(){
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/"+cname, USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();

            //Retrieving the data
            ResultSet rs = stmt.executeQuery("Show tables");
            while (rs.next()) {
                String aa=rs.getString(1);
storer(aa);


            }
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private String storer(String a) {
        double m = 0;
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/" +cname, USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM " + a +" WHERE username=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, mname);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                String mark = resultSet.getString("marks");
                if(mark==null){
                    mark="0";

                    double i=Double.parseDouble(mark);
                            m=m+i;

                    store(a, mark);
                }
                else {

                    double i=Double.parseDouble(mark);
                    m=m+i;

                    store(a, mark);
                }
                double ch=Double.parseDouble(mark);
                if(ch<40){
                    fail++;
                }
                if(fail>0){
                    if(pa!=null) {
                        pa.setText("Fail");
                    }
                }
                else if(fail==0){
                    if(pa!=null) {
                        pa.setText("Pass");
                    }

                }
                m=m/3;
                ma+=m;
                if(mar!=null){
                    String s=String.valueOf(ma/3);
                    mar.setText(s);
            }
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private void store(String a,String b){
        credatabases();
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/result", USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO "+cname+"result (`username`, `modulename`, `marks`) VALUES ('" + mname + "','" + a + "','" + b + "');";
            stmt.executeUpdate(sql);


            stmt.close();
            conn.close();

        } catch(Exception e){
            e.printStackTrace();
        }

    }
    private void credatabases(){
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/result";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS result");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS "+cname+"result ("
                    + "id INT( 100 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "username VARCHAR(200) NOT NULL,"
                    + "modulename VARCHAR(200) NOT NULL,"
                    + "marks VARCHAR(10) "
                    + ")";
            statement.executeUpdate(sql);
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void deletecdatabase() {
        final String DB_URL = "jdbc:mysql://localhost/result";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();
            String sql2 = "DROP TABLE " + cname + "result";
            stmt.executeUpdate(sql2);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

