package Model;

public class Users
{
	private int userid;
	private String emailId;
	private String password;
	private String roll;
	private String userName;
	private String fristName;
	private String lastname;
	private String mobilenumber;
	public Users() {
		
	}
	public Users(int userid, String emailId, String password, String roll, String userName, String fristName,
			String lastname, String mobilenumber) {
		super();
		this.userid = userid;
		this.emailId = emailId;
		this.password = password;
		this.roll = roll;
		this.userName = userName;
		this.fristName = fristName;
		this.lastname = lastname;
		this.mobilenumber = mobilenumber;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", emailId=" + emailId + ", password=" + password + ", roll=" + roll
				+ ", userName=" + userName + ", fristName=" + fristName + ", lastname=" + lastname + ", mobilenumber="
				+ mobilenumber + "]";
	}
	
	
	
}
