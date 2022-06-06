package assignment.solution;

import assignment.file.TextDAO;

import java.util.ArrayList;
import java.util.List;

public class Personnel extends User implements UserAction {
	
	private final String PATH = "src/assignment/solution/";
	private TextDAO dao = new TextDAO( PATH+"Personnel.txt" );
	private TextDAO temp = new TextDAO( PATH+"TemporaryPersonnel.txt" );
	
	public Personnel() {
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return super.toString();
	}

	public String getFirst() {
		return super.getFirst();
	}

	public void setFirst(String first) {
		super.setFirst(first);
	}

	public String getLast() {
		return super.getLast();
	}

	public void setLast(String last) {
		super.setLast(last);
	}
	
	public String getUsername() {
		return super.getUsername();
	}

	public void setUsername(String username) {
		super.setUsername(username);
	}
	
	public String getPassword() {
		return super.getPassword();
	}

	public void setPassword(String password) {
		super.setPassword(password);
	}
	
	public String getDOB() {
		return super.getDOB();
	}

	public void setDOB(String dob) {
		super.setDOB(dob);
	}
	
	public String getAddress() {
		return super.getAddress();
	}

	public void setAddress(String address) {
		super.setAddress(address);
	}
	
	public String getNationalID() {
		return super.getNationalID();
	}

	public void setNationalID(String nationalID) {
		super.setNationalID(nationalID);
	}
	
	public String getNationality() {
		return super.getNationality();
	}

	public void setNationality(String nationality) {
		super.setNationality(nationality);
	}
	
	public String getVacStatus() {
		return super.getVacStatus();
	}

	public void setVacStatus(String vacstatus) {
		super.setVacStatus(vacstatus);
	}
	
	public String getID() {
		return super.getID();
	}

	public void setID(String ID) {
		super.setID(ID);
	}
	
	public String getNewID() {
		String lineNumberCount = Integer.toString(dao.lineNumber());
		return lineNumberCount;
	}
	
	public void register() {
		dao.write( this.toString() );
	}
	
	public void register2() {
		temp.write( this.toString() );
	}
	
	public List<User> view() {
		List<String> usrLst = dao.readAll();
		List<User> lst = new ArrayList<>();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			User pnl = new Personnel();
			pnl.setID(split[0]);
			pnl.setFirst(split[1]);
			pnl.setLast(split[2]);
			pnl.setUsername(split[3]);
			pnl.setPassword(split[4]);
			pnl.setDOB(split[5]);
			pnl.setAddress(split[6]);
			pnl.setNationalID(split[7]);
			pnl.setNationality(split[8]);
			pnl.setVacStatus(split[9]);
			lst.add(pnl);
		}
		
		return lst;
	}
	
	public void modify(String username, String valueUpdate, String indicator) {
		List<String> usrLst = dao.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Personnel pnl = new Personnel();
			pnl.setID(split[0]);
			String peopleID = pnl.getID();
			pnl.setFirst(split[1]);
			String firstName = pnl.getFirst();
			pnl.setLast(split[2]);
			String lastName = pnl.getLast();
			pnl.setUsername(split[3]);
			String userName = pnl.getUsername();
			pnl.setPassword(split[4]);
			String passWord = pnl.getPassword();
			pnl.setDOB(split[5]);
			String peopleDOB = pnl.getDOB();
			pnl.setAddress(split[6]);
			String address = pnl.getAddress();
			pnl.setNationalID(split[7]);
			String nationalID = pnl.getNationalID();
			pnl.setNationality(split[8]);
			String nationality = pnl.getNationality();
			pnl.setVacStatus(split[9]);
			String vaccineStatus = pnl.getVacStatus();
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
			pnl.setID(peopleID);
			pnl.setFirst(firstName);
			pnl.setLast(lastName);
			pnl.setUsername(userName);
			pnl.setPassword(passWord);
			pnl.setDOB(peopleDOB);
			pnl.setAddress(address);
			pnl.setNationalID(nationalID);
			pnl.setNationality(nationality);
			pnl.setVacStatus(vaccineStatus);
			pnl.register2();
		}
		dao.deleteAll();
		List<String> lstUsr = temp.readAll();
		for (String tsr : lstUsr) {
			String[] split = tsr.split("\\|");
			Personnel pnl = new Personnel();
			pnl.setID(split[0]);
			String peopleID = pnl.getID();
			pnl.setFirst(split[1]);
			String firstName = pnl.getFirst();
			pnl.setLast(split[2]);
			String lastName = pnl.getLast();
			pnl.setUsername(split[3]);
			String userName = pnl.getUsername();
			pnl.setPassword(split[4]);
			String passWord = pnl.getPassword();
			pnl.setDOB(split[5]);
			String peopleDOB = pnl.getDOB();
			pnl.setAddress(split[6]);
			String address = pnl.getAddress();
			pnl.setNationalID(split[7]);
			String nationalID = pnl.getNationalID();
			pnl.setNationality(split[8]);
			String nationality = pnl.getNationality();
			pnl.setVacStatus(split[9]);
			String vaccineStatus = pnl.getVacStatus();
			pnl.setID(peopleID);
			pnl.setFirst(firstName);
			pnl.setLast(lastName);
			pnl.setUsername(userName);
			pnl.setPassword(passWord);
			pnl.setDOB(peopleDOB);
			pnl.setAddress(address);
			pnl.setNationalID(nationalID);
			pnl.setNationality(nationality);
			pnl.setVacStatus(vaccineStatus);
			pnl.register();
		}
		temp.deleteAll();
	}
	
	public List<User> search(String value, String indicator) {
		List<String> usrLst = dao.readAll();
		List<User> lst = new ArrayList<>();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			User pnl = new Personnel();
			pnl.setID(split[0]);
			String personnelID = pnl.getID();
			pnl.setFirst(split[1]);
			String firstName = pnl.getFirst();
			pnl.setLast(split[2]);
			String lastName = pnl.getLast();
			pnl.setUsername(split[3]);
			String userName = pnl.getUsername();
			pnl.setPassword(split[4]);
			String passWord = pnl.getPassword();
			pnl.setDOB(split[5]);
			String peopleDOB = pnl.getDOB();
			pnl.setAddress(split[6]);
			String address = pnl.getAddress();
			pnl.setNationalID(split[7]);
			String nationalID = pnl.getNationalID();
			pnl.setNationality(split[8]);
			String nationality = pnl.getNationality();
			pnl.setVacStatus(split[9]);
			String vaccineStatus = pnl.getVacStatus();
			if(indicator == "USERNAME") {
				if(value.equalsIgnoreCase(userName)) {
					lst.add(pnl);
				}
			} else if(indicator == "FIRST_NAME") {
				if(value.equalsIgnoreCase(firstName)) {
					lst.add(pnl);
				}
			} else if(indicator == "LAST_NAME") {
				if(value.equalsIgnoreCase(lastName)) {
					lst.add(pnl);
				}
			} else if(indicator == "ID") {
				if(value.equalsIgnoreCase(personnelID)) {
					lst.add(pnl);
				}
			} else {
				if(value.equalsIgnoreCase(vaccineStatus)) {
					lst.add(pnl);
				}
			}
		}
		return lst;
	}
	
	public int login(String usr, String pwd) {
		List<String> usrLst = dao.readAll();
		int x = 0;
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Personnel pnl = new Personnel();
			pnl.setUsername(split[3]);
			String userName = pnl.getUsername();
			pnl.setPassword(split[4]);
			String passWord = pnl.getPassword();
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
	
	public String getFullName(String usr, String pwd) {
		List<String> usrLst = dao.readAll();
		String fullName = "";
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Personnel pnl = new Personnel();
			pnl.setFirst(split[1]);
			String firstName = pnl.getFirst();
			pnl.setLast(split[2]);
			String lastName = pnl.getLast();
			pnl.setUsername(split[3]);
			String userName = pnl.getUsername();
			pnl.setPassword(split[4]);
			String passWord = pnl.getPassword();
			if (usr.equals(userName) && pwd.equals(passWord)) {
				fullName = (firstName+" "+ lastName);
				break;
			}
		}
		return fullName;
	}
	
	public String retrieveID(String usr, String pwd) {
		List<String> usrLst = dao.readAll();
		String thisID = "";
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Personnel pnl = new Personnel();
			pnl.setID(split[0]);
			String personnelID = pnl.getID();
			pnl.setUsername(split[3]);
			String userName = pnl.getUsername();
			pnl.setPassword(split[4]);
			String passWord = pnl.getPassword();
			if (usr.equals(userName) && pwd.equals(passWord)) {
				thisID = personnelID;
				break;
			}
		}
		return thisID;
	}
	
	public int validatingUsername(String value) {
		int x = 0;
		List<String> usrLst = dao.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Personnel pnl = new Personnel();
			pnl.setUsername(split[3]);
			String userName = pnl.getUsername();
			if(value.equalsIgnoreCase(userName)) {
				x = 1;
				break;
			}
		}
		return x;
	}
	
	public int validatingPassword(String value) {
		int x = 0;
		List<String> usrLst = dao.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Personnel pnl = new Personnel();
			pnl.setPassword(split[4]);
			String passWord = pnl.getPassword();
			if(value.equals(passWord)) {
				x = 1;
				break;
			}
		}
		return x;
	}
	
	public List<User> viewAccount(String id) {
		List<String> usrLst = dao.readAll();
		List<User> lst = new ArrayList<>();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Personnel pnl = new Personnel();
			pnl.setID(split[0]);
			String personnelID = pnl.getID();
			pnl.setFirst(split[1]);
			pnl.setLast(split[2]);
			pnl.setUsername(split[3]);
			pnl.setPassword(split[4]);
			pnl.setDOB(split[5]);
			pnl.setAddress(split[6]);
			pnl.setNationalID(split[7]);
			pnl.setNationality(split[8]);
			pnl.setVacStatus(split[9]);
			if(id.equals(personnelID)) {
				lst.add(pnl);
			}
		}
		return lst;
	}
}
