package assignment.gui;

import assignment.solution.Appointment;

import java.awt.EventQueue;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PeopleVaccinationAppointmentView extends JFrame {
	
	Appointment a = new Appointment();

	private JPanel contentPane;
	private JTable table;
	private static String fullName, username, id, chosenCenter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PeopleVaccinationAppointmentView frame = new PeopleVaccinationAppointmentView(fullName, username, id, chosenCenter);
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
	public PeopleVaccinationAppointmentView(String fullName, String username, String id, String chosenCenter) {
		this.fullName = fullName;
		this.username = username;
		this.id = id;
		this.chosenCenter = chosenCenter;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 474, 262);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "DATE", "MONTH", "YEAR", "TIME", "CENTER", "CITY", "SLOT"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PeopleVaccinationAppointment(fullName, username, id).setVisible(true);
				PeopleVaccinationAppointmentView.this.dispose();
			}
		});
		btnNewButton.setBounds(10, 284, 474, 23);
		contentPane.add(btnNewButton);
		updateTableModel();
	}
	
	private void updateTableModel(){
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		List<Appointment> lst = a.peopleView(chosenCenter);
		for (Appointment apn : lst) {
			String[] record = { apn.getID(), apn.getDate(), apn.getMonth(), apn.getYear(), apn.getTime(), apn.getCenter(), apn.getCity(), apn.getSlot()};
			model.addRow( record );
		}
		
	}
}