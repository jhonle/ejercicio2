package Vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Point;

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

import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
public class VentanaDeJuego extends JFrame 
{
	private static JPanel contentPane;		
	public JButton b1;
	public JButton b2;
	public JButton b3;
	public JButton b4;
	public JButton b5;
	public JButton b6;
	public JButton b7;
	public JButton b8;
	public JButton b9;
	private JMenuBar menuBar;
	private JMenu mnMenu;
	public JMenuItem menu_Reiniciar;
	public JMenuItem menu_volverAtras;
	private JMenuItem mntmAyuda;
	private JMenu mnAyuda;
	private JMenuItem mntmSalir;
	private JPanel panel;
	public JLabel lblMsg;	
	public JMenuItem menu_GuardarPartida;
	private ImageIcon cursorImg;    
    private Cursor cursor;
	/**
	 * Create the frame.
	 */
	public VentanaDeJuego() 
	{		
		getContentPane().setBackground(new Color(102, 204, 255));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBackground(Color.GRAY);
	    getContentPane().setLayout(null);
					
	    panel = new JPanel();
	    panel.setBounds(0, 26, 294, 266);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
										   
		b1 = new JButton("");
		b1.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 32));
		panel.add(b1);
		b2 = new JButton("");
		b2.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 32));
		panel.add(b2);
		b3 = new JButton("");
		b3.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 32));
		panel.add(b3);
		b4 = new JButton("");
		b4.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 32));
		panel.add(b4);
		b5 = new JButton("");
		b5.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 32));
		panel.add(b5);
		b6 = new JButton("");
		b6.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 32));
		panel.add(b6);
		b7 = new JButton("");
		b7.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 32));
		panel.add(b7);
		b8 = new JButton("");
		b8.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 32));
		panel.add(b8);
		b9 = new JButton("");
		b9.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 32));
		panel.add(b9);
			
		lblMsg = new JLabel("");
		lblMsg.setFont(new Font("Waree", Font.BOLD | Font.ITALIC, 14));
		lblMsg.setBounds(62, 0, 170, 23);
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
		mntmSalir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{					
				System.exit(0);
			}		
		});
			
		menu_GuardarPartida = new JMenuItem("Guardar Partida");
		mnMenu.add(menu_GuardarPartida);
		mnMenu.add(mntmSalir);
		
		mnMenu.add(mntmSalir);
			
		mnAyuda = new JMenu("AYUDA");
		menuBar.add(mnAyuda);
			
		mntmAyuda = new JMenuItem("About");
		mntmAyuda.addActionListener(new ActionListener() 
		{				
			public void actionPerformed(ActionEvent e) 
			{					
				JOptionPane.showMessageDialog(null,"desarrollado por Grupo: 'UBUNTU' " );
			    
			}			
		});		
		mnAyuda.add(mntmAyuda);	
	
	
		cursorImg = new ImageIcon("Cursores/cursor1.png");
		Toolkit TK = Toolkit.getDefaultToolkit();		 
        cursor = TK.createCustomCursor(cursorImg.getImage(),new Point(2,2),"Cursor 01");
        setCursor(cursor);
	
	}

/**
 * @param numboton  numero de boton que se quiere cambiar su texto(label)
 * @param ficha  Ficha que contiene el Texto para modifical dicho boton               
 * @return void
 * */
	public void marcarBoton(int numboton, Ficha ficha) 
	{	    
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
