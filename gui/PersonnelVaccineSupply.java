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

public class PersonnelVaccineSupply extends JFrame {

	private JPanel contentPane;
	private static String fullName, username, id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonnelVaccineSupply frame = new PersonnelVaccineSupply(fullName, username, id);
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
	public PersonnelVaccineSupply(String fullName, String username, String id) {
		this.fullName = fullName;
		this.username = username;
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Choose one of these functionalities:");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("Add Vaccine Supply");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelVaccineSupplyAdd(fullName, username, id).setVisible(true);
				PersonnelVaccineSupply.this.dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Remove Vaccine Supply");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelVaccineSupplyRemove(fullName, username, id).setVisible(true);
				PersonnelVaccineSupply.this.dispose();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Modify Vaccine Supply");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelVaccineSupplyModify1(fullName, username, id).setVisible(true);
				PersonnelVaccineSupply.this.dispose();
			}
		});
		
		JButton btnNewButton_3 = new JButton("View Vaccine Supply");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Record dateTime = new Record();
				dateTime.setCurrentdate();
				dateTime.setAction("VIEWING VACCINE");
				dateTime.setUsername(username);
				dateTime.setID(id);
				dateTime.activityRecord();
				new PersonnelVaccineSupplyView(fullName, username, id).setVisible(true);
				PersonnelVaccineSupply.this.dispose();
			}
		});
		
		JButton btnNewButton_4 = new JButton("Search Vaccine Supply");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelVaccineSupplySearch1(fullName, username, id).setVisible(true);
				PersonnelVaccineSupply.this.dispose();
			}
		});
		
		JButton btnNewButton_5 = new JButton("Back");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelWindow(fullName, username, id).setVisible(true);
				PersonnelVaccineSupply.this.dispose();
			}
		});
		
		JButton btnNewButton_6 = new JButton("Add or Eliminate Vaccine Supply");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelVaccineSupplyAddEliminate1(fullName, username, id).setVisible(true);
				PersonnelVaccineSupply.this.dispose();
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
				.addComponent(btnNewButton_6, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(btnNewButton_5, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
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
					.addComponent(btnNewButton_6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_5)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}