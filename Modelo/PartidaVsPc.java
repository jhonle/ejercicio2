package Modelo;

import java.awt.font.NumericShaper;
import java.util.Scanner;

import Vista.VentanaDeJuego;
import Vista.VentanaDeOpciones;

public class PartidaVsPc extends Partida
{
	private Computadora comp;	 
	
	/**
	 * */
	public PartidaVsPc(char fichaComp)
    {    super();    
      
    comp=new Computadora(new Ficha(fichaComp));  
  
    }
	 
    /**
     * Realiza una jugada dada una posicion
     * @return true si se inserto ficha correctamente
     * */
	public boolean RealizarJugada(int posicion)
	    { 
		  //System.out.println("###ficha comp = "+comp.getFicha().getFicha());
		  //System.out.println("###jugadorFicha = "+jugador1.getFichaJugador().getFicha());
		  boolean estado=true;
	    	if(ganador==0 && contador < 9)
	        {                                                          
	    		if(turno==1)
	    		{
	    			if(tablero.VerificarCasilla(posicion)==true)
	        		{
	        			tablero.InsertarFicha(posicion, comp.getFicha()) ; 
	            		boolean resultado=tablero.VerificarResultado(comp.getFicha().getFicha());
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
	    		else
	    		{
	    			if(tablero.VerificarCasilla(posicion)==true)
	        		{
	        			tablero.InsertarFicha(posicion, jugador1.getFichaJugador()) ; 
	            		boolean resultado=tablero.VerificarResultado(jugador1.getFichaJugador().getFicha());
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
	        }
	    	return estado;
	    }
	 /**
	  * Crea un nuevo jugador. 
	  * solo crea 1 jugador 
	  * @param nombre nombre del jugador
	  * @param ficha ficha  del jugador
	  * */
	 public boolean crearJugador(String nombre,char ficha)
	    {                                                                                         
		 //System.out.println("### se creo al jugador con la ficha  "+ ficha);
	                                            		                         			
	    		jugador1=new Jugador(nombre,new Ficha(ficha));
	    		return true;
	       
	    } 
   /*
    * @return 1=computador
    * @return 2=jugador
    * @return 3=empate
    * */
	 public int getGanador()
	    {
	    	return ganador;
	    }
	 
	 /**
	  * Realiza una jugada Automatica por la PC
	  *  @param ventanaJuego es la ventana en donde ingresara la ficha
	  * */
	 public void realizarJugadaPc(VentanaDeJuego ventanaJuego) {

		int pos= comp.NumeroAleatoreo();
        while(!tablero.VerificarCasilla(pos)){
        	pos= comp.NumeroAleatoreo();
		}
        RealizarJugada(pos);
	    if( ventanaJuego!=null){ventanaJuego.marcarBoton(pos,comp.getFicha());}
		
	   // System.out.println("#### pc seleciono casilla "+pos);
		
	 }

}