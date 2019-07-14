package WebPackage.homepage;

import java.util.Date;

public class Activity {
	
	private int userid;
	private String activity, actid;
	private Date date;
	
	public Activity(int userid, String activity, String actid, Date date) {
		this.userid = userid;
		this.activity = activity;
		this.actid = actid;
		this.date = date;
	}
	
	public int getUserId() {
		return userid;
	}
	
	public String getActivity() {
		return activity;
	}
	
	public String getActId() {
		return actid;
	}
	
	public Date getDate() {
		return date;
	}
}
