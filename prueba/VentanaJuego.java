package prueba;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Ficha;
import Modelo.Jugador;
import Modelo.TableroVsJ2;
import controlador.Coordinador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class VentanaJuego extends JFrame {

	private static JPanel contentPane;
	
	Jugador  j1;
	Jugador j2;
	TableroVsJ2 tablero;
	

	

	/**
	 * Create the frame.
	 */
	public VentanaJuego() {
		setResizable(false);
		setBackground(Color.GRAY);
		
		this.tablero=tablero;
		this.j1=j1;
		this.j1=j2;
		
			Button b1 = new Button("1");
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(!posicionOcupado(1,0)){
						marcarPosicion();
					 }else{
						 System.out.println("ya esta marcada la posicion");
					 }
				}
			});
			Button b2 = new Button("2");
			Button b3 = new Button("3");
			Button b4 = new Button("4");
		    Button b5 = new Button("5");
			Button b6 = new Button("6");
			Button b7 = new Button("7");
			Button b8 = new Button("8");
			Button b9 = new Button("9");
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
			
		    this.setSize(300, 300);
	}




	protected boolean posicionOcupado(int i, int j) {
		
		return false;
	}




	protected void marcarPosicion() {
		// TODO Auto-generated method stub
		
	}




	



	
	

	/*	
	public static void main(String []args){
      VentanaJuego v = new VentanaJuego();
		v.setVisible(true);
	}*/
		
}
