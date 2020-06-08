package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import Model.Grouped;
import Model.IssueTracker;
import Model.Project;
import Model.Users;
import service.IssueCrud;
import service.ProjectMaintance;
import service.UserCreation;

public class AdminController
{
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	

	public void dasboard(String retriveroll, String email, String userName)
			throws NumberFormatException, IOException, ClassNotFoundException, SQLException
{
	   System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("!!!!!!! WELCOME TO ADMIN DASHBOARD !!!!!!!");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	   System.out.println("");
	   ProjectMaintance  pm=new ProjectMaintance();
	   Project p=new Project();
	   UserCreation uc=new UserCreation();
	   Users user=new Users();
	   IssueHelper ih=new IssueHelper();
	   IssueCrud ic=new IssueCrud();
	   IssueTracker  it=new IssueTracker();
	   it.setRollUser(retriveroll);	  
	   ic.FilerByRoll(it);
		Main m = new Main();
		System.out.print(
				"1.Create Project\n2.Delete Project\n3.Delete User\n4.Raise Ticket\n5.Modify Ticket\n6.Filter By Status\n7.Filter By Priority\n8.Filter By IssueType\n9.Check Tickets that are Assigned to you\n10.Create Association Between Users & Projects\n11.Checking Association\n12.Monitoring IssueTracker\n13.Home"
						+ "\n\n" + "Please Enter Your Choice: ");

		try {
			int options1 = Integer.parseInt(br.readLine());
		switch (options1) {
		case 1:
			System.out.print("Enter your Project Name :");
			String prName = br.readLine();
			p.setProjectName(prName);
			String serverSideProjectChecker = pm.serverSideProjectChecker(p);
			System.out.println(serverSideProjectChecker);
			if (serverSideProjectChecker.equals("ProjectName  Verified.. Please Go with it..")) {
				pm.insertproject(p);// inserting the project
				System.out.print("1.ADMIN DASHBOARD\n2.Home\nPlease Enter Your Choice:");
				int options13 = Integer.parseInt(br.readLine());
				switch (options13) {
				case 1:
					AdminController ac = new AdminController();
					ac.dasboard(retriveroll, email, userName);
					break;
				case 2:
					m.start();
					break;
				default:
					System.out.println("Invalid Input From :" + userName + "\nPlease Choose: |1|2| ");
					AdminController ac1 = new AdminController();
					ac1.dasboard(retriveroll, email, userName);
					break;
				}
			} else {
				System.out.print("1.ADMIN DASHBOARD\n2.Home\nPlease Enter Your Choice:");
				int options2 = Integer.parseInt(br.readLine());
				switch (options2) {
				case 1:
					AdminController ac = new AdminController();
					ac.dasboard(retriveroll, email, userName);
					break;
				case 2:
					m.start();
					break;
				default:
					System.out.println("Invalid Input From :" + userName + "\nPlease Choose: |1|2| ");
					AdminController ac1 = new AdminController();
					ac1.dasboard(retriveroll, email, userName);
					break;
				}
				}
				break;
			case 2:
				pm.printproject();
				Project pp = new Project();
				System.out.print("Please Select your Project id :");
				int projectId = Integer.parseInt(br.readLine());
				pp.setProjectId(projectId);
				pm.deleteProject(pp);
				pm.printproject();

				System.out.print("1.ADMIN DASHBOARD\n2.Home\nPlease Enter Your Choice:");
				int options21 = Integer.parseInt(br.readLine());
				switch (options21) {
				case 1:
					AdminController ac = new AdminController();
					ac.dasboard(retriveroll, email, userName);
					break;
				case 2:
					m.start();
					break;
				default:
					System.out.println("Invalid Input From :" + userName + "\nPlease Choose: |1|2| ");
					AdminController ac1 = new AdminController();
					ac1.dasboard(retriveroll, email, userName);
					break;
				}
					break;
				case 3:
					// int retriveid = uc.retriveid(email,retriveroll); //Retrieve User id
					// pm.Printingrelative(retriveid);
					uc.printUser(user);
					System.out.print("Please Enter user id: ");
					int userid = Integer.parseInt(br.readLine());
					user.setUserid(userid);
					uc.deleteUser(user);
					uc.printUser(user);
				System.out.print("1.ADMIN DASHBOARD\n2.Home\nPlease Enter Your Choice:");
				int options3 = Integer.parseInt(br.readLine());
				switch (options3) {
				case 1:
					AdminController ac = new AdminController();
					ac.dasboard(retriveroll, email, userName);
					break;
				case 2:
					m.start();
					break;
				default:
					System.out.println("Invalid Input From :" + userName + "\nPlease Choose: |1|2| ");
					AdminController ac1 = new AdminController();
					ac1.dasboard(retriveroll, email, userName);
					break;
				}
				break;

			case 4:
				ih.raiseTicket(retriveroll, email, userName);

				System.out.print("1.ADMIN DASHBOARD\n2.Home\nPlease Enter Your Choice:");
				int options4 = Integer.parseInt(br.readLine());
				switch (options4) {
				case 1:
					AdminController ac = new AdminController();
					ac.dasboard(retriveroll, email, userName);
					break;
				case 2:
					m.start();
					break;
				default:
					System.out.println("Invalid Input From :" + userName + "\nPlease Choose: |1|2| ");
					AdminController ac1 = new AdminController();
					ac1.dasboard(retriveroll, email, userName);
					break;
				}

				break;
			case 5:
				ih.ModifyRecord(retriveroll, email, userName);

				System.out.print("1.ADMIN DASHBOARD\n2.Home\nPlease Enter Your Choice:");
				int options5 = Integer.parseInt(br.readLine());
				switch (options5) {
				case 1:
					AdminController ac = new AdminController();
					ac.dasboard(retriveroll, email, userName);
					break;
				case 2:
					m.start();
					break;
				default:
					System.out.println("Invalid Input From :" + userName + "\nPlease Choose: |1|2| ");
					AdminController ac1 = new AdminController();
					ac1.dasboard(retriveroll, email, userName);
					break;
				}
				break;

			case 6:
				System.out.print("STATUS TYPE:\n-------------\n1.open\n2.Work-In-Progress\n3.Pending\n4.Close\n5.Reopen"
						+ "\n\n" + "Please Enter Your Choice: ");
				int statusTicket = Integer.parseInt(br.readLine());
				it.setRollUser(retriveroll);
				it.setStatusTicket(statusTicket);
				ic.FilerByStatus(it);
				System.out.print("1.ADMIN DASHBOARD\n2.HOME\nPlease Enter Your Choice:");
				int options6 = Integer.parseInt(br.readLine());
				switch (options6) {
				case 1:
					AdminController ac = new AdminController();
					ac.dasboard(retriveroll, email, userName);
					break;
				case 2:
					m.start();
					break;
				default:
					System.out.println("Invalid Input From :" + userName + "\nPlease Choose: |1|2| ");
					AdminController ac1 = new AdminController();
					ac1.dasboard(retriveroll, email, userName);
					break;

				}
				break;

			case 7:

				System.out.print("PRIORITY TYPE:\n------------\n1.Low\n2.Medium\n3.High" + "\n\n"
						+ "Please Enter Your Choice: ");
				int priorityLinkID = Integer.parseInt(br.readLine());
				it.setRollUser(retriveroll);
				it.setPriorityLinkID(priorityLinkID);
				ic.FilerByPriority(it);

				System.out.print("1.ADMIN DASHBOARD\n2.HOME\nPlease Enter your Choice :");
				int options7 = Integer.parseInt(br.readLine());
				switch (options7) {
				case 1:
					AdminController ac = new AdminController();
					ac.dasboard(retriveroll, email, userName);
					break;
				case 2:
					m.start();
					break;
				default:
					System.out.println("Invalid Input From :" + userName + "\nPlease Choose: |1|2| ");
					AdminController ac1 = new AdminController();
					ac1.dasboard(retriveroll, email, userName);
					break;
				}
				break;
			case 8:

				System.out.print(
						"ISSUE TYPE:\n------------\n1.Task\n2.Bug\n3.Epic" + "\n\n" + "Please Enter Your Choice: ");
				int issuetypeLinkID = Integer.parseInt(br.readLine());
				it.setRollUser(retriveroll);
				it.setIssuetypeLinkID(issuetypeLinkID);
				ic.FilerByIssueType(it);

				System.out.print("1.ADMIN DASHBOARD\n2.HOME\nPlease Enter Your Choice:");
				int options8 = Integer.parseInt(br.readLine());
				switch (options8) {
				case 1:
					AdminController ac = new AdminController();
					ac.dasboard(retriveroll, email, userName);
					break;
				case 2:
					m.start();
					break;
				default:
					System.out.println("Invalid Input From :" + userName + "\nPlease Choose: |1|2| ");
					AdminController ac1 = new AdminController();
					ac1.dasboard(retriveroll, email, userName);
					break;
				}

				break;

			case 9:
				try {
				it.setRollUser(retriveroll);
				ic.CheckingAsingedTicketToYou(it);

				System.out.print("1.ADMIN DASHBOARD\n2.HOME\nPlease Enter Your Choice:");
				int options9 = Integer.parseInt(br.readLine());
				switch (options9) {
				case 1:
					AdminController ac = new AdminController();
					ac.dasboard(retriveroll, email, userName);
					break;
				case 2:
					m.start();
					break;
				default:
					System.out.println("Invalid Input From :" + userName + "\nPlease Choose: |1|2| ");
					AdminController ac1 = new AdminController();
					ac1.dasboard(retriveroll, email, userName);
					break;

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
							break;
						case 10:
							try {
								System.out.println("\n");
								System.out.println(
										"******************************USERS TABLE******************************");
								uc.printUser(user);
								System.out.println("\n");
								System.out.println("***************ADMIN TABLE***************");
								pm.printproject();
								System.out.println("\n");
								System.out.print("Enter Project id: ");
								int groupedProjectLinkedId = Integer.parseInt(br.readLine());
								System.out.print("Enter UserId id: ");
								int groupedUSerLinkedId = Integer.parseInt(br.readLine());

								Grouped gr = new Grouped();
								gr.setGroupedProjectLinkedId(groupedProjectLinkedId);
								gr.setGroupedUSerLinkedId(groupedUSerLinkedId);
								pm.Insertgropuingproject(gr);

								System.out.print("1.ADMIN DASHBOARD\n2.HOME\nPlease Enter your Choice :");
								try {
									int options10 = Integer.parseInt(br.readLine());//

									switch (options10) {
									case 1:
										AdminController ac = new AdminController();
										ac.dasboard(retriveroll, email, userName);
										break;
									case 2:
										m.start();
										break;
									default:
										System.out.println("It is an invalid option. Please select from 1 & 2.");
										AdminController ac1 = new AdminController();
										ac1.dasboard(retriveroll, email, userName);
										break;
									}
								} catch (Exception e) {
									System.out.println("PLEASE ENTER NUMBER ONLY...");
									AdminController ac1 = new AdminController();
									ac1.dasboard(retriveroll, email, userName);
								}
							} catch (SQLException ex) {
								System.out.println("");
								System.out.println("REPEATED COMBINATION PLEASE ADMIN CHOOSE DIFFERNET ONE ...!");
								AdminController ac1 = new AdminController();
								ac1.dasboard(retriveroll, email, userName);
							}
							break;

						case 11:
							ProjectMaintance prm = new ProjectMaintance();
							prm.checkingAssociation();

							System.out.print("1.ADMIN DASHBOARD\n2.HOME\nPlease Enter your Choice :");
							int options11 = Integer.parseInt(br.readLine());
							switch (options11) {
							case 1:
								AdminController ac = new AdminController();
								ac.dasboard(retriveroll, email, userName);
								break;
							case 2:
								m.start();
								break;
							default:
								System.out.println("Invalid Input From :" + userName + "\nPlease Choose: |1|2| ");
								AdminController ac1 = new AdminController();
								ac1.dasboard(retriveroll, email, userName);
								break;
							}
							break;
						case 12:
							ic.totalTable();

							System.out.print("1.ADMIN DASHBOARD\n2.HOME\nPlease Enter your Choice :");
							int optionss1 = Integer.parseInt(br.readLine());
							switch (optionss1) {
							case 1:
								AdminController ac = new AdminController();
								ac.dasboard(retriveroll, email, userName);
								break;
							case 2:
								m.start();
								break;
							default:
								System.out.println("Invalid Input From :" + userName + "\nPlease Choose: |1|2| ");
								AdminController ac1 = new AdminController();
								ac1.dasboard(retriveroll, email, userName);
								break;
						}
						break;
					case 13:
						m.start();
						break;

					default:
						System.out.println(
								"Invalid Input From " + userName
										+ "\nPlease Choose : |1|2|3|4|5|6|7|8|9|10|11|12|13| ");
						AdminController ac = new AdminController();
						ac.dasboard(retriveroll, email, userName);
						break;
	  }
	} catch (Exception e) {
		System.out.println("Invalid Input From " + userName);
		System.out.println("");

			AdminController ac = new AdminController();
			ac.dasboard(retriveroll, email, userName);

	}
}
}
