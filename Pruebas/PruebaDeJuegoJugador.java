package Pruebas;

import java.util.Scanner;

import Modelo.Partida;

public class PruebaDeJuegoJugador 
{
	public static void main(String[] args) 
	{
		Partida modelo = new Partida();
		modelo.CrearJugador("Marcelo", 'X', "", 1);
		modelo.CrearJugador("Juan", 'O', "", 2);
		modelo.imrprimirTablero();
		Scanner escaner = new Scanner(System.in);
		int posicion;
		int	turnojuego=1;
   	   	   
	   while(modelo.getGanador()==0)
	   { 		
		   if(modelo.getTurno()==1)
		   {
			   System.out.println("Turno de Jugador:"+modelo.getTurno());		
			   posicion = Integer.parseInt(escaner.next());
			   modelo.RealizarJugada(posicion,modelo.getTurno());
		   }	    	
		   else
		   {
			   System.out.println("Turno de Jugador:"+modelo.getTurno());			
			   posicion = Integer.parseInt(escaner.next());
			   modelo.RealizarJugada(posicion,modelo.getTurno());
		   }	    		    	
		   modelo.imrprimirTablero();	
	}
	if (modelo.getGanador()!=3)
	{
		System.out.println("Gano Jugador"+modelo.getGanador());
	}
	else
	{
		System.out.println("EMPATE");
	}
	}

}
