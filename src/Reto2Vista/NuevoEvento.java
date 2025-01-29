package Reto2Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevoEvento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoEvento frame = new NuevoEvento();
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
	public NuevoEvento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(nuevoevento());
		
		
	}
	
	public JPanel nuevoevento () {
		JPanel Evento = new JPanel();
		Evento.setBounds(0, 0, 908, 574);
		contentPane.add(Evento);
		Evento.setLayout(null);
		
		JLabel lblNombreEvento = new JLabel("Nombre Evento");
		lblNombreEvento.setBounds(70, 45, 141, 14);
		Evento.add(lblNombreEvento);
		
		JLabel lblTipoEvento = new JLabel("Tipo de Evento");
		lblTipoEvento.setBounds(70, 82, 141, 14);
		Evento.add(lblTipoEvento);
		
		JComboBox cbNombreEvento = new JComboBox();
		cbNombreEvento.setBounds(238, 78, 187, 22);
		Evento.add(cbNombreEvento);
		
		textField = new JTextField();
		textField.setBounds(238, 42, 187, 20);
		Evento.add(textField);
		textField.setColumns(10);
		return Evento;
	}
}
