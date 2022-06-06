package assignment.gui;

import assignment.additional.Record;
import assignment.solution.Center;

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

public class PeopleVaccinationProgrammeRegister extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static String fullName, username, id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PeopleVaccinationProgrammeRegister frame = new PeopleVaccinationProgrammeRegister(fullName, username, id);
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
	public PeopleVaccinationProgrammeRegister(String fullName, String username, String id) {
		this.fullName = fullName;
		this.username = username;
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 162);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Enter your chosen Vaccination Programme ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PeopleVaccinationProgramme(fullName, username, id).setVisible(true);
				PeopleVaccinationProgrammeRegister.this.dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Continue");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valueSearch = textField.getText();
				if(valueSearch.isEmpty()) {
					JOptionPane.showMessageDialog(btnNewButton_1, "Please enter your chosen Vaccination Programme ID!");
				} else {
					if(valueSearch.equalsIgnoreCase("1") || valueSearch.equalsIgnoreCase("2") || valueSearch.equalsIgnoreCase("3") || valueSearch.equalsIgnoreCase("4") || valueSearch.equalsIgnoreCase("5")) {
						Record dateTime = new Record();
						dateTime.setCurrentdate();
						dateTime.setAction("CHOOSING VACCINATION PROGRAMME");
						dateTime.setUsername(username);
						dateTime.setID(id);
						dateTime.activityRecord();
						if(valueSearch.equalsIgnoreCase("1")) {
							Center ctr = new Center();
							ctr.setPeopleID(id);
							ctr.setPeopleUsername(username);
							ctr.setCenterID(valueSearch);
							ctr.setCenterName("Bukit Jalil Stadium");
							ctr.setCenterCity("Kuala Lumpur");
							ctr.register();
							JOptionPane.showMessageDialog(btnNewButton_1, "You have been registered to a Vaccination Programme");
							new PeopleVaccinationProgramme(fullName, username, id).setVisible(true);
							PeopleVaccinationProgrammeRegister.this.dispose();
						} else if(valueSearch.equalsIgnoreCase("2")) {
							Center ctr = new Center();
							ctr.setPeopleID(id);
							ctr.setPeopleUsername(username);
							ctr.setCenterID(valueSearch);
							ctr.setCenterName("Pavilion Kuala Lumpur");
							ctr.setCenterCity("Kuala Lumpur");
							ctr.register();
							JOptionPane.showMessageDialog(btnNewButton_1, "You have been registered to a Vaccination Programme");
							new PeopleVaccinationProgramme(fullName, username, id).setVisible(true);
							PeopleVaccinationProgrammeRegister.this.dispose();
						} else if(valueSearch.equalsIgnoreCase("3")) {
							Center ctr = new Center();
							ctr.setPeopleID(id);
							ctr.setPeopleUsername(username);
							ctr.setCenterID(valueSearch);
							ctr.setCenterName("Penang Town Hall");
							ctr.setCenterCity("Penang");
							ctr.register();
							JOptionPane.showMessageDialog(btnNewButton_1, "You have been registered to a Vaccination Programme");
							new PeopleVaccinationProgramme(fullName, username, id).setVisible(true);
							PeopleVaccinationProgrammeRegister.this.dispose();
						} else if(valueSearch.equalsIgnoreCase("4")) {
							Center ctr = new Center();
							ctr.setPeopleID(id);
							ctr.setPeopleUsername(username);
							ctr.setCenterID(valueSearch);
							ctr.setCenterName("LegoLand Malaysia");
							ctr.setCenterCity("Johor");
							ctr.register();
							JOptionPane.showMessageDialog(btnNewButton_1, "You have been registered to a Vaccination Programme");
							new PeopleVaccinationProgramme(fullName, username, id).setVisible(true);
							PeopleVaccinationProgrammeRegister.this.dispose();
						} else {
							Center ctr = new Center();
							ctr.setPeopleID(id);
							ctr.setPeopleUsername(username);
							ctr.setCenterID(valueSearch);
							ctr.setCenterName("The Astana Kuching");
							ctr.setCenterCity("Kuching");
							ctr.register();
							JOptionPane.showMessageDialog(btnNewButton_1, "You have been registered to a Vaccination Programme");
							new PeopleVaccinationProgramme(fullName, username, id).setVisible(true);
							PeopleVaccinationProgrammeRegister.this.dispose();
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
