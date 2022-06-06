package assignment.gui;

import assignment.additional.Record;
import assignment.solution.Appointment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PeopleVaccinationAppointmentSubmit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static String fullName, username, id, chosenCenter, currentStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PeopleVaccinationAppointmentSubmit frame = new PeopleVaccinationAppointmentSubmit(fullName, username, id, chosenCenter, currentStatus);
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
	public PeopleVaccinationAppointmentSubmit(String fullName, String username, String id, String chosenCenter, String currentStatus) {
		this.fullName = fullName;
		this.username = username;
		this.id = id;
		this.chosenCenter = chosenCenter;
		this.currentStatus = currentStatus;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 162);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Enter your chosen Vaccination Appointment ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PeopleVaccinationAppointment(fullName, username, id).setVisible(true);
				PeopleVaccinationAppointmentSubmit.this.dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Continue");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valueSearch = textField.getText();
				if(valueSearch.isEmpty()) {
					JOptionPane.showMessageDialog(btnNewButton_1, "Please enter your chosen Vaccination Appointment ID!");
				} else {
					Appointment a = new Appointment();
					int x = a.validatingChosenID(chosenCenter, valueSearch);
					if(x == 1) {
						int y = a.checkSlot(valueSearch);
//						int y = 0;
						if(y == 0) {
							Record dateTime = new Record();
							dateTime.setCurrentdate();
							dateTime.setAction("CHOOSING APPOINTMENT");
							dateTime.setUsername(username);
							dateTime.setID(id);
							dateTime.activityRecord();
							if(currentStatus.equalsIgnoreCase("NOT VACCINATED")) {
								a.setPeopleID(id);
								a.setPeopleUsername(username);
								a.setChosenAppointmentID(valueSearch);
								a.setChosenCenter(chosenCenter);
								a.register3();
							} else {
								a.setPeopleID(id);
								a.setPeopleUsername(username);
								a.setChosenAppointmentID(valueSearch);
								a.setChosenCenter(chosenCenter);
								a.register4();
							}
							a.addEliminateSlot(valueSearch, "ELIMINATE");
							JOptionPane.showMessageDialog(btnNewButton_1, "Record has been saved!");
							new PeopleVaccinationAppointment(fullName, username, id).setVisible(true);
							PeopleVaccinationAppointmentSubmit.this.dispose();
						} else {
							JOptionPane.showMessageDialog(btnNewButton_1, "Slots are fully booked!");
						}
					} else {
						JOptionPane.showMessageDialog(btnNewButton_1, "Invalid input!");
					}
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(textField, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
					.addComponent(btnNewButton_1))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(169, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
