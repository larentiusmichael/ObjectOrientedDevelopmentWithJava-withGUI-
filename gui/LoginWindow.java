package assignment.gui;

import assignment.solution.People;
import assignment.solution.Personnel;
import assignment.additional.Record;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class LoginWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private static String type;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow(type);
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
	public LoginWindow(String type) {
		this.type = type;
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = new String( passwordField.getPassword() );
				if(type == "people") {
					People people1 = new People();
					int x = people1.login(username, password);
					if(x == 1) {
						JOptionPane.showMessageDialog(btnNewButton, "Valid Login!");
						String fullName = people1.getFullName(username, password);
						String identityno = people1.retrieveID(username, password);
						Record dateTime = new Record();
						dateTime.setCurrentdate();
						dateTime.setAction("LOGIN");
						dateTime.setUsername(username);
						dateTime.setID(identityno);
						dateTime.addRecord();
						new PeopleWindow(fullName, username, identityno).setVisible(true);
						LoginWindow.this.dispose();
					} else if(x == 2) {
						JOptionPane.showMessageDialog(btnNewButton, "Username or Password Might be Wrong!");
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Invalid Login!");
					}
				} else {
					Personnel personnel1 = new Personnel();
					int x = personnel1.login(username, password);
					if(x == 1) {
						JOptionPane.showMessageDialog(btnNewButton, "Valid Login!");
						String fullName = personnel1.getFullName(username, password);
						String identityno = personnel1.retrieveID(username, password);
						Record dateTime = new Record();
						dateTime.setCurrentdate();
						dateTime.setAction("LOGIN");
						dateTime.setUsername(username);
						dateTime.setID(identityno);
						dateTime.addRecord();
						new PersonnelWindow(fullName, username, identityno).setVisible(true);
						LoginWindow.this.dispose();
					} else if(x == 2) {
						JOptionPane.showMessageDialog(btnNewButton, "Username or Password Might be Wrong!");
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Invalid Login!");
					}
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Enter your username:");
		
		JLabel lblEnterYourPassword = new JLabel("Enter your password:");
		
		JLabel lblNewLabel_1 = new JLabel("Don't have any account?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("Register yourself through nearby personnel");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OpeningWindow().setVisible(true);
				LoginWindow.this.dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(textField, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblEnterYourPassword, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(16)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(lblEnterYourPassword)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
