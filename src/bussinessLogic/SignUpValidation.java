package bussinessLogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpValidation
{
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	private static final String  EMAILID_PATTERN="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	private static final String MOBILENUMBER_PATTERN="^(0|91|\\+91)?-?[789]\\d{9}$";
	private Pattern pattern;
	 private Matcher matcher1,matcher2;

	public String checkUserDetails(String password,String confirmPassword) {
	   if(validPassword(password,confirmPassword))
			return "Both Passwords Matched.. Valid Password..";
		else
			return "Invalid Pasword.. Both Passwords Must Match..";
	}

	private boolean validPassword(String password, String confirmPassword) {
		
		
		 pattern = Pattern.compile(PASSWORD_PATTERN);
		 if(password.equals(confirmPassword)) {
		 
		 matcher1 = pattern.matcher(password);
		 matcher2 = pattern.matcher(confirmPassword);
	    return (matcher2.matches() && matcher1.matches());
		 }
		return false;
		 
	}
	public String validEmail(String email) {
		
		
		 pattern = Pattern.compile(EMAILID_PATTERN);
		 matcher1 = pattern.matcher(email);
		   if(matcher1.matches())
		   {
				return "Email Verified.. You can go with this..";
		   }
			return "Invalid Email Address.. Please Use Proper EMail Format..";
		  
	}
	public String validMobile(String mob) 
	{
		
		 pattern = Pattern.compile(MOBILENUMBER_PATTERN);
		 matcher1 = pattern.matcher(mob);
		   if(matcher1.matches())
		   {
				return "Mobile Number Verified..";
		   }
			return "Invalid Mobile Number..";
	}
	public String validFirstName(String fristName) 
	{
		
		if (fristName.equals(""))
		{
			return "It Should Not be a Null Value, Please Enter Valid First Name..";
		} else
		{
			return "Verified FirstName..";
		}
	}
	public String validLastName(String lastName) 
	{

		if (lastName.equals(""))
		{
			return "It Should Not be a Null Value, Please Enter Valid Last Name..";
		}else
		{
			return "Verified LastName..";
		}
		  
	}
	public String validUser(String userName) 
	{

		if (userName.equals(""))
		{
			return "It Should Not be a Null Value, Please Enter Valid User Name..";
		}else
		{
			return "Verified UserName..";
		  
		}
	}
	
	
}
