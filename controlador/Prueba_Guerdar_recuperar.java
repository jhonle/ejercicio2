package controlador;

import java.util.Scanner;

import vista.VentanaDeJuego;
import Modelo.BaseDeDato;
import Modelo.Partida;
import Modelo.PartidaVsPc;

public class Prueba_Guerdar_recuperar {
public static void main(String []args)
{
	/*
	Partida partida = new PartidaVsPc('X');
	((PartidaVsPc) partida).crearJugador("Marcelo", 'O');
	
	 
	((PartidaVsPc) partida).realizarJugadaPc(null);
     int turno=2;
     partida.imrprimirTablero();
	   
while(partida.getGanador()==0){ 
	System.out.println("Turno de Jugador: Macelo");
	Scanner escaner = new Scanner(System.in);
    int	posicion = Integer.parseInt(escaner.next());
    if(posicion<=9){ 
    	partida.RealizarJugada(posicion);
        ((PartidaVsPc)partida).realizarJugadaPc(null);
        partida.imrprimirTablero();	
    }else
    { 
    	BaseDeDato datos = new BaseDeDato();
	    Serializador ser= new Serializador();
	   // datos.addPartida("prueba1", partida);
	    //ser.escribirObjeto(datos,"Datos.a");
	    datos = (BaseDeDato)ser.leerObjeto("Datos.a"); 
        partida = datos.getPartida("prueba1");
        partida.imrprimirTablero();
        System.out.println("Se recupero la partida con: "+datos.getPartida("prueba1"));
    }
  
}
if (partida.getGanador()!=3){
  if(partida.getGanador()==2) System.out.println("gano Marcelo");
  else System.out.println("gano PC"); 	
  }else{
	System.out.println("EMPATE");
}

   
	*/
	BaseDeDato datos = new BaseDeDato();
    Serializador ser= new Serializador();
    datos = (BaseDeDato)ser.leerObjeto("Datos.a"); 
    Partida  partida = datos.getPartida("prueba1");
    partida.imrprimirTablero();
    VentanaDeJuego  v = new VentanaDeJuego();
    v.llenarCasillas(partida);
    v.setVisible(true);


}
	
}



