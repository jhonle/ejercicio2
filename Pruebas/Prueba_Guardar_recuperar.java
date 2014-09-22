package Pruebas;

import java.util.Scanner;
import Modelo.Serializador;
import Modelo.BaseDeDato;
import Modelo.Partida;

public class Prueba_Guardar_recuperar 
{
    public static void main (String []args){
    	
    	Partida partida = new Partida();
    	partida.ReiniciarJuego();
    	BaseDeDato datos = new BaseDeDato();
	    Serializador ser= new Serializador();
	    datos.addPartida("prueba1", partida);
	    ser.escribirObjeto(datos,"Datos.a");
	    //datos = (BaseDeDato)ser.leerObjeto("Datos.a"); 
       //partida = datos.getPartida("partida214");
        partida.imrprimirTablero();
        System.out.println("se creo un nuevo fichero con una partida llamada : 'prueba 1'"
        		+ "line 22 clase 'Prueba_Guardar_recuperar.java' ");
    	
    }

}


