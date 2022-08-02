import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class insertmarks extends JDialog {
    private JTable detail;
    private JPanel panel1;
    private JButton insert;
    private JButton backButton;
    private JTextField uname;
    private JTextField marks;
    private JButton close;
    static String sname;
    static String iname;
    static String cname;
    public insertmarks(JFrame parent) {
        super(parent);
        setTitle("Dashboard");
        setContentPane(panel1);
        setMinimumSize(new Dimension(800, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        insert.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                String mark =marks.getText();
                String username=uname.getText();
                System.out.println(mark+username);
                inserter(mark,username);
                dispose();
                insertmarks.main(null);
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                dashboardins.main(null);
            }
        });

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
public void inserter(String mark, String username){
    try {
        System.out.println(sname);
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/"+sname,"root","");
        Statement s = c.createStatement();
        String sql="UPDATE "+cname+" SET `marks`='"+mark+"' WHERE username=?";
        PreparedStatement preparedStatement = c.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.execute();
//        preparedStatement.setString(1, username);
//        s.executeUpdate(sql);
        s.close();
        c.close();



    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public static void main(String[] args) {
        insertmarks insertmarks=new insertmarks(null);
    }
    static void namereceive(String insname, String name, String coname){
        cname =name;
        iname=insname;
        sname=coname;

    }
    String head[] = {"First name", "Last name","User name","marks"};
    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultTableModel model= new DefaultTableModel(0,4);
        model.addRow(head);
        model.setColumnIdentifiers(head);
        detail = new JTable(model);
        try {
            System.out.println(sname);
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/"+sname,"root","");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select * from "+cname);
            while(rs.next()){
                Object[] row={rs.getString("fname"),rs.getString("lname"),rs.getString("username"),rs.getInt("marks")};
                if(row!=null){
                    model.addRow(row);
                }
                else{
                    System.out.println("No student");
                }



            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
