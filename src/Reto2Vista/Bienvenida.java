package Reto2Vista;

import java.awt.EventQueue;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Bienvenida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public Bienvenida() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);


		ImageIcon image = new ImageIcon(getClass().getResource("/Reto2Img/fondo1.jpg"));
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,0, 0));
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(image.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT)));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login ventana = new Login();
				setVisible(false);
				ventana.setVisible(true);
			}
		});
		panel.add(lblNewLabel);
		
	}
}
