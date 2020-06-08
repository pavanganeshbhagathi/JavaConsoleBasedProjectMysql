package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import Model.Users;
import bussinessLogic.SignUpValidation;
import service.UserCreation;


public class UserSignup {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
 

	public void singUp(String roll) throws IOException, ClassNotFoundException, SQLException
	{
		
		SignUpValidation suv = new SignUpValidation();// client side
		UserCreation ucr=new UserCreation();//servers side
		String emailId="";
		String password="";
		String confirmPassword="";
		String userName="";
		String firstName="";
		String lastName="";
		String mobnumber="";
		String finalrole=roll;
		
		//reading values form user for registration
		System.out.println("=========== Welcome To "+roll+"  Registration ===========");
		System.out.print("Email Should Consists of Proper Format like @ and a dot(.)\nEnter Your  EmailId: ");
		emailId=br.readLine();
		System.out.println(
				"Password should consists of minimum one Upper case, one Lower case, one digit, and one special character.");
		System.out.print("Enter Your  Password: ");
		password=br.readLine();
		System.out.print("Enter Your Retype-Password: ");
		confirmPassword=br.readLine();
		System.out.print("Enter Your UserName: ");
		userName=br.readLine();
		System.out.print("Enter Your FirstName: ");
		firstName=br.readLine();
		System.out.print("Enter Your LastName: ");
        lastName=br.readLine();
		System.out.print("Enter Your MobileNumber: ");
        mobnumber=br.readLine();
        
        //validating for terms condition
         System.out.println("");
         String validEmail = suv.validEmail(emailId);
			String serverSideEmailChecker = ucr.serverSideEmailChecker(emailId, finalrole, validEmail);// serverside
																										// validation
         System.out.println(validEmail+"  &&  "+serverSideEmailChecker);
         String checkUserDetails = suv.checkUserDetails(password, confirmPassword);
         System.out.println(checkUserDetails);
         String validUser = suv.validUser(userName);
			String serverSideUserNameChecker = ucr.serverSideUserNameChecker(userName, validEmail,
					serverSideEmailChecker, checkUserDetails);// serverside validation
         System.out.println(validUser+" && "+serverSideUserNameChecker);
         String validFirstName = suv.validFirstName(firstName);
         System.out.println(validFirstName);
         String validLastName = suv.validLastName(lastName);
         System.out.println(validLastName);
         String validMobile = suv.validMobile(mobnumber);
         System.out.println(validMobile);
         
         
        //if it checks the all correct or not ,success case if block execute and else block again redirect t
         if(
			validEmail.equals(
					"Email Verified.. You can go with this..")
					&& checkUserDetails.equals(
							"Both Passwords Matched.. Valid Password..")
					&& validUser.equals(
							"Verified UserName..")
					&& validFirstName.equals(
							"Verified FirstName..")
					&& validLastName.equals(
							"Verified LastName..")
					&& validMobile.equals(
							"Mobile Number Verified..")
					&& serverSideEmailChecker.equals(
							"Server Side Email Verification is Success..")
					&& serverSideUserNameChecker.equals("Server Side Username Verified.. Please Go with it.."))
         {
        	
        	 Users user=new Users();
        	 user.setEmailId(emailId);
        	 user.setPassword(password);
        	 user.setRoll(roll);
        	 user.setUserName(userName);
        	 user.setFristName(firstName);
        	 user.setLastname(lastName);
        	 user.setMobilenumber(mobnumber);
        	 UserCreation  uc=new  UserCreation ();
        	 uc.inSertingUser(user);
        	 System.out.println("");
				System.out.println("User Creation Successful..");
				System.out.println("Navigating to Home Page..!");
				Main.start();
        	 
        	 
         }else
         {
        	 System.out.println("\n");
				System.out.println("User Authentication failed, You are re-directed to Home page..");
				Main.start();
         }
        
		
	}
}
