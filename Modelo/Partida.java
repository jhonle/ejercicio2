package Modelo;

import java.io.Serializable;

import Vista.VentanaDeJuego;

/**
 * 
 *generaliza lo tipos de jugada: Vs PC, Vs Jugador2, LAN etc
 *  
 *   
 * */
public class Partida implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	protected Tablero tablero;
    protected Jugador jugador1;
   
    protected int contador;
    protected int turno;//1 jugador1 /2 jugador2
    protected int ganador;//1 jugador1 /2 jugador2 /3empate        
   
    /*
     * Constructor de la clase Juego
     * **/
    public Partida()
    {        
        tablero=new Tablero();
        contador=0;
        turno=1;
        ganador=0;        
        tablero.LlenarTablero();
    }
 
     /**
      * metodo que dada una posicion, verifica la casilla, inserta la ficha 
     *  de acuerdo al turno del jugador y verifica el resultado(gana-empate)
     *  @param posicion posicion a la que se desea insertar  la dicha
     *@return boolean: FALSE si se realizo si se inseto, TRUE si no
     **/
    public boolean RealizarJugada(int posicion)
    {                                                                     	
        return true;
    } 
    /**
     * retorna quien es ganador
     * */
    public int getGanador()
    {
    	return ganador;
    }
	/**
	 * Imprime La Tabla y las fichas en ella
	 * 
	 * */
    public void imrprimirTablero(){
		    int cont=0;
		    Ficha[][] tabla = tablero.getTablero();
		    for(int fila=0; fila<3;fila++)
		   	{
		   		for(int columna=0;columna<3;columna++)
		   		{
		   			
		   			if(cont==2){
		   			 System.out.println("_"+tabla[fila][columna].getFicha()+"_|");
		   			  cont=0;
		   			}else{
		   				System.out.print("_"+tabla[fila][columna].getFicha()+"_|");
			   		cont++;	
		   			}
		   	     }
		   	}

	}

	public Ficha[][] getTablero() {
		
		return tablero.getTablero();
	}

	

	

}
