package assignment.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import assignment.additional.Record;
import assignment.solution.Vaccine;

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

public class PersonnelVaccineSupplyAdd extends JFrame {

	private JPanel contentPane;
	private JTextField NameField;
	private JTextField CountryField;
	private JTextField DoseField;
	private JTextField CenterField;
	private JTextField CityField;
	private static String fullName, username, id;
	private JTextField AmountField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonnelVaccineSupplyAdd frame = new PersonnelVaccineSupplyAdd(fullName, username, id);
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
	public PersonnelVaccineSupplyAdd(String fullName, String username, String id) {
		this.fullName = fullName;
		this.username = username;
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("ADD VACCINE SUPPLY");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Enter Vaccine Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		NameField = new JTextField();
		NameField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Producing Country:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		CountryField = new JTextField();
		CountryField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Dose Required:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		DoseField = new JTextField();
		DoseField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Enter Center Name:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		CenterField = new JTextField();
		CenterField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Enter City:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		CityField = new JTextField();
		CityField.setColumns(10);
		
		JButton SaveButton = new JButton("Save");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = NameField.getText();
				String country = CountryField.getText();
				String dose = DoseField.getText();
				String center = CenterField.getText();
				String city = CityField.getText();
				String amount = AmountField.getText();
				if(name.isEmpty() || country.isEmpty() || dose.isEmpty() || center.isEmpty() || city.isEmpty() || amount.isEmpty()) {
					JOptionPane.showMessageDialog(SaveButton, "Please fill the blank field!");
				} else {
					Vaccine vaccine1 = new Vaccine();
					String uniqueID = vaccine1.getNewID();
					vaccine1.setName(name);
					vaccine1.setCountry(country);
					vaccine1.setDose(dose);
					vaccine1.setCenter(center);
					vaccine1.setCity(city);
					vaccine1.setAmount(amount);
					vaccine1.setID(uniqueID);
					vaccine1.register();
					Record dateTime = new Record();
					dateTime.setCurrentdate();
					dateTime.setAction("ADDING VACCINE");
					dateTime.setUsername(username);
					dateTime.setID(id);
					dateTime.activityRecord();
					JOptionPane.showMessageDialog(SaveButton, "Update has been saved");
					new PersonnelVaccineSupply(fullName, username, id).setVisible(true);
					PersonnelVaccineSupplyAdd.this.dispose();
				}
			}
		});
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelVaccineSupply(fullName, username, id).setVisible(true);
				PersonnelVaccineSupplyAdd.this.dispose();
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("Enter Amount:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		AmountField = new JTextField();
		AmountField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(NameField, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(CountryField, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(DoseField, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(CenterField, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(CityField, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(AmountField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
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
					.addComponent(NameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(CountryField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(DoseField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(CenterField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(CityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(AmountField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(BackButton)
						.addComponent(SaveButton))
					.addGap(42))
		);
		contentPane.setLayout(gl_contentPane);
	}
}