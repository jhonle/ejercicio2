package Modelo;

import java.net.*;
import java.io.*;

import javax.swing.JOptionPane;

public class ConexionCliente 
{
  private Socket cliente;
  private BufferedReader entrada,teclado;
  private PrintStream salida;
  private int puerto =9999;
  private String ip,datoRecibido,datoEnviado;
  private boolean estado; // true si se encuentra conectado, false si es que no
  
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
		    estado= true;
		}		
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Error no se puede establecer la coneccion co el servidor");

			estado = false;
		}		
	}
	public void EnviarDatos( String f)
	{
		try
		{
							
			salida.println(f);
											
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
			//System.out.print(respuesta);
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
	/**
	 *
	 * @return String; Retorna IP del cliente
	 */
	public String getIP() {
		String res="";
		 res = cliente.getInetAddress().toString();
		// System.out.println("SERVIDOR: IP CLIENTE = "+ res);
		
		return res;
		//System.out.println(" Cliente se conecto con  el servidor : ");
	}
	public boolean getEstado() {
	  return estado;	
	}
	

}
