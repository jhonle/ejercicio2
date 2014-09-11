package prueba;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.List;
import java.awt.Choice;
import javax.swing.JSeparator;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Canvas;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Figura extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Figura frame = new Figura();
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
	public Figura() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJugador = new JLabel("JUGADOR");
		lblJugador.setForeground(new Color(153, 51, 51));
		lblJugador.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 16));
		lblJugador.setBounds(212, 24, 100, 33);
		contentPane.add(lblJugador);
		
		JLabel lblElijeUnaFigura = new JLabel("ELIJE UNA FIGURA");
		lblElijeUnaFigura.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 16));
		lblElijeUnaFigura.setBounds(34, 63, 190, 39);
		contentPane.add(lblElijeUnaFigura);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(256, 68, 112, 20);
		contentPane.add(comboBox);
		
		JLabel lblTipo = new JLabel("TIPO");
		lblTipo.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 16));
		lblTipo.setBounds(71, 128, 46, 14);
		contentPane.add(lblTipo);
		
		JRadioButton rdbtnHumano = new JRadioButton("HUMANO");
		rdbtnHumano.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 16));
		rdbtnHumano.setBounds(168, 124, 109, 23);
		contentPane.add(rdbtnHumano);
		
		JRadioButton rdbtnComputadora = new JRadioButton("COMPUTADORA");
		rdbtnComputadora.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 16));
		rdbtnComputadora.setBounds(283, 124, 109, 23);
		contentPane.add(rdbtnComputadora);
		
		JButton btnJugar = new JButton("JUGAR");
		btnJugar.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 16));
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaJuego nuevoventana = new VentanaJuego();
			 	nuevoventana.setVisible(true);
			 	Figura.this.dispose();
			}
		});
		btnJugar.setBounds(168, 202, 120, 33);
		contentPane.add(btnJugar);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
