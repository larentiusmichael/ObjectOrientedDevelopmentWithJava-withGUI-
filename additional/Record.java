package assignment.additional;

import java.text.SimpleDateFormat;
import java.util.Date;

import assignment.file.TextDAO;

public class Record {
	
	private String currentdate, action, username, id;
	
	private final String PATH = "src/assignment/additional/";
	private TextDAO dao = new TextDAO( PATH+"LoginLogoutRecord.txt" );
	private TextDAO act = new TextDAO( PATH+"ActivityRecord.txt" );
	
	public Record() {
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return String.join("|", currentdate, action, id, username);
	}

	public void setCurrentdate() { //to get the current date and time
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String currentDate = sdf.format(date)+ " (GMT+7)";
		this.currentdate = currentDate;
	}

	public void setAction(String action) { // set the action being performed by user
		this.action = action;
	}

	public void setUsername(String username) { // set the username of the user
		this.username = "@"+ username;
	}
	
	public void setID(String id) { // set the ID of the user
		this.id = id;
	}
	
	public void addRecord() {
		dao.write( this.toString() ); // writing login logout activity record
	}
	
	public void activityRecord() {
		act.write( this.toString() ); // writing activity record
	}
}
