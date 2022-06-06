package assignment.solution;

public interface UserAction {
	String getNewID();

	void register();
	
	void register2();
	
	void modify(String username, String valueUpdate, String indicator);
	
	int login(String usr, String pwd);
	
	String getFullName(String usr, String pwd);
	
	String retrieveID(String usr, String pwd);
	
	int validatingUsername(String value);
	
	int validatingPassword(String value);
}
