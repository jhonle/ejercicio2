package Modelo;

public class Tablero 
{
	private Ficha[][] tablero; 
	//constructor de la clase Tablero
	public Tablero()
    {
        tablero = new Ficha[3][3];        
    }
	/* Metodo que llena el tablero con - para que 
	 * reconosca como vacio*/
    public void LlenarTablero()
    {
        for (int i=0;i<tablero.length;i++)
        {
            for(int j=0;j<tablero[i].length;j++)
             {
                 tablero[i][j]=new Ficha('-');
             }
        }
    }  
    /*Metodo que inserta en una determinada posicion 
     * del tablero la ficha*/
    public void InsertarFicha(int fil,int col,Ficha fic)
    {       
        tablero[fil][col]=fic;          
    }
    /*Metodo que verifica si en una determinada posicion
     * del tablero esta vacia o no*/
    public boolean VerificarCasilla(int fil,int col)
    {
        if(tablero[fil][col].getFicha()=='-')
        {
            return true;
        }
        else
        {
            return false;
        }
    }   
    /*Metodo que dado una ficha verifica el tres en raya en 
     * el tablero */
    public boolean VerificarResultado(char ficha)
    {
        if(tablero[0][0].getFicha()==ficha && tablero[0][1].getFicha()==ficha && tablero[0][2].getFicha()==ficha ||           
           tablero[1][0].getFicha()==ficha && tablero[1][1].getFicha()==ficha && tablero[1][2].getFicha()==ficha ||
           tablero[2][0].getFicha()==ficha && tablero[2][1].getFicha()==ficha && tablero[2][2].getFicha()==ficha ||
           tablero[0][0].getFicha()==ficha && tablero[1][0].getFicha()==ficha && tablero[2][0].getFicha()==ficha ||
           tablero[0][1].getFicha()==ficha && tablero[1][1].getFicha()==ficha && tablero[2][1].getFicha()==ficha ||
           tablero[0][2].getFicha()==ficha && tablero[1][2].getFicha()==ficha && tablero[2][2].getFicha()==ficha ||
           tablero[0][0].getFicha()==ficha && tablero[1][1].getFicha()==ficha && tablero[2][2].getFicha()==ficha ||
           tablero[2][0].getFicha()==ficha && tablero[1][1].getFicha()==ficha && tablero[0][2].getFicha()==ficha)                              
        {                                                                                                                  
            return true;                                                       
        }
        else
        {
            return false;
        }
    }        
}
