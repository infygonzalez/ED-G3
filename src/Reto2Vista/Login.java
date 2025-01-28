package Reto2Vista;

import java.awt.EventQueue;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Reto2Controlador.Controlador;
import Reto2Modelo.Agencia;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreAgencia;
	private JTextField txtContraseña;
	private Controlador controlador = new Controlador();

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		JPanel pnl_login = new JPanel();
		pnl_login.setBounds(0, 150, 800, 200);
		contentPane.add(pnl_login);
		pnl_login.setLayout(null);

		txtNombreAgencia = new JTextField();
		txtNombreAgencia.setBounds(404, 55, 148, 20);
		pnl_login.add(txtNombreAgencia);
		txtNombreAgencia.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nombre agencia");
		lblNewLabel_1.setBounds(281, 58, 95, 14);
		pnl_login.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Contraseña");
		lblNewLabel_1_1.setBounds(281, 96, 95, 14);
		pnl_login.add(lblNewLabel_1_1);

		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(404, 93, 148, 20);
		pnl_login.add(txtContraseña);

		JButton btnInciarSesion = new JButton("Iniciar Sesion");
		btnInciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtNombreAgencia.getText().equals("") && txtContraseña.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Nombre de agencia y contraseña incorrectos.", "Error",
							JOptionPane.ERROR_MESSAGE);

				} else if (txtNombreAgencia.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Nombre de agencia incorrecto.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (txtContraseña.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					Agencia login = controlador.login(txtNombreAgencia.getText(), txtContraseña.getText());
					if (login == null) {
						JOptionPane.showMessageDialog(null, "Nombre de agencia y contraseña incorrectos.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "cfcorrectos.", "Error",
								JOptionPane.ERROR_MESSAGE);	
					}
				}
			}
		});
		btnInciarSesion.setBounds(267, 151, 129, 23);
		pnl_login.add(btnInciarSesion);

		JButton btnNuevaAgencia = new JButton("Nueva agencia");
		btnNuevaAgencia.setBounds(423, 151, 129, 23);
		pnl_login.add(btnNuevaAgencia);
		ImageIcon image = new ImageIcon(getClass().getResource("/Reto2Img/fondo1.jpg"));

		JPanel fondo = new JPanel();
		fondo.setBounds(0, 0, 800, 500);
		fondo.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(fondo);
		fondo.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel(
				new ImageIcon(image.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT)));
		fondo.add(lblNewLabel);

	}
}
