package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import service.UserCreation;

public class Main {
	public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException 
	{


			start();

	}

	public static void start() throws NumberFormatException, IOException, SQLException, ClassNotFoundException
	  	{

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  			System.out.println("\n");
				System.out.println("$$$$$$$$$$$$$$ WELCOME TO ULTIMATIX ISSUE TRACKER $$$$$$$$$$$$$$"
						+ "\n\n");
				System.out.println(
						"-----An issue tracking system (ITS) is a software application that allows an enterprise to record and follow the progress of every problem or issue that a\n\t computer system user identifies"
								+ " until the problem is resolved-----");

				System.out.print("1.SignUp" + "\n" + "2.Login" + "\n\n" + "Please Provide Your Option: ");
	  			int options=Integer.parseInt(br.readLine());
				UserSignup us = new UserSignup();
		
				String roll="";
				//selcting the page

				switch(options)
				{
				case 1:
					System.out.print(
							"1.Admin Registration\n2.Developer Registration\n3.Tester Registration\n4.Deployer Registration"
									+ "\n\n" + "Please Provide Your Option: ");

					int options1 = Integer.parseInt(br.readLine());
							//selecting roles of the user
								switch(options1)
			 						{
			 							case 1: 
			 									roll="Admin";
			 									us.singUp(roll);
			 									break;
			 							case 2: 
			 									roll="Developer";
			 									us.singUp(roll);
			 									break;
			 							case 3: 
			 									roll="Tester";
			 									us.singUp(roll);
			 									break;
			 							case 4: 
											roll = "Deployer";
			 									us.singUp(roll);
			 									break;
											default:
												System.out.println("Invalid Data Input\nPlease choose:  |1|2|3|4|");
												start();
												break;
			 						}
								break;
				 
							case 2:
					
					//Login page of 
								String email = "";
								String password = "";
								String userName = "";
								System.out.println("=========== WELCOME TO LOGIN PAGE ===========");
								System.out.print("Enter Your  EmailId: ");
								email = br.readLine();
								System.out.print("Enter Your  Username: ");
								userName = br.readLine();
								System.out.print("Enter Your  Password: ");
								password = br.readLine();
								UserCreation ucr = new UserCreation();
								String validtionUser = ucr.validtionUser(email, password, userName);// checking user and
																									// password by
																									// calling
																									// UserCreation
																									// .validtionUser
								System.out.println(validtionUser);

								if (validtionUser.equals("User Succefully Login")) {

									String retriveroll = ucr.retriveroll(email, password, userName);// retieving the
																									// role logged user
									LoginUsers lu = new LoginUsers();
									lu.users(retriveroll, email, userName);// sending role
								} else {
									start();
								}

								break;

							default:
								System.out.println("Invalid Data Input\nPlease Choose : |1|2|");
								start();
								break;
				}

			} catch (Exception e) {
				System.out.println("Invalid Data Input");
				start();
			}
	}
} // case 6: asing for id
// double salary=retreive();
//storeValue(id,salary);