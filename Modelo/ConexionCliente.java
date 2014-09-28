package Modelo;

import java.net.*;
import java.io.*;

public class ConexionCliente 
{
  private Socket cliente;
  private BufferedReader entrada,teclado;
  private PrintStream salida;
  private int puerto =9999;
  private String ip,datoRecibido,datoEnviado;
  
	public ConexionCliente(String ip) 
	{
		this.ip = ip;
	}
	public void iniciarConexion()
	{
		try
		{
			cliente = new Socket(ip, puerto);
			entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			teclado = new BufferedReader(new InputStreamReader(System.in));
			salida = new PrintStream(cliente.getOutputStream());						
		}		
		catch(Exception e)
		{
			
		}		
	}
	public void EnviarDatos(int posicion, String f,char c)
	{
		try
		{
							
			salida.println(f + " " + c + " " + posicion);
											
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
			System.out.print(respuesta);
		}
		catch (Exception e) 
		{
		
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
			cliente.close();
		}
		catch (Exception e)
		{		
		}
	}
	

}
