package WebPackage.homepage;

import java.util.Date;

public class announcement {
	private int ann_id;
    private String titel;
    private String announcement;
    private Date announce_date;
    private int admin_id;
    
	public announcement(int ann_id, String titel, String announcement, Date announce_date, int admin_id) {
		this.ann_id = ann_id;;
		this.titel = titel;
		this.announcement = announcement;
		this.announce_date = announce_date;
		this.admin_id = admin_id;
	}
	
	public int getAnnId(){
		return ann_id;
	}
	
	public String getTitel(){
		return titel;
	}
	
	public String getAnn(){
		return announcement;
	}
	
	public Date getDate(){
		return announce_date;
	}
	
	public int getAdmin(){
		return admin_id;
	}
}
