package Modelo;

import java.util.Scanner;

import vista.VentanaDeJuego;

public class PruevaDePartidaVsPC {
	public static void main(String[] args) {
		Partida modelo = new PartidaVsPc('X');
		((PartidaVsPc) modelo).crearJugador("Marcelo", 'O');
		
		 
		((PartidaVsPc) modelo).realizarJugadaPc(null);
	     int turno=2;
	     modelo.imrprimirTablero();
   	   
	while(modelo.getGanador()==0){ 
		System.out.println("Turno de Jugador: Macelo");
		Scanner escaner = new Scanner(System.in);
	    int	posicion = Integer.parseInt(escaner.next());
	    modelo.RealizarJugada(posicion);
	   // if(turno==1)turno=2;
	   //else turno=1;
	   ((PartidaVsPc)modelo).realizarJugadaPc(null);
	    modelo.imrprimirTablero();	
	}
	if (modelo.getGanador()!=3){
	  if(modelo.getGanador()==2) System.out.println("gano Marcelo");
	  else System.out.println("gano PC"); 	
	  }else{
		System.out.println("EMPATE");
	}
	}

}
