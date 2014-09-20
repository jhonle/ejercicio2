package controlador;

import java.util.Scanner;

import Modelo.BaseDeDato;
import Modelo.Partida;
import Modelo.PartidaVsPc;

public class Prueba_Guerdar_recuperar {
public static void main(String []args)
{
	Partida partida = new PartidaVsPc('X');
	((PartidaVsPc) partida).crearJugador("Marcelo", 'O');
	
	 
	((PartidaVsPc) partida).realizarJugadaPc(null);
     int turno=2;
     partida.imrprimirTablero();
	   
while(partida.getGanador()==0){ 
	System.out.println("Turno de Jugador: Macelo");
	Scanner escaner = new Scanner(System.in);
    int	posicion = Integer.parseInt(escaner.next());
   if(posicion<=9){ partida.RealizarJugada(posicion);
   // if(turno==1)turno=2;
   //else turno=1;
   ((PartidaVsPc)partida).realizarJugadaPc(null);
    partida.imrprimirTablero();	
   }else{ 
	   
	   BaseDeDato datos = new BaseDeDato();
	   Serializador ser= new Serializador();
	   //datos.addPartida("prueba1", partida);
	   //ser.escribirObjeto(datos,"Datos.d");
	   datos = (BaseDeDato)ser.leerObjeto("Datos.d"); 
        partida = datos.getPartida("prueba1");
        partida.imrprimirTablero();
   }
   }
if (partida.getGanador()!=3){
  if(partida.getGanador()==2) System.out.println("gano Marcelo");
  else System.out.println("gano PC"); 	
  }else{
	System.out.println("EMPATE");
}
}
	



}


