package Ej12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Tabla(Object[][] datos, String [] nombreColumnas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAcme = new JLabel("ACME");
		lblAcme.setForeground(new Color(0, 128, 128));
		lblAcme.setFont(new Font("Segoe UI Black", Font.PLAIN, 31));
		lblAcme.setBounds(165, 37, 118, 52);
		contentPane.add(lblAcme);
		
		table = new JTable(datos,nombreColumnas);
		table.setBounds(60, 111, 299, 115);
		contentPane.add(table);
		
	}
}
