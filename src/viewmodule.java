import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Locale;

public class viewmodule  extends JDialog{
    private JPanel panel1;
    private JButton back;
    private JButton close;
    private JButton insertMarks;
    private JTable inscourses;

    static String iname;
    public viewmodule(JFrame parent) {
        super(parent);
        setTitle("View module");
        setContentPane(panel1);
        setMinimumSize(new Dimension(800, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        createUIComponents();
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
dispose();
            }
        });
        insertMarks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
                selectcourseins.namereceive(iname);
                selectcourseins.main(null);
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        viewmodule viewmodule=new viewmodule(null);
    }
static void namereceive(String insname){

    iname=insname;

}
    String header[] = {"COURSE", "INSTRUCTOR"};

    private void createUIComponents() {
        // TODO: place custom component creation code here

        DefaultTableModel model= new DefaultTableModel(0,3);
        model.addRow(header);
        model.setColumnIdentifiers(header);
        inscourses = new JTable(model);
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/insdetail","root","");
            Statement s = c.createStatement();
            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM insdet WHERE instructor=?");
            preparedStatement.setString(1, iname);
            ResultSet resuSet = preparedStatement.executeQuery();
            while(resuSet.next()){
                Object[] row={resuSet.getString("coursename"),resuSet.getString("instructor")};
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

}
}
