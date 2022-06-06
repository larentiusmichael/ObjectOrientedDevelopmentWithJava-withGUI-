package assignment.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import assignment.additional.Record;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonnelVaccinationAppointment extends JFrame {

	private JPanel contentPane;
	private static String fullName, username, id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonnelVaccinationAppointment frame = new PersonnelVaccinationAppointment(fullName, username, id);
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
	public PersonnelVaccinationAppointment(String fullName, String username, String id) {
		this.fullName = fullName;
		this.username = username;
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Choose one of these functionalities:");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("Add Vaccination Appointment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelVaccinationAppointmentAdd(fullName, username, id).setVisible(true);
				PersonnelVaccinationAppointment.this.dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Remove Vaccination Appointment");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelVaccinationAppointmentRemove(fullName, username, id).setVisible(true);
				PersonnelVaccinationAppointment.this.dispose();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Modify Vaccination Appointment");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelVaccinationAppointmentModify1(fullName, username, id).setVisible(true);
				PersonnelVaccinationAppointment.this.dispose();
			}
		});
		
		JButton btnNewButton_3 = new JButton("View Vaccination Appointment List");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Record dateTime = new Record();
				dateTime.setCurrentdate();
				dateTime.setAction("VIEWING APPOINTMENT");
				dateTime.setUsername(username);
				dateTime.setID(id);
				dateTime.activityRecord();
				new PersonnelVaccinationAppointmentView(fullName, username, id).setVisible(true);
				PersonnelVaccinationAppointment.this.dispose();
			}
		});
		
		JButton btnNewButton_4 = new JButton("Search Vaccination Appointment");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelVaccinationAppointmentSearch1(fullName, username, id).setVisible(true);
				PersonnelVaccinationAppointment.this.dispose();
			}
		});
		
		JButton btnNewButton_5 = new JButton("Back");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelWindow(fullName, username, id).setVisible(true);
				PersonnelVaccinationAppointment.this.dispose();
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
				.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(btnNewButton_5, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_5)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
