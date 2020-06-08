package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Users;
import utility.ConnectionManager;

public class UserCreation 

{

	
//##############################################  INSERTING DATA INTO USERS#############################################
	public void inSertingUser(Users user) throws ClassNotFoundException, SQLException, IOException
	{
			Connection connection = ConnectionManager.getConnection();
		
			String javaquery="insert into users(emailId,password,roll,username,fristname,lastname,mobilenumber) values(?,?,?,?,?,?,?);";
			PreparedStatement pst=connection.prepareStatement(javaquery);
          
			pst.setString(1, user.getEmailId());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getRoll());
			pst.setString(4, user.getUserName());
			pst.setString(5, user.getFristName());
			pst.setString(6, user.getLastname());
			pst.setString(7, user.getMobilenumber());
			pst.executeUpdate();
			connection.close();
           	
	}
	
	// ############################################## RETRIVING LOGIN ROLE AND USER
	// NAVIGATE TO CURRENT DASHBOARD#############################################
	public String retriveroll(String email,String password, String userName) throws ClassNotFoundException, SQLException, IOException
	{
		 String roll=null;
		 Connection connection = ConnectionManager.getConnection();
		String sql = "SELECT * FROM users";
		 Statement stmt=  connection.createStatement();
		 ResultSet rs =stmt.executeQuery(sql);
		
		 while(rs.next())
		 { 
			    String tableEmail = rs.getString("emailId");
				String tablePassword = rs.getString("password");
				 String tableroll = rs.getString("roll");
				 String tableusername = rs.getString("username");
		
				

				if(tableEmail.equals(email) && tablePassword.equals(password)&&tableusername.equals(userName))
				{
					 return tableroll;	
				}
			
		 }
		 return roll;
		
	}

	// ############################################## VALIDATING LOGIN DETAILS AND
	// USER
	// NAVIGATE TO CURRENT DASHBOARD#############################################
	public String validtionUser(String email,String password, String userName) throws ClassNotFoundException, SQLException, IOException
	{
		
	

		 String testPassowrd=password;
		

			
		 Connection connection = ConnectionManager.getConnection();
	

			
		 String javaquery=" select * from users";
		 Statement stmt=  connection.createStatement();
		 ResultSet rs =stmt.executeQuery(javaquery);
		 
		while(rs.next())
		{
			String tableEmail = rs.getString("emailId");
			String tablePassword = rs.getString("password");
			String tableusername = rs.getString("username");
			

			if(tableEmail.equals(email) && tablePassword.equals(testPassowrd)&&tableusername.equals(userName))
			{
				return "User Succefully Login";
			}
		}
		
		return "User Login Attempt Fails";
	}
	
	// ############################################## EMAIL CHECKING LOGGED USERS
	// AND IF NOT MATCHED HE/SHE ENABLE TO CREATE ACCOUNT ONLY
	// MAIL#############################################
	public String serverSideEmailChecker(String email, String finalrole, String validemail)
			throws ClassNotFoundException, SQLException, IOException
	{
		String query = "SELECT emailId,roll  FROM users WHERE emailId = '" + email + "'";
		 Connection connection = ConnectionManager.getConnection();
			
			if (!email.equals("")) {
				UserCreation ucr = new UserCreation();


				if (validemail.equals("Email Verified.. You can go with this..")) {
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					ConnectionManager.getConnection().close();
					while (rs.next()) {
						String tempEmail = rs.getString("emailId");
						String roll = rs.getString("roll");
						if (tempEmail.equals(email) && roll.equals(finalrole)) {
							return "Please choose a different one.. Email already exists:" + tempEmail + " Role :"
									+ roll;
						}
					}
					connection.close();
					return "Server Side Email Verification is Success..";
	} else {
		return "Pattern Doesn't matched.. ServerSide Validation attempt to Fail.";
	}

	}
	return "Please Enter a Valid Email Address, It Shouldn't be Null.";
}

	// ############################################## USERNAME CHECKING LOGGED USERS
	// AND IF NOT MATCHED HE/SHE ENABLE TO CREATE ACCOUNT ONLY
	// MAIL#############################################
public String serverSideUserNameChecker(String username, String validEmail, String serverSideEmailChecker, String checkUserDetails) throws ClassNotFoundException, SQLException, IOException
	{
		String query = "SELECT username FROM users WHERE username = '" + username + "'";
		 Connection connection = ConnectionManager.getConnection();
			

		
		 Statement stmt=  connection.createStatement();
		 ResultSet rs =stmt.executeQuery(query);

			if (!username.equals("")) {
				
				if (validEmail.equals(
						"Email Verified.. You can go with this..")
						&& serverSideEmailChecker.equals(
								"Server Side Email Verification is Success..")
						&& checkUserDetails.equals("Both Passwords Matched.. Valid Password..")) {
				
	                  while(rs.next())
	                   {
	                	  					String tempuser = rs.getString("username");
	                	  						if(tempuser.equals(username))
	                	  							{
													return "Please choose a different one.. Username already exists:"
															+ tempuser;
	                	  							}
	                   }
			connection.close();
			return "Server Side Username Verified.. Please Go with it..";
				}else
				{
					return "Server Side Username Not Verified.. \nPlease Make Sure Email & Password verification completed Successfully.. ";
				}
	}
	return "Please Enter Valid Username, It Shouldn't be Null..";
	}

	// ############################################## DELETE USERS FOLLOWED BY
	// ID#############################################
	 public void deleteUser(Users user) throws ClassNotFoundException, SQLException, IOException
	 {
		
			Connection connection = ConnectionManager.getConnection();
			Statement stmt = connection.createStatement();
			int executeUpdate = stmt.executeUpdate("DELETE FROM users WHERE usersId =" + user.getUserid() + " ");
			connection.close();
			
	 }

		// ############################################## PRINTING THE USERS
		// #############################################
	 public void printUser(Users user) throws ClassNotFoundException, SQLException, IOException
	 {
		
			
			String query=" select  usersId,emailId,roll,username FROM users ";
			 Connection connection = ConnectionManager.getConnection();
			 Statement stmt=  connection.createStatement();
			 ResultSet rs =stmt.executeQuery(query);

			 System.out.println("-----------------------------------------------------------------------------------------");
	       
				System.out.format("%15s %30s %30s %15s", "User_Id", "EMAIL_ID", "ROLL", "USERNAME");
			 System.out.println("");
			 System.out.println("-----------------------------------------------------------------------------------------");
				while (rs.next())
		      {
				  
				  int usersId = rs.getInt("usersId");
				  String emailId = rs.getString("emailId");
				  String roll = rs.getString("roll");
		    	  String username = rs.getString("username");
					// System.out.println( usersId +" "+emailId+" "+roll+" "+username);
					System.out.format("%15d %30s %30s %15s", usersId, emailId, roll, username);
					System.out.println("");
		      }
				System.out.println(
						"-----------------------------------------------------------------------------------------");
				connection.close();
	 }

		// ############################################## RETRIVEING BY USERS ID FOLLWED
		// BY ROLL AND EMAIL
		// #############################################
		public int retriveid(String email,String roll) throws ClassNotFoundException, SQLException, IOException
		{

			String query = "SELECT * FROM users WHERE users.emailId= '" + email + "'"+" AND " + "users.roll = '"+roll+"'";
			 Connection connection = ConnectionManager.getConnection();
				

			
			 Statement stmt=  connection.createStatement();
				ResultSet rs = stmt.executeQuery(query);
			 ConnectionManager.getConnection().close();
		      while(rs.next())
		      {
		    	  String tempemail = rs.getString("emailId");
					String roll1 = rs.getString("roll");
					int usersId1 = rs.getInt("users.usersId");
					if (tempemail.equals(email) && roll.equals(roll1))
		    	  {
		    	  return usersId1 ;
		    	  }
		      }
				// calculate(annualctc)
				connection.close();

			return 0;
		}

			
			 
}

