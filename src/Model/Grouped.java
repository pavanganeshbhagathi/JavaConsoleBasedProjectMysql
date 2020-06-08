package Model;

public class Grouped {
	
	private int groupedProjectLinkedId;
	private int groupedUSerLinkedId;
	public Grouped() {
		super();
	}
	public Grouped(int groupedProjectLinkedId, int groupedUSerLinkedId) {
		super();
		this.groupedProjectLinkedId = groupedProjectLinkedId;
		this.groupedUSerLinkedId = groupedUSerLinkedId;
	}
	public int getGroupedProjectLinkedId() {
		return groupedProjectLinkedId;
	}
	public void setGroupedProjectLinkedId(int groupedProjectLinkedId) {
		this.groupedProjectLinkedId = groupedProjectLinkedId;
	}
	public int getGroupedUSerLinkedId() {
		return groupedUSerLinkedId;
	}
	public void setGroupedUSerLinkedId(int groupedUSerLinkedId) {
		this.groupedUSerLinkedId = groupedUSerLinkedId;
	}
	@Override
	public String toString() {
		return "Grouped [groupedProjectLinkedId=" + groupedProjectLinkedId + ", groupedUSerLinkedId="
				+ groupedUSerLinkedId + "]";
	}
	

}
