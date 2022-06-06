package assignment.solution;

import java.util.List;

public abstract class User {
	
	private String ID, first, last, username, password, dob, address, nationalID, nationality, vacstatus;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public String toString() { // printing the details of the object into human readable form
		return String.join("|", ID, first, last, username, password, dob, address, nationalID, nationality, vacstatus);
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDOB() {
		return dob;
	}

	public void setDOB(String dob) {
		this.dob = dob;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getNationalID() {
		return nationalID;
	}

	public void setNationalID(String nationalID) {
		this.nationalID = nationalID;
	}
	
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public String getVacStatus() {
		return vacstatus;
	}

	public void setVacStatus(String vacstatus) {
		this.vacstatus = vacstatus;
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}
	
	public abstract List<User> view();
	
	public abstract List<User> search(String value, String indicator);
	
	public abstract List<User> viewAccount(String id);
}
