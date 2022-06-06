package assignment.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpeningWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpeningWindow frame = new OpeningWindow();
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
	public OpeningWindow() {
		setTitle("CHOOSE USER TYPE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel WelcomeLabel = new JLabel("Welcome!");
		WelcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WelcomeLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		
		JLabel OpeningLabel = new JLabel("COVID-19 VACCINE REGISTRATION SYSTEM");
		OpeningLabel.setHorizontalAlignment(SwingConstants.CENTER);
		OpeningLabel.setForeground(new Color(255, 0, 0));
		OpeningLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		JLabel ChooseLabel = new JLabel("Choose User Type:");
		ChooseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ChooseLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		
		JButton PeopleButton = new JButton("PEOPLE");
		PeopleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = "people";
				new LoginWindow(type).setVisible(true);
				OpeningWindow.this.dispose();
			}
		});
		
		JLabel DevelopLabel = new JLabel("Develop by:");
		DevelopLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel TeamLabel = new JLabel("LAURENTIUS MICHAEL & ABINAASH A/L V CHANDRASEKARAN");
		TeamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnPersonnel = new JButton("PERSONNEL");
		btnPersonnel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = "personnel";
				new LoginWindow(type).setVisible(true);
				OpeningWindow.this.dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(DevelopLabel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(btnPersonnel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(ChooseLabel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(PeopleButton, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(OpeningLabel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(TeamLabel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(WelcomeLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(WelcomeLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(OpeningLabel)
					.addGap(25)
					.addComponent(ChooseLabel)
					.addGap(11)
					.addComponent(PeopleButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnPersonnel)
					.addGap(27)
					.addComponent(DevelopLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(TeamLabel)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
