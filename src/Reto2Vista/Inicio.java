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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Reto2Modelo.Agencia;
import Reto2Modelo.Viaje;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Reto2Controlador.Controlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;
	private Controlador controlador = new Controlador();

	/**
	 * Create the frame.
	 */
	public Inicio(Agencia agencia) {
		setTitle(agencia.getNombreAgencia());
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 304, 611);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panelLogo = new JPanel();
		panelLogo.setOpaque(false);
		panelLogo.setBorder(null);
		panelLogo.setBackground(new Color(240, 240, 240));
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
		lblNombreAgencia.setForeground(new Color(255, 255, 255));
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
		panel.add(btnGenerarOfertaViaje);

		JLabel lblViaje = new JLabel("Viajes");
		lblViaje.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblViaje.setBounds(327, 29, 284, 51);
		contentPane.add(lblViaje);

		JButton btnCrearViaje = new JButton("Crear viaje");
		btnCrearViaje.setForeground(Color.BLACK);
		btnCrearViaje.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnCrearViaje.setBackground(Color.WHITE);
		btnCrearViaje.setBounds(778, 33, 196, 51);
		contentPane.add(btnCrearViaje);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(327, 91, 647, 208);
		contentPane.add(scrollPane);

		modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Tipo");
		modelo.addColumn("Fecha inicio");
		modelo.addColumn("Fecha fin");
		modelo.addColumn("Pais");
		table = new JTable(modelo);
		cargarTabla(agencia);
		scrollPane.setViewportView(table);
		
		JLabel lblEventos = new JLabel("Eventos");
		lblEventos.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblEventos.setBounds(327, 330, 284, 51);
		contentPane.add(lblEventos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(327, 392, 647, 208);
		contentPane.add(scrollPane_1);
		
		JButton btnCrearEvento = new JButton("Crear evento");
		btnCrearEvento.setForeground(Color.BLACK);
		btnCrearEvento.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnCrearEvento.setBackground(Color.WHITE);
		btnCrearEvento.setBounds(778, 334, 196, 51);
		contentPane.add(btnCrearEvento);
	}

	public void cargarTabla(Agencia agencia) {
		modelo.setRowCount(0);
	
		agencia.setViajes(	controlador.getListaViajes(controlador.getListaPaises(), agencia));
		ArrayList<Viaje> viajesArray = agencia.getViajes();
		for (int i = 0; i < viajesArray.size(); i++) {
			String[] fila= new String[5];
			fila[0] = viajesArray.get(i).getNombreViaje();
			fila[1] = viajesArray.get(i).getTipoViaje();
			fila[2] = viajesArray.get(i).getFechaInicio();
			fila[3] = viajesArray.get(i).getFechaFin();
			fila[4] = viajesArray.get(i).getPaisDestino().getDescripcionPais();

			modelo.addRow(fila);
		}

	}
}
