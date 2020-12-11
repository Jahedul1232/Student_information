import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

public class Home extends JFrame{
	
	JLabel jLabel1=new JLabel("Student Information");
	JLabel idl=new JLabel("ID: ");
	JLabel namel=new JLabel("Name:  ");
	JLabel cgpal=new JLabel("CGPA: ");
	JLabel emaill=new JLabel("Email: ");
	JLabel passl=new JLabel("Password: ");
	String t="                                                            ";
	
	JTextField id=new JTextField();
	JTextField name=new JTextField();
	JTextField cgpa=new JTextField();
	JTextField email=new JTextField(t);
	
	JPanel jPanel1=new JPanel();
	
	public Home(String sid) {
		// TODO Auto-generated constructor stub
		 try {
		      jbInit(sid);
		    }
		    catch(Exception e) {
		      e.printStackTrace();
		 }
	}

	private void jbInit(String sid) {
		// TODO Auto-generated method stub
		id.setFont(new java.awt.Font("Dialog", 1, 14));
		//id.setBounds(new Rectangle(100, 50));
		name.setFont(new java.awt.Font("Dialog", 1, 14));
		cgpa.setFont(new java.awt.Font("Dialog", 1, 14));
		email.setFont(new java.awt.Font("Dialog", 1, 14));
		
		
		try {
	    	
	           /// database code
	        	
	        	 // create a mysql database connection
	        	Class.forName("com.mysql.jdbc.Driver");
	            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/stdinfo", "root", "");
	            String query = "SELECT id,name,cgpa,email FROM STUDENT WHERE id='"+sid+"'";
	            Statement stm = connection.createStatement();
	            ResultSet rs=stm.executeQuery(query);
	            if(rs.next()) {
	            id.setText(sid);
	            name.setText(rs.getString("name"));
	            email.setText(rs.getString("email"));
	            String c=String.valueOf(rs.getFloat("cgpa"));
	            cgpa.setText(c);
	            JOptionPane.showMessageDialog(rootPane, "Login Success !!!");
	            }
	            else {
	            	JOptionPane.showMessageDialog(null, "Some Error Occured", "Error", JOptionPane.ERROR_MESSAGE);
	 	           
	            }
	            
	        	
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }

	       
		
		
		JButton jButtonExit=new JButton("Exit");
		//jButtonReg.setText("Register");
		jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jButtonExitActionPerformed(evt);
            }
        });
		
		JButton jButtonAll=new JButton("All Student");
		//jButtonReg.setText("Register");
		jButtonAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jButtonAllActionPerformed(evt);
            }
        });
		
		
		JPanel stdinfo=new JPanel();
		//stdinfo.setBackground(Color.red);
		
		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255), 4));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Registered Student Information");
        
        
        
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
		                    )
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                .addGroup(stdinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
		                		.addComponent(id)
		                        .addComponent(name)
		                        .addComponent(cgpa)
		                        .addComponent(email)
		                        )
		                .addContainerGap(112, Short.MAX_VALUE))
		            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stdinfoLayout.createSequentialGroup()
		                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                .addComponent(jButtonExit)
		                .addComponent(jButtonAll)
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
                            .addComponent(jButtonExit)
                            .addComponent(jButtonAll)
                            )
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
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(jButtonExit)
                        .addComponent(jButtonAll)
                        )
                );
                jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonExit)
                            .addComponent(jButtonAll)
                            )
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
        
        
        
        
		
	}
	
	private void jButtonExitActionPerformed(ActionEvent evt) {
		int a=JOptionPane.showConfirmDialog(null,"Do you want to Exit?"," Warning ",JOptionPane.INFORMATION_MESSAGE);
		  if(a==0)
		 System.exit(0);
	}
	
	private void jButtonAllActionPerformed(ActionEvent evt) {
		new AllStudent();
	}


}
