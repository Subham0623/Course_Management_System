import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class canclesucess extends JDialog {
    private JPanel panel1;
    private JButton closeButton;
    private JButton goToDashboardAdminButton;
    private JLabel cna;
    static String Aa;

    public canclesucess(JFrame parent) {
        super(parent);
        setTitle("Cancle course sucess");
        setContentPane(panel1);
        setMinimumSize(new Dimension(500, 400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cna.setText(Aa);
        goToDashboardAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                dashboardadm.main(null);
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
    public static void name(String a){
        Aa=a;

    }

    public static void main(String[] args) {
        canclesucess canclesucess=new canclesucess(null);
    }

}
