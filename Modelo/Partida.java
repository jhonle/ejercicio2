package Modelo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
/**
 *generaliza los tipos de jugada: Vs PC, Vs Jugador2, LAN etc  
 * */
public class Partida implements Serializable 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	protected Tablero tablero;
    protected Jugador jugador1;
    protected Jugador jugador2;
    protected Computadora pc;
    protected int contador;
    protected int turno;//1 jugador1 /2 jugador2
    protected int ganador;//1 jugador1 /2 jugador2 /3empate /4pc    
    protected HashMap lista;
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
    public void FichaPc(char fichaComp,String fig)
    {
    	pc=new Computadora(new Ficha(fichaComp,fig));
    }
    public void ReiniciarJuego()
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
     *@return boolean: FALSE si se inserto, TRUE si no
     **/        
    public boolean RealizarJugada(int pos,int turnojug)
    {
    	boolean estado=true;
    	if(turnojug==1)
		{
			if(tablero.VerificarCasilla(pos)==true)
    		{
    			tablero.InsertarFicha(pos, jugador1.getFichaJugador()) ; 
        		boolean resultado=tablero.VerificarResultado(jugador1.getFichaJugador().getFicha());
        		if(resultado == true)
        		{
        			ganador=1;
        		}
        		else
        		{
        			contador=contador+1;
        			turno=2;
        		}
        		if(contador==9 && ganador==0)
                {                                   
        			ganador=3;
                }
    		}
    		else
    		{
    			estado=false;
    		}			
		}
    	if(turnojug==2)
		{
			if(tablero.VerificarCasilla(pos)==true)
    		{
    			tablero.InsertarFicha(pos, jugador2.getFichaJugador()) ; 
        		boolean resultado=tablero.VerificarResultado(jugador2.getFichaJugador().getFicha());
        		if(resultado == true)
        		{
        			ganador=2;
        		}
        		else
        		{
        			contador=contador+1;
        			turno=1;
        		}
        		if(contador==9 && ganador==0)
                {                                   
        			ganador=3;
                }
    		}
    		else
    		{
    			estado=false;
    		}
		}    	
    	return estado;
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
    public void imrprimirTablero()
    {		    
    	int cont=0;
		Ficha[][] tabla = tablero.getTablero();
		for(int fila=0; fila<3;fila++)
		{		   		
			for(int columna=0;columna<3;columna++)		   		
			{		   					   			
				if(cont==2)
		   		{
					System.out.println("_"+tabla[fila][columna].getFicha()+"_|");
		   			cont=0;		   			
		   		}
				else
				{		   				
					System.out.print("_"+tabla[fila][columna].getFicha()+"_|");
			   		cont++;	
		   		}		   	   
			}		   	
		}
	}
    /**
	  * Crea un nuevo jugador.  
	  * @param nombre nombre del jugador
	  * @param ficha ficha  del jugador
	  * */
    public boolean CrearJugador(String nombre,char ficha,String fig,int nrojugador)
    {                                                                                         
    	boolean estado=false;
    	if(nrojugador==1)
        {                                        		                         			
    		jugador1=new Jugador(nombre,new Ficha(ficha,fig));
    		estado=true;
        }
    	if(nrojugador==2)
    	{
    		if(ficha!=jugador1.getFichaJugador().getFicha())
    		{
    			jugador2=new Jugador(nombre,new Ficha(ficha,fig));
        		estado=true;
    		}    		
    	}    		    	    
    	return estado;
    }
    /**
	  * Realiza una jugada Automatica por la PC
	  *  @param ventanaJuego es la ventana en donde ingresara la ficha
	  * */
	 public int realizarJugadaPc() 
	 {
		 int posicion=-1;
		 boolean bandera=false;
		 		 		 
		 while(bandera==false && contador < 10)
		 {
			 int pos= pc.NumeroAleatoreo();
		     if(tablero.VerificarCasilla(pos)==true)
			 {
				 tablero.InsertarFicha(pos, pc.getFicha());
				 bandera=true;
				 posicion=pos;
				 //turno=1;
				 if(tablero.VerificarResultado(pc.getFicha().getFicha())== true)     			
				 {
	     			ganador=4;     			
				 }     			
				 else     			
				 {
	     			contador=contador+1;
	     			turno=1;     			
				 }     			
				 if(contador==9 && ganador==0)
	             {                                   
	     			ganador=3;
	             }
			 }			 			
		 }		 
		 return posicion;
		 // System.out.println("#### pc seleciono casilla "+pos);			 
	 }    
	 public int getTurno()
	 {
		 return turno;
	 }
	 public String getFigura(int turnojug )
	 {
		 if(turnojug==1)
		 {
			return jugador1.getFichaJugador().getFigura();
		 }
		 else
		 {
			 return jugador2.getFichaJugador().getFigura();
		 }		 
	 }
	 public String getFiguraPc()
	 {
		 return pc.getFicha().getFigura();
	 }	 
	 public Tablero getTablero()
	 {		 
		 return tablero;
	 }
}
