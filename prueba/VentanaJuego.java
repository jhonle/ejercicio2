package prueba;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class VentanaJuego extends JFrame {

	private static JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuego frame = new VentanaJuego();
					frame.setSize(300,300);
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
	public VentanaJuego() {
		setBackground(Color.GRAY);
		
			Button b1 = new Button("A");
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			Button b2 = new Button("B");
			Button b3 = new Button("C");
			Button b4 = new Button("D");
			Button b5 = new Button("E");
			Button b6 = new Button("f");
			Button b7 = new Button("g");
			Button b8 = new Button("h");
			Button b9 = new Button("i");
			getContentPane().setLayout(new GridLayout(3, 3));
			getContentPane().add(b1);
			getContentPane().add(b2);
			getContentPane().add(b3);
			getContentPane().add(b4);
			getContentPane().add(b5);
			getContentPane().add(b6);
			getContentPane().add(b7);
			getContentPane().add(b8);
			getContentPane().add(b9);
		}
		public static void main1 (String[] args){
			VentanaJuego v = new VentanaJuego();
			v.setSize(300, 300);
			v.show();

		//setDefaultCloseOperation1(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		ContentPane(contentPane);
	}

		private static void ContentPane(JPanel contentPane2) {
			// TODO Auto-generated method stub
			
		}
	

}
