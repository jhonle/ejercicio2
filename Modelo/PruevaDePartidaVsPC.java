package Modelo;

import java.util.Scanner;

import Vista.VentanaDeJuego;

public class PruevaDePartidaVsPC {
	public static void main(String[] args) {
		Partida partida = new PartidaVsPc('X');
		((PartidaVsPc) partida).crearJugador("Marcelo", 'O');
		
		 
		((PartidaVsPc) partida).realizarJugadaPc(null);
	     int turno=2;
	     partida.imrprimirTablero();
   	   
	while(partida.getGanador()==0){ 
		System.out.println("Turno de Jugador: Macelo");
		Scanner escaner = new Scanner(System.in);
	    int	posicion = Integer.parseInt(escaner.next());
	    partida.RealizarJugada(posicion);
	   // if(turno==1)turno=2;
	   //else turno=1;
	   ((PartidaVsPc)partida).realizarJugadaPc(null);
	    partida.imrprimirTablero();	
	}
	if (partida.getGanador()!=3){
	  if(partida.getGanador()==2) System.out.println("gano Marcelo");
	  else System.out.println("gano PC"); 	
	  }else{
		System.out.println("EMPATE");
	}
	}

}
