package Modelo;


import java.io.Serializable;


public class Computadora implements Serializable
{
   /**
	 * version para la serializacion
	 */
	private static final long serialVersionUID = 6L;
    private Ficha ficha; 

	public Computadora(Ficha ficha) 
	{	
		this.ficha = ficha;
	}
	/**
	 * NumeroAleatoreo este metodo genera numeros aleatores en un rango del 1 al 9 
	 */
	public int NumeroAleatoreo()
	{
		int respuesta = (int) (Math.random() * 9) + 1;
		return respuesta;
	}
	/**
	 * @return Ficha de la computadora
	 * */
	public Ficha getFicha() 
	{
		return ficha;
	}
}
