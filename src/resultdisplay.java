import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class resultdisplay extends JDialog {
    private JPanel panel1;
    private JTable mod1;
    private JButton closeButton;
    private JButton backButton;
    private JButton confirm;
    private JTextField uname;
    static String coname,y,s;
    String tname;
    public resultdisplay(JFrame parent) {
        super(parent);
        setTitle("Display result");
        setContentPane(panel1);
        setMinimumSize(new Dimension(800, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                generateresult.main(null);
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usname= uname.getText();
                if(usname.isEmpty()){
                    JOptionPane.showMessageDialog(resultdisplay.this,
                            "username not entered",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
                else{
                    tname=coname+y+"y"+s+"s";
                    boolean ch=checker(usname);
                    if(ch==true){
                        dispose();

                        shoeresult.namereceiver(tname,usname);
                        shoeresult.main(null);
                    }
                    else{
                        JOptionPane.showMessageDialog(resultdisplay.this,
                                "Incorrect username",
                                "Try again",
                                JOptionPane.ERROR_MESSAGE);
                    }

                }

            }
        });
        setVisible(true);
    }
    protected static void datareceiver(String cname, String year, String sem){
        coname=cname;
        y=year;
        s=sem;
    }
    boolean checker(String aa){
    boolean a=false;
    final String USERNAME = "root";
    final String PASSWORD = "";
    String aaa=table();
        try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/"+tname, USERNAME, PASSWORD);
        // Connected to database successfully..
        Statement stmt = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT `username` FROM "+aaa+" WHERE username=?");
        preparedStatement.setString(1, aa);
        ResultSet resuSet = preparedStatement.executeQuery();
        if (resuSet.next()) {
            a=true;

        }

        stmt.close();
        conn.close();
    } catch(Exception e){
        e.printStackTrace();
    }
        return a;
}
    private String table(){
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/"+tname, USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();

            //Retrieving the data
            ResultSet rs = stmt.executeQuery("Show tables");
            while (rs.next()) {
                String aa=rs.getString(1);
                return aa;


            }
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
String header[]={"First name","Last name","Username"};
    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultTableModel model = new DefaultTableModel(0, 4);
        model.addRow(header);
        model.setColumnIdentifiers(header);
        mod1 = new JTable(model);
        try {
            String a = coname;
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/enroller" , "root", "");
            Statement s = c.createStatement();


            ResultSet rs = s.executeQuery("select * from " + a+"student");
            while (rs.next()) {
                Object[] row = {rs.getString("fname"), rs.getString("fname"),rs.getString("username")};
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        resultdisplay resultdisplay=new resultdisplay(null);
    }

}
