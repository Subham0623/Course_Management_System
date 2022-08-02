import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class enrolledbba extends JDialog{
    private JPanel bbasucc;
    private JButton closeButton;

    public enrolledbba(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(bbasucc);
        setMinimumSize(new Dimension(800, 400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        enrolledbba enrolledbba= new enrolledbba(null);
    }
}
