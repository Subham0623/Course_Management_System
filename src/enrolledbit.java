import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class enrolledbit extends JDialog{
    private JPanel successbit;
    private JButton close;

    public enrolledbit(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(successbit);
        setMinimumSize(new Dimension(800, 400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        enrolledbit enrolledbit= new enrolledbit(null);
    }
}
