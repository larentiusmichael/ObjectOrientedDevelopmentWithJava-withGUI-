package assignment.gui;

import assignment.additional.Record;
import assignment.solution.People;
import assignment.solution.Personnel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonnelUserModify2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static String fullName, username, id, type, value;
	private static String indicator = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonnelUserModify2 frame = new PersonnelUserModify2(fullName, username, id, type, value);
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
	public PersonnelUserModify2(String fullName, String username, String id, String type, String value) {
		this.fullName = fullName;
		this.username = username;
		this.id = id;
		this.type = type;
		this.value = value;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Enter new value:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("What do you want to modify?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 12));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("First Name");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indicator = "FIRST_NAME";
			}
		});
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Last Name");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indicator = "LAST_NAME";
			}
		});
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Place, DOB");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indicator = "DOB";
			}
		});
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Address");
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indicator = "ADDRESS";
			}
		});
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Vaccination Status");
		rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indicator = "VAC_STATUS";
			}
		});
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Nationality");
		rdbtnNewRadioButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indicator = "NATIONALITY";
			}
		});
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("National ID");
		rdbtnNewRadioButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indicator = "NATIONAL_ID";
			}
		});
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_3);
		group.add(rdbtnNewRadioButton_4);
		group.add(rdbtnNewRadioButton_5);
		group.add(rdbtnNewRadioButton_6);
		
		JLabel lblNewLabel_2 = new JLabel("(NOT VACCINATED / 1ST DOSE / FULL DOSE)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 8));
		lblNewLabel_2.setForeground(Color.GRAY);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indicator = "";
				new PersonnelUserModify(fullName, username, id, type).setVisible(true);
				PersonnelUserModify2.this.dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valueUpdate = textField.getText();
				if(valueUpdate.isEmpty()) {
					JOptionPane.showMessageDialog(btnNewButton_1, "Please enter updated value!");
				} else {
					if(indicator.isEmpty()) {
						JOptionPane.showMessageDialog(btnNewButton_1, "Please select indicator!");
					} else {
						if(type == "PEOPLE") {
							Record dateTime = new Record();
							dateTime.setCurrentdate();
							dateTime.setAction("MODIFYING PEOPLE");
							dateTime.setUsername(username);
							dateTime.setID(id);
							dateTime.activityRecord();
							People people1 = new People();
							people1.modify(value, valueUpdate, indicator);
						} else {
							Record dateTime = new Record();
							dateTime.setCurrentdate();
							dateTime.setAction("MODIFYING PERSONNEL");
							dateTime.setUsername(username);
							dateTime.setID(id);
							dateTime.activityRecord();
							Personnel personnel1 = new Personnel();
							personnel1.modify(value, valueUpdate, indicator);
						}
						JOptionPane.showMessageDialog(btnNewButton_1, "Change has been saved!");
						indicator = "";
						if(type == "PEOPLE") {
							new PersonnelUserPeople(fullName, username, id).setVisible(true);
							PersonnelUserModify2.this.dispose();
						} else {
							new PersonnelUserPersonnel(fullName, username, id).setVisible(true);
							PersonnelUserModify2.this.dispose();
						}
					}
				}
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(rdbtnNewRadioButton, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(rdbtnNewRadioButton_1, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(rdbtnNewRadioButton_2, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(rdbtnNewRadioButton_3, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(rdbtnNewRadioButton_6, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(rdbtnNewRadioButton_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(rdbtnNewRadioButton_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
					.addComponent(btnNewButton_1))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnNewRadioButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnNewRadioButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnNewRadioButton_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnNewRadioButton_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnNewRadioButton_6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnNewRadioButton_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnNewRadioButton_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(28))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
