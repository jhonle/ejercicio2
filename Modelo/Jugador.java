package Modelo;

public class Jugador 
{
	private Ficha ficha;
	private String nombre;
	/*Constructor de la clase Jugador*/
	public Jugador(String nom,Ficha fic)
	{
		nombre=nom;
		ficha=fic;
	}
	/*Metodo que retorna el nombre del jugador*/
	public String getNombreJugador()
	{
		return nombre;
	}
	/*Metodo que retorna la ficha del jugador*/
	public Ficha getFichaJugador()
	{
		return ficha;
	}
}
