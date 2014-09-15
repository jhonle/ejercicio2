package vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Ficha;
import Modelo.Jugador;
import Modelo.Tablero;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

public class VentanaDeJuego extends JFrame {

	private static JPanel contentPane;
	
	
	public Button b1;
	public Button b2;
	public Button b3;
	public Button b4;
	public Button b5;
	public Button b6;
	public Button b7;
	public Button b8;
	public Button b9;
	private JMenuBar menuBar;
	private JMenu mnMenu;
	public JMenuItem menu_Reiniciar;
	public JMenuItem menu_volverAtras;
	private JMenuItem mntmAyuda;
	private JMenu mnAyuda;
	private JMenuItem mntmSalir;
	private JPanel panel;
	public JLabel lblMsg;
	

	

	/**
	 * Create the frame.
	 */
	public VentanaDeJuego() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBackground(Color.GRAY);
			getContentPane().setLayout(null);
			
			panel = new JPanel();
			panel.setBounds(0, 69, 294, 223);
			getContentPane().add(panel);
			panel.setLayout(new GridLayout(3, 3, 0, 0));
			
			
			
				b1 = new Button("");
				panel.add(b1);
			b2 = new Button("");
			panel.add(b2);
			b3 = new Button("");
			panel.add(b3);
			b4 = new Button("");
			panel.add(b4);
			b5 = new Button("");
			panel.add(b5);
			b6 = new Button("");
			panel.add(b6);
			b7 = new Button("");
			panel.add(b7);
			b8 = new Button("");
			panel.add(b8);
			b9 = new Button("");
			panel.add(b9);
			
			lblMsg = new JLabel("");
			lblMsg.setBounds(93, 42, 189, 15);
			getContentPane().add(lblMsg);
			this.setSize(300, 343);
			
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			mnMenu = new JMenu("MENU");
			menuBar.add(mnMenu);
			
			menu_Reiniciar = new JMenuItem("Reiniciar Juego");
			mnMenu.add(menu_Reiniciar);
			
			menu_volverAtras = new JMenuItem("Volver a Menu");
			mnMenu.add(menu_volverAtras);
			
			mntmSalir = new JMenuItem("Salir");
			mntmSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			mnMenu.add(mntmSalir);
			
			mnAyuda = new JMenu("AYUDA");
			menuBar.add(mnAyuda);
			
			mntmAyuda = new JMenuItem("About");
			mntmAyuda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,"desarrollado por Grupo: 'UBUNTU' " );
			    }
			});
			mnAyuda.add(mntmAyuda);

	}




	public void marcarBoton(int numboton, Ficha ficha) {
	    if(numboton==1)b1.setLabel(Character.toString(ficha.getFicha()));
	    if(numboton==2)b2.setLabel(Character.toString(ficha.getFicha()));
	    if(numboton==3)b3.setLabel(Character.toString(ficha.getFicha()));
	    if(numboton==4)b4.setLabel(Character.toString(ficha.getFicha()));
	    if(numboton==5)b5.setLabel(Character.toString(ficha.getFicha()));
	    if(numboton==6)b6.setLabel(Character.toString(ficha.getFicha()));
	    if(numboton==7)b7.setLabel(Character.toString(ficha.getFicha()));
	    if(numboton==8)b8.setLabel(Character.toString(ficha.getFicha()));
	    if(numboton==9)b9.setLabel(Character.toString(ficha.getFicha()));
	    
	}
}
