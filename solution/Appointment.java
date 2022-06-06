package assignment.solution;

import java.util.ArrayList;
import java.util.List;

import assignment.file.TextDAO;

public class Appointment {
	
	private String ID, date, month, year, time, center, city, slot;
	private String peopleID, peopleUsername, chosenAppointmentID, chosenCenter;
	private final String PATH = "src/assignment/solution/";
	private TextDAO dao = new TextDAO( PATH+"Appointment.txt" );
	private TextDAO temp = new TextDAO( PATH+"TemporaryAppointment.txt" );
	private TextDAO atpl = new TextDAO( PATH+"AppointmentPeopleNV.txt" );
	private TextDAO anpp = new TextDAO( PATH+"AppointmentPeople1D.txt" );
	
	public Appointment() {
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return String.join("|", ID, date, month, year, time, center, city, slot);
	}
	
	public String toString2() {
		return String.join("|", peopleID, peopleUsername, chosenAppointmentID, chosenCenter);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
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
	
	public String getChosenAppointmentID() {
		return chosenAppointmentID;
	}

	public void setChosenAppointmentID(String chosenAppointmentID) {
		this.chosenAppointmentID = chosenAppointmentID;
	}
	
	public String getChosenCenter() {
		return chosenCenter;
	}

	public void setChosenCenter(String chosenCenter) {
		this.chosenCenter = chosenCenter;
	}
	
	public String getNewID() {
		List<String> usrLst = dao.readAll();
		int x = 0;
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Appointment apn = new Appointment();
			apn.setID(split[0]);
			String appointmentID = apn.getID();
			x = Integer.parseInt(appointmentID);
		}
		x++;
		String y = Integer.toString(x);
		return y;
	}
	
	public void register() {
		dao.write( this.toString() );
	}
	
	public void register2() {
		temp.write( this.toString() );
	}
	
	public void register3() {
		atpl.write( this.toString2() );
	}
	
	public void register4() {
		anpp.write( this.toString2() );
	}
	
	public void register5() {
		temp.write( this.toString2() );
	}
	
	public List<Appointment> view() {
		List<String> usrLst = dao.readAll();
		List<Appointment> lst = new ArrayList<>();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Appointment apn = new Appointment();
			apn.setID(split[0]);
			apn.setDate(split[1]);
			apn.setMonth(split[2]);
			apn.setYear(split[3]);
			apn.setTime(split[4]);
			apn.setCenter(split[5]);
			apn.setCity(split[6]);
			apn.setSlot(split[7]);
			lst.add(apn);
		}
		return lst;
	}
	
	public List<Appointment> peopleView(String nameofCenter) {
		List<String> usrLst = dao.readAll();
		List<Appointment> lst = new ArrayList<>();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Appointment apn = new Appointment();
			apn.setID(split[0]);
			apn.setDate(split[1]);
			apn.setMonth(split[2]);
			apn.setYear(split[3]);
			apn.setTime(split[4]);
			apn.setCenter(split[5]);
			String appointmentCenter = apn.getCenter();
			apn.setCity(split[6]);
			apn.setSlot(split[7]);
			if(nameofCenter.equalsIgnoreCase(appointmentCenter)) {
				lst.add(apn);
			}
		}
		return lst;
	}
	
	public void modify(String ID, String valueUpdate, String indicator) {
		List<String> usrLst = dao.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Appointment apn = new Appointment();
			apn.setID(split[0]);
			String appointmentID = apn.getID();
			apn.setDate(split[1]);
			String appointmentdate = apn.getDate();
			apn.setMonth(split[2]);
			String appointmentMonth = apn.getMonth();
			apn.setYear(split[3]);
			String appointmentYear = apn.getYear();
			apn.setTime(split[4]);
			String appointmentTime = apn.getTime();
			apn.setCenter(split[5]);
			String appointmentCenter = apn.getCenter();
			apn.setCity(split[6]);
			String appointmentCity = apn.getCity();
			apn.setSlot(split[7]);
			String appointmentSlot = apn.getSlot();
			if(ID.equals(appointmentID)) {
				if(indicator == "DATE") {
					appointmentdate = valueUpdate;
				} else if(indicator == "MONTH") {
					appointmentMonth = valueUpdate;
				} else if(indicator == "YEAR") {
					appointmentYear = valueUpdate;
				} else if(indicator == "TIME") {
					appointmentTime = valueUpdate;
				} else if(indicator == "CENTER") {
					appointmentCenter = valueUpdate;
				} else if(indicator == "CITY") {
					appointmentCity = valueUpdate;
				} else {
					appointmentSlot = valueUpdate;
				}
			}
			apn.setID(appointmentID);
			apn.setDate(appointmentdate);
			apn.setMonth(appointmentMonth);
			apn.setYear(appointmentYear);
			apn.setTime(appointmentTime);
			apn.setCenter(appointmentCenter);
			apn.setCity(appointmentCity);
			apn.setSlot(appointmentSlot);
			apn.register2();
		}
		dao.deleteAll();
		List<String> lstUsr = temp.readAll();
		for (String str : lstUsr) {
			String[] split = str.split("\\|");
			Appointment apn = new Appointment();
			apn.setID(split[0]);
			String appointmentID = apn.getID();
			apn.setDate(split[1]);
			String appointmentdate = apn.getDate();
			apn.setMonth(split[2]);
			String appointmentMonth = apn.getMonth();
			apn.setYear(split[3]);
			String appointmentYear = apn.getYear();
			apn.setTime(split[4]);
			String appointmentTime = apn.getTime();
			apn.setCenter(split[5]);
			String appointmentCenter = apn.getCenter();
			apn.setCity(split[6]);
			String appointmentCity = apn.getCity();
			apn.setSlot(split[7]);
			String appointmentSlot = apn.getSlot();
			apn.setID(appointmentID);
			apn.setDate(appointmentdate);
			apn.setMonth(appointmentMonth);
			apn.setYear(appointmentYear);
			apn.setTime(appointmentTime);
			apn.setCenter(appointmentCenter);
			apn.setCity(appointmentCity);
			apn.setSlot(appointmentSlot);
			apn.register();
		}
		temp.deleteAll();
	}
	
	public List<Appointment> search(String value, String indicator) {
		List<String> usrLst = dao.readAll();
		List<Appointment> lst = new ArrayList<>();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Appointment apn = new Appointment();
			apn.setID(split[0]);
			String appointmentID = apn.getID();
			apn.setDate(split[1]);
			String appointmentdate = apn.getDate();
			apn.setMonth(split[2]);
			String appointmentMonth = apn.getMonth();
			apn.setYear(split[3]);
			String appointmentYear = apn.getYear();
			apn.setTime(split[4]);
			String appointmentTime = apn.getTime();
			apn.setCenter(split[5]);
			String appointmentCenter = apn.getCenter();
			apn.setCity(split[6]);
			String appointmentCity = apn.getCity();
			apn.setSlot(split[7]);
			String appointmentSlot = apn.getSlot();
			if(indicator == "ID") {
				if(value.equalsIgnoreCase(appointmentID)) {
					lst.add(apn);
				}
			} else if(indicator == "MONTH") {
				if(value.equalsIgnoreCase(appointmentMonth)) {
					lst.add(apn);
				}
			} else if(indicator == "YEAR") {
				if(value.equalsIgnoreCase(appointmentYear)) {
					lst.add(apn);
				}
			} else if(indicator == "CENTER") {
				if(value.equalsIgnoreCase(appointmentCenter)) {
					lst.add(apn);
				}
			} else if(indicator == "SLOT") {
				if(value.equalsIgnoreCase(appointmentSlot)) {
					lst.add(apn);
				}
			} else {
				if(value.equalsIgnoreCase(appointmentCity)) {
					lst.add(apn);
				}
			}
		}
		return lst;
	}
	
	public void remove(String ID) {
		List<String> usrLst = dao.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Appointment apn = new Appointment();
			apn.setID(split[0]);
			String appointmentID = apn.getID();
			apn.setDate(split[1]);
			String appointmentdate = apn.getDate();
			apn.setMonth(split[2]);
			String appointmentMonth = apn.getMonth();
			apn.setYear(split[3]);
			String appointmentYear = apn.getYear();
			apn.setTime(split[4]);
			String appointmentTime = apn.getTime();
			apn.setCenter(split[5]);
			String appointmentCenter = apn.getCenter();
			apn.setCity(split[6]);
			String appointmentCity = apn.getCity();
			apn.setSlot(split[7]);
			String appointmentSlot = apn.getSlot();
			if(!(ID.equals(appointmentID))) {
				apn.setID(appointmentID);
				apn.setDate(appointmentdate);
				apn.setMonth(appointmentMonth);
				apn.setYear(appointmentYear);
				apn.setTime(appointmentTime);
				apn.setCenter(appointmentCenter);
				apn.setCity(appointmentCity);
				apn.setSlot(appointmentSlot);
				apn.register2();
			}
		}
		dao.deleteAll();
		List<String> lstUsr = temp.readAll();
		for (String str : lstUsr) {
			String[] split = str.split("\\|");
			Appointment apn = new Appointment();
			apn.setID(split[0]);
			String appointmentID = apn.getID();
			apn.setDate(split[1]);
			String appointmentdate = apn.getDate();
			apn.setMonth(split[2]);
			String appointmentMonth = apn.getMonth();
			apn.setYear(split[3]);
			String appointmentYear = apn.getYear();
			apn.setTime(split[4]);
			String appointmentTime = apn.getTime();
			apn.setCenter(split[5]);
			String appointmentCenter = apn.getCenter();
			apn.setCity(split[6]);
			String appointmentCity = apn.getCity();
			apn.setSlot(split[7]);
			String appointmentSlot = apn.getSlot();
			apn.setID(appointmentID);
			apn.setDate(appointmentdate);
			apn.setMonth(appointmentMonth);
			apn.setYear(appointmentYear);
			apn.setTime(appointmentTime);
			apn.setCenter(appointmentCenter);
			apn.setCity(appointmentCity);
			apn.setSlot(appointmentSlot);
			apn.register();
		}
		temp.deleteAll();
	}
	
	public int validatingID(String value) {
		int x = 0;
		List<String> usrLst = dao.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Appointment apt = new Appointment();
			apt.setID(split[0]);
			String appointmentID = apt.getID();
			if(value.equalsIgnoreCase(appointmentID)) {
				x = 1;
				break;
			}
		}
		return x;
	}
	
	public int validatingChosenID(String chosenCenter, String chosenID) {
		int x = 0;
		List<String> usrLst = dao.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Appointment apt = new Appointment();
			apt.setID(split[0]);
			String appointmentID = apt.getID();
			apt.setCenter(split[5]);
			String appointmentCenter = apt.getCenter();
			if(chosenCenter.equalsIgnoreCase(appointmentCenter)) {
				if(chosenID.equals(appointmentID)) {
					x = 1;
				}
			}
		}
		return x;
	}
	
	public void addEliminateSlot(String ID, String indicator) {
		int x = 0;
		int y = 0;
		List<String> usrLst = dao.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Appointment apn = new Appointment();
			apn.setID(split[0]);
			String appointmentID = apn.getID();
			apn.setDate(split[1]);
			String appointmentdate = apn.getDate();
			apn.setMonth(split[2]);
			String appointmentMonth = apn.getMonth();
			apn.setYear(split[3]);
			String appointmentYear = apn.getYear();
			apn.setTime(split[4]);
			String appointmentTime = apn.getTime();
			apn.setCenter(split[5]);
			String appointmentCenter = apn.getCenter();
			apn.setCity(split[6]);
			String appointmentCity = apn.getCity();
			apn.setSlot(split[7]);
			String appointmentSlot = apn.getSlot();
			if(ID.equalsIgnoreCase(appointmentID)) {
				if(indicator == "ELIMINATE") {
					x = Integer.parseInt(appointmentSlot);
					y = x - 1;
					appointmentSlot = Integer.toString(y);
				} else {
					x = Integer.parseInt(appointmentSlot);
					y = x + 1;
					appointmentSlot = Integer.toString(y);
				}
			}
			apn.setID(appointmentID);
			apn.setDate(appointmentdate);
			apn.setMonth(appointmentMonth);
			apn.setYear(appointmentYear);
			apn.setTime(appointmentTime);
			apn.setCenter(appointmentCenter);
			apn.setCity(appointmentCity);
			apn.setSlot(appointmentSlot);
			apn.register2();
		}
		dao.deleteAll();
		List<String> lstUsr = temp.readAll();
		for (String str : lstUsr) {
			String[] split = str.split("\\|");
			Appointment apn = new Appointment();
			apn.setID(split[0]);
			String appointmentID = apn.getID();
			apn.setDate(split[1]);
			String appointmentdate = apn.getDate();
			apn.setMonth(split[2]);
			String appointmentMonth = apn.getMonth();
			apn.setYear(split[3]);
			String appointmentYear = apn.getYear();
			apn.setTime(split[4]);
			String appointmentTime = apn.getTime();
			apn.setCenter(split[5]);
			String appointmentCenter = apn.getCenter();
			apn.setCity(split[6]);
			String appointmentCity = apn.getCity();
			apn.setSlot(split[7]);
			String appointmentSlot = apn.getSlot();
			apn.setID(appointmentID);
			apn.setDate(appointmentdate);
			apn.setMonth(appointmentMonth);
			apn.setYear(appointmentYear);
			apn.setTime(appointmentTime);
			apn.setCenter(appointmentCenter);
			apn.setCity(appointmentCity);
			apn.setSlot(appointmentSlot);
			apn.register();
		}
		temp.deleteAll();
	}
	
	public int checkSlot(String ID) {
		int x = 0;
		int y = 0;
		List<String> usrLst = dao.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Appointment apn = new Appointment();
			apn.setID(split[0]);
			String appointmentID = apn.getID();
			apn.setSlot(split[7]);
			String appointmentSlot = apn.getSlot();
			if(ID.equalsIgnoreCase(appointmentID)) {
				x = Integer.parseInt(appointmentSlot);
				if(x <= 0) {
					y = 1;
				}
			}
		}
		return y;
	}
	
	public int checkExistence1(String ID) {
		int x = 0;
		List<String> usrLst = atpl.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Appointment apn = new Appointment();
			apn.setPeopleID(split[0]);
			String peopleID = apn.getPeopleID();
			if(ID.equalsIgnoreCase(peopleID)) {
				x = 1;
				break;
			}
		}
		return x;
	}
	
	public int checkExistence2(String ID) {
		int x = 0;
		List<String> usrLst = anpp.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Appointment apn = new Appointment();
			apn.setPeopleID(split[0]);
			String peopleID = apn.getPeopleID();
			if(ID.equalsIgnoreCase(peopleID)) {
				x = 1;
				break;
			}
		}
		return x;
	}
	
	public void cancel1(String ID) {
		List<String> usrLst = atpl.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Appointment apn = new Appointment();
			apn.setPeopleID(split[0]);
			String peopleID = apn.getPeopleID();
			apn.setPeopleUsername(split[1]);
			String peopleUsername = apn.getPeopleUsername();
			apn.setChosenAppointmentID(split[2]);
			String appointmentID = apn.getChosenAppointmentID();
			apn.setChosenCenter(split[3]);
			String chosenCenter = apn.getChosenCenter();
			if(!(ID.equals(peopleID))) {
				apn.setPeopleID(peopleID);
				apn.setPeopleUsername(peopleUsername);
				apn.setChosenAppointmentID(appointmentID);
				apn.setChosenCenter(chosenCenter);
				apn.register5();
			}
		}
		atpl.deleteAll();
		List<String> lstUsr = temp.readAll();
		for (String str : lstUsr) {
			String[] split = str.split("\\|");
			Appointment apn = new Appointment();
			apn.setPeopleID(split[0]);
			String peopleID = apn.getPeopleID();
			apn.setPeopleUsername(split[1]);
			String peopleUsername = apn.getPeopleUsername();
			apn.setChosenAppointmentID(split[2]);
			String appointmentID = apn.getChosenAppointmentID();
			apn.setChosenCenter(split[3]);
			String chosenCenter = apn.getChosenCenter();
			apn.setPeopleID(peopleID);
			apn.setPeopleUsername(peopleUsername);
			apn.setChosenAppointmentID(appointmentID);
			apn.setChosenCenter(chosenCenter);
			apn.register3();
		}
		temp.deleteAll();
	}
	
	public void cancel2(String ID) {
		List<String> usrLst = anpp.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Appointment apn = new Appointment();
			apn.setPeopleID(split[0]);
			String peopleID = apn.getPeopleID();
			apn.setPeopleUsername(split[1]);
			String peopleUsername = apn.getPeopleUsername();
			apn.setChosenAppointmentID(split[2]);
			String appointmentID = apn.getChosenAppointmentID();
			apn.setChosenCenter(split[3]);
			String chosenCenter = apn.getChosenCenter();
			if(!(ID.equals(peopleID))) {
				apn.setPeopleID(peopleID);
				apn.setPeopleUsername(peopleUsername);
				apn.setChosenAppointmentID(appointmentID);
				apn.setChosenCenter(chosenCenter);
				apn.register5();
			}
		}
		anpp.deleteAll();
		List<String> lstUsr = temp.readAll();
		for (String str : lstUsr) {
			String[] split = str.split("\\|");
			Appointment apn = new Appointment();
			apn.setPeopleID(split[0]);
			String peopleID = apn.getPeopleID();
			apn.setPeopleUsername(split[1]);
			String peopleUsername = apn.getPeopleUsername();
			apn.setChosenAppointmentID(split[2]);
			String appointmentID = apn.getChosenAppointmentID();
			apn.setChosenCenter(split[3]);
			String chosenCenter = apn.getChosenCenter();
			apn.setPeopleID(peopleID);
			apn.setPeopleUsername(peopleUsername);
			apn.setChosenAppointmentID(appointmentID);
			apn.setChosenCenter(chosenCenter);
			apn.register4();
		}
		temp.deleteAll();
	}
	
	public String getAppointmentID1(String IDpeople) {
		String x = "";
		List<String> usrLst = atpl.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Appointment apn = new Appointment();
			apn.setPeopleID(split[0]);
			String peopleID = apn.getPeopleID();
			apn.setChosenAppointmentID(split[2]);
			String appointmentID = apn.getChosenAppointmentID();
			if(IDpeople.equalsIgnoreCase(peopleID)) {
				x = appointmentID;
			}
		}
		return x;
	}
	
	public String getAppointmentID2(String IDpeople) {
		String x = "";
		List<String> usrLst = anpp.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Appointment apn = new Appointment();
			apn.setPeopleID(split[0]);
			String peopleID = apn.getPeopleID();
			apn.setChosenAppointmentID(split[2]);
			String appointmentID = apn.getChosenAppointmentID();
			if(IDpeople.equalsIgnoreCase(peopleID)) {
				x = appointmentID;
			}
		}
		return x;
	}
}
