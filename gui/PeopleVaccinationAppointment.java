package assignment.gui;

import assignment.solution.Appointment;
import assignment.solution.Center;
import assignment.solution.People;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import assignment.additional.Record;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PeopleVaccinationAppointment extends JFrame {

	private JPanel contentPane;
	private static String fullName, username, id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PeopleVaccinationAppointment frame = new PeopleVaccinationAppointment(fullName, username, id);
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
	public PeopleVaccinationAppointment(String fullName, String username, String id) {
		this.fullName = fullName;
		this.username = username;
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Choose one of these functionalities:");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("View Vaccination Appointment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Center c = new Center();
				String chosenCenter = c.getChosenCenter(id);
				if(chosenCenter.equals("")) {
					JOptionPane.showMessageDialog(btnNewButton, "Please select a Vaccination Programme first");
				} else {
					Record dateTime = new Record();
					dateTime.setCurrentdate();
					dateTime.setAction("VIEWING APPOINTMENT");
					dateTime.setUsername(username);
					dateTime.setID(id);
					dateTime.activityRecord();
					new PeopleVaccinationAppointmentView(fullName, username, id, chosenCenter).setVisible(true);
					PeopleVaccinationAppointment.this.dispose();
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Submit Vaccination Appointment");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				People ppl = new People();
				String currentStatus = ppl.getCurrentStatus(id);
				if(currentStatus.equalsIgnoreCase("NOT VACCINATED")) {
					Appointment a = new Appointment();
					int x = a.checkExistence1(id);
					if(x == 1) {
						JOptionPane.showMessageDialog(btnNewButton_1, "You have selected a Vaccination Appointment");
					} else {
						Center c = new Center();
						String chosenCenter = c.getChosenCenter(id);
						new PeopleVaccinationAppointmentSubmit(fullName, username, id, chosenCenter, currentStatus).setVisible(true);
						PeopleVaccinationAppointment.this.dispose();
					}
				} else if (currentStatus.equalsIgnoreCase("1ST DOSE")) {
					Appointment a = new Appointment();
					int x = a.checkExistence2(id);
					if(x == 1) {
						JOptionPane.showMessageDialog(btnNewButton_1, "You have selected a Vaccination Appointment");
					} else {
						Center c = new Center();
						String chosenCenter = c.getChosenCenter(id);
						new PeopleVaccinationAppointmentSubmit(fullName, username, id, chosenCenter, currentStatus).setVisible(true);
						PeopleVaccinationAppointment.this.dispose();
					}
				} else {
					JOptionPane.showMessageDialog(btnNewButton_1, "You are already fully vaccinated");
				}
			}
		});
		
		JButton btnNewButton_2 = new JButton("Cancel Vaccination Appointment");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				People ppl = new People();
				String currentStatus = ppl.getCurrentStatus(id);
				if(currentStatus.equalsIgnoreCase("NOT VACCINATED")) {
					Appointment a = new Appointment();
					int x = a.checkExistence1(id);
					if(x == 1) {
						String y = a.getAppointmentID1(id);
						a.cancel1(id);
						a.addEliminateSlot(y, "ADD");
						JOptionPane.showMessageDialog(btnNewButton_1, "You have cancelled your previous Vaccination Appointment Booking");
					} else {
						JOptionPane.showMessageDialog(btnNewButton_1, "You have not yet selected any Vaccination Appointment");
					}
				} else if (currentStatus.equalsIgnoreCase("1ST DOSE")) {
					Appointment a = new Appointment();
					int x = a.checkExistence2(id);
					if(x == 1) {
						String y = a.getAppointmentID2(id);
						a.cancel2(id);
						a.addEliminateSlot(y, "ADD");
						JOptionPane.showMessageDialog(btnNewButton_1, "You have cancelled your previous Vaccination Appointment Booking");
					} else {
						JOptionPane.showMessageDialog(btnNewButton_1, "You have not yet selected any Vaccination Appointment");
					}
				} else {
					JOptionPane.showMessageDialog(btnNewButton_1, "You are already fully vaccinated");
				}
			}
		});
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PeopleWindow(fullName, username, id).setVisible(true);
				PeopleVaccinationAppointment.this.dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_3)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
