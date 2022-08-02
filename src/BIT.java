import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Locale;

public class BIT extends JDialog {
    private JPanel BITen;
    private JTable threetwo;
    private JTable threeone;
    private JTable twotwo;
    private JTable twoone;
    private JTable onetwo;
    private JTable oneone;
    private JTextField uname;
    private JButton enrollButton;
    private JButton backButton;
    private JCheckBox sub1;
    private JCheckBox sub2;
    private JLabel ins1;
    private JLabel ins2;
    private JCheckBox sub3;
    private JCheckBox sub4;
    private JLabel ins3;
    private JLabel ins4;


    private JButton enroll;
    private JButton back;

    public BIT(JFrame parent) {
        super(parent);
        setTitle("Courses of BIT");
        setContentPane(BITen);
        setMinimumSize(new Dimension(900, 650));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        createUIComponents();


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                dashboardstd dashboardstd = new dashboardstd(null);
            }
        });
        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean a = sub1.isSelected();
                boolean b = sub2.isSelected();
                boolean c = sub3.isSelected();
                boolean d = sub4.isSelected();
                boolean ans = che();
                System.out.println(ans);
                if (ans == false) {
                if (a == true && b == true || c == true && d == true) {
                    JOptionPane.showMessageDialog(BIT.this,
                            "please choose only courses",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);

                } else {
                    String usname = uname.getText();
                    user = checker(usname);
                    String  en = checker();

                    if (user != null) {

                            if (a == true || b == true && c == true || d == true) {


                                if (a == true) {
                                    String s2 = sub2.getText();
                                    if (c == true) {
                                        String s4 = sub4.getText();

                                        enrolle(user.name, user.lname, user.uname, s2, s4);

                                        dispose();
                                        enrolledbit enrolledbit = new enrolledbit(null);


                                    } else {
                                        String s3 = sub3.getText();

                                        enrolle(user.name, user.lname, user.uname, s2, s3);

                                        dispose();
                                        enrolledbit enrolledbit = new enrolledbit(null);


                                    }
                                }


                                if (b == true) {
                                    String s1 = sub1.getText();
                                    if (c == true) {
                                        String s4 = sub4.getText();

                                        enrolle(user.name, user.lname, user.uname, s1, s4);

                                        dispose();
                                        enrolledbit enrolledbit = new enrolledbit(null);


                                    } else {
                                        String s3 = sub3.getText();

                                        enrolle(user.name, user.lname, user.uname, s1, s3);

                                        dispose();
                                        enrolledbit enrolledbit = new enrolledbit(null);


                                    }

                                }
                            } else {
                                JOptionPane.showMessageDialog(BIT.this,
                                        "please choose courses",
                                        "Try again",
                                        JOptionPane.ERROR_MESSAGE);
                            }


                    } else {
                        JOptionPane.showMessageDialog(BIT.this,
                                "Incorrect user name",
                                "Try again",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
                }else {
                    JOptionPane.showMessageDialog(BIT.this,
                            "Already enrolled",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        setVisible(true);
        }
    boolean che(){
        final String USERNAME = "root";
        final String PASSWORD = "";
        boolean a=false;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bit1y1s", USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();

            //Retrieving the data
            ResultSet rs = stmt.executeQuery("Show tables");
            while (rs.next()) {
                String aa=rs.getString(1);
                a =chec(aa);

            }
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return a;
    }
    boolean chec(String aa){
        boolean a=false;
        String usname = uname.getText();
        System.out.println(aa);
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bit1y1s", USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();


            PreparedStatement preparedStatement = conn.prepareStatement("SELECT `username` FROM "+aa);

            ResultSet resuSet = preparedStatement.executeQuery();

            if (resuSet.next()) {
                user = new User();
                user.cname = resuSet.getString("username");
            }
            if(user.cname!=null){
            if(user.cname.equals(usname)){
                a=true;
            }
            }
            stmt.close();
            conn.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }
    public User user;
    private User checker(String usename){
        User user = null;


        final String USERNAME = "root";
        final String PASSWORD = "";
        try{

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/student", USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE username=? ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, usename);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.uname = resultSet.getString("username");
user.lname=resultSet.getString("lname");
                user.name=resultSet.getString("fname");
            }

            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }


        return user;
    }
    private String checker(){
        String a = null;
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/enroller", USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM student WHERE username=? ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                a="apple";
            }

            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }


        return a;
    }
    boolean store1(String b,String fname,String lname,String uname){
        boolean a = true;
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bit1y1s", USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();

                String sql = "INSERT INTO " + b + "(`fname`, `lname`, `username`) VALUES ('" + fname + "','" + lname + "','" + uname + "');";
                stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }
    void store2(String b,String fname,String lname,String uname){
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bit1y2s", USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();
            String sql= "INSERT INTO "+b+"(`fname`, `lname`, `username`) VALUES ('"+fname+"','"+lname+"','"+uname+"');";
            stmt.executeUpdate(sql);
            storer storer=new storer();
            storer.newdata(fname,lname,uname,"bit");
            stmt.close();
            conn.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    void store3(String b,String fname,String lname,String uname){
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bit2y1s", USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();
            String sql= "INSERT INTO "+b+"(`fname`, `lname`, `username`) VALUES ('"+fname+"','"+lname+"','"+uname+"');";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    void store4(String b,String fname,String lname,String uname){
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bit2y2s", USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();
            String sql= "INSERT INTO "+b+"(`fname`, `lname`, `username`) VALUES ('"+fname+"','"+lname+"','"+uname+"');";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    void store5(String b,String fname,String lname,String uname){
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bit3y1s", USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();
            String sql= "INSERT INTO "+b+"(`fname`, `lname`, `username`) VALUES ('"+fname+"','"+lname+"','"+uname+"');";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    void store6(String b,String fname,String lname,String uname){
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bit3y2s", USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();
            String sql= "INSERT INTO "+b+"(`fname`, `lname`, `username`) VALUES ('"+fname+"','"+lname+"','"+uname+"');";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    private void en1y1s(String fname,String lname,String uname){
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bit1y1s", USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();

            //Retrieving the data
            ResultSet rs = stmt.executeQuery("Show tables");
            while (rs.next()) {
               String aa=rs.getString(1);
//               if(aa!=)
                store1(aa,fname,lname,uname);
            }
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    private void en1y2s(String fname,String lname,String uname){
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bit1y2s", USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();

            //Retrieving the data
            ResultSet rs = stmt.executeQuery("Show tables");

            while (rs.next()) {
                String aa=rs.getString(1);
                store2(aa,fname,lname,uname);
            }
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    private void en2y1s(String fname,String lname,String uname){
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bit2y1s", USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();

            //Retrieving the data
            ResultSet rs = stmt.executeQuery("Show tables");

            while (rs.next()) {
                String aa=rs.getString(1);
                store3(aa,fname,lname,uname);
            }
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    private void en2y2s(String fname,String lname,String uname){
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bit2y2s", USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();

            //Retrieving the data
            ResultSet rs = stmt.executeQuery("Show tables");

            while (rs.next()) {
                String aa=rs.getString(1);
                store4(aa,fname,lname,uname);
            }
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    private void en3y1s(String fname,String lname,String uname,String sub){
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bit3y1s", USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();

            //Retrieving the data
            ResultSet rs = stmt.executeQuery("Show tables");

            while (rs.next()) {
                String aa=rs.getString(1);
                if(aa.equals(sub.toLowerCase(Locale.ROOT))) {

                }
                else{

                    store5(aa, fname, lname, uname);
                }
            }
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    private void en3y2s(String fname,String lname,String uname,String sub){
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bit3y2s", USERNAME, PASSWORD);
            // Connected to database successfully..
            Statement stmt = conn.createStatement();

            //Retrieving the data
            ResultSet rs = stmt.executeQuery("Show tables");

            while (rs.next()) {
                String aa=rs.getString(1);
                if(aa.equals(sub.toLowerCase(Locale.ROOT))) {

                }
                else{
                    store6(aa, fname, lname, uname);
                }
            }
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    private void enrolle(String fname,String lname,String uname,String su1,String su2){

            en1y1s(fname, lname, uname);
            en1y2s(fname, lname, uname);
            en2y1s(fname, lname, uname);
            en2y2s(fname, lname, uname);
            en3y1s(fname, lname, uname,su1);
            en3y2s(fname, lname, uname,su2);

    }
    String header[] = {"COURSE", "INSTRUCTOR"};

    public static void main(String[] args) {
        BIT BIT = new BIT(null);
BIT.createUIComponents( );
    }

    private void createUIComponents( ) {
        // TODO: place custom component creation code here
        //11
        DefaultTableModel model= new DefaultTableModel(0,3);
        model.addRow(header);
        model.setColumnIdentifiers(header);
        oneone = new JTable(model);
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/course","root","");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select * from bit1y1s");
            while(rs.next()){
                Object[] row={rs.getString("coursename"),rs.getString("instructor")};
                model.addRow(row);
                String cname=rs.getString("coursename");
                bitcreatedatabase.create11(cname);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //12
         DefaultTableModel model0 = new DefaultTableModel(0, 3);
        model0.addRow(header);
        model0.setColumnIdentifiers(header);
        onetwo = new JTable(model0);
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/course", "root", "");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select * from bit1y2s");
            while (rs.next()) {
                Object[] row = {rs.getString("coursename"), rs.getString("instructor")};
                model0.addRow(row);
                String cname=rs.getString("coursename");
                bitcreatedatabase.create12(cname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //21
        DefaultTableModel model1 = new DefaultTableModel(0, 3);
        model1.addRow(header);
        model1.setColumnIdentifiers(header);
        twoone = new JTable(model1);
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/course", "root", "");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select * from bit2y1s");
            while (rs.next()) {
                Object[] row = {rs.getString("coursename"), rs.getString("instructor")};
                model1.addRow(row);
                String cname=rs.getString("coursename");
                bitcreatedatabase.create21(cname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //22
        DefaultTableModel model2 = new DefaultTableModel(0, 3);
        model2.addRow(header);
        model2.setColumnIdentifiers(header);
        twotwo = new JTable(model2);
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/course", "root", "");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select * from bit2y2s");
            while (rs.next()) {
                Object[] row = {rs.getString("coursename"), rs.getString("instructor")};
                model2.addRow(row);
                String cname=rs.getString("coursename");
                bitcreatedatabase.create22(cname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //31
        DefaultTableModel model3 = new DefaultTableModel(0, 3);
        model3.addRow(header);
        model3.setColumnIdentifiers(header);
        threeone = new JTable(model3);
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/course", "root", "");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select * from bit3y1s");
            while (rs.next()) {
                Object[] row = {rs.getString("coursename"), rs.getString("instructor")};
                String r=rs.getString("coursename");
                String in=rs.getString("instructor");
                int i=rs.getInt("id");
                if(i<=2){
                    model3.addRow(row);
                }
                else if(i==3){

                    if(sub1 !=null){
                        sub1.setText(r);
                        ins1.setText(in);
                    }
                }
                else if(i==4){

                    if(sub2 !=null){
                        sub2.setText(r);
                        ins2.setText(in);
                    }
                }


                String cname=rs.getString("coursename");

                bitcreatedatabase.create31(cname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //32
        DefaultTableModel model4 = new DefaultTableModel(0, 3);
        model4.addRow(header);
        model4.setColumnIdentifiers(header);
        threetwo = new JTable(model4);
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/course", "root", "");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select * from bit3y2s");
            while (rs.next()) {
                Object[] row = {rs.getString("coursename"), rs.getString("instructor")};
                String cname=rs.getString("coursename");
                bitcreatedatabase.create32(cname);
                String ro=rs.getString("coursename");
                String ina=rs.getString("instructor");
                int i=rs.getInt("id");
                if(i<=2){
                    model4.addRow(row);
                }
                else if(i==3){

                    if(sub3 !=null){
                        sub3.setText(ro);
                        ins3.setText(ina);
                    }
                }
                else if(i==4){
                    if(sub4 !=null){
                        sub4.setText(ro);
                        ins4.setText(ina);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void creater(){
        boolean a= coursecreate.BITcourse1y1sem();
        boolean b= coursecreate.BITcourse1y2sem();
        boolean c= coursecreate.BITcourse2y1sem();
        boolean d= coursecreate.BITcourse2y2sem();
        boolean ea= coursecreate.BITcourse3y1sem();
        boolean f= coursecreate.BITcourse3y2sem();
        System.out.println(a);
        course.bitachecker(a);
        course.bitbchecker(b);
        course.bitcchecker(c);
        course.bitdchecker(d);
        course.biteachecker(ea);
        course.bitfchecker(f);
    }
}