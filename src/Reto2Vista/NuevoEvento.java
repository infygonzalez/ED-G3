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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;

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
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
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
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;

public class NuevoEvento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controlador controlador = new Controlador();
	private JTextField txtNombreEvento;
	private JTextField txtCiudad;
	private JTextField txtNombreHotel;
	private JSpinner spinnerPrecioAlojamiento;
	private JSpinner spinnerPrecioVuelo;
	private JSpinner spinnerPrecioOtros;
	private JComboBox<String> cbA_Origen;
	private JComboBox<String> cbA_Destino;
	private JComboBox<String> cbAerolinea;
	private JDateChooser chooserVueloFechaSalida;
	private JSpinner spinnerHoraSalida;
	private JDateChooser chooserEntrada;
	private JDateChooser chooserSalida;
	private JTextField txtCodigoVueloVuelta;
	private JComboBox<String> cbAerolineaVuelta;
	private JDateChooser chooserFechaOtros;
	private JComboBox<String> cbTipoHabitacion;
	private JTextArea txtDescripcionOtros;
	private JTextField txtCodigoVuelo;
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
	private DefaultComboBoxModel<String> modeloAeropuertosOrigen;
	private DefaultComboBoxModel<String> modeloAeropuertosDestino;
	private DefaultComboBoxModel<String> modeloAerolineasIda;
	private DefaultComboBoxModel<String> modeloAerolineasVuelta;
	private JDateChooser chooserVueloFechaSalidaVuelta;
	private JSpinner spinnerHoraSalidaVuelta;
	private JButton btnGuardar;
	private JButton btnDesconectar;
	private String TipoHabitacion = "";
	private JTextField txtDuracionVueloVuelta;

	public NuevoEvento(Viaje viaje, Agencia agencia, ArrayList<Aeropuerto> aeropuertos,
			ArrayList<Aerolinea> aerolineas) {
		setResizable(false);
		setTitle("Crear evento | " + agencia.getNombreAgencia());
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 650);
		setLocationRelativeTo(null);
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

		JLabel lblNombreAgencia = new JLabel(agencia.getNombreAgencia());
		lblNombreAgencia.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNombreAgencia.setForeground(new Color(255, 255, 255));
		lblNombreAgencia.setBounds(15, 196, 256, 38);
		panelIzquierda.add(lblNombreAgencia);

		btnDesconectar = new JButton("Cancelar");
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

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarEvento(viaje, agencia, aeropuertos, aerolineas);
			}
		});
		btnGuardar.setForeground(new Color(0, 0, 0));
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnGuardar.setBackground(new Color(255, 255, 255));
		btnGuardar.setBounds(10, 491, 284, 38);

		panelIzquierda.add(btnGuardar);

		JLabel lblCrearEvento = new JLabel("Crear evento");
		lblCrearEvento.setForeground(Color.WHITE);
		lblCrearEvento.setFont(new Font("Segoe UI", Font.BOLD, 40));
		lblCrearEvento.setBounds(15, 244, 256, 54);
		panelIzquierda.add(lblCrearEvento);

		txtNombreEvento = new JTextField();
		txtNombreEvento.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtNombreEvento.setColumns(10);
		txtNombreEvento.setBounds(355, 54, 488, 41);
		contentPane.add(txtNombreEvento);

		JLabel lblDescripcin = new JLabel("Nombre del evento");
		lblDescripcin.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDescripcin.setBounds(355, 12, 250, 32);
		contentPane.add(lblDescripcin);

		JLabel lblTipoEvento = new JLabel("Tipo de evento");
		lblTipoEvento.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTipoEvento.setBounds(355, 108, 250, 32);
		contentPane.add(lblTipoEvento);

		rdbtnVuelo = new JRadioButton("Vuelo");
		rdbtnVuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnAlojamiento.setSelected(false);
				rdbtnOtros.setSelected(false);
				tipoEvento();
			}
		});
		rdbtnVuelo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		rdbtnVuelo.setBounds(355, 146, 126, 41);
		contentPane.add(rdbtnVuelo);

		rdbtnAlojamiento = new JRadioButton("Alojamiento");
		rdbtnAlojamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnVuelo.setSelected(false);
				rdbtnOtros.setSelected(false);
				tipoEvento();
			}
		});
		rdbtnAlojamiento.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		rdbtnAlojamiento.setBounds(516, 146, 162, 41);
		contentPane.add(rdbtnAlojamiento);

		rdbtnOtros = new JRadioButton("Otros");
		rdbtnOtros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnAlojamiento.setSelected(false);
				rdbtnVuelo.setSelected(false);
				tipoEvento();
			}
		});
		rdbtnOtros.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		rdbtnOtros.setBounds(717, 146, 126, 47);
		contentPane.add(rdbtnOtros);

		modeloAeropuertosOrigen = new DefaultComboBoxModel<String>();
		modeloAeropuertosDestino = new DefaultComboBoxModel<String>();
		modeloAerolineasIda = new DefaultComboBoxModel<String>();
		modeloAerolineasVuelta = new DefaultComboBoxModel<String>();
		contentPane.add(desplegarAlojamiento());
		contentPane.add(desplegarOtros());
		contentPane.add(desplegarVuelo(aeropuertos, aerolineas));

		contentPane.add(desplegarVueloVuelta());
		panelAlojamiento.setVisible(false);
		panelOtros.setVisible(false);
		panelVuelo.setVisible(false);
		panelVueloVuelta.setVisible(false);
	}

	public JPanel desplegarAlojamiento() {
		panelAlojamiento = new JPanel();
		panelAlojamiento.setBounds(354, 195, 492, 333);
		// contentPane.add(panelAlojamiento);
		panelAlojamiento.setLayout(null);
		Calendar c = Calendar.getInstance();
		chooserEntrada = new JDateChooser(c.getTime());
		chooserEntrada.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		chooserEntrada.setBounds(0, 42, 220, 41);
		panelAlojamiento.add(chooserEntrada);

		JButton btnBuscarAlojamiento = new JButton("Buscar alojamiento en Booking");
		btnBuscarAlojamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				    try {
						Desktop.getDesktop().browse(new URI("https://www.booking.com/"));
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnBuscarAlojamiento.setBackground(new Color(255, 255, 255));
		btnBuscarAlojamiento.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnBuscarAlojamiento.setBounds(0, 200, 489, 41);
		panelAlojamiento.add(btnBuscarAlojamiento);

		chooserSalida = new JDateChooser(c.getTime());
		chooserSalida.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		chooserSalida.setBounds(269, 42, 220, 41);
		panelAlojamiento.add(chooserSalida);

		JLabel lblEntrada = new JLabel("Entrada");
		lblEntrada.setHorizontalAlignment(SwingConstants.LEFT);
		lblEntrada.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblEntrada.setBounds(0, 0, 203, 41);
		panelAlojamiento.add(lblEntrada);

		JLabel lblDescripcin_1_1 = new JLabel("Salida");
		lblDescripcin_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDescripcin_1_1.setBounds(269, 0, 203, 41);
		panelAlojamiento.add(lblDescripcin_1_1);

		txtCiudad = new JTextField();
		txtCiudad.setToolTipText("ej. Paris");
		txtCiudad.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(0, 145, 220, 41);
		panelAlojamiento.add(txtCiudad);

		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblCiudad.setBounds(0, 106, 203, 41);
		panelAlojamiento.add(lblCiudad);

		JLabel lblNombreHotel = new JLabel("Nombre del hotel");
		lblNombreHotel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNombreHotel.setBounds(0, 251, 249, 41);
		panelAlojamiento.add(lblNombreHotel);

		txtNombreHotel = new JTextField();
		txtNombreHotel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtNombreHotel.setColumns(10);
		txtNombreHotel.setBounds(0, 292, 220, 41);
		panelAlojamiento.add(txtNombreHotel);

		spinnerPrecioAlojamiento = new JSpinner();
		spinnerPrecioAlojamiento
				.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerPrecioAlojamiento.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		spinnerPrecioAlojamiento.setBounds(269, 145, 195, 41);
		panelAlojamiento.add(spinnerPrecioAlojamiento);
		;

		JLabel lblNombreHotel_1 = new JLabel("Precio");
		lblNombreHotel_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNombreHotel_1.setBounds(269, 106, 170, 41);
		panelAlojamiento.add(lblNombreHotel_1);

		cbTipoHabitacion = new JComboBox<String>();
		cbTipoHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Tipo = cbTipoHabitacion.getSelectedItem() + "";
				System.out.println("aaa" + Tipo);
				if (Tipo.equals("Doble")) {
					TipoHabitacion = "DB";
				} else if (Tipo.equals("Doble con uso individual")) {
					TipoHabitacion = "DUI";
				} else if (Tipo.equals("Individual")) {
					TipoHabitacion = "SIN";
				} else if (Tipo.equals("Triple")) {
					TipoHabitacion = "TPL";
				}
			}
		});
		cbTipoHabitacion.setBackground(new Color(255, 255, 255));
		cbTipoHabitacion.setModel(new DefaultComboBoxModel<String>(
				new String[] { "", "Doble", "Doble con uso individual", "Individual", "Triple" }));
		cbTipoHabitacion.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		cbTipoHabitacion.setBounds(270, 292, 219, 41);
		panelAlojamiento.add(cbTipoHabitacion);

		JLabel lblTipoDelViaje_1 = new JLabel("Tipo de habitacion");
		lblTipoDelViaje_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTipoDelViaje_1.setBounds(269, 251, 195, 41);
		panelAlojamiento.add(lblTipoDelViaje_1);

		JLabel lblDescripcin_1 = new JLabel("€");
		lblDescripcin_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDescripcin_1.setBounds(473, 149, 16, 32);
		panelAlojamiento.add(lblDescripcin_1);
		return panelAlojamiento;

	}

	public JPanel desplegarOtros() {
		panelOtros = new JPanel();
		panelOtros.setBounds(354, 195, 488, 383);
		// contentPane.add(panelOtros);
		panelOtros.setLayout(null);

		Calendar c = Calendar.getInstance();

		chooserFechaOtros = new JDateChooser(c.getTime());
		chooserFechaOtros.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		chooserFechaOtros.setBounds(0, 41, 220, 41);
		panelOtros.add(chooserFechaOtros);
		chooserFechaOtros.getCalendarButton().setFont(new Font("Segoe UI", Font.PLAIN, 20));

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblFecha.setBounds(0, 0, 203, 41);
		panelOtros.add(lblFecha);
		spinnerPrecioOtros = new JSpinner();
		spinnerPrecioOtros
				.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerPrecioOtros.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		spinnerPrecioOtros.setBounds(269, 41, 186, 41);
		panelOtros.add(spinnerPrecioOtros);

		JLabel lblFecha_1 = new JLabel("Precio");
		lblFecha_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblFecha_1.setBounds(269, 0, 166, 41);
		panelOtros.add(lblFecha_1);

		JLabel lblFecha_1_1 = new JLabel("€");
		lblFecha_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblFecha_1_1.setBounds(465, 41, 34, 32);
		panelOtros.add(lblFecha_1_1);

		txtDescripcionOtros = new JTextArea();
		txtDescripcionOtros.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtDescripcionOtros.setColumns(10);
		txtDescripcionOtros.setBounds(0, 156, 488, 227);
		panelOtros.add(txtDescripcionOtros);

		JLabel lblDescripcin_2 = new JLabel("Descripción");
		lblDescripcin_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDescripcin_2.setBounds(0, 105, 478, 41);
		panelOtros.add(lblDescripcin_2);
		return panelOtros;
	}

	public JPanel desplegarVuelo(ArrayList<Aeropuerto> aeropuertos, ArrayList<Aerolinea> aerolineas) {
		Calendar c = Calendar.getInstance();
		panelVuelo = new JPanel();
		panelVuelo.setBounds(354, 195, 493, 473);
		// contentPane.add(panelVuelo);
		panelVuelo.setLayout(null);
		spinnerPrecioVuelo = new JSpinner();
		spinnerPrecioVuelo
				.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerPrecioVuelo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		spinnerPrecioVuelo.setBounds(270, 41, 195, 41);
		panelVuelo.add(spinnerPrecioVuelo);
		JLabel lblqueTipoDe = new JLabel("¿Que tipo de vuelo es?");
		lblqueTipoDe.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblqueTipoDe.setBounds(0, 0, 250, 41);
		panelVuelo.add(lblqueTipoDe);
		JButton btnBuscarViaje = new JButton("Buscar viaje en SkyScanner");
		btnBuscarViaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				    try {
						Desktop.getDesktop().browse(new URI("https://www.skyscanner.es/"));
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnBuscarViaje.setBackground(new Color(255, 255, 255));
		btnBuscarViaje.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnBuscarViaje.setBounds(0, 182, 488, 41);
		panelVuelo.add(btnBuscarViaje);

		rdbtnVueloIda = new JRadioButton("Ida");
		rdbtnVueloIda.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		rdbtnVueloIda.setBounds(10, 41, 66, 23);
		rdbtnVueloIda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarTipoVuelo("Ida");

			}
		});
		panelVuelo.add(rdbtnVueloIda);

		rdbtnVueloIdaVuelta = new JRadioButton("Ida y vuelta");
		rdbtnVueloIdaVuelta.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		rdbtnVueloIdaVuelta.setBounds(83, 41, 140, 23);
		rdbtnVueloIdaVuelta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarTipoVuelo("Ida y vuelta");
			}
		});
		panelVuelo.add(rdbtnVueloIdaVuelta);

		JLabel lblVueloDeIda = new JLabel("VUELO DE IDA");
		lblVueloDeIda.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblVueloDeIda.setBounds(0, 251, 250, 32);
		panelVuelo.add(lblVueloDeIda);

		JLabel lblVueloDeIda_1 = new JLabel("Aeropuerto origen");
		lblVueloDeIda_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda_1.setBounds(0, 87, 250, 41);
		panelVuelo.add(lblVueloDeIda_1);

		JLabel lblVueloDeIda_2 = new JLabel("Aeropuerto destino");
		lblVueloDeIda_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda_2.setBounds(270, 87, 250, 41);
		panelVuelo.add(lblVueloDeIda_2);

		JLabel lblVueloDeIda_2_1 = new JLabel("Aerolínea");
		lblVueloDeIda_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda_2_1.setBounds(270, 222, 218, 41);
		panelVuelo.add(lblVueloDeIda_2_1);

		cbA_Origen = new JComboBox<String>(modeloAeropuertosOrigen);
		cbA_Origen.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		cbA_Origen.setBackground(Color.white);
		cbA_Origen.setBounds(0, 131, 203, 41);
		panelVuelo.add(cbA_Origen);

		cbA_Destino = new JComboBox<String>(modeloAeropuertosDestino);
		cbA_Destino.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		cbA_Destino.setBounds(270, 131, 218, 41);
		cbA_Destino.setBackground(Color.white);
		panelVuelo.add(cbA_Destino);

		cbAerolinea = new JComboBox<String>(modeloAerolineasIda);
		cbAerolinea.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		cbAerolinea.setBounds(270, 263, 218, 41);
		cbAerolinea.setBackground(Color.white);
		panelVuelo.add(cbAerolinea);

		rellenaraeropuertos(aeropuertos);
		rellenaraerolineas(aerolineas);

		txtCodigoVuelo = new JTextField();
		txtCodigoVuelo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtCodigoVuelo.setColumns(10);
		txtCodigoVuelo.setBounds(0, 344, 250, 41);
		panelVuelo.add(txtCodigoVuelo);

		JLabel lblVueloDeIda_2_1_1 = new JLabel("Código del vuelo");
		lblVueloDeIda_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda_2_1_1.setBounds(0, 293, 250, 41);
		panelVuelo.add(lblVueloDeIda_2_1_1);

		chooserVueloFechaSalida = new JDateChooser(c.getTime());
		chooserVueloFechaSalida.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		chooserVueloFechaSalida.setBounds(0, 427, 250, 41);
		panelVuelo.add(chooserVueloFechaSalida);
		chooserVueloFechaSalida.getCalendarButton().setFont(new Font("Segoe UI", Font.PLAIN, 20));

		JLabel lblVueloDeIda_2_1_1_1 = new JLabel("Fecha de salida");
		lblVueloDeIda_2_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda_2_1_1_1.setBounds(0, 382, 250, 41);
		panelVuelo.add(lblVueloDeIda_2_1_1_1);

		JLabel lblVueloDeIda_2_1_1_1_1 = new JLabel("Hora de salida");
		lblVueloDeIda_2_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda_2_1_1_1_1.setBounds(270, 302, 218, 41);
		panelVuelo.add(lblVueloDeIda_2_1_1_1_1);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblPrecio.setBounds(269, 0, 224, 32);
		panelVuelo.add(lblPrecio);

		txtDuracionVuelo = new JTextField();
		txtDuracionVuelo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtDuracionVuelo.setColumns(10);
		txtDuracionVuelo.setBounds(270, 429, 218, 41);
		panelVuelo.add(txtDuracionVuelo);

		JLabel lblDescripcin_1_1 = new JLabel("Duración del vuelo");
		lblDescripcin_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDescripcin_1_1.setBounds(270, 386, 218, 41);
		panelVuelo.add(lblDescripcin_1_1);

		JLabel lblPrecio_1 = new JLabel("€");
		lblPrecio_1.setBounds(474, 45, 21, 32);
		panelVuelo.add(lblPrecio_1);
		lblPrecio_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		Calendar now = Calendar.getInstance();
		SpinnerDateModel model = new SpinnerDateModel();
		model.setValue(now.getTime());
		spinnerHoraSalida = new JSpinner(model);
		spinnerHoraSalida.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		spinnerHoraSalida.setLocation(270, 344);
		spinnerHoraSalida.setSize(218, 41);
		JSpinner.DateEditor de_spinnerHoraSalida = new JSpinner.DateEditor(spinnerHoraSalida, "HH:mm");
		spinnerHoraSalida.setEditor(de_spinnerHoraSalida);
		spinnerHoraSalida.setPreferredSize(new Dimension(80, 30));
		panelVuelo.add(spinnerHoraSalida);

		return panelVuelo;
	}

	public JPanel desplegarVueloVuelta() {
		Calendar c = Calendar.getInstance();
		panelVueloVuelta = new JPanel();
		panelVueloVuelta.setBounds(888, 195, 493, 473);
		panelVueloVuelta.setLayout(null);

		JLabel lblVueloDeIda = new JLabel("VUELO DE VUELTA");
		lblVueloDeIda.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblVueloDeIda.setBounds(0, 251, 250, 32);
		panelVueloVuelta.add(lblVueloDeIda);

		cbAerolineaVuelta = new JComboBox<String>(modeloAerolineasVuelta);
		cbAerolineaVuelta.setBackground(Color.white);
		cbAerolineaVuelta.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		cbAerolineaVuelta.setBounds(270, 263, 218, 41);
		panelVueloVuelta.add(cbAerolineaVuelta);

		JLabel lblVueloDeIda_2_1 = new JLabel("Aerolínea");
		lblVueloDeIda_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda_2_1.setBounds(270, 222, 218, 41);
		panelVueloVuelta.add(lblVueloDeIda_2_1);

		txtCodigoVueloVuelta = new JTextField();
		txtCodigoVueloVuelta.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtCodigoVueloVuelta.setColumns(10);
		txtCodigoVueloVuelta.setBounds(0, 344, 250, 41);
		panelVueloVuelta.add(txtCodigoVueloVuelta);

		JLabel lblVueloDeIda_2_1_1 = new JLabel("Código del vuelo");
		lblVueloDeIda_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda_2_1_1.setBounds(0, 293, 250, 41);
		panelVueloVuelta.add(lblVueloDeIda_2_1_1);

		chooserVueloFechaSalidaVuelta = new JDateChooser(c.getTime());
		chooserVueloFechaSalidaVuelta.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		chooserVueloFechaSalidaVuelta.setBounds(0, 427, 250, 41);
		panelVueloVuelta.add(chooserVueloFechaSalidaVuelta);
		chooserVueloFechaSalidaVuelta.getCalendarButton().setFont(new Font("Segoe UI", Font.PLAIN, 20));

		JLabel lblVueloDeIda_2_1_1_1 = new JLabel("Fecha de salida");
		lblVueloDeIda_2_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda_2_1_1_1.setBounds(0, 382, 250, 41);
		panelVueloVuelta.add(lblVueloDeIda_2_1_1_1);

		JLabel lblVueloDeIda_2_1_1_1_1 = new JLabel("Hora de salida");
		lblVueloDeIda_2_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblVueloDeIda_2_1_1_1_1.setBounds(270, 302, 218, 41);
		panelVueloVuelta.add(lblVueloDeIda_2_1_1_1_1);

		txtDuracionVueloVuelta = new JTextField();
		txtDuracionVueloVuelta.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtDuracionVueloVuelta.setColumns(10);
		txtDuracionVueloVuelta.setBounds(270, 429, 218, 41);
		panelVueloVuelta.add(txtDuracionVueloVuelta);

		JLabel lblDescripcin_1_1 = new JLabel("Duración del vuelo");
		lblDescripcin_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDescripcin_1_1.setBounds(270, 386, 218, 41);
		panelVueloVuelta.add(lblDescripcin_1_1);

		Calendar now = Calendar.getInstance();
		SpinnerDateModel model = new SpinnerDateModel();
		model.setValue(now.getTime());
		spinnerHoraSalidaVuelta = new JSpinner(model);
		spinnerHoraSalidaVuelta.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		spinnerHoraSalidaVuelta.setLocation(270, 344);
		spinnerHoraSalidaVuelta.setSize(218, 41);
		JSpinner.DateEditor de_spinnerHoraSalidaVuelta = new JSpinner.DateEditor(spinnerHoraSalidaVuelta, "HH:mm");
		spinnerHoraSalidaVuelta.setEditor(de_spinnerHoraSalidaVuelta);
		spinnerHoraSalidaVuelta.setPreferredSize(new Dimension(80, 30));
		panelVueloVuelta.add(spinnerHoraSalidaVuelta);

		return panelVueloVuelta;
	}

	public String tipoEvento() {
		if (rdbtnVuelo.isSelected()) {
			panelAlojamiento.setVisible(false);
			panelOtros.setVisible(false);
			panelVuelo.setVisible(true);
			btnGuardar.setBounds(10, 573, 284, 38);
			btnDesconectar.setBounds(10, 622, 284, 38);
			if (rdbtnVueloIdaVuelta.isSelected() == true) {
				panelVueloVuelta.setVisible(true);
				setBounds(0, 0, 1450, 720);
				setLocationRelativeTo(null);
				return "VueloIdaVuelta";
			} else {
				if (rdbtnVueloIda.isSelected() == false) {
					rdbtnVueloIda.setSelected(true);
				}
				setBounds(0, 0, 1000, 720);
				setLocationRelativeTo(null);
				return "VueloIda";
			}
		}
		if (rdbtnAlojamiento.isSelected()) {
			panelVuelo.setVisible(false);
			panelOtros.setVisible(false);
			panelVueloVuelta.setVisible(false);
			panelAlojamiento.setVisible(true);
			setBounds(0, 0, 1000, 650);
			setLocationRelativeTo(null);
			btnGuardar.setBounds(10, 491, 284, 38);
			btnDesconectar.setBounds(10, 540, 284, 38);
			return "Alojamiento";
		}
		if (rdbtnOtros.isSelected()) {
			panelVuelo.setVisible(false);
			panelVueloVuelta.setVisible(false);
			panelAlojamiento.setVisible(false);
			panelOtros.setVisible(true);
			setBounds(0, 0, 1000, 650);
			setLocationRelativeTo(null);
			btnGuardar.setBounds(10, 491, 284, 38);
			btnDesconectar.setBounds(10, 540, 284, 38);
			return "Otros";
		}
		return null;
	}

	public void rellenaraeropuertos(ArrayList<Aeropuerto> aeropuertos) {
		modeloAeropuertosOrigen.addElement("");
		modeloAeropuertosDestino.addElement("");
		for (Aeropuerto aeropuerto : aeropuertos) {
			modeloAeropuertosOrigen.addElement(aeropuerto.getNombreAeropuerto());
			modeloAeropuertosDestino.addElement(aeropuerto.getNombreAeropuerto());
		}
	}

	public void rellenaraerolineas(ArrayList<Aerolinea> aerolineas) {
		modeloAerolineasIda.addElement("");
		modeloAerolineasVuelta.addElement("");
		for (Aerolinea aerolinea : aerolineas) {
			modeloAerolineasIda.addElement(aerolinea.getNombreAerolinea());
			modeloAerolineasVuelta.addElement(aerolinea.getNombreAerolinea());
		}

	}

	public void cambiarTipoVuelo(String TipoVuelo) {
		rdbtnVueloIda.setSelected(TipoVuelo == "Ida");
		rdbtnVueloIdaVuelta.setSelected(TipoVuelo == "Ida y vuelta");
		panelVueloVuelta.setVisible(TipoVuelo == "Ida y vuelta");
		if (TipoVuelo == "Ida y vuelta") {
			setBounds(0, 0, 1450, 720);
			setLocationRelativeTo(null);
		} else {
			setBounds(0, 0, 1000, 720);
			setLocationRelativeTo(null);
		}
	}

	public boolean validarEvento(Viaje viaje, Agencia agencia, ArrayList<Aeropuerto> aeropuertos,
			ArrayList<Aerolinea> aerolineas) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dfh = new SimpleDateFormat("HH:mm");

		// Atributos comunes de todos los eventos
		String NombreEvento = txtNombreEvento.getText();
		String TipoEvento = tipoEvento();
		int Precio = 0;
		if (TipoEvento != null) {
			switch (TipoEvento) {
			case "Alojamiento":
				Precio = (Integer) spinnerPrecioAlojamiento.getValue();
				break;
			case "VueloIda":
				Precio = (Integer) spinnerPrecioVuelo.getValue();
				break;
			case "VueloIdaVuelta":
				Precio = (Integer) spinnerPrecioVuelo.getValue();
				break;
			case "Otros":
				Precio = (Integer) spinnerPrecioOtros.getValue();
				break;
			}
		}
		// Atributos ALOJAMIENTO
		String NombreHotel = txtNombreHotel.getText();
		String FechaEntrada_Alojamiento = df.format(chooserEntrada.getDate());
		String FechaSalida_Alojamiento = df.format(chooserSalida.getDate());
		String Ciudad = txtCiudad.getText();
		// Atributos OTROS
		String Fecha_Otros = df.format(chooserFechaOtros.getDate());
		String Descripcion = txtDescripcionOtros.getText();
		// Atributos VUELO
		String AeropuertoOrigen = cbA_Origen.getSelectedItem() + "";
		String AeropuertoDestino = cbA_Destino.getSelectedItem() + "";
		// Atributos VUELO IDA
		String Aerolinea = cbAerolinea.getSelectedItem() + "";
		String CodigoVuelo = txtCodigoVuelo.getText();
		String DuracionVuelo = txtDuracionVuelo.getText();
		String HoraSalida = dfh.format((Date) spinnerHoraSalida.getValue());
		String FechaSalida = df.format(chooserVueloFechaSalida.getDate());
		// Atributos VUELO VUELTA
		String AerolineaVuelta = cbAerolineaVuelta.getSelectedItem() + "";
		String CodigoVueloVuelta = txtCodigoVueloVuelta.getText();
		String HoraSalidaVuelta = dfh.format((Date) spinnerHoraSalidaVuelta.getValue());
		String FechaSalidaVuelta = df.format(chooserVueloFechaSalidaVuelta.getDate());
		String DuracionVueloVuelta = txtDuracionVueloVuelta.getText();

		ArrayList<String> mensajeError = new ArrayList<String>();
		if (NombreEvento.length() < 1 || NombreEvento.length() > 30) {
			mensajeError.add("El nombre del evento no puede estar vacío");
		}
		if (TipoEvento == null) {
			mensajeError.add("El tipo del Evento no puede estar vacío");
		} else {
			if (TipoEvento.equals("Alojamiento")) {
				if (NombreHotel.length() < 1 || NombreHotel.length() > 30) {
					mensajeError.add("El nombre del hotel no puede estar vacío");
				}
				if (FechaEntrada_Alojamiento.length() == 0) {
					mensajeError.add("La fecha de entrada al hotel no puede estar vacía");
				}
				if (FechaSalida_Alojamiento.length() == 0) {
					mensajeError.add("La fecha de salida al hotel no puede estar vacío");
				}
				if (Ciudad.length() == 0) {
					mensajeError.add("El nombre de la ciudad no puede estar vacío");
				}
				if (TipoHabitacion.length() == 0) {
					mensajeError.add("El tipo de habitación no puede estar vacío");
				}

			}
			if (TipoEvento.equals("VueloIda") || TipoEvento.equals("VueloIdaVuelta")) {
				if (AeropuertoOrigen.length() == 0) {
					mensajeError.add("El aeropuerto de origen no puede estar vacío");
				}
				if (AeropuertoDestino.length() == 0) {
					mensajeError.add("El aeropuerto de destino no puede estar vacío");
				}
				if (Aerolinea.length() == 0) {
					mensajeError.add("El nombre de la aerolinea no puede estar vacío");
				}
				if (CodigoVuelo.length() == 0) {
					mensajeError.add("El codigo del vuelo no puede estar vacío");
				}
				if (HoraSalida.length() == 0) {
					mensajeError.add("La hora de salida del vuelo no puede estar vacía");
				}
				if (DuracionVuelo.length() == 0) {
					mensajeError.add("La duración del vuelo no puede estar vacía");
				}
				if (FechaSalida.length() == 0) {
					mensajeError.add("La fecha de salida del vuelo no puede estar vacía");
				}
				if (TipoEvento.equals("VueloIdaVuelta")) {

					if (AerolineaVuelta.length() == 0) {
						mensajeError.add("El nombre de la aerolinea de vuelta no puede estar vacío");
					}
					if (CodigoVueloVuelta.length() == 0) {
						mensajeError.add("El codigo del vuelo de vuelta no puede estar vacío");
					}
					if (HoraSalidaVuelta.length() == 0) {
						mensajeError.add("La hora de salida del vuelo de vuelta no puede estar vacía");
					}
					if (FechaSalidaVuelta.length() == 0) {
						mensajeError.add("La fecha de salida del vuelo de vuelta no puede estar vacía");
					}
					if (DuracionVueloVuelta.length() == 0) {
						mensajeError.add("La duración del vuelo de vuelta no puede estar vacía");
					}
				}
			}
			if (TipoEvento.equals("Otros")) {
				if (Fecha_Otros.length() == 0) {
					mensajeError.add("La fecha del evento no puede estar vacía");
				}
				if (Descripcion.length() == 0) {
					mensajeError.add("La descripcion evento no puede estar vacía");
				}
			}
		}
		if (mensajeError.size() == 0) {
			boolean creado = false;
			if (TipoEvento.equals("Alojamiento")) {
				Alojamiento alojamiento = new Alojamiento();
				alojamiento.setViajeID(viaje);
				alojamiento.setNombreEvento(NombreEvento);
				alojamiento.setPrecio(Precio + "");
				alojamiento.setNombreHotel(NombreHotel);
				alojamiento.setFechaEntrada(FechaEntrada_Alojamiento);
				alojamiento.setFechaSalida(FechaSalida_Alojamiento);
				alojamiento.setCiudad(Ciudad);
				alojamiento.setTipoHabitacion(TipoHabitacion);
				creado = controlador.insertarAlojamiento(alojamiento);
			} else if (TipoEvento.equals("Otros")) {

				Otros otros = new Otros();
				otros.setViajeID(viaje);
				otros.setNombreEvento(NombreEvento);
				otros.setPrecio(Precio + "");
				otros.setFecha(Fecha_Otros);
				otros.setDescripcion(Descripcion);
				creado = controlador.insertarOtros(otros);
			} else if (TipoEvento.equals("VueloIda") || TipoEvento.equals("VueloIdaVuelta")) {

				Vuelo vuelo = crearVuelo(viaje, NombreEvento, Precio, AeropuertoOrigen, AeropuertoDestino, Aerolinea,
						CodigoVuelo, HoraSalida, FechaSalida, DuracionVuelo, aeropuertos, aerolineas);

				if (TipoEvento.equals("VueloIdaVuelta")) {
					Vuelo vueloVuelta = crearVuelo(viaje, NombreEvento, Precio, AeropuertoDestino, AeropuertoOrigen,
							AerolineaVuelta, CodigoVueloVuelta, HoraSalidaVuelta, FechaSalidaVuelta,
							DuracionVueloVuelta, aeropuertos, aerolineas);
					controlador.insertarVuelo(vueloVuelta);
					System.out.println(controlador.getSumaVuelos());
					vueloVuelta.setEventoID(controlador.getSumaVuelos() + "");
					vuelo.setEventoVueltaID(vueloVuelta);

				}
				creado = controlador.insertarVuelo(vuelo);

			}

			if (creado == true) {
				dispose();
				Inicio ventana = new Inicio(agencia);
				ventana.setVisible(true);
				JOptionPane.showMessageDialog(null, "!Evento creado correctamente!", agencia.getNombreAgencia(),
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, " - " + String.join("\n - ", mensajeError),
					"Error al crear evento | " + agencia.getNombreAgencia(), JOptionPane.ERROR_MESSAGE);
		}

		return mensajeError.size() == 0;

	}

	public Vuelo crearVuelo(Viaje viaje, String NombreEvento, int Precio, String AeropuertoOrigen,
			String AeropuertoDestino, String Aerolinea, String CodigoVuelo, String HoraSalida, String FechaSalida,
			String DuracionVuelo, ArrayList<Aeropuerto> aeropuertos, ArrayList<Aerolinea> aerolineas) {
		Vuelo vuelo = new Vuelo();
		vuelo.setViajeID(viaje);
		vuelo.setNombreEvento(NombreEvento);
		vuelo.setPrecio(Precio + "");
		vuelo.setDuracionVuelo(DuracionVuelo);
		for (Aerolinea aerolinea : aerolineas) {
			if (aerolinea.getNombreAerolinea().equals(Aerolinea)) {
				vuelo.setAerolinea(aerolinea);
			}
		}
		vuelo.setCodigoVuelo(CodigoVuelo);
		vuelo.setHoraSalida(HoraSalida);
		vuelo.setFechaSalida(FechaSalida);
		for (Aeropuerto aeropuerto : aeropuertos) {
			if (aeropuerto.getNombreAeropuerto().equals(AeropuertoOrigen)) {
				vuelo.setAeropuertoOrigen(aeropuerto);

			}
			if (aeropuerto.getNombreAeropuerto().equals(AeropuertoDestino)) {
				vuelo.setAeropuertoDestino(aeropuerto);
			}
		}
		return vuelo;
	}
}
