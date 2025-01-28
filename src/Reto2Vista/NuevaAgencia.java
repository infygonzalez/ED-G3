package Reto2Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Reto2Controlador.Controlador;
import Reto2Modelo.Agencia;
import Reto2Modelo.Viaje;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class NuevaAgencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreAgencia;
	private JTextField txtColor;
	private JTextField txtLogo;
	private JTextField txtContraseña;
	private Controlador controlador = new Controlador();
	private JComboBox comboBoxTipoAgencia;
	private JComboBox comboBoxNumeroEmpleados;
	private JPanel panelColor;

	/**
	 * Create the frame.
	 */
	public NuevaAgencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 351);
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
		txtColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelColor.setBackground( Color.decode(txtColor.getText()));
			}
		});
		txtColor.setColumns(10);
		txtColor.setBounds(207, 62, 122, 20);
		contentPane.add(txtColor);

		txtLogo = new JTextField();
		txtLogo.setColumns(10);
		txtLogo.setBounds(207, 186, 174, 20);
		contentPane.add(txtLogo);

		JLabel lblTipoAgencia = new JLabel("Tipo de Agencia");
		lblTipoAgencia.setBounds(56, 148, 122, 14);
		contentPane.add(lblTipoAgencia);

		comboBoxNumeroEmpleados = new JComboBox();
		comboBoxNumeroEmpleados.setModel(new DefaultComboBoxModel(
				new String[] { "Entre 2 y 10 empleados", "Entre 10 y 100 empleados", "Entre 100 y 1000 empleados" }));
		comboBoxNumeroEmpleados.setBounds(207, 100, 174, 22);
		contentPane.add(comboBoxNumeroEmpleados);

		comboBoxTipoAgencia = new JComboBox();
		comboBoxTipoAgencia
				.setModel(new DefaultComboBoxModel(new String[] { "mayorista", "minorista", "mayorista-minorista" }));
		comboBoxTipoAgencia.setBounds(207, 144, 174, 22);
		contentPane.add(comboBoxTipoAgencia);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validarAgencia() == true) {
					Login ventana = new Login();
					setVisible(false);
					ventana.setVisible(true);
				}

			}
		});
		btnGuardar.setBounds(56, 266, 151, 23);
		contentPane.add(btnGuardar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login ventana = new Login();
				setVisible(false);
				ventana.setVisible(true);
			}
		});
		btnCancelar.setBounds(217, 266, 164, 23);
		contentPane.add(btnCancelar);

		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(56, 227, 122, 14);
		contentPane.add(lblContrasea);

		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(207, 224, 174, 20);
		contentPane.add(txtContraseña);
		
		panelColor = new JPanel();
		panelColor.setBackground(new Color(255, 255, 255));
		panelColor.setBounds(337, 65, 43, 20);
		contentPane.add(panelColor);
	}

	public boolean validarAgencia() {
		String NombreAgencia = txtNombreAgencia.getText();
		String TipoAgencia = comboBoxTipoAgencia.getSelectedItem() + "";
		String NumeroEmpleados = comboBoxNumeroEmpleados.getSelectedItem() + "";
		String ColorMarca = txtColor.getText();
		String Logo = txtLogo.getText();
		String Contraseña = txtContraseña.getText();

		boolean valido = true;
		if ((NombreAgencia.length() >= 1 || NombreAgencia.length() >= 30) == false) {
			JOptionPane.showMessageDialog(null, "Nombre de agencia incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		}
		if (TipoAgencia.length() == 0) {
			JOptionPane.showMessageDialog(null, "Tipo de agencia incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		}
		if (NumeroEmpleados.length() == 0) {
			JOptionPane.showMessageDialog(null, "Número de empleados incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		}
		if (ColorMarca.length() != 7) {
			JOptionPane.showMessageDialog(null, "Color de marca incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		}
		if (Logo.length() == 0) {
			JOptionPane.showMessageDialog(null, "Logo incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		}
		if (Contraseña.length() == 0) {
			JOptionPane.showMessageDialog(null, "Contraseña incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		}
		if (valido == true) {
			Agencia agencia = new Agencia();
			agencia.setNombreAgencia(NombreAgencia);
			agencia.setColorMarca(ColorMarca);
			agencia.setContraseña(Contraseña);
			agencia.setLogo(Logo);
			agencia.setTipoAgencia(TipoAgencia);
			agencia.setNumeroEmpleados(NumeroEmpleados);
			controlador.insertarAgencia(agencia);
		}
		return valido;
	}
}
