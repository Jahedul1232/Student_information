import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Register extends JFrame {
	
	JLabel jLabel1=new JLabel("Student Info: Registration");
	JLabel idl=new JLabel("ID: ");
	JLabel namel=new JLabel("Name:  ");
	JLabel cgpal=new JLabel("CGPA: ");
	JLabel emaill=new JLabel("Email: ");
	JLabel passl=new JLabel("Password: ");
	String t="                                              ";
	
	JTextField id=new JTextField();
	JTextField name=new JTextField();
	JTextField cgpa=new JTextField();
	JTextField email=new JTextField(t);
	JPasswordField pass=new JPasswordField("");
	JPanel jPanel1=new JPanel();
	
       public Register() {
		// TODO Auto-generated constructor stub
    	   try {
    		      jbInit();
    		    }
    		    catch(Exception e) {
    		      e.printStackTrace();
    		 }
	}

	private void jbInit() {
		// TODO Auto-generated method stub
		
		
		id.setFont(new java.awt.Font("Dialog", 1, 14));
		//id.setBounds(new Rectangle(100, 50));
		name.setFont(new java.awt.Font("Dialog", 1, 14));
		cgpa.setFont(new java.awt.Font("Dialog", 1, 14));
		email.setFont(new java.awt.Font("Dialog", 1, 14));
		
		JButton jButtonReg=new JButton("Register");
		//jButtonReg.setText("Register");
		jButtonReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jButtonRegActionPerformed(evt);
            }
        });
		
		JPanel stdinfo=new JPanel();
		//stdinfo.setBackground(Color.red);
		
		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255), 4));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Register Student");
		
		/*
		
		stdinfo.setLayout(new GridLayout(3, 2));
		
		//stdinfo.add(heading);
		stdinfo.add(id);
		stdinfo.add(name);
		stdinfo.add(cgpa);
		stdinfo.add(email);
		
		stdinfo.add(idl);
		stdinfo.add(namel);
		stdinfo.add(cgpal);
		stdinfo.add(emaill);
		
		*/
		
		javax.swing.GroupLayout stdinfoLayout = new javax.swing.GroupLayout(stdinfo);
		stdinfo.setLayout(stdinfoLayout);
		stdinfoLayout.setHorizontalGroup(
				stdinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGroup(stdinfoLayout.createSequentialGroup()
		                .addContainerGap()
		                .addGroup(stdinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                		.addComponent(idl)
		                        .addComponent(namel)
		                        .addComponent(cgpal)
		                        .addComponent(emaill)
		                        .addComponent(passl)
		                    )
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                .addGroup(stdinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
		                		.addComponent(id)
		                        .addComponent(name)
		                        .addComponent(cgpa)
		                        .addComponent(email)
		                        .addComponent(pass)
		                        )
		                .addContainerGap(112, Short.MAX_VALUE))
		            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stdinfoLayout.createSequentialGroup()
		                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                .addComponent(jButtonReg)
		                .addGap(50, 50, 50))
		        );
		         
                stdinfoLayout.setVerticalGroup(
                        stdinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(stdinfoLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(stdinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(idl)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(stdinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(namel)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(stdinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cgpal)
                                .addComponent(cgpa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(stdinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(emaill)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(stdinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(passl)
                                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED) 
                            .addComponent(jButtonReg))
                    );
                
                
                
                
                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(stdinfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(jButtonReg))
                );
                jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonReg))
                        .addGap(16, 16, 16)
                        .addComponent(stdinfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 30, Short.MAX_VALUE))
                );
                
                
                
                
                
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                
                pack();

		
	//	JPanel bg=(JPanel) this.getContentPane();
//		bg.setBackground(Color.CYAN);
		
	//	bg.add(stdinfo);
		
		
	//	this.setSize(500, 400);
		this.setVisible(true);
		this.setTitle("Student Info: Registration");
	    
	}
	
	private void jButtonRegActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String i = id.getText();
        String n = name.getText();
        String c = cgpa.getText();
        String e = email.getText();
        String p = pass.getText();
        
     /*   create table student (
        		  id varchar(32) not null,
        		  name varchar(32) not null,
        		  cgpa float,
        		  email varchar(32) not null,
        		  pass varchar(32) not null,
        		  primary key (id)
        		);
        		
        		*/

        Student student = new Student(i, n, c, e);

        try {
        	    	
           /// database code
        	
        	 // create a mysql database connection
        	Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/stdinfo", "root", "");

            String query = "INSERT INTO STUDENT VALUES ('" + i + "','" + n+ "',"+c+",'" +e+ "','" +p+ "')";

            Statement stm = connection.createStatement();

            stm.executeUpdate(query);

            JOptionPane.showMessageDialog(rootPane, "Student Added OK !!!");
        	
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        id.setText("");
        name.setText("");
        cgpa.setText("");
        email.setText("");
        pass.setText("");
		
	}

}
