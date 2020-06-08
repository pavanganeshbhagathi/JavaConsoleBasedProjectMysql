package Model;

public class IssueTracker 
{
 private  int projectLinkID;
 private int issuetypeLinkID;
 private int priorityLinkID;
 private int statusTicket;
 private String rollUser;
 private String AssignedBy;
 private String AssigeeTo;
 private String summary;
 private String issueDescription;
 private String issueDate;
 private String closeDate;
public IssueTracker() {

}
public IssueTracker(int projectLinkID, int issuetypeLinkID, int priorityLinkID, int statusTicket, String rollUser,
		String assignedBy, String assigeeTo, String summary, String issueDescription, String issueDate,
		String closeDate) {
	super();
	this.projectLinkID = projectLinkID;
	this.issuetypeLinkID = issuetypeLinkID;
	this.priorityLinkID = priorityLinkID;
	this.statusTicket = statusTicket;
	this.rollUser = rollUser;
	AssignedBy = assignedBy;
	AssigeeTo = assigeeTo;
	this.summary = summary;
	this.issueDescription = issueDescription;
	this.issueDate = issueDate;
	this.closeDate = closeDate;
}
public int getProjectLinkID() {
	return projectLinkID;
}
public void setProjectLinkID(int projectLinkID) {
	this.projectLinkID = projectLinkID;
}
public int getIssuetypeLinkID() {
	return issuetypeLinkID;
}
public void setIssuetypeLinkID(int issuetypeLinkID) {
	this.issuetypeLinkID = issuetypeLinkID;
}
public int getPriorityLinkID() {
	return priorityLinkID;
}
public void setPriorityLinkID(int priorityLinkID) {
	this.priorityLinkID = priorityLinkID;
}
public int getStatusTicket() {
	return statusTicket;
}
public void setStatusTicket(int statusTicket) {
	this.statusTicket = statusTicket;
}
public String getRollUser() {
	return rollUser;
}
public void setRollUser(String rollUser) {
	this.rollUser = rollUser;
}
public String getAssignedBy() {
	return AssignedBy;
}
public void setAssignedBy(String assignedBy) {
	AssignedBy = assignedBy;
}
public String getAssigeeTo() {
	return AssigeeTo;
}
public void setAssigeeTo(String assigeeTo) {
	AssigeeTo = assigeeTo;
}
public String getSummary() {
	return summary;
}
public void setSummary(String summary) {
	this.summary = summary;
}
public String getIssueDescription() {
	return issueDescription;
}
public void setIssueDescription(String issueDescription) {
	this.issueDescription = issueDescription;
}
public String getIssueDate() {
	return issueDate;
}
public void setIssueDate(String issueDate) {
	this.issueDate = issueDate;
}
public String getCloseDate() {
	return closeDate;
}
public void setCloseDate(String closeDate) {
	this.closeDate = closeDate;
}
@Override
public String toString() {
	return "IssueTracker [projectLinkID=" + projectLinkID + ", issuetypeLinkID=" + issuetypeLinkID + ", priorityLinkID="
			+ priorityLinkID + ", statusTicket=" + statusTicket + ", rollUser=" + rollUser + ", AssignedBy="
			+ AssignedBy + ", AssigeeTo=" + AssigeeTo + ", summary=" + summary + ", issueDescription="
			+ issueDescription + ", issueDate=" + issueDate + ", closeDate=" + closeDate + "]";
}
 
}
