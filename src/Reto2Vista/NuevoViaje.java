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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Reto2Controlador.Controlador;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.awt.Window.Type;
import javax.swing.SwingConstants;

public class NuevoViaje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controlador controlador = new Controlador();
	private JTextField txtNombreViaje;
	private JTextArea txtServiciosNoIncluidos;
	private DefaultComboBoxModel<String> modeloPais;
	private JComboBox<String> cbTipoViaje;
	private JComboBox<String> cbPais;
	private JDateChooser chooserFechaIncio;
	private JDateChooser chooserFechaFin;
	private JTextArea txtDescripcion;
	private JLabel lblDiasViaje;

	public NuevoViaje(Agencia agencia, ArrayList<Pais> paises) {
		setFont(new Font("Segoe UI", Font.PLAIN, 20));
		setResizable(false);
		setTitle("Crear viaje | " + agencia.getNombreAgencia());
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1000, 650);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.decode(agencia.getColorMarca()));
		panel.setBounds(0, 0, 304, 700);
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

		JLabel lblNombreAgencia = new JLabel(agencia.getNombreAgencia());
		lblNombreAgencia.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNombreAgencia.setForeground(Inicio.colorTexto(Color.decode(agencia.getColorMarca())));
		lblNombreAgencia.setBounds(15, 196, 256, 38);
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
		btnGenerarOfertaViaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarViaje(agencia, paises);
			}
		});
		btnGenerarOfertaViaje.setForeground(new Color(0, 0, 0));
		btnGenerarOfertaViaje.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnGenerarOfertaViaje.setBackground(new Color(255, 255, 255));
		btnGenerarOfertaViaje.setBounds(10, 491, 284, 38);
		panel.add(btnGenerarOfertaViaje);

		JLabel lblTitulo2 = new JLabel("Crear viaje");
		lblTitulo2.setForeground(Inicio.colorTexto(Color.decode(agencia.getColorMarca())));
		lblTitulo2.setFont(new Font("Segoe UI", Font.BOLD, 40));
		lblTitulo2.setBounds(15, 244, 256, 54);
		panel.add(lblTitulo2);

		JLabel lblNombreDelViaje = new JLabel("Nombre del viaje");
		lblNombreDelViaje.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNombreDelViaje.setBounds(334, 33, 273, 32);
		contentPane.add(lblNombreDelViaje);

		txtNombreViaje = new JTextField();
		txtNombreViaje.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtNombreViaje.setColumns(10);
		txtNombreViaje.setBounds(334, 76, 580, 35);
		contentPane.add(txtNombreViaje);

		JLabel lblTipoDelViaje = new JLabel("Tipo de viaje");
		lblTipoDelViaje.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTipoDelViaje.setBounds(334, 139, 264, 32);
		contentPane.add(lblTipoDelViaje);

		cbTipoViaje = new JComboBox<String>();
		cbTipoViaje.setBackground(Color.white);
		cbTipoViaje.setModel(new DefaultComboBoxModel<String>(
				new String[] { "", "Novios", "Senior", "Grupos", "Grandes viajes(destinos exoticos)",
						"Combinado(vuelo+hotel)", "Escapadas", "Familias con niños menores" }));
		cbTipoViaje.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		cbTipoViaje.setBounds(334, 182, 273, 33);
		contentPane.add(cbTipoViaje);
		Calendar c = Calendar.getInstance();
		chooserFechaIncio = new JDateChooser(c.getTime());
		chooserFechaIncio.getCalendarButton().setFont(new Font("Segoe UI", Font.PLAIN, 20));
		chooserFechaIncio.setSize(273, 35);
		chooserFechaIncio.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		chooserFechaIncio.setLocation(334, 269);
		chooserFechaIncio.addPropertyChangeListener("date", e -> calcularDias());
		contentPane.add(chooserFechaIncio);

		JLabel lblFechaInicio = new JLabel("Fecha inicio");
		lblFechaInicio.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblFechaInicio.setBounds(334, 226, 273, 32);
		contentPane.add(lblFechaInicio);

		JLabel lblFechaFin = new JLabel("Fecha fin");
		lblFechaFin.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblFechaFin.setBounds(641, 226, 273, 32);
		contentPane.add(lblFechaFin);

		chooserFechaFin = new JDateChooser(c.getTime());
		chooserFechaFin.getCalendarButton().setFont(new Font("Segoe UI", Font.PLAIN, 20));
		chooserFechaFin.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		chooserFechaFin.setBounds(641, 269, 273, 35);
		chooserFechaFin.addPropertyChangeListener("date", e -> calcularDias());
		contentPane.add(chooserFechaFin);

		txtDescripcion = new JTextArea();
		txtDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(334, 404, 580, 60);
		contentPane.add(txtDescripcion);

		JLabel lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDescripcin.setBounds(334, 359, 580, 41);
		contentPane.add(lblDescripcin);

		JLabel lblServiciosNoIncluidos = new JLabel("Servicios no incluidos");
		lblServiciosNoIncluidos.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblServiciosNoIncluidos.setBounds(334, 474, 580, 41);
		contentPane.add(lblServiciosNoIncluidos);

		txtServiciosNoIncluidos = new JTextArea();
		txtServiciosNoIncluidos.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtServiciosNoIncluidos.setColumns(10);
		txtServiciosNoIncluidos.setBounds(334, 517, 580, 60);
		contentPane.add(txtServiciosNoIncluidos);

		JLabel lblPais = new JLabel("Pais de destino");
		lblPais.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblPais.setBounds(638, 139, 273, 32);
		contentPane.add(lblPais);
		modeloPais = new DefaultComboBoxModel<String>();
		rellenarpaises(paises);
		cbPais = new JComboBox<String>(modeloPais);
		cbPais.setBackground(Color.white);
		cbPais.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		cbPais.setBounds(638, 182, 273, 33);
		contentPane.add(cbPais);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(334, 314, 580, 41);
		panel_1.setBackground(Color.white);
		contentPane.add(panel_1);
		lblDiasViaje = new JLabel("Duración del viaje: 1 día");
		lblDiasViaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiasViaje.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDiasViaje.setBounds(334, 314, 580, 41);
		panel_1.add(lblDiasViaje);
	}

	public void rellenarpaises(ArrayList<Pais> paises) {
		modeloPais.addElement("");
		for (Pais pais : paises) {
			modeloPais.addElement(pais.getDescripcionPais());
		}
	}

	public void calcularDias() {
			long dias = TimeUnit.DAYS.convert(
					chooserFechaFin.getDate().getTime() - chooserFechaIncio.getDate().getTime(), TimeUnit.MILLISECONDS)+1;
			if (dias>0 ) {
				lblDiasViaje.setText("Duración del viaje: " + dias + (dias == 1?" día": " días"));
			} else {
				lblDiasViaje.setText("La FECHA FIN no puede ser antes que la FECHA INICIO");

			}
		
	}

	public boolean validarViaje(Agencia agencia, ArrayList<Pais> paises) {
		String NombreViaje = txtNombreViaje.getText();
		String TipoViaje = cbTipoViaje.getSelectedItem() + "";
		String Pais = cbPais.getSelectedItem() + "";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String FechaInicio = df.format(chooserFechaIncio.getDate());
		String FechaFin = df.format(chooserFechaFin.getDate());
		String Descripcion = txtDescripcion.getText();
		String ServiciosNoIncluidos = txtServiciosNoIncluidos.getText();

		ArrayList<String> mensajeError = new ArrayList<String>();
		if ((NombreViaje.length() >= 1 || NombreViaje.length() >= 30) == false) {
			mensajeError.add("Nombre no puede estar vacio");
		}
		if (TipoViaje.length() == 0) {
			mensajeError.add("Tipo de viaje no puede estar vacio");
		}
		if (Pais.length() == 0) {
			mensajeError.add("Pais no puede estar vacio");
		}
		if (FechaInicio.length() == 0) {
			mensajeError.add("Fecha de inicio no puede estar vacio");
		}
		if (FechaFin.length() == 0) {
			mensajeError.add("Fecha de fin no puede estar vacio");
		}
		if ((chooserFechaIncio.getDate().before(chooserFechaFin.getDate()) || chooserFechaIncio.getDate().equals(chooserFechaFin.getDate())) == false) {
			mensajeError.add("Fecha fin no puede ser antes que fecha inicio");
		}
		if (Descripcion.length() == 0) {
			mensajeError.add("Descripción no puede estar vacio");

		}
		if (ServiciosNoIncluidos.length() == 0) {
			mensajeError.add("Servicios no incluidos no puede estar vacio");
		}
		if (mensajeError.size() == 0) {
			Viaje viaje = new Viaje();
			viaje.setNombreAgencia(agencia);
			viaje.setNombreViaje(NombreViaje);
			viaje.setTipoViaje(TipoViaje);
			for (Pais pais : paises) {
				if (pais.getDescripcionPais().equals(Pais)) {
					viaje.setPaisDestino(pais);
				}
			}
			viaje.setFechaInicio(FechaInicio);
			viaje.setFechaFin(FechaFin);
			viaje.setDescripciónViaje(Descripcion);
			viaje.setServiciosNoIncluidos(ServiciosNoIncluidos);
			if (controlador.insertarViaje(viaje) == true) {
				dispose();
				Inicio ventana = new Inicio(agencia);
				ventana.setVisible(true);
				JOptionPane.showMessageDialog(null, "¡Viaje `" + NombreViaje + "' creado correctamente!",
						agencia.getNombreAgencia(), JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "- " + String.join("\n - ", mensajeError),
					"Error al crear viaje | " + agencia.getNombreAgencia(), JOptionPane.ERROR_MESSAGE);
		}
		return mensajeError.size() == 0;
	}
}
