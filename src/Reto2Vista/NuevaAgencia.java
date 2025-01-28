package Reto2Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevaAgencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreAgencia;
	private JTextField txtColor;
	private JTextField txtColor2;
	private JTextField txtLogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevaAgencia frame = new NuevaAgencia();
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
	public NuevaAgencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreAgencia = new JLabel("Nombre Agencia");
		lblNombreAgencia.setBounds(56, 23, 122, 14);
		contentPane.add(lblNombreAgencia);
		
		JLabel lblColorMarca = new JLabel("Color de Marca");
		lblColorMarca.setBounds(56, 65, 122, 14);
		contentPane.add(lblColorMarca);
		
		JLabel lblNumeroEmpleados = new JLabel("Numero de Empleados");
		lblNumeroEmpleados.setBounds(56, 104, 122, 14);
		contentPane.add(lblNumeroEmpleados);
		
		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setBounds(56, 189, 122, 14);
		contentPane.add(lblLogo);
		
		txtNombreAgencia = new JTextField();
		txtNombreAgencia.setBounds(207, 20, 174, 20);
		contentPane.add(txtNombreAgencia);
		txtNombreAgencia.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(207, 62, 86, 20);
		contentPane.add(txtColor);
		
		txtColor2 = new JTextField();
		txtColor2.setColumns(10);
		txtColor2.setBounds(321, 62, 60, 20);
		contentPane.add(txtColor2);
		
		txtLogo = new JTextField();
		txtLogo.setColumns(10);
		txtLogo.setBounds(207, 186, 174, 20);
		contentPane.add(txtLogo);
		
		JLabel lblTipoAgencia = new JLabel("Tipo de Agencia");
		lblTipoAgencia.setBounds(56, 148, 122, 14);
		contentPane.add(lblTipoAgencia);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Entre 2 y 10 empleados", "Entre 10 y 100 empleados", "Entre 100 y 1000 empleados"}));
		comboBox.setBounds(207, 100, 174, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"mayorista", "minorista", "mayorista-minorista"}));
		comboBox_1.setBounds(207, 144, 174, 22);
		contentPane.add(comboBox_1);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(100, 227, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(217, 227, 89, 23);
		contentPane.add(btnCancelar);
	}
}
