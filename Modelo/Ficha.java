package Modelo;

import java.io.Serializable;

public class Ficha implements Serializable
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 6L;
private char ficha;
   private String figura;
	public Ficha(char ficha,String fig) 
	{		
		this.ficha = ficha;
		this.figura=fig;
	}
	/**
	 * SetFicha es el metodo para asignar el valor que va tener la ficha
	 */
    public void setFicha(char ficha)
    {
    	this.ficha = ficha;
    }
    /**
     * GetFicha retorna el valor que tiene esa ficha(el valor es un char)
     */
    public char getFicha()
    {
    	return ficha;
    }
    public String getFigura()
    {
    	return figura;
    }
}
