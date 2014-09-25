package Pruebas;

import java.util.Scanner;

import Modelo.Partida;

public class PruebaDePartidaVsPC 
{
	public static void main(String[] args) 
	{
		Partida modelo = new Partida();
		modelo.FichaPc('X',"");
		modelo.CrearJugador("Marcelo", 'O',"",1);				
		modelo.realizarJugadaPc();
	    int turnojuego=1;
	    modelo.imrprimirTablero();
	    System.out.println();   	   
	    while(modelo.getGanador()==0)
	    { 
	    	System.out.println("turno "+modelo.getTurno());
	    	if(modelo.getTurno()==1)
	    	{
	    		System.out.println("Turno de Jugador: Marcelo");
	    		Scanner escaner = new Scanner(System.in);
	    		int	posicion = Integer.parseInt(escaner.next());
	    		modelo.RealizarJugada(posicion,turnojuego);
	    	}
	    	else
	    	{
	    		System.out.println("Turno de pc "+modelo.realizarJugadaPc());
	    		System.out.println();
	    		//modelo.realizarJugadaPc();
	    	}			    	   
	    	modelo.imrprimirTablero();	
	    }	
	    if(modelo.getGanador()!=3)
	    {
	    	System.out.println("gano jugador "+modelo.getGanador());
	    }		  
	    else
	    {
	    	System.out.println("Empate");
	    }		   		 			
	}
}
