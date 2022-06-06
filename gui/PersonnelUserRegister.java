package assignment.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import assignment.additional.Record;
import assignment.solution.People;
import assignment.solution.Personnel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonnelUserRegister extends JFrame {

	private JPanel contentPane;
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField TemporaryUsername;
	private JTextField TemporaryPassword;
	private JTextField PlaceDOB;
	private JTextField Address;
	private JTextField NationalID;
	private JTextField Nationality;
	private JTextField VaccinationStatus;
	private static String fullName, username, id, type;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonnelUserRegister frame = new PersonnelUserRegister(fullName, username, id, type);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PersonnelUserRegister(String fullName, String username, String id, String type) {
		this.fullName = fullName;
		this.username = username;
		this.id = id;
		this.type = type;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("REGISTER");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Enter First Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		FirstName = new JTextField();
		FirstName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Last Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		LastName = new JTextField();
		LastName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Temporary Username:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		TemporaryUsername = new JTextField();
		TemporaryUsername.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Enter Temporary Password:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		TemporaryPassword = new JTextField();
		TemporaryPassword.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Enter Place, Date of Birth:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		PlaceDOB = new JTextField();
		PlaceDOB.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Enter Address:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		Address = new JTextField();
		Address.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Enter National ID:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		NationalID = new JTextField();
		NationalID.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Enter Nationality:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		Nationality = new JTextField();
		Nationality.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Enter Vaccination Status (NOT VACCINATED/1ST DOSE/FULL DOSE):");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		VaccinationStatus = new JTextField();
		VaccinationStatus.setColumns(10);
		
		JButton SaveButton = new JButton("Save");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String namefirst = FirstName.getText();
				String namelast = LastName.getText();
				String usertemp = TemporaryUsername.getText();
				String pwdtemp = TemporaryPassword.getText();
				String dobplace = PlaceDOB.getText();
				String address = Address.getText();
				String IDnational = NationalID.getText();
				String nationality = Nationality.getText();
				String statusvac = VaccinationStatus.getText();
				if(namefirst.isEmpty() || namelast.isEmpty() || usertemp.isEmpty() || pwdtemp.isEmpty() || dobplace.isEmpty() || address.isEmpty() || IDnational.isEmpty() || nationality.isEmpty() || statusvac.isEmpty()) {
					JOptionPane.showMessageDialog(SaveButton, "Please fill the blank field!");
				} else {
					if(type == "PEOPLE") {
						People people1 = new People();
						int x =people1.validatingUsername(usertemp);
						if(x == 1) {
							JOptionPane.showMessageDialog(SaveButton, "Username has been taken! Please create another username");
						} else {
							String uniqueID = people1.getNewID();
							people1.setFirst(namefirst);
							people1.setLast(namelast);
							people1.setUsername(usertemp);
							people1.setPassword(pwdtemp);
							people1.setDOB(dobplace);
							people1.setAddress(address);
							people1.setNationalID(IDnational);
							people1.setNationality(nationality);
							people1.setVacStatus(statusvac);
							people1.setID(uniqueID);
							people1.register();
							Record dateTime = new Record();
							dateTime.setCurrentdate();
							dateTime.setAction("REGISTERING PEOPLE");
							dateTime.setUsername(username);
							dateTime.setID(id);
							dateTime.activityRecord();
							JOptionPane.showMessageDialog(SaveButton, "Update has been saved");
							new PersonnelUserPeople(fullName, username, id).setVisible(true);
							PersonnelUserRegister.this.dispose();
						}
					} else {
						Personnel personnel1 = new Personnel();
						int x =personnel1.validatingUsername(usertemp);
						if(x == 1) {
							JOptionPane.showMessageDialog(SaveButton, "Username has been taken! Please create another username");
						} else {
							String uniqueID = personnel1.getNewID();
							personnel1.setFirst(namefirst);
							personnel1.setLast(namelast);
							personnel1.setUsername(usertemp);
							personnel1.setPassword(pwdtemp);
							personnel1.setDOB(dobplace);
							personnel1.setAddress(address);
							personnel1.setNationalID(IDnational);
							personnel1.setNationality(nationality);
							personnel1.setVacStatus(statusvac);
							personnel1.setID(uniqueID);
							personnel1.register();
							Record dateTime = new Record();
							dateTime.setCurrentdate();
							dateTime.setAction("REGISTERING PERSONNEL");
							dateTime.setUsername(username);
							dateTime.setID(id);
							dateTime.activityRecord();
							JOptionPane.showMessageDialog(SaveButton, "Update has been saved");
							new PersonnelUserPersonnel(fullName, username, id).setVisible(true);
							PersonnelUserRegister.this.dispose();
						}
					}
				}
			}
		});
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(type == "PEOPLE") {
					new PersonnelUserPeople(fullName, username, id).setVisible(true);
					PersonnelUserRegister.this.dispose();
				} else {
					new PersonnelUserPersonnel(fullName, username, id).setVisible(true);
					PersonnelUserRegister.this.dispose();
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(FirstName, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(LastName, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(TemporaryUsername, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(TemporaryPassword, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(PlaceDOB, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_6, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(Address, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_7, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(NationalID, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(Nationality, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_9, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_8, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(VaccinationStatus, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(BackButton)
					.addPreferredGap(ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
					.addComponent(SaveButton))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(FirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(LastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(TemporaryUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(TemporaryPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(PlaceDOB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_7)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(NationalID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_8)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Nationality, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_9)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(VaccinationStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(SaveButton)
						.addComponent(BackButton))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
