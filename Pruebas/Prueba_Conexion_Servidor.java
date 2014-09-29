package Pruebas;

import java.util.Scanner;

import Modelo.ConexionServidor;

public class Prueba_Conexion_Servidor {
	
	public static void main(String[] args) {
		
		ConexionServidor servidor = new ConexionServidor();
		servidor.iniciarsServicio();
		System.out.println("SERVIDOR: Estoy esperando A un Cliente");
	    servidor.esperarClienteyConectar();
	    System.out.println("estoy conectado con el cliente con IP:" +servidor.getIPCLiente());
        Scanner scaner = new Scanner(System.in);
	    int cont=1;
	     while(cont<=9){
	 	 
	    	String msg = servidor.RecibirDatos();
	        System.out.println("CLIENTE:  "+msg);         //muestro respusta
	       
	        int	posicion = Integer.parseInt(scaner.next());
	 		 
	        servidor.EnviarDatos(posicion, "nombre Ficha", 'X');
	       
	        System.out.println("Esperando cliente.....");     
	 	
	        cont++;
	 		}
	
	
	}
	

}
