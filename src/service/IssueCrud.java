package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.IssueTracker;
import utility.ConnectionManager;

public class IssueCrud {
	
	
	///####################################### INSERTING RECORD TO ISUUE TRACKER############################################
	public void InsertDataIntoIssueTracker(IssueTracker iT) throws ClassNotFoundException, SQLException, IOException
	{
		Connection connection = ConnectionManager.getConnection();
		
                                                           //1       2               3               4           5       6          7          8         9               10        11                1.2.3.4.5.6.7.8.9.10.11
		String javaquery="insert into issuseTracker (projectLinkId,issuetypeLinkId,priorityLinkId,statusTicket,rollUser,AssignedBy,AssigneeTo,summary,issueDescription,issueDate,closedDate) values(?,?,?,?,?,?,?,?,?, ?, ?)";
		PreparedStatement pst=connection.prepareStatement(javaquery);
		
		pst.setInt(1,iT.getProjectLinkID());
		pst.setInt(2, iT.getIssuetypeLinkID());
		pst.setInt(3, iT.getPriorityLinkID());
		pst.setInt(4, iT.getStatusTicket());
		pst.setString(5, iT.getRollUser());
		pst.setString(6, iT.getAssignedBy());
		pst.setString(7, iT.getAssigeeTo());
		pst.setString(8, iT.getSummary());
		pst.setString(9, iT.getIssueDescription());
		pst.setString(10, iT.getIssueDate());
		pst.setString(11, iT.getCloseDate());	
		pst.executeUpdate();
		connection.close();
	}
	///####################################### FILTER BY PROPRITY ASSIGNEED TICKETS TO YOU ############################################
	public void FilerByPriority(IssueTracker iT) throws ClassNotFoundException, SQLException, IOException
	{
		Connection connection = ConnectionManager.getConnection();
		
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                //Sting                                            //int
		// String sql = "SELECT issusetracker.issuertrackerid,project.projectName,issuetype.issueType,prioritytype.priority,statusticket.statusTicket,rollUser,AssignedBy,AssigneeTo,summary,issueDescription,issueDate,closedDate FROM issuseTracker INNER JOIN project ON  issuseTracker.projectLinkId =project.projectId INNER JOIN statusticket ON  issuseTracker.statusTicket=statusTicket.statusTicketId INNER JOIN issuetype ON issuseTracker.issuetypeLinkId=issuetype.issueTypeid INNER JOIN prioritytype ON issuseTracker.priorityLinkId=prioritytype.prioriTypeId WHERE  issuseTracker.rollUser= ' " + iT.getRollUser() +" 'AND issuseTracker.priority= ' " + iT.getPriorityLinkID() +" ' ";;
		
		String rollUser2 = iT.getRollUser();
	    int priorityLinkID = iT.getPriorityLinkID();
		String sql="SELECT  issusetracker.issuertrackerid,prioritytype.priority,project.projectName,issuetype.issueType,statusticket.statusTicket\r\n" + 
				",rollUser,AssignedBy,AssigneeTo,summary,issueDescription\r\n" + 
				",issueDate,closedDate\r\n" + 
				" FROM issuseTracker\r\n" + 
				"INNER JOIN project\r\n" + 
				"ON  issuseTracker.projectLinkId =project.projectId\r\n" + 
				"INNER JOIN statusticket \r\n" + 
				"ON  issuseTracker.statusTicket=statusTicket.statusTicketId\r\n" + 
				"INNER JOIN issuetype\r\n" + 
				"ON issuseTracker.issuetypeLinkId=issuetype.issueTypeid\r\n" + 
				"INNER JOIN prioritytype\r\n" + 
				"ON issuseTracker.priorityLinkId=prioritytype.prioriTypeId\r\n" +
				" WHERE " + "issusetracker.AssigneeTo = '" + rollUser2 + "'"
				+ " AND " + "issuseTracker.priorityLinkId = '" + priorityLinkID + "'";
		
		
		
		 Statement stmt=  connection.createStatement();
		 ResultSet rs =stmt.executeQuery(sql);
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			// 1 2 3 4 5 6 7 8 9 10 11 12 1 2 3 4 5 6 7 8 9 10 11 12
			System.out.format(
					"%15s %15s %15s %15s %15s %15s %15s %15s %40s %40s %30s %30s",
					"ISSUETRACKER_ID",
					"PROJECT_NAME", "ISSUE_TYPE", "PRIORITY_TYPE", "STATUS_TYPE", "ROLL_USER", "ASSIGNED_BY",
					"ASSIGNED_TO", "SUMMARY", "ISSUE_DESCRIPTION", "ISSUE_DATE", "ISSUE_CLOSED_DATE");
		 System.out.println("");
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			while (rs.next())
		 { 
			    int id = rs.getInt("issusetracker.issuertrackerid");
				String projectName = rs.getString("project.projectName");
				
				String issueType=rs.getString("issuetype.issueType");
				String prioritytype=rs.getString("prioritytype.priority");
				String statusticket=rs.getString("statusticket.statusTicket");
				String rollUser=rs.getString("rollUser");
				String AssignedBy=rs.getString("AssignedBy");
				String AssigneeTo = rs.getString("AssigneeTo");
				String summary=rs.getString("summary");
				String issueDescription=rs.getString("issueDescription");
				String issueDate=rs.getString("issueDate");
				String closedDate=rs.getString("closedDate");

				
				//System.out.println(id+"  "+projectName+"  "+issueType+"  "+prioritytype+"  "+statusticket+"  "+rollUser+"  "+AssignedBy+"  "+AssigneeTo+"  "+summary+"  "+issueDescription+"  "+issueDate+"  "+closedDate);
				
				System.out.format("%15s %15s %15s %15s %15s %15s %15s %15s %40s %40s %30s %30s", id,
						projectName,
						issueType, prioritytype, statusticket, rollUser, AssignedBy, AssigneeTo, summary,
						issueDescription, issueDate, closedDate);
				System.out.println("");


		 }
		
	
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
	
	///####################################### FILTER BY ISSUETYPE ASSIGNEED TICKETS TO YOU ############################################
	public void FilerByIssueType(IssueTracker iT) throws ClassNotFoundException, SQLException, IOException
	{
		Connection connection = ConnectionManager.getConnection();
		
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                //Sting                                            //int
		// String sql = "SELECT issusetracker.issuertrackerid,project.projectName,issuetype.issueType,prioritytype.priority,statusticket.statusTicket,rollUser,AssignedBy,AssigneeTo,summary,issueDescription,issueDate,closedDate FROM issuseTracker INNER JOIN project ON  issuseTracker.projectLinkId =project.projectId INNER JOIN statusticket ON  issuseTracker.statusTicket=statusTicket.statusTicketId INNER JOIN issuetype ON issuseTracker.issuetypeLinkId=issuetype.issueTypeid INNER JOIN prioritytype ON issuseTracker.priorityLinkId=prioritytype.prioriTypeId WHERE  issuseTracker.rollUser= ' " + iT.getRollUser() +" 'AND issuetype.issueType= ' " + iT.getIssuetypeLinkID()+" ' ";
		String rollUser2 = iT.getRollUser();
		int issuetypeLinkID = iT.getIssuetypeLinkID();
		String sql="SELECT  issusetracker.issuertrackerid,prioritytype.priority,project.projectName,issuetype.issueType,statusticket.statusTicket\r\n" + 
				",rollUser,AssignedBy,AssigneeTo,summary,issueDescription\r\n" + 
				",issueDate,closedDate\r\n" + 
				" FROM issuseTracker\r\n" + 
				"INNER JOIN project\r\n" + 
				"ON  issuseTracker.projectLinkId =project.projectId\r\n" + 
				"INNER JOIN statusticket \r\n" + 
				"ON  issuseTracker.statusTicket=statusTicket.statusTicketId\r\n" + 
				"INNER JOIN issuetype\r\n" + 
				"ON issuseTracker.issuetypeLinkId=issuetype.issueTypeid\r\n" + 
				"INNER JOIN prioritytype\r\n" + 
				"ON issuseTracker.priorityLinkId=prioritytype.prioriTypeId\r\n" +
				" WHERE " + "issusetracker.AssigneeTo = '" + rollUser2 + "'"
				+ " AND " + "issuseTracker.issuetypeLinkId = '" + issuetypeLinkID + "'";
		
		
			Statement stmt=  connection.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.format(
					"%15s %15s %15s %15s %15s %15s %15s %15s %40s %40s %30s %30s",
					"ISSUETRACKER_ID",
					"PROJECT_NAME", "ISSUE_TYPE", "PRIORITY_TYPE", "STATUS_TYPE", "ROLL_USER", "ASSIGNED_BY",
					"ASSIGNED_TO", "SUMMARY", "ISSUE_DESCRIPTION", "ISSUE_DATE", "ISSUE_CLOSED_DATE");
			System.out.println("");
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			while (rs.next())
		 { 
			    int id = rs.getInt("issusetracker.issuertrackerid");
				String projectName = rs.getString("project.projectName");
				
				String issueType=rs.getString("issuetype.issueType");
				String prioritytype=rs.getString("prioritytype.priority");
				String statusticket=rs.getString("statusticket.statusTicket");
				String rollUser=rs.getString("rollUser");
				String AssignedBy=rs.getString("AssignedBy");
				String AssigneeTo=rs.getString("AssigneeTo");
				String summary=rs.getString("summary");
				String issueDescription=rs.getString("issueDescription");
				String issueDate=rs.getString("issueDate");
				String closedDate=rs.getString("closedDate");

				
				//System.out.println(id+"  "+projectName+"  "+issueType+"  "+prioritytype+"  "+statusticket+"  "+rollUser+"  "+AssignedBy+"  "+AssigneeTo+"  "+summary+"  "+issueDescription+"  "+issueDate+"  "+closedDate);
				
				System.out.format("%15d %15s %15s %15s %15s %15s %15s %15s %40s %40ss %30s %30s", id, projectName,
						issueType, prioritytype, statusticket, rollUser, AssignedBy, AssigneeTo, summary,
						issueDescription, issueDate, closedDate);
				System.out.println("");


		 }
		
		
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
	
	///####################################### FILTER BY STATUS ASSIGNEED TICKETS TO YOU ############################################
	public void FilerByStatus(IssueTracker iT) throws ClassNotFoundException, SQLException, IOException
	{
		Connection connection = ConnectionManager.getConnection();
		
		// String sql = "SELECT issusetracker.issuertrackerid,project.projectName,issuetype.issueType,prioritytype.priority,statusticket.statusTicket,rollUser,AssignedBy,AssigneeTo,summary,issueDescription,issueDate,closedDate FROM issuseTracker INNER JOIN project ON  issuseTracker.projectLinkId =project.projectId INNER JOIN statusticket ON  issuseTracker.statusTicket=statusTicket.statusTicketId INNER JOIN issuetype ON issuseTracker.issuetypeLinkId=issuetype.issueTypeid INNER JOIN prioritytype ON issuseTracker.priorityLinkId=prioritytype.prioriTypeId WHERE  issuseTracker.rollUser= ' " + iT.getRollUser() +" 'AND statusticket.statusTicket= ' " + iT.getStatusTicket()+" ' ";
		String rollUser2 = iT.getRollUser();
		System.out.println(rollUser2);

		int statusTicket2 = iT.getStatusTicket();
		System.out.println(statusTicket2);
		String sql="SELECT  issusetracker.issuertrackerid,prioritytype.priority,project.projectName,issuetype.issueType,statusticket.statusTicket\r\n" + 
				",rollUser,AssignedBy,AssigneeTo,summary,issueDescription\r\n" + 
				",issueDate,closedDate\r\n" + 
				" FROM issuseTracker\r\n" + 
				"INNER JOIN project\r\n" + 
				"ON  issuseTracker.projectLinkId =project.projectId\r\n" + 
				"INNER JOIN statusticket \r\n" + 
				"ON  issuseTracker.statusTicket=statusTicket.statusTicketId\r\n" + 
				"INNER JOIN issuetype\r\n" + 
				"ON issuseTracker.issuetypeLinkId=issuetype.issueTypeid\r\n" + 
				"INNER JOIN prioritytype\r\n" + 
				"ON issuseTracker.priorityLinkId=prioritytype.prioriTypeId\r\n" +
				" WHERE " + "issusetracker.AssigneeTo = '" + rollUser2 + "'"
				+ " AND " + "issuseTracker.statusTicket = '" + statusTicket2 + "'";
		 Statement stmt=  connection.createStatement();
		 ResultSet rs =stmt.executeQuery(sql);
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.format(
					"%15s %15s %15s %15s %15s %15s %15s %15s %40s %40s %30s %30s",
					"ISSUETRACKER_ID",
					"PROJECT_NAME", "ISSUE_TYPE", "PRIORITY_TYPE", "STATUS_TYPE", "ROLL_USER", "ASSIGNED_BY",
					"ASSIGNED_TO", "SUMMARY", "ISSUE_DESCRIPTION", "ISSUE_DATE", "ISSUE_CLOSED_DATE");
		 System.out.println("");
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			while (rs.next())
		 { 
			    int id = rs.getInt("issusetracker.issuertrackerid");
				String projectName = rs.getString("project.projectName");
				String issueType=rs.getString("issuetype.issueType");
				String prioritytype=rs.getString("prioritytype.priority");
				String statusticket=rs.getString("statusticket.statusTicket");
				String rollUser=rs.getString("rollUser");
				String AssignedBy=rs.getString("AssignedBy");
				String AssigneeTo=rs.getString("AssigneeTo");
				String summary=rs.getString("summary");
				String issueDescription=rs.getString("issueDescription");
				String issueDate=rs.getString("issueDate");
				String closedDate=rs.getString("closedDate");

				
				//System.out.println(id+"  "+projectName+"  "+issueType+"  "+prioritytype+"  "+statusticket+"  "+rollUser+"  "+AssignedBy+"  "+AssigneeTo+"  "+summary+"  "+issueDescription+"  "+issueDate+"  "+closedDate);
				
				System.out.format("%15d %15s %15s %15s %15s %15s %15s %15s %40s %40s %30s %30s", id, projectName,
						issueType, prioritytype, statusticket, rollUser, AssignedBy, AssigneeTo, summary,
						issueDescription, issueDate, closedDate);
				System.out.println("");


		 }
		
		
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
	
	///####################################### FILTER BY ROLE ############################################
	public void FilerByRoll(IssueTracker iT) throws ClassNotFoundException, SQLException, IOException
	{
		Connection connection = ConnectionManager.getConnection();
		
		String rollUser2 = iT.getRollUser();
		// String sql = "SELECT issusetracker.issuertrackerid,project.projectName,issuetype.issueType,prioritytype.priority,statusticket.statusTicket,rollUser,AssignedBy,AssigneeTo,summary,issueDescription,issueDate,closedDate FROM issuseTracker INNER JOIN project ON  issuseTracker.projectLinkId =project.projectId INNER JOIN statusticket ON  issuseTracker.statusTicket=statusTicket.statusTicketId INNER JOIN issuetype ON issuseTracker.issuetypeLinkId=issuetype.issueTypeid INNER JOIN prioritytype ON issuseTracker.priorityLinkId=prioritytype.prioriTypeId WHERE  issuseTracker.rollUser= ' " + iT.getRollUser() +" ' ";
		
		String sql="SELECT  issusetracker.issuertrackerid,prioritytype.priority,project.projectName,issuetype.issueType,statusticket.statusTicket\r\n" + 
				",rollUser,AssignedBy,AssigneeTo,summary,issueDescription\r\n" + 
				",issueDate,closedDate\r\n" + 
				" FROM issuseTracker\r\n" + 
				"INNER JOIN project\r\n" + 
				"ON  issuseTracker.projectLinkId =project.projectId\r\n" + 
				"INNER JOIN statusticket \r\n" + 
				"ON  issuseTracker.statusTicket=statusTicket.statusTicketId\r\n" + 
				"INNER JOIN issuetype\r\n" + 
				"ON issuseTracker.issuetypeLinkId=issuetype.issueTypeid\r\n" + 
				"INNER JOIN prioritytype\r\n" + 
				"ON issuseTracker.priorityLinkId=prioritytype.prioriTypeId\r\n" +
				" WHERE " + "issusetracker.rollUser = '" + rollUser2 + "'" ;
			//	+" AND " + "issuseTracker.AssigneeTo = '" + rollUser2 + "'";
		
		//" WHERE " + "issusetracker.rollUser = " + " 'Admin' " + " AND " + "issuseTracker.AssigneeTo = " + " 'Developer'";
		
				//" WHERE " + "issusetracker.rollUser = " + " 'Admin' " + " AND " + "issuseTracker.AssigneeTo = " + " 'Developer'";
			
		 Statement stmt=  connection.createStatement();
		 ResultSet rs =stmt.executeQuery(sql);
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.format(
					"%15s %15s %15s %15s %15s %15s %15s %15s %40s %40s %30s %30s",
						"ISSUETRACKER_ID",
						"PROJECT_NAME", "ISSUE_TYPE", "PRIORITY_TYPE", "STATUS_TYPE", "ROLL_USER", "ASSIGNED_BY",
						"ASSIGNED_TO", "SUMMARY", "ISSUE_DESCRIPTION", "ISSUE_DATE", "ISSUE_CLOSED_DATE");
			 System.out.println("");
			 System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				while (rs.next())
		           { 
			    int id = rs.getInt("issusetracker.issuertrackerid");
				String projectName = rs.getString("project.projectName");
				
				String issueType=rs.getString("issuetype.issueType");
				String prioritytype=rs.getString("prioritytype.priority");
				String statusticket=rs.getString("statusticket.statusTicket");
				String rollUser=rs.getString("rollUser");
				String AssignedBy=rs.getString("AssignedBy");
				String AssigneeTo=rs.getString("AssigneeTo");
				String summary=rs.getString("summary");
				String issueDescription=rs.getString("issueDescription");
				String issueDate=rs.getString("issueDate");
				String closedDate=rs.getString("closedDate");

			
			//	System.out.println(id+"  "+projectName+" "+issueType+"   "+prioritytype+"   "+statusticket+"  "+rollUser+"  "+AssignedBy+"  "+AssigneeTo+"  "+summary+"  "+issueDescription+"  "+issueDate+"  "+closedDate);
				
				System.out.format("%15d %15s %15s %15s %15s %15s %15s %15s %40s %40s %30s %30s", id, projectName,
						issueType, prioritytype, statusticket, rollUser, AssignedBy, AssigneeTo, summary,
						issueDescription, issueDate, closedDate);
				System.out.println("");

		 }
		
		
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
	
	
	 
///####################################### MODIFIED ASSIGNEED TICKETS TO YOU ############################################
	public void modifiedTicket(IssueTracker ist,int id) throws ClassNotFoundException, SQLException, IOException
	{
		
		
		Connection connection = ConnectionManager.getConnection();
		int issuetypeLinkID = ist.getIssuetypeLinkID();
		int priorityLinkID = ist.getPriorityLinkID();
		int statusTicket = ist.getStatusTicket();
		String rollUser = ist.getRollUser();
		String assignedBy = ist.getAssignedBy();
		String assigeeTo = ist.getAssigeeTo();
		String closeDate = ist.getCloseDate();
		String sql = "UPDATE issuseTracker SET issuetypeLinkId=" +issuetypeLinkID +",priorityLinkId = " + priorityLinkID + ", statusTicket = " + statusTicket + ", rollUser = '" + rollUser +"', AssignedBy = '" +assignedBy + "', AssigneeTo = '" + assigeeTo + "', closedDate = '" + closeDate + "'WHERE issuertrackerid="+ id;
		Statement stmt=  connection.createStatement();
		
		
		 int executeUpdate = stmt.executeUpdate(sql);
	System.out.println("Successfully Modified");
	}
	
	 
///####################################### CHECKING ASSIGNEED TICKETS TO YOU ############################################
	public void CheckingAsingedTicketToYou(IssueTracker iT) throws ClassNotFoundException, SQLException, IOException
	{
		Connection connection = ConnectionManager.getConnection();
		
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                //Sting                                            //int
		// String sql = "SELECT issusetracker.issuertrackerid,project.projectName,issuetype.issueType,prioritytype.priority,statusticket.statusTicket,rollUser,AssignedBy,AssigneeTo,summary,issueDescription,issueDate,closedDate FROM issuseTracker INNER JOIN project ON  issuseTracker.projectLinkId =project.projectId INNER JOIN statusticket ON  issuseTracker.statusTicket=statusTicket.statusTicketId INNER JOIN issuetype ON issuseTracker.issuetypeLinkId=issuetype.issueTypeid INNER JOIN prioritytype ON issuseTracker.priorityLinkId=prioritytype.prioriTypeId WHERE  issuseTracker.rollUser= ' " + iT.getRollUser() +" 'AND issuetype.issueType= ' " + iT.getIssuetypeLinkID()+" ' ";
		String rollUser2 = iT.getRollUser();
		int issuetypeLinkID = iT.getIssuetypeLinkID();
		String sql="SELECT  issusetracker.issuertrackerid,prioritytype.priority,project.projectName,issuetype.issueType,statusticket.statusTicket\r\n" + 
				",rollUser,AssignedBy,AssigneeTo,summary,issueDescription\r\n" + 
				",issueDate,closedDate\r\n" + 
				" FROM issuseTracker\r\n" + 
				"INNER JOIN project\r\n" + 
				"ON  issuseTracker.projectLinkId =project.projectId\r\n" + 
				"INNER JOIN statusticket \r\n" + 
				"ON  issuseTracker.statusTicket=statusTicket.statusTicketId\r\n" + 
				"INNER JOIN issuetype\r\n" + 
				"ON issuseTracker.issuetypeLinkId=issuetype.issueTypeid\r\n" + 
				"INNER JOIN prioritytype\r\n" + 
				"ON issuseTracker.priorityLinkId=prioritytype.prioriTypeId\r\n" +
				" WHERE " + "issusetracker.AssigneeTo = '" + rollUser2 + "'";
			
		
		
		 Statement stmt=  connection.createStatement();
		 ResultSet rs =stmt.executeQuery(sql);
		 System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");		//                    1   2    3    4    5    6   7     8   9     10   11  12        1                2             3             4              5             6             7             8            9               10           11               12
			// 1 2 3 4 5 6 7 8 9 10 11 12 1 2 3 4 5 6 7 8 9 10 11 12

			System.out
					.format(
					"%15s %15s %15s %15s %15s %15s %15s %15s %40s %40s %30s %30s",
					"ISSUETRACKER_ID",
					"PROJECT_NAME", "ISSUE_TYPE", "PRIORITY_TYPE", "STATUS_TYPE", "ROLL_USER", "ASSIGNED_BY",
					"ASSIGNED_TO", "SUMMARY", "ISSUE_DESCRIPTION", "ISSUE_DATE", "ISSUE_CLOSED_DATE");
		 System.out.println("");
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			while (rs.next())
		 { 
			    int id = rs.getInt("issusetracker.issuertrackerid");
				String projectName = rs.getString("project.projectName");
				
				String issueType=rs.getString("issuetype.issueType");
				String prioritytype=rs.getString("prioritytype.priority");
				String statusticket=rs.getString("statusticket.statusTicket");
				String rollUser=rs.getString("rollUser");
				String AssignedBy=rs.getString("AssignedBy");
				String AssigneeTo=rs.getString("AssigneeTo");
				String summary=rs.getString("summary");
				String issueDescription=rs.getString("issueDescription");
				String issueDate=rs.getString("issueDate");
				String closedDate=rs.getString("closedDate");

				
			//	System.out.println(id+"  "+projectName+"  "+issueType+"  "+prioritytype+"  "+statusticket+"  "+rollUser+"  "+AssignedBy+"  "+AssigneeTo+"  "+summary+"  "+issueDescription+"  "+issueDate+"  "+closedDate);
				//                  1    2    3   4      5   6    7   8    9    10   11   12    1    2          3         4              5          6        7           8         9        10             11         12
				System.out.format("%15d %15s %15s %15s %15s %15s %15s %15s %40s %40s %30s %30s", id, projectName,
						issueType, prioritytype, statusticket, rollUser, AssignedBy, AssigneeTo, summary,
						issueDescription, issueDate, closedDate);
				System.out.println("");

		 }
		
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
	
	///####################################### TOATAL TABLE ############################################
	public void totalTable() throws ClassNotFoundException, SQLException, IOException
	{
		Connection connection = ConnectionManager.getConnection();
		
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                //Sting                                            //int
		// String sql = "SELECT issusetracker.issuertrackerid,project.projectName,issuetype.issueType,prioritytype.priority,statusticket.statusTicket,rollUser,AssignedBy,AssigneeTo,summary,issueDescription,issueDate,closedDate FROM issuseTracker INNER JOIN project ON  issuseTracker.projectLinkId =project.projectId INNER JOIN statusticket ON  issuseTracker.statusTicket=statusTicket.statusTicketId INNER JOIN issuetype ON issuseTracker.issuetypeLinkId=issuetype.issueTypeid INNER JOIN prioritytype ON issuseTracker.priorityLinkId=prioritytype.prioriTypeId WHERE  issuseTracker.rollUser= ' " + iT.getRollUser() +" 'AND issuetype.issueType= ' " + iT.getIssuetypeLinkID()+" ' ";
		
		String sql="SELECT  project.projectName,issusetracker.issuertrackerid,prioritytype.priority,issuetype.issueType,statusticket.statusTicket\r\n" + 
				",rollUser,AssignedBy,AssigneeTo,summary,issueDescription\r\n" + 
				",issueDate,closedDate FROM  project\r\n" + 
				"LEFT JOIN issuseTracker\r\n" + 
				"ON  issuseTracker.projectLinkId =project.projectId\r\n" + 
				"LEFT JOIN statusticket \r\n" + 
				"ON  issuseTracker.statusTicket=statusTicket.statusTicketId\r\n" + 
				"LEFT JOIN issuetype\r\n" + 
				"ON issuseTracker.issuetypeLinkId=issuetype.issueTypeid\r\n" + 
				"LEFT JOIN prioritytype\r\n" + 
				"ON issuseTracker.priorityLinkId=prioritytype.prioriTypeId";
			
		
		
		Statement stmt=  connection.createStatement();
		 ResultSet rs =stmt.executeQuery(sql);
		 System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");			//                    1   2    3    4    5    6   7     8   9     10   11  12        1                2             3             4              5             6             7             8            9               10           11               12
			System.out.format(
					"%15s %15s %15s %15s %15s %15s %15s %15s %40s %40s %30s %30s",
					"ISSUETRACKER_ID",
					"PROJECT_NAME", "ISSUE_TYPE", "PRIORITY_TYPE", "STATUS_TYPE", "ROLL_USER", "ASSIGNED_BY",
					"ASSIGNED_TO", "SUMMARY", "ISSUE_DESCRIPTION", "ISSUE_DATE", "ISSUE_CLOSED_DATE");
			 System.out.println("");
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				while (rs.next())
		 { 
			    int id = rs.getInt("issusetracker.issuertrackerid");
				String projectName = rs.getString("project.projectName");
				
				String issueType=rs.getString("issuetype.issueType");
				String prioritytype=rs.getString("prioritytype.priority");
				String statusticket=rs.getString("statusticket.statusTicket");
				String rollUser=rs.getString("rollUser");
				String AssignedBy=rs.getString("AssignedBy");
				String AssigneeTo=rs.getString("AssigneeTo");
				String summary=rs.getString("summary");
				String issueDescription=rs.getString("issueDescription");
				String issueDate=rs.getString("issueDate");
				String closedDate=rs.getString("closedDate");

				
				//System.out.println(id+"  "+projectName+"  "+issueType+"  "+prioritytype+"  "+statusticket+"  "+rollUser+"  "+AssignedBy+"  "+AssigneeTo+"  "+summary+"  "+issueDescription+"  "+issueDate+"  "+closedDate);
				
				System.out.format("%15s %15s %15s %15s %15s %15s %15s %15s %40s %40s %30s %30s",
						id,
						projectName, issueType, prioritytype, statusticket, rollUser, AssignedBy, AssigneeTo, summary,
						issueDescription, issueDate, closedDate);
				System.out.println("");

		 }
		
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	// #################################################################################Searching
	// issue table project id and return that id



}
