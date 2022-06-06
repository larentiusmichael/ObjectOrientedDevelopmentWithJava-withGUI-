package assignment.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import assignment.additional.Record;
import assignment.solution.Appointment;

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

public class PersonnelVaccinationAppointmentAdd extends JFrame {

	private JPanel contentPane;
	private JTextField DateField;
	private JTextField MonthField;
	private JTextField YearField;
	private JTextField TimeField;
	private JTextField CenterField;
	private static String fullName, username, id;
	private JTextField CityField;
	private JTextField SlotField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonnelVaccinationAppointmentAdd frame = new PersonnelVaccinationAppointmentAdd(fullName, username, id);
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
	public PersonnelVaccinationAppointmentAdd(String fullName, String username, String id) {
		this.fullName = fullName;
		this.username = username;
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("ADD VACCINATION APPOINTMENT");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Enter Date (2 digits):");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		DateField = new JTextField();
		DateField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Month (January - December):");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		MonthField = new JTextField();
		MonthField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Year:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		YearField = new JTextField();
		YearField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Enter Time (24-hour format):");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		TimeField = new JTextField();
		TimeField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Enter Center Name:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		CenterField = new JTextField();
		CenterField.setColumns(10);
		
		JButton SaveButton = new JButton("Save");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = DateField.getText();
				String month = MonthField.getText();
				String year = YearField.getText();
				String time = TimeField.getText();
				String center = CenterField.getText();
				String city = CityField.getText();
				String slot = SlotField.getText();
				if(date.isEmpty() || month.isEmpty() || year.isEmpty() || time.isEmpty() || center.isEmpty() || city.isEmpty() || slot.isEmpty()) {
					JOptionPane.showMessageDialog(SaveButton, "Please fill the blank field!");
				} else {
					Appointment appointment1 = new Appointment();
					String uniqueID = appointment1.getNewID();
					appointment1.setDate(date);
					appointment1.setMonth(month);
					appointment1.setYear(year);
					appointment1.setTime(time);
					appointment1.setCenter(center);
					appointment1.setCity(city);
					appointment1.setSlot(slot);
					appointment1.setID(uniqueID);
					appointment1.register();
					Record dateTime = new Record();
					dateTime.setCurrentdate();
					dateTime.setAction("ADDING APPOINTMENT");
					dateTime.setUsername(username);
					dateTime.setID(id);
					dateTime.activityRecord();
					JOptionPane.showMessageDialog(SaveButton, "Update has been saved");
					new PersonnelVaccinationAppointment(fullName, username, id).setVisible(true);
					PersonnelVaccinationAppointmentAdd.this.dispose();
				}
			}
		});
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelVaccinationAppointment(fullName, username, id).setVisible(true);
				PersonnelVaccinationAppointmentAdd.this.dispose();
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("Enter City:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		CityField = new JTextField();
		CityField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Enter Total Slot:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		SlotField = new JTextField();
		SlotField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(DateField, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(MonthField, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(YearField, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(TimeField, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(CenterField, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(CityField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(SlotField, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(BackButton)
					.addPreferredGap(ComponentPlacement.RELATED, 312, Short.MAX_VALUE)
					.addComponent(SaveButton))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(DateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(MonthField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(YearField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(TimeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(CenterField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(CityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_7)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(SlotField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(BackButton)
						.addComponent(SaveButton))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
