package Modelo;

import java.io.Serializable;

public class Ficha implements Serializable
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 6L;
private char ficha;
	public Ficha(char ficha) 
	{		
		this.ficha = ficha;
	}
	/**
	 * SetFicha es el metodo para asignar el valor que va tener la ficha
	 */
    public void setFicha(char ficha)
    {
    	this.ficha = ficha;
    }
    /**
     * GetFicha retirna el valor que tiene esa ficha(el valor es un char)
     */
    public char getFicha()
    {
    	return ficha;
    }
}
