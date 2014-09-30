package Modelo;

import java.net.*;
import java.io.*;

public class ConexionServidor 
{
  private ServerSocket skServidor;
  private Socket skCliente;
  private BufferedReader entrada,teclado;
  private PrintStream salida;
  private int puerto =9999;
  private String ip,datoRecibido,datoEnviado;
  private boolean estado;
  
	
	public boolean iniciarsServicio()
	{
		try
		{
			skServidor = new ServerSocket(puerto);
			return true;

		}		
		catch(Exception e)
		{
			System.out.println("error al crear el Socket Server");
			return false;
		}		
	}
	
	
	public void EnviarDatos(String f)
	{
		try
		{
							
			salida.println(f );
											
		}
		catch (Exception e) 
		{

		}
	
	}
	public String RecibirDatos() 
	{
		String respuesta="";
		try
		{
			respuesta = entrada.readLine();
			//System.out.print("Se Recibio a SERVIDOR"+respuesta);
		}
		catch (Exception e) 
		{
			System.out.println("error al recibir datos###SERVDOR");
		
		}
		return respuesta;
	}
	public void CerrarConexion()
	{
		try
		{
			entrada.close();
			salida.close();
			teclado.close();			
			skServidor.close();
			skCliente.close();
		}
		catch (Exception e)
		{		
			System.out.println("Error al cerrar las conecciones");
		}
	}
	
     public boolean esperarClienteyConectar(){
	
         	    try {	
         	        skCliente = skServidor.accept();
         	        entrada = new BufferedReader(new InputStreamReader(skCliente.getInputStream()));
       			    teclado = new BufferedReader(new InputStreamReader(System.in));
       			    salida = new PrintStream(skCliente.getOutputStream());	
					estado = true;
       			    return true;
					
				} catch (IOException e) {
					System.out.println("error al conectar con cliente");
				 	e.printStackTrace();
				    estado = false;
					return false;
				}
    	
      }


	public String getIPCLiente() {
	 
		String res="";
		 res = skCliente.getInetAddress().toString();
	//	 System.out.println("SERVIDOR: IP CLIENTE = "+ res);
		
		return res;
	
	}


	public boolean getEstado() {
		return estado; 
		
	}


}
