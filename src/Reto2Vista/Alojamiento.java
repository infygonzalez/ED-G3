package Reto2Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Alojamiento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alojamiento frame = new Alojamiento();
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
	public Alojamiento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add(alojamiento());

	}

	public JPanel alojamiento() {
		JPanel Alojamiento = new JPanel();
		Alojamiento.setLayout(null);
		Alojamiento.setBorder(new EmptyBorder(5, 5, 5, 5));
		Alojamiento.setBounds(0, 0, 805, 601);

		JLabel lblTipoHabitacion_1 = new JLabel("Tipo de Habitación");
		lblTipoHabitacion_1.setBounds(39, 58, 141, 14);
		Alojamiento.add(lblTipoHabitacion_1);

		JLabel lblPrecio_1 = new JLabel("Precio");
		lblPrecio_1.setBounds(39, 145, 141, 14);
		Alojamiento.add(lblPrecio_1);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(207, 142, 187, 20);
		Alojamiento.add(textField_5);

		JButton btnNewButton_1 = new JButton("Buscar Alojamiento");
		btnNewButton_1.setBounds(425, 117, 152, 23);
		Alojamiento.add(btnNewButton_1);

		JLabel lblNombreEvento_1_2_1 = new JLabel("Fecha de Entrada");
		lblNombreEvento_1_2_1.setBounds(39, 195, 141, 14);
		Alojamiento.add(lblNombreEvento_1_2_1);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(207, 192, 187, 20);
		Alojamiento.add(textField_6);

		JLabel lblFechaSalida_1 = new JLabel("Fecha de Salida");
		lblFechaSalida_1.setBounds(425, 195, 141, 14);
		Alojamiento.add(lblFechaSalida_1);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(533, 192, 187, 20);
		Alojamiento.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(207, 55, 187, 20);
		Alojamiento.add(textField_8);

		JLabel lblCiudad_1 = new JLabel("Ciudad");
		lblCiudad_1.setBounds(39, 101, 141, 14);
		Alojamiento.add(lblCiudad_1);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(207, 98, 187, 20);
		Alojamiento.add(textField_9);

		JPanel Alojamiento_1 = new JPanel();
		Alojamiento_1.setLayout(null);
		Alojamiento_1.setBounds(0, 0, 10, 10);
		Alojamiento.add(Alojamiento_1);
		return Alojamiento;
	}
}
