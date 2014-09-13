package controlador;
import prueba.*;
import Modelo.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Coordinador  {
	
	VentanaJuego ventana;
	Jugador jugador1;
	Jugador jugador2;
	public Coordinador(Jugador j1){
		
		this.jugador1 = j1;
	    ventana = new VentanaJuego();
	    ventana.setVisible(true);
	    ventana.setSize(300,300);
	    Oyente escuchadorDeEvetos = new Oyente();
	    ventana.b1.addActionListener(escuchadorDeEvetos);
	    ventana.b2.addActionListener(escuchadorDeEvetos);
	    ventana.b3.addActionListener(escuchadorDeEvetos);
	    ventana.b4.addActionListener(escuchadorDeEvetos);
	    ventana.b5.addActionListener(escuchadorDeEvetos);
	    ventana.b6.addActionListener(escuchadorDeEvetos);
	    ventana.b7.addActionListener(escuchadorDeEvetos);
	    ventana.b8.addActionListener(escuchadorDeEvetos);
	    ventana.b9.addActionListener(escuchadorDeEvetos);
	   }
	
	
    public Coordinador(Jugador j1, Jugador j2){
    	this.jugador1 = j1;
    	this.jugador2 = j2;
    	ventana = new VentanaJuego();
		
	}


	
	public static void main(String []args){
		Coordinador c =new Coordinador(new Jugador("marcelo",new Ficha('X')));		
		
	}
    
}
