package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import Model.IssueTracker;
import Model.Project;
import Model.Users;
import service.IssueCrud;
import service.ProjectMaintance;
import service.UserCreation;

public class TesterController
{
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	

	public void dasboard(String retriveroll, String email, String userName)
			throws NumberFormatException, IOException, ClassNotFoundException, SQLException
{
	  System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("!!!!!!! WELCOME TO TESTER DASHBOARD !!!!!!!");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("");
		ProjectMaintance pm = new ProjectMaintance();
		Project p = new Project();
		UserCreation uc = new UserCreation();
		Users user = new Users();
		IssueHelper ih = new IssueHelper();
		IssueCrud ic = new IssueCrud();
		IssueTracker it = new IssueTracker();
		it.setRollUser(retriveroll);
		ic.FilerByRoll(it);
		Main mm = new Main();
		System.out
				.print(
						"1.RaiseTicket\n2.ModifyTicket\n3.FilterByStatus\n4.FilterByPriority\n5.FilterByIssueType\n6.CheckingAssingedTicketToYou\n7.Home"
								+ "\n\n" + "Please Enter Your Choice: ");
		try
		{
	  int options1=Integer.parseInt(br.readLine());
	  switch(options1)
	  {
	  case 1: 
			ih.raiseTicket(retriveroll, email, userName);
				System.out.print("1.TESTER DASHBOARD\n2.HOME\nPlease Enter your Choice : ");
				int options2 = Integer.parseInt(br.readLine());
				switch (options2) {
				case 1:
					TesterController dc = new TesterController();
					dc.dasboard(retriveroll, email, userName);
					break;
				case 2:
					mm.start();
					break;
				default:
					System.out.println("Invalid Input From :" + userName + "\nPlease Choose : |1|2|");
					TesterController dc1 = new TesterController();
					dc1.dasboard(retriveroll, email, userName);
					break;
				}
		     break;
	  case 2:
			ih.ModifyRecord(retriveroll, email, userName);
			System.out.print("1.TESTER DASHBOARD\n2.HOME\nPlease Enter your Choice : ");
			int options3 = Integer.parseInt(br.readLine());
			switch (options3) {
			case 1:
				TesterController dc = new TesterController();
				dc.dasboard(retriveroll, email, userName);
				break;
			case 2:
				mm.start();
				break;
			default:
				System.out.println("Invalid Input From :" + userName + "\nPlease Choose : |1|2|");
				TesterController dc1 = new TesterController();
				dc1.dasboard(retriveroll, email, userName);
				break;
			}
		  	 break;
	  case 3: 
			System.out.print("STATUS TYPE:\n--------------\n1.open\n2.Work-In-Progress\n3.Pending\n4.Close\n5.Reopen"
					+ "\n\n" + "Please Enter your Choice : ");
              int statusTicket=Integer.parseInt(br.readLine());	
              it.setRollUser(retriveroll);
              it.setStatusTicket(statusTicket);
				System.out.print("1.TESTER DASHBOARD\n2.HOME\nPlease Enter your Choice : ");
				int options4 = Integer.parseInt(br.readLine());
				switch (options4) {
				case 1:
					TesterController dc = new TesterController();
					dc.dasboard(retriveroll, email, userName);
					break;
				case 2:
					mm.start();
					break;
				default:
					System.out.println("Invalid Input From :" + userName + "\nPlease Choose : |1|2|");
					TesterController dc1 = new TesterController();
					dc1.dasboard(retriveroll, email, userName);
					break;
				}
		  	 break;
	  case 4:
			System.out.print("PRIORITY TYPE:\n--------------\n1.Low\n2.Medium\n3.High" + "\n\n"
					+ "Please Enter your Choice : ");
              int  priorityLinkID=Integer.parseInt(br.readLine());
              it.setRollUser(retriveroll);
              it.setPriorityLinkID(priorityLinkID);
              ic.FilerByPriority(it);
				System.out.print("1.TESTER DASHBOARD\n2.HOME\nPlease Enter your Choice : ");
				int options5 = Integer.parseInt(br.readLine());
				switch (options5) {
				case 1:
					TesterController dc = new TesterController();
					dc.dasboard(retriveroll, email, userName);
					break;
				case 2:
					mm.start();
					break;
				default:
					System.out.println("Invalid Input From :" + userName + "\nPlease Choose : |1|2|");
					TesterController dc1 = new TesterController();
					dc1.dasboard(retriveroll, email, userName);
					break;
				}
		  	 break;
	  case 5:
			System.out.print(
					"ISSUE TYPE:\n--------------\n1.Task\n2.Bug\n3.Epic" + "\n\n" + "Please Enter your Choice : ");
		  	 int issuetypeLinkID=Integer.parseInt(br.readLine());
			 it.setRollUser(retriveroll);
	         it.setIssuetypeLinkID(issuetypeLinkID);
	         ic.FilerByIssueType(it);
				System.out.print("1.TESTER DASHBOARD\n2.HOME\nPlease Enter your Choice : ");
				int options6 = Integer.parseInt(br.readLine());
				switch (options6) {
				case 1:
					TesterController dc = new TesterController();
					dc.dasboard(retriveroll, email, userName);
					break;
				case 2:
					mm.start();
					break;
				default:
					System.out.println("Invalid Input From :" + userName + "\nPlease Choose : |1|2|");
					TesterController dc1 = new TesterController();
					dc1.dasboard(retriveroll, email, userName);
					break;
				}
		  	 break;
	  case 6: 
		      it.setRollUser(retriveroll);
		      ic.CheckingAsingedTicketToYou(it);
				System.out.print("1.TESTER DASHBOARD\n2.HOME\nPlease Enter your Choice : ");
				int options7 = Integer.parseInt(br.readLine());
				switch (options7) {
				case 1:
					TesterController dc = new TesterController();
					dc.dasboard(retriveroll, email, userName);
					break;
				case 2:
					mm.start();
					break;
				default:
					System.out.println("Invalid Input From :" + userName + "\nPlease Choose : |1|2|");
					TesterController dc1 = new TesterController();
					dc1.dasboard(retriveroll, email, userName);
					break;

				}
		     break;
			case 7:
				mm.start();
				break;
			default:
				System.out.println("Invalid Input From :" + userName + "\nPlease Choose : |1|2|3|4|5|6|7|");
				TesterController dc = new TesterController();
				dc.dasboard(retriveroll, email, userName);
				break;

	  }
		}catch(Exception e)
		{
			System.out.println("Invalid Input From :" + userName);
			TesterController dc = new TesterController();
			dc.dasboard(retriveroll, email, userName);
		}
		}
}

