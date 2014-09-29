package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Vista.VentanaRed;

public class ControladorRed implements ActionListener {
	
	VentanaRed ventana;
	int tipoDeVentana;// 1 Ventana de Red, 2 Ventana de Juego
	boolean servidor;
	boolean cliente;
	String Ip;//por si lo necesito
	String port;//por si lo necesito
	boolean coneccion;

	public ControladorRed(VentanaRed ventanaRed) {
		
		this.ventana = ventanaRed;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
