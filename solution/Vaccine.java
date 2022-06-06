package assignment.solution;

import java.util.ArrayList;
import java.util.List;

import assignment.file.TextDAO;

public class Vaccine {
	
	private String ID, name, country, dose, center, city, amount;
	private final String PATH = "src/assignment/solution/";
	private TextDAO dao = new TextDAO( PATH+"Vaccine.txt" );
	private TextDAO temp = new TextDAO( PATH+"TemporaryVaccine.txt" );
	
	public Vaccine() {
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return String.join("|", ID, name, country, dose, center, city, amount);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
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
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String getNewID() {
		List<String> usrLst = dao.readAll();
		int x = 0;
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Vaccine vcn = new Vaccine();
			vcn.setID(split[0]);
			String vaccineID = vcn.getID();
			x = Integer.parseInt(vaccineID);
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
	
	public List<Vaccine> view() {
		List<String> usrLst = dao.readAll();
		List<Vaccine> lst = new ArrayList<>();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Vaccine vcn = new Vaccine();
			vcn.setID(split[0]);
			vcn.setName(split[1]);
			vcn.setCountry(split[2]);
			vcn.setDose(split[3]);
			vcn.setCenter(split[4]);
			vcn.setCity(split[5]);
			vcn.setAmount(split[6]);
			lst.add(vcn);
		}
		return lst;
	}
	
	public void modify(String ID, String valueUpdate, String indicator) {
		List<String> usrLst = dao.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Vaccine vcn = new Vaccine();
			vcn.setID(split[0]);
			String vaccineID = vcn.getID();
			vcn.setName(split[1]);
			String vaccineName = vcn.getName();
			vcn.setCountry(split[2]);
			String vaccineCountry = vcn.getCountry();
			vcn.setDose(split[3]);
			String vaccineDose = vcn.getDose();
			vcn.setCenter(split[4]);
			String vaccineCenter = vcn.getCenter();
			vcn.setCity(split[5]);
			String vaccineCity = vcn.getCity();
			vcn.setAmount(split[6]);
			String vaccineAmount = vcn.getAmount();
			if(ID.equals(vaccineID)) {
				if(indicator == "NAME") {
					vaccineName = valueUpdate;
				} else if(indicator == "COUNTRY") {
					vaccineCountry = valueUpdate;
				} else if(indicator == "DOSE") {
					vaccineDose = valueUpdate;
				} else if(indicator == "CENTER") {
					vaccineCenter = valueUpdate;
				} else if(indicator == "CITY") {
					vaccineCity = valueUpdate;
				} else {
					vaccineAmount = valueUpdate;
				}
			}
			vcn.setID(vaccineID);
			vcn.setName(vaccineName);
			vcn.setCountry(vaccineCountry);
			vcn.setDose(vaccineDose);
			vcn.setCenter(vaccineCenter);
			vcn.setCity(vaccineCity);
			vcn.setAmount(vaccineAmount);
			vcn.register2();
		}
		dao.deleteAll();
		List<String> lstUsr = temp.readAll();
		for (String str : lstUsr) {
			String[] split = str.split("\\|");
			Vaccine vcn = new Vaccine();
			vcn.setID(split[0]);
			String vaccineID = vcn.getID();
			vcn.setName(split[1]);
			String vaccineName = vcn.getName();
			vcn.setCountry(split[2]);
			String vaccineCountry = vcn.getCountry();
			vcn.setDose(split[3]);
			String vaccineDose = vcn.getDose();
			vcn.setCenter(split[4]);
			String vaccineCenter = vcn.getCenter();
			vcn.setCity(split[5]);
			String vaccineCity = vcn.getCity();
			vcn.setAmount(split[6]);
			String vaccineAmount = vcn.getAmount();
			vcn.setID(vaccineID);
			vcn.setName(vaccineName);
			vcn.setCountry(vaccineCountry);
			vcn.setDose(vaccineDose);
			vcn.setCenter(vaccineCenter);
			vcn.setCity(vaccineCity);
			vcn.setAmount(vaccineAmount);
			vcn.register();
		}
		temp.deleteAll();
	}
	
	public List<Vaccine> search(String value, String indicator) {
		List<String> usrLst = dao.readAll();
		List<Vaccine> lst = new ArrayList<>();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Vaccine vcn = new Vaccine();
			vcn.setID(split[0]);
			String vaccineID = vcn.getID();
			vcn.setName(split[1]);
			String vaccineName = vcn.getName();
			vcn.setCountry(split[2]);
			String vaccineCountry = vcn.getCountry();
			vcn.setDose(split[3]);
			String vaccineDose = vcn.getDose();
			vcn.setCenter(split[4]);
			String vaccineCenter = vcn.getCenter();
			vcn.setCity(split[5]);
			String vaccineCity = vcn.getCity();
			vcn.setAmount(split[6]);
			String vaccineAmount = vcn.getAmount();
			if(indicator == "ID") {
				if(value.equalsIgnoreCase(vaccineID)) {
					lst.add(vcn);
				}
			} else if(indicator == "NAME") {
				if(value.equalsIgnoreCase(vaccineName)) {
					lst.add(vcn);
				}
			} else if(indicator == "COUNTRY") {
				if(value.equalsIgnoreCase(vaccineCountry)) {
					lst.add(vcn);
				}
			} else if(indicator == "DOSE") {
				if(value.equalsIgnoreCase(vaccineDose)) {
					lst.add(vcn);
				}
			} else if(indicator == "CENTER") {
				if(value.equalsIgnoreCase(vaccineCenter)) {
					lst.add(vcn);
				}
			} else if(indicator == "CITY") {
				if(value.equalsIgnoreCase(vaccineCity)) {
					lst.add(vcn);
				}
			} else {
				if(value.equalsIgnoreCase(vaccineAmount)) {
					lst.add(vcn);
				}
			}
		}
		return lst;
	}
	
	public void remove(String ID) {
		List<String> usrLst = dao.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Vaccine vcn = new Vaccine();
			vcn.setID(split[0]);
			String vaccineID = vcn.getID();
			vcn.setName(split[1]);
			String vaccineName = vcn.getName();
			vcn.setCountry(split[2]);
			String vaccineCountry = vcn.getCountry();
			vcn.setDose(split[3]);
			String vaccineDose = vcn.getDose();
			vcn.setCenter(split[4]);
			String vaccineCenter = vcn.getCenter();
			vcn.setCity(split[5]);
			String vaccineCity = vcn.getCity();
			vcn.setAmount(split[6]);
			String vaccineAmount = vcn.getAmount();
			if(!(ID.equals(vaccineID))) {
				vcn.setID(vaccineID);
				vcn.setName(vaccineName);
				vcn.setCountry(vaccineCountry);
				vcn.setDose(vaccineDose);
				vcn.setCenter(vaccineCenter);
				vcn.setCity(vaccineCity);
				vcn.setAmount(vaccineAmount);
				vcn.register2();
			}
		}
		dao.deleteAll();
		List<String> lstUsr = temp.readAll();
		for (String str : lstUsr) {
			String[] split = str.split("\\|");
			Vaccine vcn = new Vaccine();
			vcn.setID(split[0]);
			String vaccineID = vcn.getID();
			vcn.setName(split[1]);
			String vaccineName = vcn.getName();
			vcn.setCountry(split[2]);
			String vaccineCountry = vcn.getCountry();
			vcn.setDose(split[3]);
			String vaccineDose = vcn.getDose();
			vcn.setCenter(split[4]);
			String vaccineCenter = vcn.getCenter();
			vcn.setCity(split[5]);
			String vaccineCity = vcn.getCity();
			vcn.setAmount(split[6]);
			String vaccineAmount = vcn.getAmount();
			vcn.setID(vaccineID);
			vcn.setName(vaccineName);
			vcn.setCountry(vaccineCountry);
			vcn.setDose(vaccineDose);
			vcn.setCenter(vaccineCenter);
			vcn.setCity(vaccineCity);
			vcn.setAmount(vaccineAmount);
			vcn.register();
		}
		temp.deleteAll();
	}
	
	public int validatingID(String value) {
		int x = 0;
		List<String> usrLst = dao.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Vaccine vcn = new Vaccine();
			vcn.setID(split[0]);
			String vaccineID = vcn.getID();
			if(value.equalsIgnoreCase(vaccineID)) {
				x = 1;
				break;
			}
		}
		return x;
	}
	
	public void addEliminate(String ID, int valueUpdate, String indicator) {
		int x;
		int y;
		List<String> usrLst = dao.readAll();
		for (String str : usrLst) {
			String[] split = str.split("\\|");
			Vaccine vcn = new Vaccine();
			vcn.setID(split[0]);
			String vaccineID = vcn.getID();
			vcn.setName(split[1]);
			String vaccineName = vcn.getName();
			vcn.setCountry(split[2]);
			String vaccineCountry = vcn.getCountry();
			vcn.setDose(split[3]);
			String vaccineDose = vcn.getDose();
			vcn.setCenter(split[4]);
			String vaccineCenter = vcn.getCenter();
			vcn.setCity(split[5]);
			String vaccineCity = vcn.getCity();
			vcn.setAmount(split[6]);
			String vaccineAmount = vcn.getAmount();
			if(ID.equals(vaccineID)) {
				if(indicator == "ADD") {
					x = Integer.parseInt(vaccineAmount);
					y = x + valueUpdate;
					vaccineAmount = Integer.toString(y);
				} else {
					x = Integer.parseInt(vaccineAmount);
					y = x - valueUpdate;
					vaccineAmount = Integer.toString(y);
				}
			}
			vcn.setID(vaccineID);
			vcn.setName(vaccineName);
			vcn.setCountry(vaccineCountry);
			vcn.setDose(vaccineDose);
			vcn.setCenter(vaccineCenter);
			vcn.setCity(vaccineCity);
			vcn.setAmount(vaccineAmount);
			vcn.register2();
		}
		dao.deleteAll();
		List<String> lstUsr = temp.readAll();
		for (String str : lstUsr) {
			String[] split = str.split("\\|");
			Vaccine vcn = new Vaccine();
			vcn.setID(split[0]);
			String vaccineID = vcn.getID();
			vcn.setName(split[1]);
			String vaccineName = vcn.getName();
			vcn.setCountry(split[2]);
			String vaccineCountry = vcn.getCountry();
			vcn.setDose(split[3]);
			String vaccineDose = vcn.getDose();
			vcn.setCenter(split[4]);
			String vaccineCenter = vcn.getCenter();
			vcn.setCity(split[5]);
			String vaccineCity = vcn.getCity();
			vcn.setAmount(split[6]);
			String vaccineAmount = vcn.getAmount();
			vcn.setID(vaccineID);
			vcn.setName(vaccineName);
			vcn.setCountry(vaccineCountry);
			vcn.setDose(vaccineDose);
			vcn.setCenter(vaccineCenter);
			vcn.setCity(vaccineCity);
			vcn.setAmount(vaccineAmount);
			vcn.register();
		}
		temp.deleteAll();
	}
}

