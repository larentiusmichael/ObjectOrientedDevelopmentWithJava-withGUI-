package assignment.solution;

import assignment.file.TextDAO;

import java.util.List;
import java.util.ArrayList;

public class People extends User implements UserAction {
	
	private final String PATH = "src/assignment/solution/";
	private TextDAO dao = new TextDAO( PATH+"People.txt" );
	private TextDAO temp = new TextDAO( PATH+"TemporaryPeople.txt" );
	
	public People() {
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return super.toString();
	}

	public String getFirst() { // get the first name of the object (people)
		return super.getFirst();
	}

	public void setFirst(String first) { // set the first name of the object (people)
		super.setFirst(first);
	}

	public String getLast() { // get the last name of the object (people)
		return super.getLast();
	}

	public void setLast(String last) { // set the last name of the object (people)
		super.setLast(last);
	}
	
	public String getUsername() { // get the username of the object (people)
		return super.getUsername();
	}

	public void setUsername(String username) { // set the username of the object (people)
		super.setUsername(username);
	}
	
	public String getPassword() { // get the password of the object (people)
		return super.getPassword();
	}

	public void setPassword(String password) { // set the password of the object (people)
		super.setPassword(password);
	}
	
	public String getDOB() { // get the place and DOB of the object (people)
		return super.getDOB();
	}

	public void setDOB(String dob) { // set the place and DOB of the object (people)
		super.setDOB(dob);
	}
	
	public String getAddress() { // get the address of the object (people)
		return super.getAddress();
	}

	public void setAddress(String address) { // set the address of the object (people)
		super.setAddress(address);
	}
	
	public String getNationalID() { // get the national ID of the object (people)
		return super.getNationalID();
	}

	public void setNationalID(String nationalID) { // set the national ID of the object (people)
		super.setNationalID(nationalID);
	}
	
	public String getNationality() { // get the nationality of the object (people)
		return super.getNationality();
	}

	public void setNationality(String nationality) { // set the nationality of the object (people)
		super.setNationality(nationality);
	}
	
	public String getVacStatus() { // get the vaccination status of the object (people)
		return super.getVacStatus();
	}

	public void setVacStatus(String vacstatus) { // set the vaccination status of the object (people)
		super.setVacStatus(vacstatus);
	}
	
	public String getID() { // get the ID of the object (people)
		return super.getID();
	}

	public void setID(String ID) { // set the ID of the object (people)
		super.setID(ID);
	}
	
	public String getNewID() { // getting new ID for new register people
		String lineNumberCount = Integer.toString(dao.lineNumber());
		return lineNumberCount;
	}
	
	public void register() { // adding record to the file of people
		dao.write( this.toString() );
	}
	
	public void register2() { // adding record to temporary file
		temp.write( this.toString() );
	}
	
	public List<User> view() { // viewing the file of people
		List<String> usrLst = dao.readAll();
		List<User> lst = new ArrayList<>();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			User ppl = new People();
			ppl.setID(split[0]);
			ppl.setFirst(split[1]);
			ppl.setLast(split[2]);
			ppl.setUsername(split[3]);
			ppl.setPassword(split[4]);
			ppl.setDOB(split[5]);
			ppl.setAddress(split[6]);
			ppl.setNationalID(split[7]);
			ppl.setNationality(split[8]);
			ppl.setVacStatus(split[9]);
			lst.add(ppl);
		}
		return lst;
	}
	
	public void modify(String username, String valueUpdate, String indicator) { //modifying the record of people
		List<String> usrLst = dao.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			People ppl = new People();
			ppl.setID(split[0]);
			String peopleID = ppl.getID();
			ppl.setFirst(split[1]);
			String firstName = ppl.getFirst();
			ppl.setLast(split[2]);
			String lastName = ppl.getLast();
			ppl.setUsername(split[3]);
			String userName = ppl.getUsername();
			ppl.setPassword(split[4]);
			String passWord = ppl.getPassword();
			ppl.setDOB(split[5]);
			String peopleDOB = ppl.getDOB();
			ppl.setAddress(split[6]);
			String address = ppl.getAddress();
			ppl.setNationalID(split[7]);
			String nationalID = ppl.getNationalID();
			ppl.setNationality(split[8]);
			String nationality = ppl.getNationality();
			ppl.setVacStatus(split[9]);
			String vaccineStatus = ppl.getVacStatus();
			if(username.equalsIgnoreCase(userName)) {
				if(indicator == "FIRST_NAME") {
					firstName = valueUpdate;
				} else if(indicator == "LAST_NAME") {
					lastName = valueUpdate;
				} else if(indicator == "USERNAME") {
					userName = valueUpdate;
				} else if(indicator == "PASSWORD") {
					passWord = valueUpdate;
				} else if(indicator == "DOB") {
					peopleDOB = valueUpdate;
				} else if(indicator == "ADDRESS") {
					address = valueUpdate;
				} else if(indicator == "NATIONAL_ID") {
					nationalID = valueUpdate;
				} else if(indicator == "NATIONALITY") {
					nationality = valueUpdate;
				} else {
					vaccineStatus = valueUpdate;
				}
			}
			ppl.setID(peopleID);
			ppl.setFirst(firstName);
			ppl.setLast(lastName);
			ppl.setUsername(userName);
			ppl.setPassword(passWord);
			ppl.setDOB(peopleDOB);
			ppl.setAddress(address);
			ppl.setNationalID(nationalID);
			ppl.setNationality(nationality);
			ppl.setVacStatus(vaccineStatus);
			ppl.register2();
		}
		dao.deleteAll();
		List<String> lstUsr = temp.readAll();
		for (String tsr : lstUsr) {
			String[] split = tsr.split("\\|");
			People ppl = new People();
			ppl.setID(split[0]);
			String peopleID = ppl.getID();
			ppl.setFirst(split[1]);
			String firstName = ppl.getFirst();
			ppl.setLast(split[2]);
			String lastName = ppl.getLast();
			ppl.setUsername(split[3]);
			String userName = ppl.getUsername();
			ppl.setPassword(split[4]);
			String passWord = ppl.getPassword();
			ppl.setDOB(split[5]);
			String peopleDOB = ppl.getDOB();
			ppl.setAddress(split[6]);
			String address = ppl.getAddress();
			ppl.setNationalID(split[7]);
			String nationalID = ppl.getNationalID();
			ppl.setNationality(split[8]);
			String nationality = ppl.getNationality();
			ppl.setVacStatus(split[9]);
			String vaccineStatus = ppl.getVacStatus();
			ppl.setID(peopleID);
			ppl.setFirst(firstName);
			ppl.setLast(lastName);
			ppl.setUsername(userName);
			ppl.setPassword(passWord);
			ppl.setDOB(peopleDOB);
			ppl.setAddress(address);
			ppl.setNationalID(nationalID);
			ppl.setNationality(nationality);
			ppl.setVacStatus(vaccineStatus);
			ppl.register();
		}
		temp.deleteAll();
	}
	
	public List<User> search(String value, String indicator) { // searching the record of people
		List<String> usrLst = dao.readAll();
		List<User> lst = new ArrayList<>();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			User ppl = new People();
			ppl.setID(split[0]);
			String peopleID = ppl.getID();
			ppl.setFirst(split[1]);
			String firstName = ppl.getFirst();
			ppl.setLast(split[2]);
			String lastName = ppl.getLast();
			ppl.setUsername(split[3]);
			String userName = ppl.getUsername();
			ppl.setPassword(split[4]);
			String passWord = ppl.getPassword();
			ppl.setDOB(split[5]);
			String peopleDOB = ppl.getDOB();
			ppl.setAddress(split[6]);
			String address = ppl.getAddress();
			ppl.setNationalID(split[7]);
			String nationalID = ppl.getNationalID();
			ppl.setNationality(split[8]);
			String nationality = ppl.getNationality();
			ppl.setVacStatus(split[9]);
			String vaccineStatus = ppl.getVacStatus();
			if(indicator == "USERNAME") {
				if(value.equalsIgnoreCase(userName)) {
					lst.add(ppl);
				}
			} else if(indicator == "FIRST_NAME") {
				if(value.equalsIgnoreCase(firstName)) {
					lst.add(ppl);
				}
			} else if(indicator == "LAST_NAME") {
				if(value.equalsIgnoreCase(lastName)) {
					lst.add(ppl);
				}
			} else if(indicator == "ID") {
				if(value.equalsIgnoreCase(peopleID)) {
					lst.add(ppl);
				}
			} else {
				if(value.equalsIgnoreCase(vaccineStatus)) {
					lst.add(ppl);
				}
			}
		}
		return lst;
	}
	
	public int login(String usr, String pwd) { // validating login as people
		List<String> usrLst = dao.readAll();
		int x = 0;
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			People ppl = new People();
			ppl.setUsername(split[3]);
			String userName = ppl.getUsername();
			ppl.setPassword(split[4]);
			String passWord = ppl.getPassword();
			if (usr.equals(userName) || pwd.equals(passWord)) {
				x = 2;
			}
			if (usr.equals(userName) && pwd.equals(passWord)) {
				x = 1;
				break;
			}
		}
		return x;
	}
	
	public String getFullName(String usr, String pwd) { // get people full name (first name + last name)
		List<String> usrLst = dao.readAll();
		String fullName = "";
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			People ppl = new People();
			ppl.setFirst(split[1]);
			String firstName = ppl.getFirst();
			ppl.setLast(split[2]);
			String lastName = ppl.getLast();
			ppl.setUsername(split[3]);
			String userName = ppl.getUsername();
			ppl.setPassword(split[4]);
			String passWord = ppl.getPassword();
			if (usr.equals(userName) && pwd.equals(passWord)) {
				fullName = (firstName+" "+ lastName);
				break;
			}
		}
		return fullName;
	}
	
	public String retrieveID(String usr, String pwd) { // get the ID of the people
		List<String> usrLst = dao.readAll();
		String thisID = "";
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			People ppl = new People();
			ppl.setID(split[0]);
			String peopleID = ppl.getID();
			ppl.setUsername(split[3]);
			String userName = ppl.getUsername();
			ppl.setPassword(split[4]);
			String passWord = ppl.getPassword();
			if (usr.equals(userName) && pwd.equals(passWord)) {
				thisID = peopleID;
				break;
			}
		}
		return thisID;
	}
	
	public int validatingUsername(String value) { // validating username of the people
		int x = 0;
		List<String> usrLst = dao.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			People ppl = new People();
			ppl.setUsername(split[3]);
			String userName = ppl.getUsername();
			if(value.equalsIgnoreCase(userName)) {
				x = 1;
				break;
			}
		}
		return x;
	}
	
	public int validatingPassword(String value) { // validating password of the people
		int x = 0;
		List<String> usrLst = dao.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			People ppl = new People();
			ppl.setPassword(split[4]);
			String passWord = ppl.getPassword();
			if(value.equals(passWord)) {
				x = 1;
				break;
			}
		}
		return x;
	}
	
	public List<User> viewAccount(String id) { // viewing account of the corresponding people
		List<String> usrLst = dao.readAll();
		List<User> lst = new ArrayList<>();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			People ppl = new People();
			ppl.setID(split[0]);
			String peopleID = ppl.getID();
			ppl.setFirst(split[1]);
			ppl.setLast(split[2]);
			ppl.setUsername(split[3]);
			ppl.setPassword(split[4]);
			ppl.setDOB(split[5]);
			ppl.setAddress(split[6]);
			ppl.setNationalID(split[7]);
			ppl.setNationality(split[8]);
			ppl.setVacStatus(split[9]);
			if(id.equals(peopleID)) {
				lst.add(ppl);
			}
		}
		return lst;
	}
	
	public String getCurrentStatus(String ID) { // get current vaccination status of people
		String currentStatus = "";
		List<String> usrLst = dao.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			People ppl = new People();
			ppl.setID(split[0]);
			String peopleID = ppl.getID();
			ppl.setVacStatus(split[9]);
			String vaccineStatus = ppl.getVacStatus();
			if(ID.equals(peopleID)) {
				currentStatus = vaccineStatus;
			}
		}
		return currentStatus;
	}
}
