package Modelo;

import java.awt.font.NumericShaper;
import java.util.Scanner;

import vista.VentanaDeJuego;
import vista.VentanaDeOpciones;

public class PartidaVsPc extends Partida
{
	private Computadora comp;	 char fichaComp;
	
	public PartidaVsPc(char fichaComp)
    {    super();    
      
    comp=new Computadora(new Ficha(fichaComp));  
  
    }
	 public boolean RealizarJugada(int posicion)
	    { 
		 boolean estado=true;
	    	if(ganador==0 && contador < 9)
	        {                                                          
	    		if(turno==1)
	    		{
	    			if(tablero.VerificarCasilla(posicion)==true)
	        		{
	        			tablero.InsertarFicha(posicion, jugador1.getFichaJugador()) ; 
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
	    		else
	    		{
	    			if(tablero.VerificarCasilla(posicion)==true)
	        		{
	        			tablero.InsertarFicha(posicion, comp.getFicha()) ; 
	            		boolean resultado=tablero.VerificarResultado(comp.getFicha().getFicha());
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
	 
	 public boolean CrearJugador(String nombre,char ficha)
	    {                                                                                         
	    	boolean estado=false;
	    	
	                                            		                         			
	    		jugador1=new Jugador(nombre,new Ficha(ficha));
	    		estado=true;
	       
	    	return estado;
	    } 
   
	 public int getGanador()
	    {
	    	return ganador;
	    }
	 
	 public void realizarJugadaPc(VentanaDeJuego ventanaJuego) {
		int pos= comp.NumeroAleatoreo();
		RealizarJugada(pos);
		ventanaJuego.marcarBoton(pos,comp.getFicha());
			
		}

}