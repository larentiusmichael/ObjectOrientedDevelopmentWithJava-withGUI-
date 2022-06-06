package assignment.gui;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PeopleVaccinationProgrammeView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static String fullName, username, id;

	private void onload() {
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.addRow( new String[] {"1","Bukit Jalil Stadium","Kuala Lumpur"} );
		model.addRow( new String[] {"2","Pavilion Kuala Lumpur","Kuala Lumpur"} );
		model.addRow( new String[] {"3","Penang Town Hall","Penang"} );
		model.addRow( new String[] {"4","LegoLand Malaysia","Johor"} );
		model.addRow( new String[] {"5","The Astana Kuching","Kuching"} );
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PeopleVaccinationProgrammeView frame = new PeopleVaccinationProgrammeView(fullName, username, id);
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
	public PeopleVaccinationProgrammeView(String fullName, String username, String id) {
		this.fullName = fullName;
		this.username = username;
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 47, 716, 259);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Center", "City"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(table);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PeopleVaccinationProgramme(fullName, username, id).setVisible(true);
				PeopleVaccinationProgrammeView.this.dispose();
			}
		});
		btnNewButton.setBounds(637, 11, 89, 23);
		contentPane.add(btnNewButton);
		onload();
		
	}
}