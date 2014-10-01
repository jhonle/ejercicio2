package Pruebas;

import Controlador.Controlador;
import Modelo.*;
import Vista.VentanaDeIngreso;
import Vista.VentanaDeJuego;

import java.io.*;

public class Main 
{		        
	/**
	 * Metodo main inicio de Juego
     * 
     * */	    
	public static void main(String[] args) 	    
	{	    	
		new Controlador();	
		Serializador ser = new Serializador();
		ser.leerObjeto("Datos.a");
		Sonido s = new Sonido("Sonidos/simpsonTema.wav");//puede aver problemas con "src" boorar para exportar a ejecutable
		s.start();
	   
	 }
	}	




