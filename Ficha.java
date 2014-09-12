package TresEnralla;

public class Ficha 
{
   private char ficha;
	public Ficha(char ficha) 
	{		
		this.ficha = ficha;
	}
	/*
	 * SetFicha es el metodo para asignar el valor que va tener la ficha
	 */
    public void SetFicha(char ficha)
    {
    	this.ficha = ficha;
    }
    /*
     * GetFicha retirna el valor que tiene esa ficha(el valor es un char)
     */
    public char GetFicha()
    {
    	return ficha;
    }
}
