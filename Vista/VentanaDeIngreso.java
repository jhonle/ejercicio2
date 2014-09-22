package Vista;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import org.jvnet.substance.*;
import org.jvnet.substance.watermark.*;;


public class VentanaDeIngreso extends JFrame 
{
	private JPanel contentPane;
	public JButton btnIniciarPartida;	
	public JButton btnCargarPartida;
	private ImageIcon cursorImg;
    private Cursor cursor;

	/**
	 * Create the frame.
	 */
	public VentanaDeIngreso() 
	
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.SaharaSkin");
		//SubstanceLookAndFeel.setCurrentTheme( "org.jvnet.substance.theme.SubstanceAquaTheme" );
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setTitle("BIENBENIDO");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnIniciarPartida = new JButton("NUEVA PARTIDA");
		
		btnIniciarPartida.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 16));
		btnIniciarPartida.setBounds(225, 74, 187, 41);
		contentPane.add(btnIniciarPartida);
		
		btnCargarPartida = new JButton("CARGAR PARTIDA");
		btnCargarPartida.setEnabled(false);
		btnCargarPartida.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 16));
		
		btnCargarPartida.setBounds(225, 138, 187, 35);
		contentPane.add(btnCargarPartida);
		
		JButton btnJugarEnLan = new JButton("JUGAR EN LAN");
		btnJugarEnLan.setEnabled(false);
		btnJugarEnLan.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 16));
	
		btnJugarEnLan.setBounds(225, 194, 187, 41);
		contentPane.add(btnJugarEnLan);
		
		JLabel lblTresEnRaya = new JLabel("TRES EN RAYA");
		lblTresEnRaya.setForeground(Color.RED);
		lblTresEnRaya.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 17));
		lblTresEnRaya.setBounds(73, 27, 145, 41);
		contentPane.add(lblTresEnRaya);
		
		JLabel lblImg = new JLabel("img");
		//lblImg.setIcon(new ImageIcon(VentanaDeIngreso.class.getResource("/vista/tres_en_raya.jpg")));
		lblImg.setBounds(12, 67, 187, 168);
		contentPane.add(lblImg);
		
		cursorImg = new ImageIcon("../Cursores/cursor1.png");
		Toolkit TK = Toolkit.getDefaultToolkit();		 
        cursor = TK.createCustomCursor(cursorImg.getImage(),new Point(2,2),"Cursor 01");
        setCursor(cursor);
	}
}
