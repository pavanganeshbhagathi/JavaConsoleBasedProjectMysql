package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Grouped;
import Model.Project;
import utility.ConnectionManager;

public class ProjectMaintance
{

	// ######################################## INSERTING RECORD INTO PROJECT
	// #######################################################
 public void insertproject(Project project ) throws ClassNotFoundException, SQLException, IOException
 {
		Connection connection = ConnectionManager.getConnection();
		
		String javaquery="insert into project(projectName) values(?)";
		PreparedStatement pst=connection.prepareStatement(javaquery);
		pst.setString(1, project.getProjectName());
		pst.executeUpdate();
		connection.close();
 }

//######################################## ASSOCITION TO USER AND PROJECT RECORD INTO GROUP #######################################################
 public void Insertgropuingproject(Grouped gr) throws ClassNotFoundException, SQLException, IOException
 {
		Connection connection = ConnectionManager.getConnection();
		
		String javaquery="insert into groupingProject(project_id,user_id) values(?,?)";
		PreparedStatement pst=connection.prepareStatement(javaquery);
		pst.setInt(1, gr.getGroupedProjectLinkedId());
		pst.setInt(2, gr.getGroupedUSerLinkedId());
		pst.executeUpdate();
		connection.close();
 }

//######################################## PRINTING  RECORD IN PROJECT ADMIN ONLY CALL IT PRINT ALL PROJECTS #######################################################
 public void printproject() throws ClassNotFoundException, SQLException, IOException
 {
	 Connection connection = ConnectionManager.getConnection();
	 String sql = "SELECT * FROM project";
	 Statement stmt=  connection.createStatement();
	 ResultSet rs =stmt.executeQuery(sql);
	 System.out.println("--------------------------------------");
	 System.out.format("%15s %15s ","PROJECT_ID","PROJECT_NAME");
	 System.out.println("");
	 System.out.println("--------------------------------------");
	 while(rs.next())
	 { 
		    int tableProjectId = rs.getInt("projectId");
			String tableProjectName= rs.getString("projectName");
			
			//System.out.println(tableEmail+"    "+tablePassword);
			
			 System.out.format("%15d %15s ",tableProjectId ,tableProjectName);
			 System.out.println("");

	 }
	 System.out.println("--------------------------------------");
	 System.out.println("");
		connection.close();
 }

//######################################## PRINTING  RECORD IN PROJECT USER ONLY CALL IT PRINT RELATIVE ID BASED ON GROUPING TABLE #######################################################
 public void printGroupProject() throws ClassNotFoundException, SQLException, IOException
 {
	 Connection connection = ConnectionManager.getConnection();
	 String sql = "SELECT * FROM groupingProject";
	 Statement stmt=  connection.createStatement();
	 ResultSet rs =stmt.executeQuery(sql);
		System.out.println("--------------------------------------");
		System.out.format("%15s %15s ", "PROJECT_ID", "USER_ID");
		System.out.println("");
		System.out.println("--------------------------------------");
	 while(rs.next())
	 { 
			int tprojectId = rs.getInt("project_id");
			String tablePassword = rs.getString("user_id");
		
			
			// System.out.println(tableEmail+" "+tablePassword);
			System.out.format("%15d %15d ", tprojectId, tablePassword);
			System.out.println("");
			

	 }
		System.out.println("--------------------------------------");
		System.out.println("");
		connection.close();
	
 }
//######################################## DELETING  RECORD IN PROJECT USER ONLY CALL IT  RELATIVE TO ID BASED ON ADMIN CALL  #######################################################

 public void deleteProject(Project project) throws ClassNotFoundException, SQLException, IOException
 {
	
	 System.out.println(project.getProjectId());
	 Connection connection = ConnectionManager.getConnection();
	 Statement stmt=  connection.createStatement();
		int executeUpdate = stmt.executeUpdate("DELETE FROM project WHERE projectId =" +project.getProjectId()+" ");
		connection.close();
	
		
 }
//######################################## CREATING  PROJECT  ONLY BASED ON ADMIN CALL IT CHECKS WHETHER EXISTS PROJECT OR NOT  #######################################################

	public String serverSideProjectChecker(Project project) throws ClassNotFoundException, SQLException, IOException
	{
		String projectName = project.getProjectName(); 
		
		String query = "SELECT projectName  FROM project WHERE projectName  = '" +projectName + "'";
		 Connection connection = ConnectionManager.getConnection();
			

		
		 Statement stmt=  connection.createStatement();
		 ResultSet rs =stmt.executeQuery(query);
		 ConnectionManager.getConnection().close();
	      while(rs.next())
	      {
	    	  String projectname = rs.getString("projectName");
	    	  if(projectname .equals(projectName))
	    	  {
	    	  return "Please choose a different one.. ProjectName  already exists:" + projectname ;
	    	  }
	      }
			connection.close();
		return "ProjectName  Verified.. Please Go with it..";
		
		 
	}
	// ######################################## DELETING RECORD IN PROJECT USER ONLY
	// CALL IT RELATIVE TO ID BASED ON ADMIN CALL
	// #######################################################

	public boolean Printingrelative(int id) throws ClassNotFoundException, SQLException, IOException
	{
	
		String query = "select project.projectId,project.projectName  from users "
				+ " INNER JOIN groupingproject "
				+ "ON  users.usersId =groupingproject.user_id"
				+ " INNER JOIN project"
				+ "  ON  groupingproject.project_id=project.projectId " + "WHERE users.usersId =" + id ;
		int	count=0;	
			
				// WHERE projectName  = '" +projectName + "'";
		 Connection connection = ConnectionManager.getConnection();
			

		
		 Statement stmt=  connection.createStatement();
		 ResultSet rs =stmt.executeQuery(query);

		 System.out.println("--------------------------------------");
		 System.out.format("%15s %15s ","PROJECT_ID","PROJECT_NAME");
		 System.out.println("");
		 System.out.println("--------------------------------------");
		
	      while(rs.next())
	      {
	    	  String tableProjectName = rs.getString("project.projectName");
	           int tableProjectId = rs.getInt("project.projectId");
	        //   System.out.println(projectId +"   "+projectname);
	    	    count=count+1;
	    	
	    	    System.out.format("%15d %15s ",tableProjectId ,tableProjectName);
				 System.out.println("");
	      }
	       System.out.println("--------------------------------------");
	 	   System.out.println("");
			connection.close();
	      
	      if(count>0)
	      {
	    	  return true;
	      }
		return false;
		 
	}

	// ######################################## CHECKING ASSOCITION PROJECT &USER
	// ONLY
	// IT WILL REACT ADMIN CALL
	// #######################################################
	public void checkingAssociation() throws ClassNotFoundException, SQLException, IOException
	{
		
		
		String query = "select users.usersId,users.emailId,users.username,users.roll,project.projectId,project.projectName from users \r\n"
				+ 
				"INNER JOIN groupingproject\r\n" + 
				"ON  users.usersId =groupingproject.user_id\r\n" + 
				"INNER JOIN project \r\n" + 
				"ON  groupingproject.project_id=project.projectId";
		 Connection connection = ConnectionManager.getConnection();
			

		
		 Statement stmt=  connection.createStatement();
		 ResultSet rs =stmt.executeQuery(query);
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.format("%30s %30s %30s %17s %17s  %17s ", "USER_ID", "USER_EMAIL", "USER_NAME",
					"USER_ROLE",

					"PROJECT_ID",
					"PROJECT_NAME");
			System.out.println("");
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------");
	      while(rs.next())
	      {
	    	 
				String usersId = rs.getString("users.usersId");
	    	   String emailId = rs.getString("users.emailId");
				String userroll = rs.getString("users.roll");
	    	   String username = rs.getString("users.username");
				String projectId = rs.getString("project.projectId");
	    	   String projectname = rs.getString("project.projectName");
				// System.out.println(usersId +" "+emailId+" "+username+" "+projectId+"
				// "+projectname);
	    	
				System.out.format("%30s %30s %30s %17s %17s  %17s", usersId, emailId, username,
						userroll,
						projectId,
						projectname);
				System.out.println("");
	      }
	
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------");
			connection.close();
	}

//######################################################################### Modify time authorization checking##############################################
	public boolean modifyAuthorization(String modifyUserName,
			int projectide)
			throws ClassNotFoundException, SQLException, IOException {

		String query = "select users.username,project.projectId from users \r\n" + "INNER JOIN groupingproject\r\n"
				+ "ON  users.usersId =groupingproject.user_id\r\n" + "INNER JOIN project \r\n"
				+ "ON  groupingproject.project_id=project.projectId\r\n" + "INNER JOIN  issusetracker\r\n"
				+ "ON issusetracker.projectLinkId=project.projectId\r\n";

		Connection connection = ConnectionManager.getConnection();

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {


			String username = rs.getString("users.username");
			int projectId = rs.getInt("project.projectId");

			if (username.equals(modifyUserName) && projectId == projectide) {
				return true;
			}

		}

		connection.close();
		return false;
	}

	public int issueProjectTracker(int id) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = ConnectionManager.getConnection();

		String sql = "SELECT  issusetracker.issuertrackerid,project.projectId\r\n" + ",issueDate,closedDate\r\n"
				+ " FROM issuseTracker\r\n" + "INNER JOIN project\r\n"
				+ "ON  issuseTracker.projectLinkId =project.projectId\r\n" + "INNER JOIN statusticket \r\n"
				+ "ON  issuseTracker.statusTicket=statusTicket.statusTicketId\r\n" + "INNER JOIN issuetype\r\n"
				+ "ON issuseTracker.issuetypeLinkId=issuetype.issueTypeid\r\n" + "INNER JOIN prioritytype\r\n"
				+ "ON issuseTracker.priorityLinkId=prioritytype.prioriTypeId\r\n" + " WHERE "
				+ "issusetracker.issuertrackerid = '" + id + "'";
		// +" AND " + "issuseTracker.AssigneeTo = '" + rollUser2 + "'";

		// " WHERE " + "issusetracker.rollUser = " + " 'Admin' " + " AND " +
		// "issuseTracker.AssigneeTo = " + " 'Developer'";

		// " WHERE " + "issusetracker.rollUser = " + " 'Admin' " + " AND " +
		// "issuseTracker.AssigneeTo = " + " 'Developer'";

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int id1 = rs.getInt("issusetracker.issuertrackerid");
			int projectid = rs.getInt("project.projectId");


				return projectid;


		}
		return 0;
	}

}
