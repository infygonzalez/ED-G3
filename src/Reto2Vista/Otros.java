package Reto2Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class Otros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreEvento;
	private JLabel lblNombreEvento;
	private JLabel lblTipoEvento;
	private JLabel lblDescripcion;
	private JLabel lblPrecio;
	private JLabel lblFecha;
	private JComboBox cbTipoEvento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Otros frame = new Otros();
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
	public Otros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(otros());
		
	}
	
	public JPanel otros() {
		JPanel otros = new JPanel();
		otros.setBounds(0, 0, 721, 477);

		otros.setLayout(null);
		
		txtNombreEvento = new JTextField();
		txtNombreEvento.setBounds(297, 43, 147, 20);
		otros.add(txtNombreEvento);
		txtNombreEvento.setColumns(10);
		
		lblNombreEvento = new JLabel("Nombre Evento");
		lblNombreEvento.setBounds(90, 46, 105, 20);
		otros.add(lblNombreEvento);
		
		lblTipoEvento = new JLabel("Tipo de Evento");
		lblTipoEvento.setBounds(90, 97, 105, 20);
		otros.add(lblTipoEvento);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(90, 155, 105, 20);
		otros.add(lblDescripcion);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(90, 218, 105, 20);
		otros.add(lblPrecio);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(90, 309, 105, 20);
		otros.add(lblFecha);
		
		cbTipoEvento = new JComboBox();
		cbTipoEvento.setModel(new DefaultComboBoxModel(new String[] {"Vuelo", "Alojamientos", "Otros"}));
		cbTipoEvento.setBounds(293, 96, 140, 22);
		otros.add(cbTipoEvento);
		
		JTextArea txtDecripcion = new JTextArea();
		txtDecripcion.setBounds(293, 153, 160, 22);
		otros.add(txtDecripcion);
		
		JTextArea txtPrecio = new JTextArea();
		txtPrecio.setBounds(271, 216, 237, 61);
		otros.add(txtPrecio);
		
		JTextArea txtFecha = new JTextArea();
		txtFecha.setBounds(273, 307, 160, 22);
		otros.add(txtFecha);
		return otros;
	}
}
