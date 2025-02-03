package Reto2Vista;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Reto2Modelo.Aerolinea;
import Reto2Modelo.Aeropuerto;
import Reto2Modelo.Agencia;
import Reto2Modelo.Pais;
import Reto2Modelo.Viaje;
import Reto2Modelo.Vuelo;
import Reto2Modelo.Alojamiento;
import Reto2Modelo.Otros;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Reto2Controlador.Controlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.util.Date;

public class NuevoViaje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controlador controlador = new Controlador();
	private JTextField txtNombreViaje;
	private JTextField txtDescripcion;
	private JTextField txtServiciosNoIncluidos;

	public NuevoViaje(Agencia agencia) {
		setTitle("Crear viaje | "+agencia.getNombreAgencia());
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.decode(agencia.getColorMarca()));
		panel.setBounds(0, 0, 304, 611);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panelLogo = new JPanel();
		panelLogo.setOpaque(false);
		panelLogo.setBorder(null);
		panelLogo.setBackground(Color.decode(agencia.getColorMarca()));
		panelLogo.setBounds(15, 15, 256, 173);
		panel.add(panelLogo);

		panelLogo.setLayout(new BorderLayout(0, 0));

		URL imgUrl = null;
		try {
			imgUrl = new URL(agencia.getLogo());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon image = new ImageIcon(imgUrl);
		JLabel lblLogo = new JLabel(new ImageIcon(image.getImage().getScaledInstance(256, 173, Image.SCALE_SMOOTH)));
		panelLogo.add(lblLogo);

		JLabel lblNombreAgencia = new JLabel("Crear viaje");
		lblNombreAgencia.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNombreAgencia.setForeground(new Color(255, 255, 255));
		lblNombreAgencia.setBounds(15, 196, 256, 58);
		panel.add(lblNombreAgencia);

		JButton btnDesconectar = new JButton("Cancelar");
		btnDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Inicio ventana = new Inicio(agencia);
				ventana.setVisible(true);
			}
		});
		btnDesconectar.setForeground(new Color(0, 0, 0));
		btnDesconectar.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnDesconectar.setBackground(new Color(255, 255, 255));
		btnDesconectar.setBounds(10, 540, 284, 38);
		panel.add(btnDesconectar);

		JButton btnGenerarOfertaViaje = new JButton("Guardar");
		btnGenerarOfertaViaje.setForeground(new Color(0, 0, 0));
		btnGenerarOfertaViaje.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnGenerarOfertaViaje.setBackground(new Color(255, 255, 255));
		btnGenerarOfertaViaje.setBounds(10, 491, 284, 38);
		panel.add(btnGenerarOfertaViaje);
		
		JLabel lblNombreDelViaje = new JLabel("Nombre del viaje");
		lblNombreDelViaje.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNombreDelViaje.setBounds(334, 33, 273, 32);
		contentPane.add(lblNombreDelViaje);
		
		txtNombreViaje = new JTextField();
		txtNombreViaje.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtNombreViaje.setColumns(10);
		txtNombreViaje.setBounds(334, 76, 273, 35);
		contentPane.add(txtNombreViaje);
		
		JLabel lblTipoDelViaje = new JLabel("Tipo del viaje");
		lblTipoDelViaje.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTipoDelViaje.setBounds(641, 33, 307, 32);
		contentPane.add(lblTipoDelViaje);
		
		JComboBox cbTipoViaje = new JComboBox();
		cbTipoViaje.setModel(new DefaultComboBoxModel(new String[] {"", "Novios", "Senior", "Grupos", "Grandes viajes(destinos exoticos)", "Combinado(vuelo+hotel)", "Escapadas", "Familias con niños menores"}));
		cbTipoViaje.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		cbTipoViaje.setBounds(641, 76, 273, 33);
		contentPane.add(cbTipoViaje);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, -10);

		JDateChooser chooserFechaIncio = new JDateChooser(c.getTime());
		chooserFechaIncio.getCalendarButton().setFont(new Font("Segoe UI", Font.PLAIN, 20));
		chooserFechaIncio.setSize(273, 35);
		chooserFechaIncio.setLocation(334, 178);
		contentPane.add(chooserFechaIncio);
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio");
		lblFechaInicio.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblFechaInicio.setBounds(334, 135, 273, 32);
		contentPane.add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha fin");
		lblFechaFin.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblFechaFin.setBounds(641, 135, 273, 32);
		contentPane.add(lblFechaFin);
		
		JDateChooser chooserFechaFin = new JDateChooser(c.getTime());
		chooserFechaFin.getCalendarButton().setFont(new Font("Segoe UI", Font.PLAIN, 20));
		chooserFechaFin.setBounds(641, 178, 273, 35);
		contentPane.add(chooserFechaFin);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(334, 276, 580, 118);
		contentPane.add(txtDescripcion);
		
		JLabel lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDescripcin.setBounds(334, 233, 580, 32);
		contentPane.add(lblDescripcin);
		
		JLabel lblServiciosNoIncluidos = new JLabel("Servicios no incluidos");
		lblServiciosNoIncluidos.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblServiciosNoIncluidos.setBounds(334, 414, 580, 32);
		contentPane.add(lblServiciosNoIncluidos);
		
		txtServiciosNoIncluidos = new JTextField();
		txtServiciosNoIncluidos.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtServiciosNoIncluidos.setColumns(10);
		txtServiciosNoIncluidos.setBounds(334, 457, 580, 118);
		contentPane.add(txtServiciosNoIncluidos);
	}
}
