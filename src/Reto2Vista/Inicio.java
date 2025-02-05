package Reto2Vista;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Reto2Controlador.Controlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableViajes;
	private DefaultTableModel modeloViajes;
	private DefaultTableModel modeloEventos;
	private Controlador controlador = new Controlador();
	private ArrayList<Aerolinea> aerolineas;
	private ArrayList<Aeropuerto> aeropuertos;
	private ArrayList<Pais> paises;
	private JTable tableEventos;
	private JButton btnBorrarViajeSeleccionado;
	private JButton btnBorrarEventoSeleccionado;
	private JLabel lblEventos;
	private JButton btnCrearEvento;
	private JScrollPane scrollPane_1;

	/**
	 * Create the frame.
	 */
	public Inicio(Agencia agencia) {
		setResizable(false);
		setTitle(agencia.getNombreAgencia());
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		lblNombreAgencia.setForeground(colorTexto(Color.decode(agencia.getColorMarca())));
		lblNombreAgencia.setBounds(15, 196, 256, 58);
		panel.add(lblNombreAgencia);

		JButton btnDesconectar = new JButton("Desconectar");
		btnDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login ventana = new Login();
				ventana.setVisible(true);
			}
		});
		btnDesconectar.setForeground(new Color(0, 0, 0));
		btnDesconectar.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnDesconectar.setBackground(new Color(255, 255, 255));
		btnDesconectar.setBounds(10, 540, 284, 38);
		panel.add(btnDesconectar);

		JButton btnGenerarOfertaViaje = new JButton("Generar oferta viaje");
		btnGenerarOfertaViaje.setForeground(new Color(0, 0, 0));
		btnGenerarOfertaViaje.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnGenerarOfertaViaje.setBackground(new Color(255, 255, 255));
		btnGenerarOfertaViaje.setBounds(10, 491, 284, 38);
		btnGenerarOfertaViaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Viaje viajeSeleccionado = viajeSeleccionado(agencia);
				if (viajeSeleccionado != null) {
					controlador.generarOfertaViaje(viajeSeleccionado);

				} else {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún viaje.",
							"Error al generar oferta cliente | " + agencia.getNombreAgencia(),
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnGenerarOfertaViaje);

		JLabel lblViaje = new JLabel("Viajes");
		lblViaje.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblViaje.setBounds(327, 29, 160, 51);
		contentPane.add(lblViaje);

		JButton btnCrearViaje = new JButton("Crear viaje");
		btnCrearViaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoViaje nuevoviaje = new NuevoViaje(agencia, paises);
				setVisible(false);
				nuevoviaje.setVisible(true);
			}
		});
		btnCrearViaje.setForeground(Color.BLACK);
		btnCrearViaje.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnCrearViaje.setBackground(Color.WHITE);
		btnCrearViaje.setBounds(778, 33, 196, 51);
		contentPane.add(btnCrearViaje);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(327, 91, 647, 208);
		contentPane.add(scrollPane);
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(327, 392, 647, 208);
		contentPane.add(scrollPane_1);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane_1.getViewport().setBackground(Color.WHITE);
		modeloViajes = new DefaultTableModel();
		modeloViajes.addColumn("ViajeID");
		modeloViajes.addColumn("Nombre");
		modeloViajes.addColumn("Tipo");
		modeloViajes.addColumn("Fecha inicio");
		modeloViajes.addColumn("Fecha fin");
		modeloViajes.addColumn("Pais");
		tableViajes = new JTable(modeloViajes);
		tableViajes.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tableViajes.setRowHeight(25);

		tableViajes.setDefaultEditor(Object.class, null);
		tableViajes.getColumnModel().getColumn(0).setMinWidth(0);
		tableViajes.getColumnModel().getColumn(0).setMaxWidth(0);
		tableViajes.getTableHeader().setReorderingAllowed(false);
		tableViajes.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 15));
		TableRowSorter<TableModel> sort = new TableRowSorter<>(modeloViajes);
		tableViajes.setRowSorter(sort);

		sort.setSortKeys(Collections.singletonList(new RowSorter.SortKey(3, SortOrder.ASCENDING)));

		scrollPane.setViewportView(tableViajes);

		modeloEventos = new DefaultTableModel();
		modeloEventos.addColumn("EventoID");
		modeloEventos.addColumn("Nombre");
		modeloEventos.addColumn("Tipo");
		modeloEventos.addColumn("Fecha");
		modeloEventos.addColumn("Precio");
		tableEventos = new JTable(modeloEventos);
		tableEventos.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		scrollPane_1.setViewportView(tableEventos);

		tableEventos.setDefaultEditor(Object.class, null);
		tableEventos.getColumnModel().getColumn(0).setMinWidth(0);
		tableEventos.getColumnModel().getColumn(0).setMaxWidth(0);
		tableEventos.getTableHeader().setReorderingAllowed(false);
		tableEventos.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tableEventos.setRowHeight(25);
		TableRowSorter<TableModel> sortEventos = new TableRowSorter<>(modeloEventos);
		tableEventos.setRowSorter(sortEventos);
		sortEventos.setSortKeys(Collections.singletonList(new RowSorter.SortKey(3, SortOrder.ASCENDING)));

		tableViajes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				Viaje viajeSeleccionado = viajeSeleccionado(agencia);
				if (viajeSeleccionado != null) {
					btnBorrarViajeSeleccionado.setVisible(true);
					mostrarEventos(viajeSeleccionado);
				}
			}
		});
		tableEventos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				btnBorrarEventoSeleccionado.setVisible(true);
			}
		});
		lblEventos = new JLabel("Eventos");
		lblEventos.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblEventos.setBounds(327, 330, 139, 51);
		contentPane.add(lblEventos);
		btnCrearEvento = new JButton("Crear evento");
		btnCrearEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Viaje viajeSeleccionado = viajeSeleccionado(agencia);
				if (viajeSeleccionado != null) {
					NuevoEvento nuevoevento = new NuevoEvento(viajeSeleccionado, agencia, aeropuertos, aerolineas);
					setVisible(false);
					nuevoevento.setVisible(true);
				}
			}

		});
		btnCrearEvento.setForeground(Color.BLACK);
		btnCrearEvento.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnCrearEvento.setBackground(Color.WHITE);
		btnCrearEvento.setBounds(778, 334, 196, 51);
		contentPane.add(btnCrearEvento);

		btnBorrarViajeSeleccionado = new JButton("Borrar viaje seleccionado");
		btnBorrarViajeSeleccionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarViaje(agencia);
			}
		});
		btnBorrarViajeSeleccionado.setForeground(Color.BLACK);
		btnBorrarViajeSeleccionado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnBorrarViajeSeleccionado.setBackground(Color.WHITE);
		btnBorrarViajeSeleccionado.setBounds(558, 49, 210, 35);
		btnBorrarViajeSeleccionado.setVisible(false);

		contentPane.add(btnBorrarViajeSeleccionado);

		btnBorrarEventoSeleccionado = new JButton("Borrar evento seleccionado");
		btnBorrarEventoSeleccionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarEvento(agencia);
			}
		});
		btnBorrarEventoSeleccionado.setForeground(Color.BLACK);
		btnBorrarEventoSeleccionado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnBorrarEventoSeleccionado.setBackground(Color.WHITE);
		btnBorrarEventoSeleccionado.setBounds(537, 346, 231, 35);
		btnBorrarEventoSeleccionado.setVisible(false);
		contentPane.add(btnBorrarEventoSeleccionado);
		btnCrearEvento.setVisible(false);
		tableEventos.setVisible(false);
		lblEventos.setVisible(false);
		scrollPane_1.setVisible(false);
		cargarTabla(agencia);
	}

	public Viaje viajeSeleccionado(Agencia agencia) {
		if (tableViajes.getSelectedRow() != -1) {
			String ViajeIDSeleccionado = tableViajes.getValueAt(tableViajes.getSelectedRow(), 0).toString();
			ArrayList<Viaje> viajesArray = agencia.getViajes();
			for (int i = 0; i < viajesArray.size(); i++) {
				if (viajesArray.get(i).getViajeID().equals(ViajeIDSeleccionado)) {
					return viajesArray.get(i);
				}
			}
		}
		return null;
	}

	public void mostrarEventos(Viaje viaje) {

		btnCrearEvento.setVisible(true);
		tableEventos.setVisible(true);
		lblEventos.setVisible(true);
		scrollPane_1.setVisible(true);

		modeloEventos.setRowCount(0);
		ArrayList<Vuelo> vuelosArray = viaje.getVuelos();
		for (int z = 0; z < vuelosArray.size(); z++) {
			String[] fila = new String[5];
			fila[0] = vuelosArray.get(z).getEventoID();
			fila[1] = vuelosArray.get(z).getNombreEvento();
			fila[2] = "Vuelo";
			fila[3] = vuelosArray.get(z).getFechaSalida();
			fila[4] = vuelosArray.get(z).getPrecio() + "€";
			modeloEventos.addRow(fila);
		}
		ArrayList<Alojamiento> alojamientosArray = viaje.getAlojamientos();
		for (int e = 0; e < alojamientosArray.size(); e++) {
			String[] fila = new String[5];
			fila[0] = alojamientosArray.get(e).getEventoID();
			fila[1] = alojamientosArray.get(e).getNombreEvento();
			fila[2] = "Alojamiento";
			fila[3] = alojamientosArray.get(e).getFechaEntrada();
			fila[4] = alojamientosArray.get(e).getPrecio() + "€";
			modeloEventos.addRow(fila);
		}
		ArrayList<Otros> otrosArray = viaje.getOtros();
		for (int d = 0; d < otrosArray.size(); d++) {
			String[] fila = new String[5];
			fila[0] = otrosArray.get(d).getEventoID();
			fila[1] = otrosArray.get(d).getNombreEvento();
			fila[2] = "Otros";
			fila[3] = otrosArray.get(d).getFecha();
			fila[4] = otrosArray.get(d).getPrecio() + "€";
			modeloEventos.addRow(fila);
		}
	}

	public void cargarTabla(Agencia agencia) {
		modeloViajes.setRowCount(0);
		paises = controlador.getListaPaises();
		aeropuertos = controlador.getListaAeropuertos();
		aerolineas = controlador.getListaAerolineas();
		agencia.setViajes(controlador.getListaViajes(paises, agencia));
		btnCrearEvento.setVisible(false);
		tableEventos.setVisible(false);
		lblEventos.setVisible(false);
		scrollPane_1.setVisible(false);

		ArrayList<Viaje> viajesArray = agencia.getViajes();
		for (int i = 0; i < viajesArray.size(); i++) {
			viajesArray.get(i).setVuelos(controlador.getListaVuelos(viajesArray.get(i), aeropuertos, aerolineas));
			viajesArray.get(i).setAlojamientos(controlador.getListaAlojamiento(viajesArray.get(i)));
			viajesArray.get(i).setOtros(controlador.getListaOtros(viajesArray.get(i)));
			String[] fila = new String[6];
			fila[0] = viajesArray.get(i).getViajeID();
			fila[1] = viajesArray.get(i).getNombreViaje();
			fila[2] = viajesArray.get(i).getTipoViaje();
			fila[3] = viajesArray.get(i).getFechaInicio();
			fila[4] = viajesArray.get(i).getFechaFin();
			fila[5] = viajesArray.get(i).getPaisDestino().getDescripcionPais();

			modeloViajes.addRow(fila);
		}

	}

	public void eliminarViaje(Agencia agencia) {
		if (controlador.eliminarViaje(viajeSeleccionado(agencia)) == true) {
			JOptionPane.showMessageDialog(null, "Eliminado correctamente.", agencia.getNombreAgencia(),
					JOptionPane.INFORMATION_MESSAGE);
			cargarTabla(agencia);
			modeloEventos.setRowCount(0);
			btnBorrarViajeSeleccionado.setVisible(false);
			btnBorrarEventoSeleccionado.setVisible(false);
		}
	}

	public void eliminarEvento(Agencia agencia) {
		boolean valido = false;
		if (tableEventos.getSelectedRow() != -1) {
			String EventoIDSeleccionado = tableEventos.getValueAt(tableEventos.getSelectedRow(), 0).toString();
			String TipoEventoSeleccionado = tableEventos.getValueAt(tableEventos.getSelectedRow(), 2).toString();
			if (TipoEventoSeleccionado == "Vuelo") {
				ArrayList<Vuelo> vuelosArray = viajeSeleccionado(agencia).getVuelos();
				for (int i = 0; i < vuelosArray.size(); i++) {
					if (vuelosArray.get(i).getEventoID().equals(EventoIDSeleccionado)) {
						valido = controlador.eliminarVuelo(vuelosArray.get(i));
					}
				}
			} else if (TipoEventoSeleccionado == "Alojamiento") {
				ArrayList<Alojamiento> alojamientosArray = viajeSeleccionado(agencia).getAlojamientos();
				for (int i = 0; i < alojamientosArray.size(); i++) {
					if (alojamientosArray.get(i).getEventoID().equals(EventoIDSeleccionado)) {
						valido = controlador.eliminarAlojamiento(alojamientosArray.get(i));
					}
				}
			} else if (TipoEventoSeleccionado == "Otros") {
				ArrayList<Otros> otrosArray = viajeSeleccionado(agencia).getOtros();
				for (int i = 0; i < otrosArray.size(); i++) {
					if (otrosArray.get(i).getEventoID().equals(EventoIDSeleccionado)) {
						valido = controlador.eliminarOtros(otrosArray.get(i));
					}
				}
			}
		}
		if (valido == true) {
			JOptionPane.showMessageDialog(null, "Eliminado correctamente.", agencia.getNombreAgencia(),
					JOptionPane.INFORMATION_MESSAGE);
			cargarTabla(agencia);
			modeloEventos.setRowCount(0);
			btnBorrarEventoSeleccionado.setVisible(false);
		}

	}
	public static Color colorTexto(Color fondo) {
        double iluminacion = (0.299 * fondo.getRed() + 0.587 * fondo.getGreen() + 0.114 * fondo.getBlue()) / 255;
        return iluminacion < 0.5 ? Color.WHITE : Color.BLACK;
    }
	
}
