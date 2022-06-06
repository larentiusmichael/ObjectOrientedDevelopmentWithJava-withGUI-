package assignment.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import assignment.additional.Record;

public class PersonnelUserPersonnel extends JFrame {

	private JPanel contentPane;
	private static String fullName, username, id;
	private static String type = "PERSONNEL";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonnelUserPersonnel frame = new PersonnelUserPersonnel(fullName, username, id);
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
	public PersonnelUserPersonnel(String fullName, String username, String id) {
		this.fullName = fullName;
		this.username = username;
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Choose one of these functionalities:");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("Register Personnel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelUserRegister(fullName, username, id, type).setVisible(true);
				PersonnelUserPersonnel.this.dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("View Personnel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Record dateTime = new Record();
				dateTime.setCurrentdate();
				dateTime.setAction("VIEWING PERSONNEL");
				dateTime.setUsername(username);
				dateTime.setID(id);
				dateTime.activityRecord();
				new PersonnelUserPersonnelView(fullName, username, id).setVisible(true);
				PersonnelUserPersonnel.this.dispose();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Search Personnel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelUserSearch(fullName, username, id, type).setVisible(true);
				PersonnelUserPersonnel.this.dispose();
			}
		});
		
		JButton btnNewButton_3 = new JButton("Modify Personnel");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelUserModify(fullName, username, id, type).setVisible(true);
				PersonnelUserPersonnel.this.dispose();
			}
		});
		
		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelUser(fullName, username, id).setVisible(true);
				PersonnelUserPersonnel.this.dispose();
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
				.addComponent(btnNewButton_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_4)
					.addContainerGap(86, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
