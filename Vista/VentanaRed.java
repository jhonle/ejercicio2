package Vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Modelo.ConexionServidor;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;

public class VentanaRed extends JFrame implements ItemListener 
{
    public JPanel panelUnirse1,panelServidor;//DONDE PONES LA IP
    //panelUnirse2 panel para los datos
    public JTextArea mensaje;
    public JLabel direccion,imagen,imagen2;
    public JTextField txtIp,txtJugadorServidor,txtJugadorCliente;    	
	public JMenuItem mntmVolveratras;    
	public JButton btnConectar,btnUnirseAPartida,btnNewButton;    	
    public JComboBox comboCliente,comboServidor;           	
    public JTabbedPane tabed= new JTabbedPane();
    
    public JTextField textField;
    
    public JComboBox comboBox;
    public String img[] = {"Ficha1","Ficha2","Ficha3","Ficha4"};
    public ImageIcon icono[] = 	
    	{
    			new ImageIcon(getClass().getResource("/imagenes/Bart.png")),
    			new ImageIcon(getClass().getResource("/imagenes/Homero.png")),
    			new ImageIcon(getClass().getResource("/imagenes/Maggie.png")),
    			new ImageIcon(getClass().getResource("/imagenes/Marge.png"))
    	};
    public JLabel labelMsg;
	public VentanaRed() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,250);
        setLocation(200,150);
        setVisible(true);
        
        tabed.setBounds(0,10,280,240);
        getContentPane().add(tabed);
        
        panelUnirse1 = new JPanel();
        panelUnirse1.setBounds(0,0,280,240);
        panelUnirse1.setLayout(null);
        
        mensaje = new JTextArea("para jugar en red ingrese \n la ip de la computadora \n con la que va a jugar en red");
        mensaje.setBounds(0,20,275,76);
        
        direccion = new JLabel("direccion ip");
        direccion.setBounds(37,107,63,30);
        
        txtIp = new JTextField();
        txtIp.setBounds(110,107,114, 30);
        
        btnConectar = new JButton("Conectarse");                
        btnConectar.setBounds(86,143,90,30);
        
        // seguno panel ----------------------
        
        txtJugadorCliente = new JTextField("jugador2");
        txtJugadorCliente.setBounds(149,53,120,25);
        txtJugadorCliente.setVisible(false);
        
        imagen = new JLabel(" ");
	    imagen.setBounds(40, 40, 100, 80);
	    imagen.setVisible(false);
	    panelUnirse1.add(imagen);
        
        comboCliente = new JComboBox(img);
        imagen.setIcon(icono[0]);
        comboCliente.setBounds(159,89,100,25);
        comboCliente.addItemListener(this);
        comboCliente.setVisible(false);
        
        btnUnirseAPartida = new JButton("Unirser a partida");
        btnUnirseAPartida.setBounds(32,148,160,25);
        btnUnirseAPartida.setVisible(false);
        	
        
        panelUnirse1.add(txtJugadorCliente);
        panelUnirse1.add(btnUnirseAPartida);
        panelUnirse1.add(comboCliente);
        panelUnirse1.add(mensaje);
        panelUnirse1.add(txtIp);
        panelUnirse1.add(direccion);
        panelUnirse1.add(btnConectar);
        
        
        panelServidor = new JPanel();
        panelServidor.setBounds(0,0,280,240);
        panelServidor.setLayout(null);
        
        imagen2 = new JLabel();
	    imagen2.setBounds(40, 40, 100, 80);
	    
	    panelServidor.add(imagen2);
        
                        
        tabed.addTab("Crear partida",null,panelServidor);
        
        btnNewButton = new JButton("Crear");        
        
        btnNewButton.setLocation(161, 120);
        btnNewButton.setSize(120, 25);
        panelServidor.add(btnNewButton);
        
        textField = new JTextField();
        textField.setLocation(161, 12);
        textField.setSize(100, 25);
        panelServidor.add(textField);
        textField.setColumns(10);
        
        comboBox = new JComboBox(img);        
        imagen2.setIcon(icono[0]);        
        comboBox.setLocation(161, 79);
        comboBox.setSize(100, 30);
        comboBox.addItemListener(this);
        panelServidor.add(comboBox);
        
        JLabel lblNombreDelJugador = new JLabel("Nombre del Jugador 1");
        lblNombreDelJugador.setBounds(12, 12, 145, 25);
        panelServidor.add(lblNombreDelJugador);
        
        JLabel lblFicha = new JLabel("Ficha");
        lblFicha.setBounds(80, 83, 56, 22);
        panelServidor.add(lblFicha);
        
        labelMsg = new JLabel("");
        labelMsg.setBounds(12, 148, 213, 27);
        panelServidor.add(labelMsg);
        tabed.addTab("Conectares a partida",null,panelUnirse1);
	}
	
	@Override
	public void itemStateChanged(ItemEvent a)
	{
		if(a.getSource().equals(comboCliente))
		{
			if(comboCliente.getSelectedIndex() == 1)
			{
				imagen.setIcon(icono[1]);
				System.out.println(comboCliente.getSelectedItem().toString());
			}
			if(comboCliente.getSelectedIndex() == 2)
			{
				imagen.setIcon(icono[2]);
				System.out.println(comboCliente.getSelectedItem().toString());
			}
			if(comboCliente.getSelectedIndex() == 3)
			{
				imagen.setIcon(icono[3]);
				System.out.println(comboCliente.getSelectedItem().toString());
			}
			if(comboCliente.getSelectedIndex() == 4)
			{
				imagen.setIcon(icono[4]);
				System.out.println(comboCliente.getSelectedItem().toString());
			}
			if(comboCliente.getSelectedIndex() == 0)
			{
				imagen.setIcon(icono[0]);
				System.out.println(comboCliente.getSelectedItem().toString());
			}			
	     }
		else if(a.getSource().equals(comboBox))
		{
			if(comboBox.getSelectedIndex() == 1)
			{
				imagen2.setIcon(icono[1]);
			}
			if(comboBox.getSelectedIndex() == 2)
			{
				imagen2.setIcon(icono[2]);
				System.out.println(comboCliente.getSelectedItem().toString());
			}
			if(comboBox.getSelectedIndex() == 3)
			{
				imagen2.setIcon(icono[3]);
				System.out.println(comboCliente.getSelectedItem().toString());
			}
			if(comboBox.getSelectedIndex() == 4)
			{
				imagen2.setIcon(icono[4]);
				System.out.println(comboCliente.getSelectedItem().toString());
			}
			if(comboBox.getSelectedIndex() == 0)
			{
				imagen2.setIcon(icono[0]);
				System.out.println(comboCliente.getSelectedItem().toString());
			}
		}
	}
}	
