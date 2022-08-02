import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admincc extends JDialog {
    private JPanel panel1;
    private JButton closeButton;
    private JButton goToAdminPageButton;

    public admincc(JFrame parent) {
        super(parent);
        setTitle("Successfully added a new course");
        setContentPane(panel1);
        setMinimumSize(new Dimension(500, 300));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        goToAdminPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                dashboardadm.main(null);
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        admincc admincc=new admincc(null);
    }
}
