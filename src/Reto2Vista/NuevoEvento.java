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
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Reto2Controlador.Controlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.util.Date;
import javax.swing.JRadioButton;
import com.toedter.calendar.JCalendar;

public class NuevoEvento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controlador controlador = new Controlador();
	private JTextField txtNombreEvento;
	private JTextField txtCiudad;
	private JTextField txtNombreHotel;
	private JTextField txtPrecio;
	private JTextField txtPrecioOtros;
	private JTextField txtDescripcionOtros;
	private JTextField txtCodigoVueloV;
	private JTextField txtCodigoVuelo;
	private JTextField txtPrecioVuelo;
	private JTextField txtDuracionVueloV;
	private JTextField txtDuracionVuelo;
	private JRadioButton rdbtnVuelo;
	private JRadioButton rdbtnAlojamiento;
	private JRadioButton rdbtnOtros;
	private JPanel panelAlojamiento;
	private JPanel panelOtros;
	private JPanel panelVueloVuelta;
	private JPanel panelVuelo;
	private JRadioButton rdbtnVueloIdaVuelta;
	private JRadioButton rdbtnVueloIda;
	private JPanel panelIzquierda;

	public NuevoEvento(Agencia agencia) {
		setResizable(false);
		setTitle("Crear evento | "+agencia.getNombreAgencia());
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelIzquierda = new JPanel();
		panelIzquierda.setBorder(null);
		panelIzquierda.setBackground(Color.decode(agencia.getColorMarca()));
		panelIzquierda.setBounds(0, 0, 304, 700);
		contentPane.add(panelIzquierda);
		panelIzquierda.setLayout(null);

		JPanel panelLogo = new JPanel();
		panelLogo.setOpaque(false);
		panelLogo.setBorder(null);
		panelLogo.setBackground(Color.decode(agencia.getColorMarca()));
		panelLogo.setBounds(15, 15, 256, 173);
		panelIzquierda.add(panelLogo);

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
		panelIzquierda.add(lblNombreAgencia);

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
		panelIzquierda.add(btnDesconectar);

		JButton btnGenerarOfertaViaje = new JButton("Guardar");
		btnGenerarOfertaViaje.setForeground(new Color(0, 0, 0));
		btnGenerarOfertaViaje.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnGenerarOfertaViaje.setBackground(new Color(255, 255, 255));
		btnGenerarOfertaViaje.setBounds(10, 491, 284, 38);
		panelIzquierda.add(btnGenerarOfertaViaje);

		JLabel lblTipoDelViaje = new JLabel("Elegir viaje");
		lblTipoDelViaje.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTipoDelViaje.setBounds(635, 11, 262, 32);
		contentPane.add(lblTipoDelViaje);

		txtNombreEvento = new JTextField();
		txtNombreEvento.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtNombreEvento.setColumns(10);
		txtNombreEvento.setBounds(355, 54, 250, 41);
		contentPane.add(txtNombreEvento);

		JLabel lblDescripcin = new JLabel("Nombre del evento");
		lblDescripcin.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDescripcin.setBounds(355, 11, 250, 32);
		contentPane.add(lblDescripcin);

		JLabel lblTipoEvento = new JLabel("Tipo de evento");
		lblTipoEvento.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTipoEvento.setBounds(355, 120, 250, 32);
		contentPane.add(lblTipoEvento);

		rdbtnVuelo = new JRadioButton("Vuelo");
		rdbtnVuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarTipoViaje("Vuelo");
			}
		});
		rdbtnVuelo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		rdbtnVuelo.setBounds(365, 159, 126, 41);
		contentPane.add(rdbtnVuelo);

		rdbtnAlojamiento = new JRadioButton("Alojamiento");
		rdbtnAlojamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarTipoViaje("Alojamiento");
			}
		});
		rdbtnAlojamiento.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		rdbtnAlojamiento.setBounds(516, 159, 162, 41);
		contentPane.add(rdbtnAlojamiento);

		rdbtnOtros = new JRadioButton("Otros");
		rdbtnOtros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarTipoViaje("Otros");

			}
		});
		rdbtnOtros.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		rdbtnOtros.setBounds(717, 159, 126, 47);
		contentPane.add(rdbtnOtros);

		JComboBox cbElegirViaje_2_1 = new JComboBox();
		cbElegirViaje_2_1.setModel(new DefaultComboBoxModel(
				new String[] { "", "Novios", "Senior", "Grupos", "Grandes viajes(destinos exoticos)",
						"Combinado(vuelo+hotel)", "Escapadas", "Familias con niños menores" }));
		cbElegirViaje_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		cbElegirViaje_2_1.setBounds(635, 54, 250, 41);

		contentPane.add(desplegarAlojamiento());
		contentPane.add(desplegarOtros());
		contentPane.add(desplegarVuelo());
		contentPane.add(desplegarVueloVuelta());
		panelAlojamiento.setVisible(false);
		panelOtros.setVisible(false);
		panelVuelo.setVisible(false);
		panelVueloVuelta.setVisible(false);
	}

	public JPanel desplegarAlojamiento() {
		panelAlojamiento = new JPanel();
		panelAlojamiento.setBounds(354, 195, 492, 293);
		// contentPane.add(panelAlojamiento);
		panelAlojamiento.setLayout(null);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, -10);

		JDateChooser chooserEntrada = new JDateChooser(c.getTime());
		chooserEntrada.setBounds(0, 53, 203, 32);
		panelAlojamiento.add(chooserEntrada);
		chooserEntrada.getCalendarButton().setFont(new Font("Segoe UI", Font.PLAIN, 20));

		JDateChooser chooserSalida = new JDateChooser((Date) null);
		chooserSalida.getCalendarButton().setFont(new Font("Segoe UI", Font.PLAIN, 20));
		chooserSalida.setBounds(286, 53, 203, 32);
		panelAlojamiento.add(chooserSalida);

		JLabel lblEntrada = new JLabel("Entrada");
		lblEntrada.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblEntrada.setBounds(0, 11, 203, 32);
		panelAlojamiento.add(lblEntrada);

		JLabel lblDescripcin_1_1 = new JLabel("Salida");
		lblDescripcin_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDescripcin_1_1.setBounds(286, 11, 203, 32);
		panelAlojamiento.add(lblDescripcin_1_1);

		txtCiudad = new JTextField();
		txtCiudad.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(0, 124, 479, 25);
		panelAlojamiento.add(txtCiudad);

		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblCiudad.setBounds(0, 96, 479, 25);
		panelAlojamiento.add(lblCiudad);

		JLabel lblNombreHotel = new JLabel("Nombre hotel");
		lblNombreHotel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNombreHotel.setBounds(0, 160, 479, 25);
		panelAlojamiento.add(lblNombreHotel);

		txtNombreHotel = new JTextField();
		txtNombreHotel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtNombreHotel.setColumns(10);
		txtNombreHotel.setBounds(0, 193, 479, 25);
		panelAlojamiento.add(txtNombreHotel);

		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtPrecio.setBounds(0, 265, 126, 20);
		panelAlojamiento.add(txtPrecio);
		txtPrecio.setColumns(10);

		JLabel lblNombreHotel_1 = new JLabel("Precio");
		lblNombreHotel_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNombreHotel_1.setBounds(0, 229, 170, 25);
		panelAlojamiento.add(lblNombreHotel_1);

		JComboBox cbTipoHabitacion = new JComboBox();
		cbTipoHabitacion.setModel(new DefaultComboBoxModel(
				new String[] { "", "Doble ", "Doble con uso individual", "Individual", "Triple" }));
		cbTipoHabitacion.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		cbTipoHabitacion.setBounds(314, 262, 170, 23);
		panelAlojamiento.add(cbTipoHabitacion);

		JLabel lblTipoDelViaje_1 = new JLabel("Tipo de habitacion");
		lblTipoDelViaje_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTipoDelViaje_1.setBounds(314, 232, 195, 25);
		panelAlojamiento.add(lblTipoDelViaje_1);

		JLabel lblDescripcin_1 = new JLabel("€");
		lblDescripcin_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDescripcin_1.setBounds(136, 253, 37, 32);
		panelAlojamiento.add(lblDescripcin_1);
		return panelAlojamiento;

	}

	public JPanel desplegarOtros() {
		panelOtros = new JPanel();
		panelOtros.setBounds(354, 195, 555, 322);
		// contentPane.add(panelOtros);
		panelOtros.setLayout(null);

		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, -10);

		JDateChooser chooserFechaOtros = new JDateChooser(c.getTime());
		chooserFechaOtros.setBounds(0, 58, 203, 32);
		panelOtros.add(chooserFechaOtros);
		chooserFechaOtros.getCalendarButton().setFont(new Font("Segoe UI", Font.PLAIN, 20));

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblFecha.setBounds(0, 15, 203, 32);
		panelOtros.add(lblFecha);

		txtPrecioOtros = new JTextField();
		txtPrecioOtros.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtPrecioOtros.setBounds(292, 58, 132, 32);
		panelOtros.add(txtPrecioOtros);
		txtPrecioOtros.setColumns(10);

		JLabel lblFecha_1 = new JLabel("Precio");
		lblFecha_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblFecha_1.setBounds(292, 15, 166, 32);
		panelOtros.add(lblFecha_1);

		JLabel lblFecha_1_1 = new JLabel("€");
		lblFecha_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblFecha_1_1.setBounds(434, 58, 34, 32);
		panelOtros.add(lblFecha_1_1);

		txtDescripcionOtros = new JTextField();
		txtDescripcionOtros.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtDescripcionOtros.setColumns(10);
		txtDescripcionOtros.setBounds(0, 156, 501, 108);
		panelOtros.add(txtDescripcionOtros);

		JLabel lblDescripcin_2 = new JLabel("Descripción");
		lblDescripcin_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDescripcin_2.setBounds(0, 112, 501, 32);
		panelOtros.add(lblDescripcin_2);
		return panelOtros;
	}

	public JPanel desplegarVuelo() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, -10);
		panelVuelo = new JPanel();
		panelVuelo.setBounds(354, 195, 564, 447);
		// contentPane.add(panelVuelo);
		panelVuelo.setLayout(null);

		JLabel lblqueTipoDe = new JLabel("¿Que tipo de vuelo es?");
		lblqueTipoDe.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblqueTipoDe.setBounds(10, 11, 250, 32);
		panelVuelo.add(lblqueTipoDe);

		rdbtnVueloIda = new JRadioButton("Ida");
		rdbtnVueloIda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarTipoVuelo("Ida");

			}
		});
		rdbtnVueloIda.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		rdbtnVueloIda.setBounds(10, 60, 109, 23);
		panelVuelo.add(rdbtnVueloIda);

		rdbtnVueloIdaVuelta = new JRadioButton("Ida y vuelta");
		rdbtnVueloIdaVuelta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarTipoVuelo("Ida y vuelta");
			}
		});
		rdbtnVueloIdaVuelta.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		rdbtnVueloIdaVuelta.setBounds(121, 60, 170, 23);
		panelVuelo.add(rdbtnVueloIdaVuelta);

		JLabel lblVueloDeIda = new JLabel("Vuelo de ida");
		lblVueloDeIda.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda.setBounds(10, 90, 250, 32);
		panelVuelo.add(lblVueloDeIda);

		JLabel lblVueloDeIda_1 = new JLabel("Aeropuerto origen");
		lblVueloDeIda_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda_1.setBounds(10, 133, 250, 32);
		panelVuelo.add(lblVueloDeIda_1);

		JLabel lblVueloDeIda_2 = new JLabel("Aeropuerto destino");
		lblVueloDeIda_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda_2.setBounds(270, 133, 250, 32);
		panelVuelo.add(lblVueloDeIda_2);

		JLabel lblVueloDeIda_2_1 = new JLabel("Aerolinea");
		lblVueloDeIda_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda_2_1.setBounds(270, 216, 250, 32);
		panelVuelo.add(lblVueloDeIda_2_1);

		JComboBox cbA_Origen = new JComboBox();
		cbA_Origen.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		cbA_Origen.setBounds(0, 164, 250, 41);
		panelVuelo.add(cbA_Origen);

		JComboBox cbA_Destino = new JComboBox();
		cbA_Destino.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		cbA_Destino.setBounds(270, 164, 250, 41);
		panelVuelo.add(cbA_Destino);

		JComboBox cbAerolinea = new JComboBox();
		cbAerolinea.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		cbAerolinea.setBounds(270, 248, 250, 41);
		panelVuelo.add(cbAerolinea);

		txtCodigoVuelo = new JTextField();
		txtCodigoVuelo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtCodigoVuelo.setColumns(10);
		txtCodigoVuelo.setBounds(0, 248, 250, 41);
		panelVuelo.add(txtCodigoVuelo);

		JLabel lblVueloDeIda_2_1_1 = new JLabel("Codigo vuelo");
		lblVueloDeIda_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda_2_1_1.setBounds(0, 216, 250, 32);
		panelVuelo.add(lblVueloDeIda_2_1_1);

		JDateChooser chooserVueloFechaSalida = new JDateChooser(c.getTime());
		chooserVueloFechaSalida.setBounds(0, 325, 250, 32);
		panelVuelo.add(chooserVueloFechaSalida);
		chooserVueloFechaSalida.getCalendarButton().setFont(new Font("Segoe UI", Font.PLAIN, 20));

		JLabel lblVueloDeIda_2_1_1_1 = new JLabel("Fecha de salida");
		lblVueloDeIda_2_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda_2_1_1_1.setBounds(0, 293, 250, 32);
		panelVuelo.add(lblVueloDeIda_2_1_1_1);

		JLabel lblVueloDeIda_2_1_1_1_1 = new JLabel("Hora de salida");
		lblVueloDeIda_2_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda_2_1_1_1_1.setBounds(270, 293, 250, 32);
		panelVuelo.add(lblVueloDeIda_2_1_1_1_1);

		txtPrecioVuelo = new JTextField();
		txtPrecioVuelo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtPrecioVuelo.setColumns(10);
		txtPrecioVuelo.setBounds(297, 54, 195, 41);
		panelVuelo.add(txtPrecioVuelo);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblPrecio.setBounds(297, 11, 250, 32);
		panelVuelo.add(lblPrecio);

		txtDuracionVuelo = new JTextField();
		txtDuracionVuelo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtDuracionVuelo.setColumns(10);
		txtDuracionVuelo.setBounds(0, 406, 250, 41);
		panelVuelo.add(txtDuracionVuelo);

		JLabel lblDescripcin_1_1 = new JLabel("Duración del vuelo (Horas)");
		lblDescripcin_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDescripcin_1_1.setBounds(0, 363, 520, 32);
		panelVuelo.add(lblDescripcin_1_1);

		JLabel lblPrecio_1 = new JLabel("€");
		lblPrecio_1.setBounds(502, 58, 42, 32);
		panelVuelo.add(lblPrecio_1);
		lblPrecio_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		Calendar now = Calendar.getInstance();
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		SpinnerDateModel model = new SpinnerDateModel();
		model.setValue(now.getTime());
		JSpinner spinnerHoraSalida = new JSpinner(model);
		spinnerHoraSalida.setLocation(270, 325);
		spinnerHoraSalida.setSize(250, 41);
		JSpinner.DateEditor de_spinnerHoraSalida = new JSpinner.DateEditor(spinnerHoraSalida, "HH:mm");
		spinnerHoraSalida.setEditor(de_spinnerHoraSalida);
		spinnerHoraSalida.setPreferredSize(new Dimension(80, 30));
		panelVuelo.add(spinnerHoraSalida);

		return panelVuelo;
	}

	public JPanel desplegarVueloVuelta() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, -10);
		panelVueloVuelta = new JPanel();
		panelVueloVuelta.setBounds(939, 195, 564, 447);
		panelVueloVuelta.setLayout(null);

		JLabel lblVueloDeIda = new JLabel("Vuelo de vuelta");
		lblVueloDeIda.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda.setBounds(10, 90, 250, 32);
		panelVueloVuelta.add(lblVueloDeIda);

		JLabel lblVueloDeIda_2_1 = new JLabel("Aerolinea");
		lblVueloDeIda_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda_2_1.setBounds(270, 147, 250, 32);
		panelVueloVuelta.add(lblVueloDeIda_2_1);

		JComboBox cbAerolineaV = new JComboBox();
		cbAerolineaV.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		cbAerolineaV.setBounds(270, 179, 250, 41);
		panelVueloVuelta.add(cbAerolineaV);

		txtCodigoVueloV = new JTextField();
		txtCodigoVueloV.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtCodigoVueloV.setColumns(10);
		txtCodigoVueloV.setBounds(0, 179, 250, 41);
		panelVueloVuelta.add(txtCodigoVueloV);

		JLabel lblVueloDeIda_2_1_1 = new JLabel("Codigo vuelo");
		lblVueloDeIda_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda_2_1_1.setBounds(0, 147, 250, 32);
		panelVueloVuelta.add(lblVueloDeIda_2_1_1);

		JDateChooser chooserVueloFechaSalidaV = new JDateChooser(c.getTime());
		chooserVueloFechaSalidaV.setBounds(0, 256, 250, 32);
		panelVueloVuelta.add(chooserVueloFechaSalidaV);
		chooserVueloFechaSalidaV.getCalendarButton().setFont(new Font("Segoe UI", Font.PLAIN, 20));

		JLabel lblVueloDeIda_2_1_1_1 = new JLabel("Fecha de salida");
		lblVueloDeIda_2_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda_2_1_1_1.setBounds(0, 224, 250, 32);
		panelVueloVuelta.add(lblVueloDeIda_2_1_1_1);

		JDateChooser chooserFechaOtros_1 = new JDateChooser((Date) null);
		chooserFechaOtros_1.getCalendarButton().setFont(new Font("Segoe UI", Font.PLAIN, 20));
		chooserFechaOtros_1.setBounds(270, 256, 250, 32);
		panelVueloVuelta.add(chooserFechaOtros_1);

		JLabel lblVueloDeIda_2_1_1_1_1 = new JLabel("Vuelo de ida");
		lblVueloDeIda_2_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda_2_1_1_1_1.setBounds(270, 224, 250, 32);
		panelVueloVuelta.add(lblVueloDeIda_2_1_1_1_1);

		txtDuracionVueloV = new JTextField();
		txtDuracionVueloV.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtDuracionVueloV.setColumns(10);
		txtDuracionVueloV.setBounds(0, 338, 250, 41);
		panelVueloVuelta.add(txtDuracionVueloV);

		JLabel lblDescripcin_1_1 = new JLabel("Duración del vuelo (Horas)");
		lblDescripcin_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDescripcin_1_1.setBounds(0, 294, 244, 32);
		panelVueloVuelta.add(lblDescripcin_1_1);

		Calendar now = Calendar.getInstance();
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		SpinnerDateModel model = new SpinnerDateModel();
		model.setValue(now.getTime());
		JSpinner spinnerHoraSalidaV = new JSpinner(model);
		spinnerHoraSalidaV.setLocation(270, 338);
		spinnerHoraSalidaV.setSize(250, 41);
		JSpinner.DateEditor de_spinnerHoraSalidaV = new JSpinner.DateEditor(spinnerHoraSalidaV, "HH:mm");
		spinnerHoraSalidaV.setEditor(de_spinnerHoraSalidaV);
		spinnerHoraSalidaV.setPreferredSize(new Dimension(80, 30));
		panelVueloVuelta.add(spinnerHoraSalidaV);

		JLabel lblVueloDeIda_2_1_1_1_1_1 = new JLabel("Hora de salida");
		lblVueloDeIda_2_1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda_2_1_1_1_1_1.setBounds(270, 294, 250, 32);
		panelVueloVuelta.add(lblVueloDeIda_2_1_1_1_1_1);

		return panelVueloVuelta;
	}

	public void cambiarTipoViaje(String TipoViaje) {

		rdbtnVuelo.setSelected(TipoViaje == "Vuelo");
		rdbtnAlojamiento.setSelected(TipoViaje == "Alojamiento");
		rdbtnOtros.setSelected(TipoViaje == "Otros");

		if (TipoViaje == "Vuelo") {
			panelAlojamiento.setVisible(false);
			panelOtros.setVisible(false);
			panelVuelo.setVisible(true);
			if (rdbtnVueloIdaVuelta.isSelected() == true) {
				panelVueloVuelta.setVisible(true);
				setBounds(0, 0, 1526, 692);
			} else {
				setBounds(0, 0, 1000, 692);
			}
		}
		if (TipoViaje == "Alojamiento") {
			panelVuelo.setVisible(false);
			panelOtros.setVisible(false);
			panelVueloVuelta.setVisible(false);
			panelAlojamiento.setVisible(true);
			setBounds(0, 0, 1000, 650);
		}
		if (TipoViaje == "Otros") {
			panelVuelo.setVisible(false);
			panelVueloVuelta.setVisible(false);
			panelAlojamiento.setVisible(false);
			panelOtros.setVisible(true);
			setBounds(0, 0, 1000, 650);
		}
	}

	public void cambiarTipoVuelo(String TipoVuelo) {

		rdbtnVueloIda.setSelected(TipoVuelo == "Ida");
		rdbtnVueloIdaVuelta.setSelected(TipoVuelo == "Ida y vuelta");
		panelVueloVuelta.setVisible(TipoVuelo == "Ida y vuelta");
		if (TipoVuelo == "Ida y vuelta") {
			setBounds(0, 0, 1526, 692);

		} else {
			setBounds(0, 0, 1000, 692);

		}
	}
}
