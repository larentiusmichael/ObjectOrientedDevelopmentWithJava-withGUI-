package assignment.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import assignment.additional.Record;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonnelWindow extends JFrame {

	private JPanel contentPane;
	private static String fullName, username, id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonnelWindow frame = new PersonnelWindow(fullName, username, id);
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
	public PersonnelWindow(String fullName, String username, String id) {
		setTitle("PERSONNEL WINDOW");
		this.fullName = fullName;
		this.username = username;
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Hi, "+ this.fullName+"!");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("What do you want to do?");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton UserButton = new JButton("USER");
		UserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelUser(fullName, username, id).setVisible(true);
				PersonnelWindow.this.dispose();
			}
		});
		
		JButton AppointmentButton = new JButton("VACCINATION APPOINTMENT");
		AppointmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelVaccinationAppointment(fullName, username, id).setVisible(true);
				PersonnelWindow.this.dispose();
			}
		});
		
		JButton SupplyButton = new JButton("VACCINE SUPLY");
		SupplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelVaccineSupply(fullName, username, id).setVisible(true);
				PersonnelWindow.this.dispose();
			}
		});
		
		JButton AccountButton = new JButton("ACCOUNT");
		AccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelAccount(fullName, username, id).setVisible(true);
				PersonnelWindow.this.dispose();
			}
		});
		
		JButton LogoutButton = new JButton("LOGOUT");
		LogoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Record dateTime = new Record();
				dateTime.setCurrentdate();
				dateTime.setAction("LOGOUT");
				dateTime.setUsername(username);
				dateTime.addRecord();
				new OpeningWindow().setVisible(true);
				PersonnelWindow.this.dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(UserButton, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(AppointmentButton, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(SupplyButton, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(AccountButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(LogoutButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(UserButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(AppointmentButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(SupplyButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(AccountButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(LogoutButton)
					.addContainerGap(71, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
