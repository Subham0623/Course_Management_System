import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class extraclasssuccess extends JDialog {
    private JPanel panel1;
    private JLabel courname;
    private JButton closeButton;
static String name;
    public extraclasssuccess(JFrame parent) {
        super(parent);
        setTitle("Courses");
        setContentPane(panel1);
        setMinimumSize(new Dimension(1200, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        courname.setText(name);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
    static void namecatcher(String a){
        name=a;
    }

    public static void main(String[] args) {
        extraclasssuccess extraclasssuccess=new extraclasssuccess(null);
    }
}
