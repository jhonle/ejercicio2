package Pruebas;

import java.util.Scanner;

import Modelo.ConexionCliente;
import Modelo.ConexionServidor;

public class Prueba_Conxion_Cliente {

	public static void main(String[] args) {
		ConexionCliente cliente = new ConexionCliente("localHost");
		cliente.iniciarConexion();
		System.out.println("CLENTE : me conecte con el servidor");
		System.out.println("CLENTE :"+cliente.getIP());
		
	    Scanner scaner = new Scanner(System.in);
	    int cont=1;
	    System.out.println("Empieza Cliente");    
	    while(cont<=9){
		         
	    	 int	posicion = Integer.parseInt(scaner.next());
	    	// cliente.EnviarDatos(posicion, "nombre Ficha", 'X');
		     
	    	  System.out.println("SERVIDOR:" +cliente.RecibirDatos());
	    	 System.out.println("Esperando servidor.....");     
	      	cont ++;
	 		}
	
	
	

	}

}
