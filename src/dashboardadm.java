import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dashboardadm extends JDialog {
    private JPanel panel1;
    private JButton addNewCourse;
    private JButton addModule;
    private JButton cancleCourse;
    private JButton deleteCourse;
    private JButton generateResult;
    private JButton close;
    private JButton editNameButton;


    public dashboardadm(JFrame parent) {
        super(parent);
        setTitle("Admin Dashboard");
        setContentPane(panel1);
        setMinimumSize(new Dimension(500, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addNewCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                courseadd.main(null);
            }
        });
        addModule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                addmodule.main(null);
            }
        });
        cancleCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canclecourse.main(null);
            }
        });
        deleteCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                deletecourse.main(null);
            }
        });
        generateResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
generateresult.main(null);
            }
        });
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        editNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
dispose();
edit.main(null

);
            }
        });
        setVisible(true);    }

    public static void main(String[] args) {
        dashboardadm dashboardadm=new dashboardadm(null);
    }

    }
