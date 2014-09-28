package Vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Modelo.ConexionCliente;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRed extends JDialog implements ActionListener
{
	private JPanel panel;
	private JLabel direccion;
	private JTextArea mensaje;
	private JTextField ip;
	public JButton btnaceptar;
	

	public VentanaRed() 
	{		
		setSize(280, 200);
		setLocation(200,150);
		getContentPane().setLayout(null);
		setVisible(true);
		panel = new JPanel();
		panel.setBounds(0,0,264,162);
		panel.setLayout(null);
		
		mensaje = new JTextArea();
		mensaje.setText(" para poder jugar en red ingrese la \n direccion  ip de la computadora \n con la que va a jugar");
		mensaje.setBounds(0,10,260,60);
		mensaje.setEnabled(false);
		
		direccion = new JLabel("direccion ip:");
		direccion.setBounds(10,81,67,30);
		
		ip = new JTextField();
		ip.setBounds(87,81,130,25);
		
		btnaceptar = new JButton("Aceptar");
		btnaceptar.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ROMAN_BASELINE, 12));
		btnaceptar.setBounds(84,121,100,30);
		
		getContentPane().add(panel);
		panel.add(mensaje);		
		panel.add(ip);
		panel.add(direccion);
		panel.add(btnaceptar);
		btnaceptar.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(btnaceptar))
		{
			 //ConexionCliente conexion = new ConexionCliente(ip.getText());
			 VentanaDeJuego ventanaJuego = new VentanaDeJuego();
			 ventanaJuego.setVisible(true);
			 setVisible(false);
		}
	}

}
