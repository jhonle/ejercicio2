package Modelo;

import javax.swing.JFrame;

import Vista.VentanaDeJuego;

public class PartidaVsJugador2 extends Partida
{
   
    
    private Jugador jugador2;
    
         
    /*Constructor de la clase Juego*/
    public PartidaVsJugador2()
    {    super();    
        
    }
    /**metodo que reinicia las variables del juego*/
    public void JugarOtraVez()
    {
    	tablero.LlenarTablero();
    	contador=0;
    	ganador=0;
    	turno=1;
    }
    /**metodo que dada una posicion, verifica la casilla, inserta la ficha 
     *de acuerdo al turno del jugador y verifica el resultado(gana-empate)*/
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
        			tablero.InsertarFicha(posicion, jugador2.getFichaJugador()) ; 
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
        }
    	return estado;
    }
    /**metodo que crea un jugador*/
    public boolean CrearJugador(String nombre,char ficha,int nrojugador)
    {                                                                                         
    	boolean estado=false;
    	if(nrojugador==1)
        {                                        		                         			
    		jugador1=new Jugador(nombre,new Ficha(ficha));
    		estado=true;
        }
    	if(nrojugador==2)
    	{
    		if(ficha!=jugador1.getFichaJugador().getFicha())
    		{
    			jugador2=new Jugador(nombre,new Ficha(ficha));
        		estado=true;
    		}    		
    	}
    	return estado;
    } 
    /**retorna quien es ganador*/
    public int getGanador()
    {
    	return ganador;
    }
    
    public void controlaEvento(Object boton, JFrame ventanaJuego){
    	
    	
    }
	
  
	

	

}



