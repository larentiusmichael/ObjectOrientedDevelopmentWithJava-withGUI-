package assignment.solution;

import java.util.List;

import assignment.file.TextDAO;

public class Center {
	
	private String peopleID, peopleUsername, centerID, centerName, centerCity;
	private final String PATH = "src/assignment/solution/";
	private TextDAO dao = new TextDAO( PATH+"CenterPeople.txt" );
	private TextDAO temp = new TextDAO( PATH+"TemporaryCenter.txt" );
	
	public Center() {
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return String.join("|", peopleID, peopleUsername, centerID, centerName, centerCity);
	}

	public String getPeopleID() {
		return peopleID;
	}

	public void setPeopleID(String peopleID) {
		this.peopleID = peopleID;
	}
	
	public String getPeopleUsername() {
		return peopleUsername;
	}

	public void setPeopleUsername(String peopleUsername) {
		this.peopleUsername = peopleUsername;
	}
	
	public String getCenterID() {
		return centerID;
	}

	public void setCenterID(String centerID) {
		this.centerID = centerID;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	
	public String getCenterCity() {
		return centerCity;
	}

	public void setCenterCity(String centerCity) {
		this.centerCity = centerCity;
	}
	
	public void register() {
		dao.write( this.toString() );
	}
	
	public void register2() {
		temp.write( this.toString() );
	}
	
	public void modify(String ID, String username, String newCenterID, String newCenterName, String newCenterCity) {
		List<String> usrLst = dao.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Center ctr = new Center();
			ctr.setPeopleID(split[0]);
			String IDpeople = ctr.getPeopleID();
			ctr.setPeopleUsername(split[1]);
			String usernamePeople = ctr.getPeopleUsername();
			ctr.setCenterID(split[2]);
			String IDCenter = ctr.getCenterID();
			ctr.setCenterName(split[3]);
			String nameCenter = ctr.getCenterName();
			ctr.setCenterCity(split[4]);
			String cityCenter = ctr.getCenterCity();
			if(ID.equals(IDpeople)) {
				usernamePeople = username;
				IDCenter = newCenterID;
				nameCenter = newCenterName;
				cityCenter = newCenterCity;
			}
			ctr.setPeopleID(IDpeople);
			ctr.setPeopleUsername(usernamePeople);
			ctr.setCenterID(IDCenter);
			ctr.setCenterName(nameCenter);
			ctr.setCenterCity(cityCenter);
			ctr.register2();
		}
		dao.deleteAll();
		List<String> lstUsr = temp.readAll();
		for (String str : lstUsr) {
			String[] split = str.split("\\|");
			Center ctr = new Center();
			ctr.setPeopleID(split[0]);
			String IDpeople = ctr.getPeopleID();
			ctr.setPeopleUsername(split[1]);
			String usernamePeople = ctr.getPeopleUsername();
			ctr.setCenterID(split[2]);
			String IDCenter = ctr.getCenterID();
			ctr.setCenterName(split[3]);
			String nameCenter = ctr.getCenterName();
			ctr.setCenterCity(split[4]);
			String cityCenter = ctr.getCenterCity();
			ctr.setPeopleID(IDpeople);
			ctr.setPeopleUsername(usernamePeople);
			ctr.setCenterID(IDCenter);
			ctr.setCenterName(nameCenter);
			ctr.setCenterCity(cityCenter);
			ctr.register();
		}
		temp.deleteAll();
	}
	
	public int validatingID(String value) {
		int x = 0;
		List<String> usrLst = dao.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Center ctr = new Center();
			ctr.setPeopleID(split[0]);
			String IDpeople = ctr.getPeopleID();
			if(value.equalsIgnoreCase(IDpeople)) {
				x = 1;
				break;
			}
		}
		return x;
	}
	
	public String getChosenCenter(String ID) {
		String chosenCenter = "";
		List<String> usrLst = dao.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Center ctr = new Center();
			ctr.setPeopleID(split[0]);
			String IDpeople = ctr.getPeopleID();
			ctr.setCenterName(split[3]);
			String nameCenter = ctr.getCenterName();
			if(ID.equals(IDpeople)) {
				chosenCenter = nameCenter;
			}
		}
		return chosenCenter;
	}
}

