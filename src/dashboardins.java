import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class dashboardins extends JDialog {

    private JPanel dashins;
    private JButton module;
    private JButton Marks;
    private JLabel tn;

static String teachername;


    public dashboardins(JFrame parent) {
        super(parent);
        setTitle("Dashboard Instructor");
        setContentPane(dashins);
        setMinimumSize(new Dimension(800, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        tn.setText(teachername);
        module.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                viewmodule.namereceive(teachername);
                viewmodule.main(null);

            }
        });

        Marks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
               selectcourseins.namereceive(teachername);
                selectcourseins.main(null);
            }
        });
        setVisible(true);

    }

    public static void main(String[] args) {
        dashboardins dashboardins=new dashboardins(null);
    }


    public static void insname(String name) {
        teachername=name;
    }
}

