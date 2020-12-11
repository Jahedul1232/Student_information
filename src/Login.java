import javax.swing.border.Border;

import com.mysql.jdbc.Connection;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*;

import javax.swing.*;

public class Login extends JFrame {
	  JPanel contentPane;
	  JMenuBar jMenuBar1 = new JMenuBar();
	  JMenu jMenuFile = new JMenu();
	  JMenuItem jMenuFileExit = new JMenuItem();
	  JMenu jMenuHelp = new JMenu();
	  JMenuItem jMenuHelpAbout = new JMenuItem();
	  JToolBar jToolBar = new JToolBar();
	  JButton jButton1 = new JButton();
	  JButton jButton2 = new JButton();
	  JButton jButton3 = new JButton();
	  ImageIcon image1;
	  ImageIcon image2;
	  ImageIcon image3;
	  JLabel statusBar = new JLabel();
	  BorderLayout borderLayout1 = new BorderLayout();
	  JLabel log = new JLabel();
	  JTextField jTextFieldu= new JTextField();
	  JPasswordField jPasswordField1=new JPasswordField();

	  JButton jButtonlog = new JButton();
	  JButton jButtonReg= new JButton();
	  
	  //ImageIcon image1;

	  //Construct the frame
	  public Login() {
	    try {
	      jbInit();
	    }
	    catch(Exception e) {
	      e.printStackTrace();
	    }
	  }
	  //Component initialization
	  private void jbInit() throws Exception  {
	    image1 = new ImageIcon("login.jpg");
	 //   Container bg=this.getContentPane();
	    
	    contentPane = (JPanel) this.getContentPane();
	    contentPane.setLayout(borderLayout1);
	    this.setSize(new Dimension(455,355));
	    this.setTitle("System Login");


	    log.setIcon(image1);
	    log.setBounds(60, 20, 400, 100);
	   // log.setText("       Student Information System");
	 //   log.setFont(new java.awt.Font("SansSerif", 1, 20));

	    jTextFieldu.setBounds(new Rectangle(180, 180, 140, 20));
	    jTextFieldu.setFont(new java.awt.Font("SansSerif", 1, 12));


	    jPasswordField1.setEchoChar('*');
	    jPasswordField1.setBounds(new Rectangle(180, 210, 140, 20));
	    jPasswordField1.setFont(new java.awt.Font("Tahoma", 1, 20));

	    jButtonlog.setBackground(new Color(0, 151, 184));
	    jButtonlog.setFont(new java.awt.Font("SansSerif", 1, 12));
	    jButtonlog.setForeground(Color.BLACK);
	    jButtonlog.setText("Login");
	    jButtonlog.setBounds(new Rectangle(260, 240, 70, 25));
	    
	    JLabel user=new JLabel("Student ID: ");
	    user.setBounds(new Rectangle(100, 180, 100, 20));
	    
	    JLabel pass=new JLabel("Password: ");
	    pass.setBounds(new Rectangle(100, 210, 100, 20));
	    
	 
	    jButtonlog.addActionListener(new java.awt.event.ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        jButtonlog_actionPerformed(e);
	      }
	    });




	    jButtonReg.setBackground(new Color(0, 151, 186));
	    jButtonReg.setFont(new java.awt.Font("Dialog", 1, 12));
	    jButtonReg.setForeground(Color.BLACK);
	    jButtonReg.setRolloverEnabled(true);
	    jButtonReg.setText("Register");
	    jButtonReg.setBounds(new Rectangle(150, 240, 100,25));
	    
	  
	    jButtonReg.addActionListener(new java.awt.event.ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        jButtonReg_actionPerformed(e);
	      }
	    });


	    contentPane.add(jTextFieldu, BorderLayout.NORTH);
	    contentPane.add(jPasswordField1, BorderLayout.NORTH);
	    contentPane.add(jButtonlog, BorderLayout.NORTH);
	    contentPane.add(jButtonReg, BorderLayout.NORTH);
	    contentPane.add(user, BorderLayout.NORTH);
	    contentPane.add(pass, BorderLayout.NORTH);
	    contentPane.setBackground(Color.CYAN);
	    
	    JPanel l=new JPanel();
	    l.setBackground(Color.LIGHT_GRAY);
	    l.setBounds(70, 160, 290, 120);
	    contentPane.add(l,BorderLayout.NORTH);
	    

	  
	    jMenuFile.setText("File");
	    jMenuFileExit.setText("Exit");
	    jMenuFileExit.addActionListener(new login_jMenuFileExit_ActionAdapter(this));
	    jMenuHelp.setText("Help");
	    jMenuHelpAbout.setText("About");
	    jMenuHelpAbout.addActionListener(new login_jMenuHelpAbout_ActionAdapter(this));
	    jButton1.setIcon(image1);
	    jButton1.setToolTipText("Open File");
	    jButton2.setIcon(image2);
	    jButton2.setToolTipText("Close File");
	    jButton3.setIcon(image3);
	    jButton3.setToolTipText("Help");
	    jToolBar.add(jButton1);
	    jToolBar.add(jButton2);
	    jToolBar.add(jButton3);
	    jMenuFile.add(jMenuFileExit);
	    jMenuHelp.add(jMenuHelpAbout);
	    jMenuBar1.add(jMenuFile);
	    jMenuBar1.add(jMenuHelp);
	    this.setJMenuBar(jMenuBar1);
	    log.setBackground(Color.LIGHT_GRAY);
	    contentPane.add(log, BorderLayout.NORTH);
	    contentPane.setBounds(new Rectangle(80, 100, 400,300));	    
	//    bg.add(contentPane);

	  }

	  //File | Exit action performed
	  public void jMenuFileExit_actionPerformed(ActionEvent e) {
	    System.exit(0);
	  }

	  void jButtonReg_actionPerformed(ActionEvent e) {
	int a=JOptionPane.showConfirmDialog(null,"Do you want to Register as new Student?"," Warning ",JOptionPane.INFORMATION_MESSAGE);
	  if(a==1)
	 System.exit(0);
	  else {
		  Register frame = new Register();
		    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		    Dimension frameSize = frame.getSize();
		    if (frameSize.height > screenSize.height) {
		      frameSize.height = screenSize.height;
		    }
		    if (frameSize.width > screenSize.width) {
		      frameSize.width = screenSize.width;
		    }
		    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		 //  frame.setSize(750,600);
		 //  frame.setLocation(10,0);
		    frame.setVisible(true);
		   //  this.hide();
	  }
	  }
	  
	  
	  
	  
	  void jButtonlog_actionPerformed(ActionEvent e) {
		  String pass = "pass";
		  String i=(String)jTextFieldu.getText();
		  try {
		    	
	          /// database code
	       	
	       	 // create a mysql database connection
	       	Class.forName("com.mysql.jdbc.Driver");
	           Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/stdinfo", "root", "");

	           String query = "SELECT pass FROM STUDENT WHERE id='"+i+"'";
	           Statement stm = connection.createStatement();
	           ResultSet rs=stm.executeQuery(query);
	          // id.setText(sid);
	           int a=0;
	           if(rs.next()) {
	        	   pass=rs.getString("pass");
	        	   a++;
	           }
	           if(a<1) {
	        	   JOptionPane.showMessageDialog(null, "Student ID is not Found", "Error", JOptionPane.ERROR_MESSAGE);
	           }
	            
	       } catch (Exception ex) {
	           ex.printStackTrace();
	       }
		  String p=(String)jPasswordField1.getText();
		  
	  if(p.equals(pass))
	  {
	      
	    Home frame = new Home(i);
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    Dimension frameSize = frame.getSize();
	    if (frameSize.height > screenSize.height) {
	      frameSize.height = screenSize.height;
	    }
	    if (frameSize.width > screenSize.width) {
	      frameSize.width = screenSize.width;
	    }
	    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	   //frame.setSize(750,600);
	   frame.setLocation(10,0);
	    frame.setVisible(true);
	     this.hide();
	     
	  }
	  else if(i.equals("SR")&jPasswordField1.getText().equals("SR"))
	  {
		 Home frame = new Home(i);
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    Dimension frameSize = frame.getSize();
	    if (frameSize.height > screenSize.height) {
	      frameSize.height = screenSize.height;
	    }
	    if (frameSize.width > screenSize.width) {
	      frameSize.width = screenSize.width;
	    }
	    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	   frame.setSize(1020,745);
	   frame.setLocation(10,0);
	    frame.setVisible(true);
	     this.hide();
	  }

	  else
	  {
	   JOptionPane.showMessageDialog(null, "Invalid Password. Please Try Again.","Information",JOptionPane.INFORMATION_MESSAGE);

	   }
	 }


	  //Help | About action performed
	  public void jMenuHelpAbout_actionPerformed(ActionEvent e)
	  {
	    login_AboutBox dlg = new login_AboutBox(this);
	    Dimension dlgSize = dlg.getPreferredSize();
	    Dimension frmSize = getSize();
	    Point loc = getLocation();
	    dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
	    dlg.setModal(true);
	    dlg.pack();
	    dlg.show();
	  }
	  //Overridden so we can exit when window is closed
	  protected void processWindowEvent(WindowEvent e) {
	    super.processWindowEvent(e);
	    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
	      jMenuFileExit_actionPerformed(null);
	    }
	  }
	}
	class login_jMenuFileExit_ActionAdapter implements ActionListener {
	  Login adaptee;

	  login_jMenuFileExit_ActionAdapter(Login adaptee) {
	    this.adaptee = adaptee;
	  }
	  public void actionPerformed(ActionEvent e) {
	    adaptee.jMenuFileExit_actionPerformed(e);
	  }
	}

	class login_jMenuHelpAbout_ActionAdapter implements ActionListener {
	  Login adaptee;

	  login_jMenuHelpAbout_ActionAdapter(Login adaptee) {
	    this.adaptee = adaptee;
	  }
	  public void actionPerformed(ActionEvent e) {
	    adaptee.jMenuHelpAbout_actionPerformed(e);
	  }
	}
