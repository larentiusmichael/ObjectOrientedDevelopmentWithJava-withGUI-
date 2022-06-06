package assignment.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import assignment.additional.Record;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PeopleVaccinationStatusSearch1 extends JFrame {

	private JPanel contentPane;
	private JTextField searchValue;
	private static String fullName, username, id;
	private static String indicator = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PeopleVaccinationStatusSearch1 frame = new PeopleVaccinationStatusSearch1(fullName, username, id);
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
	public PeopleVaccinationStatusSearch1(String fullName, String username, String id) {
		this.fullName = fullName;
		this.username = username;
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Type value that you want to search:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		searchValue = new JTextField();
		searchValue.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Search by:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Username");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indicator = "USERNAME";
			}
		});
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("First Name");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indicator = "FIRST_NAME";
			}
		});
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Last Name");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indicator = "LAST_NAME";
			}
		});
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Vaccination Status");
		rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indicator = "VAC_STATUS";
			}
		});
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_4);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indicator = "";
				new PeopleVaccinationStatus(fullName, username, id).setVisible(true);
				PeopleVaccinationStatusSearch1.this.dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valueSearch = searchValue.getText();
				if(valueSearch.isEmpty()) {
					JOptionPane.showMessageDialog(btnNewButton_1, "Please enter value that you want to search!");
				} else {
					if(indicator.isEmpty()) {
						JOptionPane.showMessageDialog(btnNewButton_1, "Please select indicator!");
					} else {
						Record dateTime = new Record();
						dateTime.setCurrentdate();
						dateTime.setAction("SEARCHING STATUS");
						dateTime.setUsername(username);
						dateTime.setID(id);
						dateTime.activityRecord();
						new PeopleVaccinationStatusSearch2(fullName, username, id, valueSearch, indicator).setVisible(true);
						PeopleVaccinationStatusSearch1.this.dispose();
						indicator = "";
					}
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(searchValue, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(rdbtnNewRadioButton_1, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(rdbtnNewRadioButton_2, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(rdbtnNewRadioButton, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
					.addComponent(btnNewButton_1))
				.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(rdbtnNewRadioButton_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(searchValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnNewRadioButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnNewRadioButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnNewRadioButton_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnNewRadioButton_4)
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
