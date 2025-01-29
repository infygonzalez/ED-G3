package Reto2Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class NuevoViaje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_1;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoViaje frame = new NuevoViaje();
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
	public NuevoViaje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1114, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(nuevoviaje());
		
		contentPane.add(vuelovuelta());
		

	}
	
	
	public JPanel nuevoviaje () {
		JPanel NuevoViaje = new JPanel();
		NuevoViaje.setLayout(null);
		NuevoViaje.setBounds(0, 0, 583, 437);
		
		JLabel lblTrayecto_1 = new JLabel("Trayecto");
		lblTrayecto_1.setBounds(50, 41, 141, 14);
		NuevoViaje.add(lblTrayecto_1);
		
		JComboBox cbTrayecto_1 = new JComboBox();
		cbTrayecto_1.setBounds(218, 37, 187, 22);
		NuevoViaje.add(cbTrayecto_1);
		
		JLabel lblAeropuertoOrigen_1 = new JLabel("Aeropuerto Origen");
		lblAeropuertoOrigen_1.setBounds(50, 82, 141, 14);
		NuevoViaje.add(lblAeropuertoOrigen_1);
		
		JComboBox cbAeropuertoOrigen_1 = new JComboBox();
		cbAeropuertoOrigen_1.setBounds(218, 78, 187, 22);
		NuevoViaje.add(cbAeropuertoOrigen_1);
		
		JLabel lblAeropuertoDestino_1 = new JLabel("Aeropuerto Destino");
		lblAeropuertoDestino_1.setBounds(50, 124, 141, 14);
		NuevoViaje.add(lblAeropuertoDestino_1);
		
		JComboBox cbAeropuertoDestino_1 = new JComboBox();
		cbAeropuertoDestino_1.setBounds(218, 120, 187, 22);
		NuevoViaje.add(cbAeropuertoDestino_1);
		
		JLabel lblFechaIda_1 = new JLabel("Fecha Ida");
		lblFechaIda_1.setBounds(50, 167, 141, 14);
		NuevoViaje.add(lblFechaIda_1);
		
		textField_2 = new JTextField();
		textField_2.setText("AQUI DATAPICKER");
		textField_2.setColumns(10);
		textField_2.setBounds(218, 164, 187, 20);
		NuevoViaje.add(textField_2);
		
		JButton btnBuscarViaje_1 = new JButton("Buscar Viaje");
		btnBuscarViaje_1.setBounds(445, 92, 126, 23);
		NuevoViaje.add(btnBuscarViaje_1);
		
		JLabel lblCodigoVuelo_1 = new JLabel("Codigo Vuelo");
		lblCodigoVuelo_1.setBounds(50, 206, 141, 14);
		NuevoViaje.add(lblCodigoVuelo_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(218, 203, 187, 20);
		NuevoViaje.add(textField_10);
		
		JLabel lblAerolinea_1 = new JLabel("Aerolinea");
		lblAerolinea_1.setBounds(50, 248, 141, 14);
		NuevoViaje.add(lblAerolinea_1);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(218, 245, 187, 20);
		NuevoViaje.add(textField_11);
		
		JLabel lblPrecio_1 = new JLabel("Precio");
		lblPrecio_1.setBounds(50, 291, 141, 14);
		NuevoViaje.add(lblPrecio_1);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(218, 288, 187, 20);
		NuevoViaje.add(textField_12);
		
		JLabel lblHoraSalida_1 = new JLabel("Hora Salida");
		lblHoraSalida_1.setBounds(50, 331, 141, 14);
		NuevoViaje.add(lblHoraSalida_1);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(218, 328, 187, 20);
		NuevoViaje.add(textField_13);
		
		JLabel lblDuracin_1 = new JLabel("Duración");
		lblDuracin_1.setBounds(50, 378, 141, 14);
		NuevoViaje.add(lblDuracin_1);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(218, 375, 187, 20);
		NuevoViaje.add(textField_14);
		
		JButton btnGuardar_1 = new JButton("Guardar");
		btnGuardar_1.setBounds(113, 530, 89, 23);
		NuevoViaje.add(btnGuardar_1);
		
		JButton btnCancelar_1 = new JButton("Cancelar");
		btnCancelar_1.setBounds(314, 530, 89, 23);
		NuevoViaje.add(btnCancelar_1);
		return NuevoViaje;
	}
	
	public JPanel vuelovuelta(){
		JPanel VueloVuelta = new JPanel();
		VueloVuelta.setBounds(593, 99, 435, 338);

		VueloVuelta.setLayout(null);
		
		JLabel lblFechaVuelta_1 = new JLabel("Fecha Vuelta");
		lblFechaVuelta_1.setBounds(10, 32, 141, 14);
		VueloVuelta.add(lblFechaVuelta_1);
		
		textField = new JTextField();
		textField.setText("AQUI DATAPICKER");
		textField.setColumns(10);
		textField.setBounds(177, 29, 187, 20);
		VueloVuelta.add(textField);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(177, 68, 187, 20);
		VueloVuelta.add(textField_3);
		
		JLabel lblFechaIda_2_1 = new JLabel("Codigo Vuelo");
		lblFechaIda_2_1.setBounds(10, 71, 141, 14);
		VueloVuelta.add(lblFechaIda_2_1);
		
		JLabel lblAerolineaVuelta_2 = new JLabel("Fecha Ida");
		lblAerolineaVuelta_2.setBounds(10, 113, 141, 14);
		VueloVuelta.add(lblAerolineaVuelta_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(177, 110, 187, 20);
		VueloVuelta.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(177, 153, 187, 20);
		VueloVuelta.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(177, 193, 187, 20);
		VueloVuelta.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(177, 235, 187, 20);
		VueloVuelta.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(177, 276, 187, 20);
		VueloVuelta.add(textField_8);
		
		JLabel lblAerolineaVuelta_1_1 = new JLabel("Aerolinea Vuelta");
		lblAerolineaVuelta_1_1.setBounds(10, 156, 141, 14);
		VueloVuelta.add(lblAerolineaVuelta_1_1);
		
		JLabel lblPrecioTotal_1 = new JLabel("Precio Total");
		lblPrecioTotal_1.setBounds(10, 196, 141, 14);
		VueloVuelta.add(lblPrecioTotal_1);
		
		JLabel lblHorarioVuelta_1 = new JLabel("Horario Vuelta");
		lblHorarioVuelta_1.setBounds(10, 238, 141, 14);
		VueloVuelta.add(lblHorarioVuelta_1);
		
		JLabel lblDuracionVuelta_1 = new JLabel("Duracion Vuelta");
		lblDuracionVuelta_1.setBounds(10, 279, 141, 14);
		VueloVuelta.add(lblDuracionVuelta_1);
		return VueloVuelta;
	}

}
