package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class VentanaDeIngreso extends JFrame {

	private JPanel contentPane;
	public JButton btnIniciarPartida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDeIngreso frame = new VentanaDeIngreso();
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
	public VentanaDeIngreso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnIniciarPartida = new JButton("NUEVA PARTIDA");
		
		btnIniciarPartida.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 16));
		btnIniciarPartida.setBounds(225, 74, 187, 41);
		contentPane.add(btnIniciarPartida);
		
		JButton btnCargarPartida = new JButton("CARGAR PARTIDA");
		btnCargarPartida.setEnabled(false);
		btnCargarPartida.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 16));
		
		btnCargarPartida.setBounds(225, 138, 187, 35);
		contentPane.add(btnCargarPartida);
		
		JButton btnJugarEnLan = new JButton("JUGAR EN LAN");
		btnJugarEnLan.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 16));
		btnJugarEnLan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//public class inicio extends JFrame {
					//public inicio() {
					//super("T�tulo de la ventana");
					//p = getContentPane();
					//setLayout(new FlowLayout());
					//setSize(200, 100);
					setVisible(true);
					setDefaultCloseOperation(EXIT_ON_CLOSE);
					Object[] textoOpciones={"Si adelante","Ahora no","cancelar"};
					//s�"};
					int opcion = JOptionPane.showOptionDialog(null,
					"�Desea continuar?", "mensaje",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, textoOpciones,
					textoOpciones[0]);
					}
			//}
		});
		btnJugarEnLan.setBounds(225, 194, 187, 41);
		contentPane.add(btnJugarEnLan);
		
		JLabel lblTresEnRaya = new JLabel("TRES EN RAYA");
		lblTresEnRaya.setForeground(Color.RED);
		lblTresEnRaya.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 17));
		lblTresEnRaya.setBounds(73, 27, 145, 41);
		contentPane.add(lblTresEnRaya);
	}
}
