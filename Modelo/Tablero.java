package Modelo;

import java.io.Serializable;

public class Tablero implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
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
                 tablero[i][j]=new Ficha('-',"");
             }
        }
    }  
    /*Metodo que inserta en una determinada posicion 
     * del tablero la ficha*/
    public void InsertarFicha(int posicion,Ficha fic)
    {                      
    	switch (posicion)
        {
            case 1:tablero[0][0]=fic; break;
            case 2:tablero[0][1]=fic; break;
            case 3:tablero[0][2]=fic; break;
            case 4:tablero[1][0]=fic; break;
            case 5:tablero[1][1]=fic; break;
            case 6:tablero[1][2]=fic; break;
            case 7:tablero[2][0]=fic; break;
            case 8:tablero[2][1]=fic; break;
            case 9:tablero[2][2]=fic; break;
        }
    }    
    /*Metodo que verifica si en una posicion
     * del tablero esta vacia*/
    public boolean VerificarCasilla(int posicion)
    {        
        boolean estado=false;
    	switch (posicion)
        {
            case 1:estado=sub_VerificarCasilla(0,0); break;
            case 2:estado=sub_VerificarCasilla(0,1); break;
            case 3:estado=sub_VerificarCasilla(0,2); break;
            case 4:estado=sub_VerificarCasilla(1,0); break;
            case 5:estado=sub_VerificarCasilla(1,1); break;
            case 6:estado=sub_VerificarCasilla(1,2); break;
            case 7:estado=sub_VerificarCasilla(2,0); break;
            case 8:estado=sub_VerificarCasilla(2,1); break;
            case 9:estado=sub_VerificarCasilla(2,2); break;
        }
    	return estado;
    }
    /*sub-metodo de VerificarCasilla*/
    private boolean sub_VerificarCasilla(int fil, int col)
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
    public Ficha[][] getTablero()
    {
    	return tablero;
    }

}

