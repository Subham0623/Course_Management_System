import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deletesucess extends JDialog {
    private JPanel panel1;
    private JButton ok;
    private JButton close;

    public deletesucess(JFrame parent) {
        super(parent);
        setTitle("Successfully deleted a course");
        setContentPane(panel1);
        setMinimumSize(new Dimension(400, 300));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                dashboardadm.main(null);
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

    public static void main(String[] args) {
        deletesucess deletesucess=new deletesucess(null);
    }
}
