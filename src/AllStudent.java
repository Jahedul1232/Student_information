import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.oracle.jdbc.Connection;

import javax.swing.*;

public class AllStudent extends JFrame implements ActionListener {

	JFrame frame1;
    JLabel l0, l1, l2;
    JComboBox c1;
    JButton b1;
    Connection con;
    ResultSet rs, rs1;
    Statement st, st1;
    PreparedStatement pst;
    String ids;
    
    static JTable table;
    String[] columnNames = {"ID", "Student Name", "CGPA", "Email"};
    String from;

    AllStudent() {
       l0 = new JLabel("Fatching Student Information");
        l0.setForeground(Color.red);
        l0.setFont(new Font("Serif", Font.BOLD, 20));
        l1 = new JLabel("Select ID: ");
        b1 = new JButton("submit");
       l0.setBounds(100, 50, 350, 40);
        l1.setBounds(75, 110, 100, 20);
        b1.setBounds(150, 150, 150, 20);
        b1.addActionListener(this);

        setTitle("Fetching Student Info From DataBase");
        setLayout(null);
        setVisible(true);
        setSize(500, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(l0);
        add(l1);;
        add(b1);
      //  showTableData();
        try {

/*          Oracle Database
 *************************************************************
        	Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@mcndesktop07:1521:xe", "sandeep", "welcome");
            st = con.createStatement();
            rs = st.executeQuery("select uname from emp");
            */
        	
        	 // create a mysql database connection
        	Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/stdinfo", "root", "");
            String query = "SELECT id,name,cgpa,email FROM STUDENT";
            Statement stm = connection.createStatement();
            ResultSet rs=stm.executeQuery(query);
            
            

            Vector v = new Vector();
            while (rs.next()) {
                ids = rs.getString(1);
                v.add(ids);
            }
            v.add("All");
            c1 = new JComboBox(v);
            c1.setBounds(150, 110, 150, 20);
            add(c1);
            st.close();
            rs.close();

        } catch (Exception e) {

        }
    }

 

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource()==b1) {
            showTableData();
        }
    }

    public void showTableData() {

        frame1 = new JFrame("Database Search Result");
      //  frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());

//TableModel tm = new TableModel();

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());

//table = new JTable(model);

        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        from = (String) c1.getSelectedItem();

//String textvalue = textbox.getText();

        String uname = "";
        String email = "";
        String pass = "";
        String cou = "";

        try {

           // pst = con.prepareStatement("SELECT id,name,cgpa,email FROM STUDENT WHERE id='"+from+"'");
        	//pst = con.prepareStatement("SELECT id,name,cgpa,email FROM STUDENT");
           //  ResultSet rs = pst.executeQuery();
        	//System.out.println(from);
        	Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:oracle://localhost/stdinfo", "system", "123456789");
            if(from.equals("All")) {
            	String query = "SELECT id,name,cgpa,email FROM STUDENT";
                Statement stm = connection.createStatement();
                ResultSet rs=stm.executeQuery(query);
                int i = 0;
                while(rs.next()) {
                	uname = rs.getString("id");
                    email = rs.getString("name");
                    //pass = rs.getString("cgpa");
                    String c=String.valueOf(rs.getFloat("cgpa"));
                    pass=c;
                    cou = rs.getString("email");
                    model.addRow(new Object[]{uname, email, pass, cou});
                    i++;
               // JOptionPane.showMessageDialog(rootPane, "Found !!!");
                }           	
            }
            else {
            String query = "SELECT id,name,cgpa,email FROM STUDENT WHERE id='"+from+"'";
            Statement stm = connection.createStatement();
            ResultSet rs=stm.executeQuery(query);
            int i = 0;
            if(rs.next()) {
            	uname = rs.getString("id");
                email = rs.getString("name");
                //pass = rs.getString("cgpa");
                String c=String.valueOf(rs.getFloat("cgpa"));
                pass=c;
                cou = rs.getString("email");
                model.addRow(new Object[]{uname, email, pass, cou});
                i++;
           // JOptionPane.showMessageDialog(rootPane, "Found !!!");
            }
            else {
            	JOptionPane.showMessageDialog(null, "Some Error Occured", "Error", JOptionPane.ERROR_MESSAGE);
 	           
            }
            }

        } catch (Exception ex) {
        	
        	ex.printStackTrace();

          //  JOptionPane.showMessageDialog(null, ex.getMessage()+"Error", "Error", JOptionPane.ERROR_MESSAGE);
        }

        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(700, 200);
        frame1.setLocation(300, 250);

    }
}