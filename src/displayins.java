import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Locale;

public class displayins extends JDialog{
    private JPanel panel1;
    private JTable table1;
    private JTextField oldname;
    private JTextField newname;
    private JButton done;
    private JButton Close;
    private JButton back;
    private JLabel coursename;
    static String coname,y,s;
    String ca;
    public displayins(JFrame parent) {
        super(parent);
        setTitle("Edit instructor");
        setContentPane(panel1);
        setMinimumSize(new Dimension(800, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ca=coname+y+"y"+s+"s";
        createUIComponents();
        coursename.setText(ca);
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String oname=oldname.getText();
            String nname=newname.getText();
            if(oname.isEmpty()||nname.isEmpty()){
                JOptionPane.showMessageDialog(displayins.this,
                        "You forgot to fill somewhere",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
            }
            else{
                String che=checker(oname);
                if(che!=null){
                    change(oname,nname);
                    dispose();
                    displayins.main(null);
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
        Close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
    protected static void datareceiver(String cname, String year, String sem){
        coname=cname;
        y=year;
        s=sem;

    }

    public static void main(String[] args) {
        displayins displayins=new displayins(null);
    }
    String header[]={"MODULE NAME","INSTROUCTOR NAME"};
    private void createUIComponents() {
        ca=coname+y+"y"+s+"s";

        // TODO: place custom component creation code here
        DefaultTableModel model = new DefaultTableModel(0, 2);
        model.addRow(header);
        model.setColumnIdentifiers(header);
        table1 = new JTable(model);
        try {

            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/course" , "root", "");
            Statement s = c.createStatement();


            ResultSet rs = s.executeQuery("select * from " + ca);
            while (rs.next()) {
                Object[] row = {rs.getString("coursename"), rs.getString("instructor")};
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String checker(String nname){
        String ca=coname+y+"y"+s+"s";

    final String USERNAME = "root";
    final String PASSWORD = "";
        try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/course", USERNAME, PASSWORD);
        // Connected to database successfully..
        Statement stmt = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT `instructor` FROM "+ ca +" WHERE instructor= ?");
        preparedStatement.setString(1, nname);
        ResultSet resuSet = preparedStatement.executeQuery();

        if (resuSet.next()) {

           String name = resuSet.getString("instructor");
            if(name!=null){
                if(name.toLowerCase(Locale.ROOT).equals(nname)){
                   return "ok";
                }
            }
        }

        stmt.close();
        conn.close();
    } catch(Exception e){
        e.printStackTrace();
    }
        return null;
}
    void change(String olname,String nename){
        String ca=coname+y+"y"+s+"s";

        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/course", USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();
            String sql="UPDATE " + ca + " SET instructor= ? WHERE instructor= ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nename);
            preparedStatement.setString(2, olname);
            preparedStatement.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
