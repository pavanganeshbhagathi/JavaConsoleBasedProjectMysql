package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import service.ProjectMaintance;
import service.UserCreation;

public class LoginUsers {
	static ProjectMaintance pm=new ProjectMaintance();
		static UserCreation uc=new UserCreation();
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	

	public static void users(String retriveroll, String email, String userName)
			throws NumberFormatException, IOException, ClassNotFoundException, SQLException
{
	String admin="Admin";
	String developer="Developer";
	String  tester="Tester";
	String deployer = "Deployer";
   if(retriveroll.equals(admin))
   {
	      

		AdminController ac = new AdminController();
		ac.dasboard(retriveroll, email, userName);
	 	   
	  
	  
   }else if(retriveroll.equals(developer))
   {

	 	  int retriveid = uc.retriveid(email,retriveroll);//Retrieve User id
	 	 
	 	  boolean printingrelative = pm.Printingrelative(retriveid);
	 	  if(printingrelative)
	 	  {
				DeveloperController dc = new DeveloperController();
			dc.dasboard(retriveroll, email, userName);
	 	  }else
	 	  {
				System.out.println(
						"Hello DEVELOPER, No Projects are assigned to you yet.. \nPlease Ask Your Organisation :\nNow You Are Re-directed to Home Page");
		    	Main m=new Main ();
				m.start();
	 	   }
   }else if(retriveroll.equals(tester))
   {
	   int retriveid = uc.retriveid(email,retriveroll);//Retrieve User id
	 	 
	    boolean printingrelative = pm.Printingrelative(retriveid);
	    if(printingrelative)
	    {
			TesterController tc = new TesterController();
		tc.dasboard(retriveroll, email, userName);
	    }else
 	    {
			System.out.println(
					"Hello TESTER, No Projects are assigned to you yet.. \nPlease Ask Your Organisation :\nNow You Are Re-directed to Home Page");
	    	Main m=new Main ();
			m.start();
 	    }
   }
   else if(retriveroll.equals(deployer))
   {
	   int retriveid = uc.retriveid(email,retriveroll);//Retrieve User id
	 	 
	    boolean printingrelative = pm.Printingrelative(retriveid);
	    if(printingrelative)
	    {
			DeployerController dc = new DeployerController();
		dc.dasboard(retriveroll, email, userName);
	    }else
 	    {
			System.out.println(
					"Hello DEPLOYER, No Projects are assigned to you yet.. \nPlease Ask Your Organisation :\nNow You Are Re-directed to Home Page");
	    	Main m=new Main ();
			m.start();
 	    }
   }
}

}
