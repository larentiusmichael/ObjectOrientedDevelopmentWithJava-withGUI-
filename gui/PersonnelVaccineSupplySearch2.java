package assignment.gui;

import assignment.solution.Vaccine;

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

public class PersonnelVaccineSupplySearch2 extends JFrame {
	
	Vaccine u = new Vaccine();

	private JPanel contentPane;
	private JTable table;
	private static String fullName, username, id, value, indicator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonnelVaccineSupplySearch2 frame = new PersonnelVaccineSupplySearch2(fullName, username, id, value, indicator);
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
	public PersonnelVaccineSupplySearch2(String fullName, String username, String id, String value, String indicator) {
		this.fullName = fullName;
		this.username = username;
		this.id = id;
		this.value = value;
		this.indicator = indicator;
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
					"ID", "NAME", "PRODUCING COUNTRY", "DOSE REQUIRED", "CENTER", "CITY", "AMOUNT"
			}
		) {
			Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonnelVaccineSupplySearch1(fullName, username, id).setVisible(true);
				PersonnelVaccineSupplySearch2.this.dispose();
			}
		});
		btnNewButton.setBounds(10, 284, 474, 23);
		contentPane.add(btnNewButton);
		updateTableModel();
	}
	
	private void updateTableModel(){
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		List<Vaccine> lst = u.search(value, indicator);
		for (Vaccine vcn : lst) {
			String[] record = { vcn.getID(), vcn.getName(), vcn.getCountry(), vcn.getDose(), vcn.getCenter(), vcn.getCenter(), vcn.getCity(), vcn.getAmount()};
			model.addRow( record );
		}
		
	}
}