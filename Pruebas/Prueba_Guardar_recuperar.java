package Pruebas;

import java.util.Scanner;
import Modelo.Serializador;
import Modelo.BaseDeDato;
import Modelo.Partida;

public class Prueba_Guardar_recuperar 
{
	public static void main(String []args)
	{
		Partida partida = new Partida();
		partida.CrearJugador("Marcelo",'O',"Ficha1",1);
		partida.FichaPc('X',"Ficha3");
		partida.realizarJugadaPc();
		//int turno=2;
		partida.imrprimirTablero();	  
		while(partida.getGanador()==0)
		{ 
			System.out.println("Turno de Jugador: Marcelo");
			Scanner escaner = new Scanner(System.in);
			int	posicion = Integer.parseInt(escaner.next());
			if(posicion <= 9)
			{ 
				partida.RealizarJugada(posicion,1);
				// if(turno==1)turno=2;
				//else turno=1;
				partida.realizarJugadaPc();
				partida.imrprimirTablero();	
			}
			else
			{ 	   
				BaseDeDato datos = new BaseDeDato();
				Serializador ser= new Serializador();
				
				datos.addPartida("prueba1", partida);
				ser.escribirObjeto(datos,"Datos.d");
				
				//datos = (BaseDeDato)ser.leerObjeto("Datos.d"); 
				//partida = datos.getPartida("prueba1");
				partida.imrprimirTablero();
			}
		}
		if (partida.getGanador()!=3)
		{
			if(partida.getGanador()==2) 
				System.out.println("gano Marcelo");
			else 
				System.out.println("gano PC"); 	
		}	
		else
		{
			System.out.println("EMPATE");
		}
}
	



}


