package TresEnralla;

public class Tablero 
{
    private Ficha [][] tablero = new Ficha[3][3];
	public Tablero() 
	{
	}
	public void LlenarTabla()
	{
	   	
	   	for(int fila=0; fila<3;fila++)
	   	{
	   		for(int columna=0;columna<3;columna++)
	   		{
	   			Ficha ficha = new Ficha('-');
	   			tablero[fila][columna] = ficha;	   			
	   		}
	   	}
	}
	/*
	 * el metodo VerificarCasilla recibe la posicion del tablero del tres en raya (los valoes son del 1 al 9)
	 * y verifica en esa posicion que este vacia y si esta vacia devuelve el valor true
	 */
	public boolean VerificarCasilla(int posicion)
	{
		boolean respuesta = false;
		switch (posicion)
		{
		    case 1:
			      if(tablero[0][0].GetFicha() == '-')
			      {			    	  
				     respuesta = true;
			      }
			break;
		    case 2:
				  if(tablero[0][1].GetFicha() == '-')
				  {
					  respuesta = true;
				  }
		    break;
		    case 3:
				  if(tablero[0][2].GetFicha() == '-')
				  {
					  respuesta = true;
				  }
		    break;
		    case 4:
				  if(tablero[1][0].GetFicha() == '-')
				  {
					  respuesta = true;
				  }
		    break;
		    case 5:
				  if(tablero[1][1].GetFicha() == '-')
				  {
					  respuesta = true;
				  }
		    break;
		    case 6:
				  if(tablero[1][2].GetFicha() == '-')
				  {
					  respuesta = true;
				  }
		    break;
		    case 7:
				  if(tablero[2][0].GetFicha() == '-')
				  {
					  respuesta = true;
				  }
		    break;
		    case 8:
				  if(tablero[2][1].GetFicha() == '-')
				  {
					  respuesta = true;
				  }
		    break;
		    case 9:
				  if(tablero[2][2].GetFicha() == '-')
				  {
					  respuesta = true;
				  }
		    break;
		    default:
			break;
		}
		return respuesta;		
	}
	/*
	 *InsertarFicha recibe como parametro la posicion el la que se va a insertar la ficha(los valores son del 1 al 9)
	 * y el objeto ficha
	 */
    public boolean InsertarFicha(int posicion,Ficha ficha)
    {
    	boolean respuesta = false;
    	switch (posicion)
    	{
		    case 1:
		       respuesta = VerificarCasilla(1);
			   if(respuesta == true)
			   {
				   tablero[0][0] = ficha;
			   }			   
			break;
		    case 2:
		    	respuesta = VerificarCasilla(1);
			   if(respuesta == true)
			   {
				   tablero[0][1] = ficha;
			   }			   
			break;
		    case 3:
		        respuesta = VerificarCasilla(1);
			   if(respuesta == true)
			   {
				   tablero[0][2] = ficha;
			   }			   
			break;
		    case 4:
		    	respuesta = VerificarCasilla(1);
			   if(respuesta == true)
			   {
				   tablero[1][0] = ficha;
			   }			   
			break;
		    case 5:
		    	respuesta = VerificarCasilla(1);
			   if(respuesta == true)
			   {
				   tablero[1][1] = ficha;
			   }			   
			break;
		    case 6:
		    	respuesta = VerificarCasilla(1);
			   if(respuesta == true)
			   {
				   tablero[1][2] = ficha;
			   }			   
			break;
		    case 7:
		    	respuesta = VerificarCasilla(1);
			   if(respuesta == true)
			   {
				   tablero[2][0] = ficha;
			   }			   
			break;
		    case 8:
		    	respuesta = VerificarCasilla(1);
			   if(respuesta == true)
			   {
				   tablero[2][1] = ficha;
			   }			   
			break;
		    case 9:
		    	respuesta = VerificarCasilla(1);
			   if(respuesta == true)
			   {
				   tablero[2][2] = ficha;
			   }			   
			break;
		    default:
			break;
		}
    	return respuesta;
    }
    /*
     *GetTablero en un metodo que solo devuelve la matriz tablero por ahora no se le da uso 
     * pero adelante puede ser que nos sirva por eso lo implemente
     */
    public Ficha[][] getTablero()
    {
    	return tablero;
    }
    /*
     * VerificarTresEnRaya recibe una ficha y verifica si es que esa ficha a hecho tres en raya
     * si hubo tres en raya devuelve un valor true
     */
    public boolean VerificarTresEnRalla(Ficha ficha)
    {
    	boolean respuesta = false;
    	if(tablero[0][0] == ficha && tablero[0][1] == ficha && tablero[0][2] == ficha ||
    	   tablero[1][0] == ficha && tablero[1][1] == ficha && tablero[1][2] == ficha ||
    	   tablero[2][0] == ficha && tablero[2][1] == ficha && tablero[2][2] == ficha ||
    	   tablero[0][0] == ficha && tablero[1][0] == ficha && tablero[2][0] == ficha ||
    	   tablero[0][1] == ficha && tablero[1][1] == ficha && tablero[2][1] == ficha ||
    	   tablero[0][2] == ficha && tablero[1][2] == ficha && tablero[2][2] == ficha ||
    	   tablero[0][0] == ficha && tablero[1][1] == ficha && tablero[2][2] == ficha ||
           tablero[0][2] == ficha && tablero[1][1] == ficha && tablero[0][2] == ficha  )
    	{
    		respuesta = true;
    	}
    	return respuesta;
    }
}
