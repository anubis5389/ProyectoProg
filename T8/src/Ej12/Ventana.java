package Ej12;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textoCodigo;
	private JTextField textoPrecio;
	private JTextField textoCantidad;
	private JButton alta;
	private JButton modificar;
	private JButton baja;
	private Articulo a;
	private String ruta;

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(GestionArticulos.guardarDatos());
		setBounds(100, 100, 450, 300);
		ruta=JOptionPane.showInputDialog("Introduce la ruta donde quieres guardar el fichero de datos");
		Fichero.setFichero(ruta);
		GestionArticulos.cargarDatos();
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblAcme = new JLabel("ACME");
		lblAcme.setForeground(new Color(0, 128, 128));
		lblAcme.setFont(new Font("Segoe UI Black", Font.PLAIN, 31));
		lblAcme.setBounds(165, 37, 118, 52);
		contentPane.add(lblAcme);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 133, 46, 14);
		contentPane.add(lblCdigo);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 173, 46, 14);
		contentPane.add(lblPrecio);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(222, 173, 46, 14);
		contentPane.add(lblCantidad);

		textoCodigo = new JTextField();
		textoCodigo.setBounds(66, 130, 134, 20);
		contentPane.add(textoCodigo);
		textoCodigo.setColumns(10);

		textoPrecio = new JTextField();
		textoPrecio.setColumns(10);
		textoPrecio.setBounds(66, 170, 134, 20);
		contentPane.add(textoPrecio);

		textoCantidad = new JTextField();
		textoCantidad.setColumns(10);
		textoCantidad.setBounds(278, 170, 134, 20);
		contentPane.add(textoCantidad);

		alta = new JButton("ALTA");
		alta.setEnabled(false);
		alta.setBounds(10, 198, 73, 23);
		
		alta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean fallo=false;
				if(!alta.isEnabled()||!textoCodigo.equals(null)) {
					if(GestionArticulos.buscarArticulo(textoCodigo.getText())!=null) {
						modificar.setEnabled(true);
						baja.setEnabled(true);

					}else {
						alta.setEnabled(true);

					}
				}else {
					if(!textoCantidad.equals(null)&&!textoPrecio.equals(null)) {
						do {
							try {
								GestionArticulos.anadirArticulo(new Articulo(textoCodigo.getText(),Integer.parseInt(textoCantidad.getText()),Double.parseDouble(textoPrecio.getText())));
								fallo=false;
							}catch(NumberFormatException nfe) {
								JOptionPane.showMessageDialog(null, "Has introducido datos que no corresponden, prueba poniendo números", "Error al introducir datos",JOptionPane.WARNING_MESSAGE);
								fallo=true;
							}
						}while(fallo);
					}
				}
				JOptionPane.showMessageDialog(null, "Articulo registrado satisfactoriamente");
			}
		});
		contentPane.add(alta);

		modificar = new JButton("MODIFICAR");
		modificar.setEnabled(false);
		modificar.setBounds(93, 198, 107, 23);
		
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Articulo b: GestionArticulos.getArticulos()) {
					if(b.getCodigo().equals(textoCodigo.getText())) {
						GestionArticulos.eliminarArticulo(b);
					}
				}
				GestionArticulos.anadirArticulo(new Articulo(textoCodigo.getText(),Integer.parseInt(textoCantidad.getText()),Double.parseDouble(textoPrecio.getText())));
				
			}
		});
		contentPane.add(modificar);
		

		baja = new JButton("BAJA");
		baja.setEnabled(false);
		baja.setBounds(214, 198, 77, 23);
		baja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Articulo b: GestionArticulos.getArticulos()) {
					if(b.getCodigo().equals(textoCodigo.getText())) {
						GestionArticulos.eliminarArticulo(b);
					}
				}
			}
		});
		
		contentPane.add(baja);

		JButton listado = new JButton("LISTADO");
		listado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object datos[][]=null;
				String columNames[] = {"Código","Cantidad","Precio"};
				for(int i=0;i<GestionArticulos.getArticulos().size();i++) {
					
						datos[0][i] = textoCodigo.getText();
						datos[1][i] = textoCantidad.getText();
						datos[2][i] = textoPrecio.getText();

				}
				Tabla listado = new Tabla(datos,columNames);
			}
		});
		listado.setBounds(301, 198, 91, 23);
		contentPane.add(listado);

		JButton fin = new JButton("FIN");
		fin.setBounds(10, 239, 382, 23);
		fin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionArticulos.guardarDatos();
			}
		});
		
		contentPane.add(fin);
	}
}
