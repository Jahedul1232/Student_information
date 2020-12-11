/*********************************************
*************************************
* CSE-2402: Simple Database Project *
* SR, CSE, IIUC, CTG                *
* ***********************************
MySql Database Name:stdinfo
table name: student
SQL Query:
create table student (
        		  id varchar(32) not null,
        		  name varchar(32) not null,
        		  cgpa float,
        		  email varchar(32) not null,
        		  pass varchar(32) not null,
        		  primary key (id)
        		);
     		
MySQL Database connection Example
*************************************************************
Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/stdinfo", "root", "");
            String query = "SELECT id,name,cgpa,email FROM STUDENT";
            Statement stm = connection.createStatement();
            ResultSet rs=stm.executeQuery(query);

        		
Oracle Database connection Example
*************************************************************
  Class.forName("oracle.jdbc.driver.OracleDriver");
  con = DriverManager.getConnection("jdbc:oracle:thin:@mcndesktop07:1521:xe", "sr", "123"); 
//con = DriverManager.getConnection("jdbc:oracle:thin:@COMPUTER_NAME:PORT_NAMBER:DATABASE_NAME", "USER", "PASSWORD");
            String query = "SELECT id,name,cgpa,email FROM STUDENT";
            Statement stm = connection.createStatement();
            ResultSet rs=stm.executeQuery(query);
            
*/

import javax.swing.JFrame;

public class StudentInformationApplication {

	// Main Method
	
	public static <String> void main(String args[]) {
		// TODO Auto-generated method stub
		  Login log=new Login();
	      log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     // log.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
	    //  log.getContentPane().add(new PersonUI());
	      log.setSize(455,355);
	      log.setVisible(true);

	}

}
