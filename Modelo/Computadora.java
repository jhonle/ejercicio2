package Modelo;


public class Computadora 
{
   private Ficha ficha; 
	public Computadora(Ficha ficha) 
	{	
		this.ficha = ficha;
	}
	/*
	 * NumeroAleatoreo este metodo genera numeros aleatores en un rango del 1 al 9 
	 */
	public int NumeroAleatoreo()
	{
		int respuesta = (int) (Math.random() * 9) + 1;
		return respuesta;
	}
	public Ficha getFicha() {
		return ficha;
	}	
}
