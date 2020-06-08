package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Model.IssueTracker;
import service.IssueCrud;
import service.ProjectMaintance;
import service.UserCreation;

public class IssueHelper 
{
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	

	public void raiseTicket(String roll,
			String email,
			String userName)
			throws NumberFormatException, IOException, ClassNotFoundException, SQLException
{
	
	
	int projectLinkID;//1
	int issuetypeLinkID;//2
	int priorityLinkID;//3
	int statusTicket;//4
	String rollUser="";//5
	String AssignedBy="";//6
	String AssignedTo = "";// 7
	String summary="";//8
	String issueDescription="";//9
	String issueDate="";//10
	String closeDate="";//11
	
	
	try {
	
	  ProjectMaintance pm=new ProjectMaintance();
	  UserCreation uc=new UserCreation();

	  int retriveid = uc.retriveid(email,roll);//Retrieve User id
	 if(roll.equals("Admin"))
	 {
	     pm.printproject();
	 }else
	 {
		  pm.Printingrelative(retriveid);
	 }
	    	
	  
	  
	
		System.out.print("\nPlease Provide Project ID: ");
	//project 1
	projectLinkID=Integer.parseInt(br.readLine());
	//issueType 2
	System.out.print("ISSUE TYPE:\n---------------\n1.Task\n2.Bug\n3.Epic" + "\n\n" + "Please Enter Your Choice: ");
	issuetypeLinkID=Integer.parseInt(br.readLine());
	if (issuetypeLinkID == 1 || issuetypeLinkID == 2 || issuetypeLinkID == 3) {
   //priortiy 3
	System.out.print(
			"PRIORITY TYPE:\n---------------\n1.Low\n2.Medium\n3.High" + "\n\n" + "Please Enter Your Choice: ");
	
	priorityLinkID=Integer.parseInt(br.readLine());
	if (priorityLinkID == 1 || priorityLinkID == 2 || priorityLinkID == 3) {

	
	//status 4
	statusTicket=1;//open a ticket with Open Status
	
	// role 5
	rollUser=roll;
	//Users mail 6
	AssignedBy=email;
	
	//7 Assigned  to
	
	
	//assigned to specific roll
	if(roll.equals("Admin"))
	{
		System.out.print("ASSIGNED TO :\n-------------\n1.Developer\n2.Tester\n3.Deployer" + "\n\n"
				+ "Please Enter Your Choice: ");
	int op=Integer.parseInt(br.readLine());
	switch(op)
	{
	case 1:
		AssignedTo = "Developer";
			break;
		case 2:
			AssignedTo = "Tester";
			break;
		case 3:
			AssignedTo = "Deployer";
			break;
		default:
			System.out.println("Invalid Input From :" + userName);

			if (roll.equals("Admin")) {
				AdminController ac = new AdminController();
				ac.dasboard(roll, email, userName);
			} else if (roll.equals("Developer")) {

				DeveloperController dc = new DeveloperController();
				dc.dasboard(roll, email, userName);

			} else if (roll.equals("Tester")) {

				TesterController dc = new TesterController();
				dc.dasboard(roll, email, userName);

			} else if (roll.equals("Deployer")) {

				DeployerController dc = new DeployerController();
				dc.dasboard(roll, email, userName);

			}
			break;
	
	}
	}else if(roll.equals("Developer"))
	{
		System.out.print("ASSIGNED TO :\n-------------\n1.Admin\n2.Tester\n3.Deployer" + "\n\n"
				+ "Please Enter Your Choice: ");
		int op=Integer.parseInt(br.readLine());
		switch(op)
		{
		case 1:
			AssignedTo = "Admin";
				break;
			case 2:
				AssignedTo = "Tester";
				break;
			case 3:
				AssignedTo = "Deployer";
				break;
			default:
				System.out.println("Invalid Input From: " + userName);

				if (roll.equals("Admin")) {
					AdminController ac = new AdminController();
					ac.dasboard(roll, email, userName);
				} else if (roll.equals("Developer")) {

					DeveloperController dc = new DeveloperController();
					dc.dasboard(roll, email, userName);

				} else if (roll.equals("Tester")) {

					TesterController dc = new TesterController();
					dc.dasboard(roll, email, userName);

				} else if (roll.equals("Deployer")) {

					DeployerController dc = new DeployerController();
					dc.dasboard(roll, email, userName);

				}
				break;
		}
	}else if(roll.equals("Tester"))
	{
		System.out.print("ASSIGNED TO :\n-------------\n1.Admin\n2.Developer\n3.Deployer" + "\n\n"
				+ "Please Enter Your Choice: ");
		int op=Integer.parseInt(br.readLine());
		switch(op)
		{
		case 1:
			AssignedTo = "Admin";
				break;
			case 2:
				AssignedTo = "Developer";
				break;
			case 3:
				AssignedTo = "Deployer";
				break;
			default:
				System.out.println("Invalid Input From :" + userName);

				if (roll.equals("Admin")) {
					AdminController ac = new AdminController();
					ac.dasboard(roll, email, userName);
				} else if (roll.equals("Developer")) {

					DeveloperController dc = new DeveloperController();
					dc.dasboard(roll, email, userName);

				} else if (roll.equals("Tester")) {

					TesterController dc = new TesterController();
					dc.dasboard(roll, email, userName);

				} else if (roll.equals("Deployer")) {

					DeployerController dc = new DeployerController();
					dc.dasboard(roll, email, userName);

				}
				break;
		}
	}else if(roll.equals("Deployer"))
	{
		System.out.print("ASSIGNED TO :\n-------------\n1.Admin\n2.Developer\n3.Tester" + "\n\n"
				+ "Please Enter Your Choice: ");
		int op=Integer.parseInt(br.readLine());
		switch(op)
		{
		case 1:
			AssignedTo = "Admin";
				break;
			case 2:
				AssignedTo = "Developer";
				break;
			case 3:
				AssignedTo = "Tester";
				break;
			default:
				System.out.println("Invalid Input From :" + userName);

				if (roll.equals("Admin")) {
					AdminController ac = new AdminController();
					ac.dasboard(roll, email, userName);
				} else if (roll.equals("Developer")) {

					DeveloperController dc = new DeveloperController();
					dc.dasboard(roll, email, userName);

				} else if (roll.equals("Tester")) {

					TesterController dc = new TesterController();
					dc.dasboard(roll, email, userName);

				} else if (roll.equals("Deployer")) {

					DeployerController dc = new DeployerController();
					dc.dasboard(roll, email, userName);

				}
				break;
		}
	}
	//8.summary
	System.out.print("Enter Your Issue Summary: " + "\n\n" + "Please Provide: ");
	summary=br.readLine();
	//9.Issue Description
	System.out.print("Enter Your Issue Description: " + "\n\n" + "Please Provide: ");
	issueDescription=br.readLine();
	Date date = Calendar.getInstance().getTime();  
	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
	//10.issue date 
	issueDate = dateFormat.format(date); 
	//11. closed date
	closeDate="Action is needed..";
	
	//setting the values in object
	IssueTracker ist=new IssueTracker();
	ist.setProjectLinkID(projectLinkID);//1
	ist.setIssuetypeLinkID(issuetypeLinkID);//2
	ist.setPriorityLinkID(priorityLinkID);//3
	ist.setStatusTicket(statusTicket);//4
	ist.setRollUser(rollUser);//5
	ist.setAssignedBy(AssignedBy);//6
	ist.setAssigeeTo(AssignedTo);// 7
	ist.setSummary(summary);//8
	ist.setIssueDescription(issueDescription);//9
	ist.setIssueDate(issueDate);//10
	ist.setCloseDate(closeDate);//11
	
	//inserting record by calling insertmethod
	
	IssueCrud ic=new IssueCrud();
	ic.InsertDataIntoIssueTracker(ist);
	System.out.println("\n");
	System.out.println("Successfully Inserted !");
	 
} else {// proprity
	System.out.println("Invalid Input From : " + userName);

	if (roll.equals("Admin")) {
		AdminController ac = new AdminController();
		ac.dasboard(roll, email, userName);
	} else if (roll.equals("Developer")) {

		DeveloperController dc = new DeveloperController();
		dc.dasboard(roll, email, userName);

	} else if (roll.equals("Tester")) {

		TesterController dc = new TesterController();
		dc.dasboard(roll, email, userName);

	} else if (roll.equals("Deployer")) {

		DeployerController dc = new DeployerController();
		dc.dasboard(roll, email, userName);

	}
}
} else {
	System.out.println("Invalid Input From : " + userName);

	if (roll.equals("Admin")) {
		AdminController ac = new AdminController();
		ac.dasboard(roll, email, userName);
	} else if (roll.equals("Developer")) {

		DeveloperController dc = new DeveloperController();
		dc.dasboard(roll, email, userName);

	} else if (roll.equals("Tester")) {

		TesterController dc = new TesterController();
		dc.dasboard(roll, email, userName);

	} else if (roll.equals("Deployer")) {

		DeployerController dc = new DeployerController();
		dc.dasboard(roll, email, userName);

	}
}
} catch (Exception e) {
	System.out.println("Invalid Input From : " + userName);

	if (roll.equals("Admin")) {
		AdminController ac = new AdminController();
		ac.dasboard(roll, email, userName);
	} else if (roll.equals("Developer")) {

		DeveloperController dc = new DeveloperController();
		dc.dasboard(roll, email, userName);

	} else if (roll.equals("Tester")) {

		TesterController dc = new TesterController();
		dc.dasboard(roll, email, userName);

	} else if (roll.equals("Deployer")) {

		DeployerController dc = new DeployerController();
		dc.dasboard(roll, email, userName);

	}
}
}


public void ModifyRecord(String roll, String email, String userName)
		throws IOException, ClassNotFoundException, SQLException
{
	int id;//1
	int issuetypeLinkID;//2
	int priorityLinkID;//3
	int statusTicket;//4
	String rollUser="";//5
	String AssignedBy="";//6
	String AssigeeTo="";//7
	String summary="";//8
	String issueDescription="";//9
	String issueDate="";//10
	String closeDate="";//11
	
	
	
	try {

	ProjectMaintance pm = new ProjectMaintance();
	System.out.print("Issue ID: Please Enter Your Choice: ");
	//project 1
	id=Integer.parseInt(br.readLine());

	int issueProjectTracker = pm.issueProjectTracker(id);

	boolean modifyAuthorization = pm.modifyAuthorization(userName, issueProjectTracker);
	System.out.println(modifyAuthorization);
	if (modifyAuthorization || roll.equals("Admin")) {

	//issueType 2
	System.out.print("ISSUE TYPE:\n-----------\n1.Task\n2.Bug\n3.Epic" + "\n\n" + "Please Provide Your Option: ");
	issuetypeLinkID=Integer.parseInt(br.readLine());
	if (issuetypeLinkID == 1 || issuetypeLinkID == 2 || issuetypeLinkID == 3) {

   //priortiy 3
	System.out.print("PRIORITY TYPE:\n-----------\n1.Low\n2.Medium\n3.High" + "\n\n" + "Please Provide Your Option: ");
	priorityLinkID=Integer.parseInt(br.readLine());
	//status 4
	if (priorityLinkID == 1 || priorityLinkID == 2 || priorityLinkID == 3) {
	System.out.print("STATUS TYPE:\n-----------\n2.Work-In-Progress\n3.Pending\n4.Close\n5.Reopen" + "\n\n"
			+ "Please Provide Your Option: ");
	statusTicket=Integer.parseInt(br.readLine());
	if (statusTicket == 2 || statusTicket == 3 || statusTicket == 4 || statusTicket == 5) {
	/*
	 * if(statusTicket==2&&statusTicket==3&&statusTicket==4&&statusTicket==5) {
	 * 
	 * 
	 * }
	 */

	
	// role 5
	rollUser=roll;
	//Users mail 6
	AssignedBy=email;
	
	String AssignedTo;
	//7 Assigned  to
	//assigned to specific roll
	if (roll.equals("Admin")) {
		System.out.print("ASSIGNED TO :\n-------------\n1.Developer\n2.Tester\n3.Deployer" + "\n\n"
				+ "Please Enter Your Choice: ");
		int op = Integer.parseInt(br.readLine());
		switch (op) {
		case 1:
			AssignedTo = "Developer";
			break;
		case 2:
			AssignedTo = "Tester";
			break;
		case 3:
			AssignedTo = "Deployer";
			break;
		default:
			System.out.println("Invalid Input From :" + userName);

			if (roll.equals("Admin")) {
				AdminController ac = new AdminController();
				ac.dasboard(roll, email, userName);
			} else if (roll.equals("Developer")) {

				DeveloperController dc = new DeveloperController();
				dc.dasboard(roll, email, userName);

			} else if (roll.equals("Tester")) {

				TesterController dc = new TesterController();
				dc.dasboard(roll, email, userName);

			} else if (roll.equals("Deployer")) {

				DeployerController dc = new DeployerController();
				dc.dasboard(roll, email, userName);

			}
			break;

		}
	} else if (roll.equals("Developer")) {
		System.out.print(
				"ASSIGNED TO :\n-------------\n1.Admin\n2.Tester\n3.Deployer" + "\n\n" + "Please Enter Your Choice: ");
		int op = Integer.parseInt(br.readLine());
		switch (op)
		{
		case 1:
			AssignedTo = "Admin";
			break;
		case 2:
			AssignedTo = "Tester";
			break;
		case 3:
			AssignedTo = "Deployer";
			break;
		default:
			System.out.println("Invalid Input From: " + userName);

			if (roll.equals("Admin")) {
				AdminController ac = new AdminController();
				ac.dasboard(roll, email, userName);
			} else if (roll.equals("Developer")) {

				DeveloperController dc = new DeveloperController();
				dc.dasboard(roll, email, userName);

			} else if (roll.equals("Tester")) {

				TesterController dc = new TesterController();
				dc.dasboard(roll, email, userName);

			} else if (roll.equals("Deployer")) {

				DeployerController dc = new DeployerController();
				dc.dasboard(roll, email, userName);

			}
			break;
		}
	} else if (roll.equals("Tester")) {
		System.out.print("ASSIGNED TO :\n-------------\n1.Admin\n2.Developer\n3.Deployer" + "\n\n"
				+ "Please Enter Your Choice: ");
		int op=Integer.parseInt(br.readLine());
		switch(op)
		{
		case 1:
			AssignedTo = "Admin";
			break;
		case 2:
			AssignedTo = "Developer";
				break;
			case 3:
				AssignedTo = "Deployer";
				break;
			default:
				System.out.println("Invalid Input From :" + userName);

				if (roll.equals("Admin")) {
					AdminController ac = new AdminController();
					ac.dasboard(roll, email, userName);
				} else if (roll.equals("Developer")) {

					DeveloperController dc = new DeveloperController();
					dc.dasboard(roll, email, userName);

				} else if (roll.equals("Tester")) {

					TesterController dc = new TesterController();
					dc.dasboard(roll, email, userName);

				} else if (roll.equals("Deployer")) {

					DeployerController dc = new DeployerController();
					dc.dasboard(roll, email, userName);

				}
				break;
		}
	} else if (roll.equals("Deployer")) {
		System.out.print(
				"ASSIGNED TO :\n-------------\n1.Admin\n2.Developer\n3.Tester" + "\n\n" + "Please Enter Your Choice: ");
		int op = Integer.parseInt(br.readLine());
		switch (op)
		{
		case 1:
			AssignedTo = "Admin";
			break;
		case 2:
			AssignedTo = "Developer";
			break;
		case 3:
			AssignedTo = "Tester";
			break;
		default:
			System.out.println("Invalid Input From :" + userName);

			if (roll.equals("Admin")) {
				AdminController ac = new AdminController();
				ac.dasboard(roll, email, userName);
			} else if (roll.equals("Developer")) {

				DeveloperController dc = new DeveloperController();
				dc.dasboard(roll, email, userName);

			} else if (roll.equals("Tester")) {

				TesterController dc = new TesterController();
				dc.dasboard(roll, email, userName);

			} else if (roll.equals("Deployer")) {

				DeployerController dc = new DeployerController();
				dc.dasboard(roll, email, userName);

			}
			break;
		}
	}
	Date date = Calendar.getInstance().getTime();  
	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
	//8. closed date
	closeDate=dateFormat.format(date); 
	
	//setting the values in object
	IssueTracker ist=new IssueTracker();

	ist.setIssuetypeLinkID(issuetypeLinkID);
	ist.setPriorityLinkID(priorityLinkID);
	ist.setStatusTicket(statusTicket);
	ist.setRollUser(rollUser);
	ist.setAssignedBy(AssignedBy);
	ist.setAssigeeTo(AssigeeTo);
	ist.setCloseDate(closeDate);
	
	//inserting record by calling insertmethod
	
	IssueCrud ic=new IssueCrud();
	ic.modifiedTicket(ist, id);

	System.out.println("\n");
	System.out.println("Successfully Updated..");
}

// if project not matched he/she not ,modify the ticket it enter into 
else {
	Main m = new Main();
	System.out.println(
			"Sorry ! You don't have Access to Modify this Project, Please Raise a Ticket to Admin for Access Permissions..! ");
	try {
	if (roll.equals("Admin")) {
		System.out.print("1.ADMIN DASHBOARD\n2.Home\n Please Enter your Choice: ");
		int op = Integer.parseInt(br.readLine());
		switch (op) {
		case 1:
			AdminController ac = new AdminController();
			ac.dasboard(roll, email, userName);
			break;
		case 2:
			m.start();
			break;
		default:
			System.out.println("Invalid Input From:" + userName + "\n Please Choose : |1|2|");
			AdminController ac1 = new AdminController();
			ac1.dasboard(roll, email, userName);
			break;
		

		}
	} else if (roll.equals("Developer")) {
		System.out.print("1.DEVELOPER DASHBOARD\n2.Home\n Please Enter your Choice: ");

		int op = Integer.parseInt(br.readLine());
		switch (op) {
		case 1:
			DeveloperController dc = new DeveloperController();
			dc.dasboard(roll, email, userName);
			break;
		case 2:
			m.start();
			break;
		default:
			System.out.println("Invalid Input From:" + userName + "\n Please Choose : |1|2|");
			DeveloperController dc1 = new DeveloperController();
			dc1.dasboard(roll, email, userName);
			break;
		}
	} else if (roll.equals("Tester")) {
		System.out.print("1.TESTER DASHBOARD\n2.Home\n Please Enter your Choice: ");
		int op = Integer.parseInt(br.readLine());
		switch (op) {
		case 1:
			TesterController dc = new TesterController();
			dc.dasboard(roll, email, userName);
			break;
		case 2:
			m.start();
			break;
		default:
			System.out.println("Invalid Input From:" + userName + "\n Please Choose : |1|2|");
			TesterController dc1 = new TesterController();
			dc1.dasboard(roll, email, userName);
			break;
		}
	} else if (roll.equals("Deployer")) {
		System.out.print("1.DEPLOYER DASHBOARD\n2.Home\n Please Enter your Choice: ");
		int op = Integer.parseInt(br.readLine());
		switch (op) {
		case 1:
			DeployerController dc = new DeployerController();
			dc.dasboard(roll, email, userName);
			break;
		case 2:
			m.start();
			break;
		default:
			System.out.println("Invalid Input From:" + userName + "\n Please Choose : |1|2|");
			DeployerController dc1 = new DeployerController();
			dc1.dasboard(roll, email, userName);
			break;
		}
	}
} catch (Exception e) {
	System.out.println("Invalid Input From" + userName);

	if (roll.equals("Admin")) {
		AdminController ac = new AdminController();
		ac.dasboard(roll, email, userName);
	} else if (roll.equals("Developer")) {

		DeveloperController dc = new DeveloperController();
		dc.dasboard(roll, email, userName);

	} else if (roll.equals("Tester")) {

		TesterController dc = new TesterController();
		dc.dasboard(roll, email, userName);

	} else if (roll.equals("Deployer")) {

		DeployerController dc = new DeployerController();
		dc.dasboard(roll, email, userName);

	}
}
}
} else {
	System.out.println("Invalid Input From : " + userName);

	if (roll.equals("Admin")) {
		AdminController ac = new AdminController();
		ac.dasboard(roll, email, userName);
	} else if (roll.equals("Developer")) {

		DeveloperController dc = new DeveloperController();
		dc.dasboard(roll, email, userName);

	} else if (roll.equals("Tester")) {

		TesterController dc = new TesterController();
		dc.dasboard(roll, email, userName);

	} else if (roll.equals("Deployer")) {

		DeployerController dc = new DeployerController();
		dc.dasboard(roll, email, userName);

	}
}
} else {
	System.out.println("Invalid Input From : " + userName);

	if (roll.equals("Admin")) {
		AdminController ac = new AdminController();
		ac.dasboard(roll, email, userName);
	} else if (roll.equals("Developer")) {

		DeveloperController dc = new DeveloperController();
		dc.dasboard(roll, email, userName);

	} else if (roll.equals("Tester")) {

		TesterController dc = new TesterController();
		dc.dasboard(roll, email, userName);

	} else if (roll.equals("Deployer")) {

		DeployerController dc = new DeployerController();
		dc.dasboard(roll, email, userName);

	}
}
} else {
	System.out.println("Invalid Input From : " + userName);

	if (roll.equals("Admin")) {
		AdminController ac = new AdminController();
		ac.dasboard(roll, email, userName);
	} else if (roll.equals("Developer")) {

		DeveloperController dc = new DeveloperController();
		dc.dasboard(roll, email, userName);

	} else if (roll.equals("Tester")) {

		TesterController dc = new TesterController();
		dc.dasboard(roll, email, userName);

	} else if (roll.equals("Deployer")) {

		DeployerController dc = new DeployerController();
		dc.dasboard(roll, email, userName);

	}
}
} catch (Exception e) {
	System.out.println("Invalid Input From : " + userName);

	if (roll.equals("Admin")) {
		AdminController ac = new AdminController();
		ac.dasboard(roll, email, userName);
	} else if (roll.equals("Developer")) {

		DeveloperController dc = new DeveloperController();
		dc.dasboard(roll, email, userName);

	} else if (roll.equals("Tester")) {

		TesterController dc = new TesterController();
		dc.dasboard(roll, email, userName);

	} else if (roll.equals("Deployer")) {

		DeployerController dc = new DeployerController();
		dc.dasboard(roll, email, userName);

	}
}
}
}

