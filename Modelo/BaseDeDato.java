package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseDeDato implements Serializable 
{	
	/**
	 * id para la serializacion
	 */
	private static final long serialVersionUID = 6L;
	HashMap<String,Partida> listaDePartidas;	
	
	public BaseDeDato() 
	{		
		listaDePartidas = new HashMap<String,Partida>();	
	}	
	
	public HashMap<String, Partida> getListaDePartidas() 
	{
		return listaDePartidas;
	}
	
	public void setListaDePartidas(HashMap<String, Partida> listaDePartidas) 
	{
		this.listaDePartidas = listaDePartidas;
	}
	
	public void addPartida(String descripcion,Partida partida )
	{
		listaDePartidas.put(descripcion, partida);
	}
	
	public Partida getPartida(String descripcion)
	{		
		return  listaDePartidas.get(descripcion);	
	}
}
