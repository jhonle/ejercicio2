package Vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Modelo.ConexionCliente;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;

public class VentanaRed extends JFrame implements ActionListener
{
    public JPanel panelUnirse1;
    public JPanel panelUnirse2;
   
    private JTextArea mensaje;
	
    public JTextField txtIp;
    public JTextField txtJugadorServidor;
	public JTextField txtJugadorCliente;
    
	public JMenuItem mntmVolveratras;
    
	public JButton btnConectar;
    public JButton btnUnirseAPartida;
    public JButton btnCrearPartida;
	
    public JComboBox comboCliente;
    public JComboBox comboServidor;
	

	public VentanaRed() 
	{
		setResizable(false);		
		setSize(329, 242);
		setLocation(200,150);
		getContentPane().setLayout(null);
		setVisible(true);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 323, 191);
		getContentPane().add(tabbedPane);
		panelUnirse1 = new JPanel();
		tabbedPane.addTab("Unirse a partida", null, panelUnirse1, null);
		panelUnirse1.setLayout(null);
		
		mensaje = new JTextArea();
		mensaje.setText(" para poder jugar en red ingrese la \n direccion  ip de la computadora servidor\n con la que va a jugar");
		mensaje.setBounds(0,12,294,60);
		mensaje.setEnabled(false);
		
		JLabel direccion = new JLabel("direccion ip:");
		direccion.setBounds(10,81,107,30);
		
		txtIp = new JTextField();
		txtIp.setBounds(118,81,117,25);
		
		btnConectar = new JButton("Aceptar");
		btnConectar.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ROMAN_BASELINE, 12));
		btnConectar.setBounds(118,111,100,30);
		panelUnirse1.add(mensaje);		
		panelUnirse1.add(txtIp);
		panelUnirse1.add(direccion);
		panelUnirse1.add(btnConectar);
		
		panelUnirse2 = new JPanel();
		panelUnirse2.setBounds(0, 0, 318, 164);
		panelUnirse1.add(panelUnirse2);
		panelUnirse2.setLayout(null);
		
		btnUnirseAPartida = new JButton("Unirse");
		btnUnirseAPartida.setBounds(200, 111, 80, 25);
		panelUnirse2.add(btnUnirseAPartida);
		
		txtJugadorCliente = new JTextField();
		txtJugadorCliente.setText("jugador2");
		txtJugadorCliente.setBounds(166, 27, 114, 19);
		panelUnirse2.add(txtJugadorCliente);
		txtJugadorCliente.setColumns(10);
		
		comboCliente = new JComboBox();
		comboCliente.setBounds(212, 58, 80, 24);
		panelUnirse2.add(comboCliente);
		
		JLabel lblNombreDeJugador = new JLabel("Nombre de Jugador");
		lblNombreDeJugador.setBounds(12, 29, 114, 15);
		panelUnirse2.add(lblNombreDeJugador);
		
		panelUnirse2.setVisible(false);
		
		JPanel panelCrear = new JPanel();
		panelCrear.setToolTipText("");
		tabbedPane.addTab("Crear Partida", null, panelCrear, null);
		panelCrear.setLayout(null);
		
		btnCrearPartida = new JButton("CREAR");
		btnCrearPartida.setBounds(165, 114, 117, 25);
		panelCrear.add(btnCrearPartida);
		
		txtJugadorServidor = new JTextField();
		txtJugadorServidor.setText("jugador1");
		txtJugadorServidor.setBounds(168, 12, 114, 19);
		panelCrear.add(txtJugadorServidor);
		txtJugadorServidor.setColumns(10);
		
		JLabel lblNombreDelJugador = new JLabel("Nombre del Jugador");
		lblNombreDelJugador.setBounds(12, 14, 150, 15);
		panelCrear.add(lblNombreDelJugador);
		
		comboServidor = new JComboBox();
		comboServidor.setBounds(165, 43, 91, 24);
		panelCrear.add(comboServidor);
		
		JLabel lblFiigura = new JLabel("Fiigura");
		lblFiigura.setBounds(12, 48, 70, 15);
		panelCrear.add(lblFiigura);
		btnConectar.addActionListener(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		mntmVolveratras = new JMenuItem("Volver Atras");
		mnMenu.add(mntmVolveratras);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(btnConectar))
		{
			 //ConexionCliente conexion = new ConexionCliente(ip.getText());
			 VentanaDeJuego ventanaJuego = new VentanaDeJuego();
			 ventanaJuego.setVisible(true);
			 setVisible(false);
		}
	}
}
