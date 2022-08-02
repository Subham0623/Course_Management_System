import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class welcome extends JDialog{
    private JPanel panel1;
    private JButton next;

    public welcome(JFrame parent)  {
            super(parent);
            setTitle("Login");
            setContentPane(panel1);
            setMinimumSize(new Dimension(800, 500));
            setModal(true);
            setLocationRelativeTo(parent);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin.checker();
                instructorname instructorname = new instructorname();
                boolean ab = instructorname.createdatabase();
                BBA.creater();
                BIT.creater();
                boolean a;
                if(ab==false){
                    instructorname.insterdatabase();
                }
                a =dashboardstd.createcourse();
                if (a==false){
                    dashboardstd.courseinsert();
                }

                dispose();
                login login=new login(null);
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        welcome welcome=new welcome(null);
    }
}
