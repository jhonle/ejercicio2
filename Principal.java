package TresEnralla;

import java.util.Scanner;

public class Principal 
{
  private static Ficha fcomp = new Ficha('o');
  private static Ficha fuser = new Ficha('x');
  private static Computadora c = new Computadora(fcomp);
  private static Tablero tablero = new Tablero();
	public static void main(String[] args) 
	{
	    tablero.LlenarTabla();
	    int contador =0;
	    boolean victoria = false;
	    int posicion = 0;
	    boolean casilla = false;
	    
	     while(contador < 9 || victoria == false)
	     {	    		
	    	 contador = contador + 1;
	    	 while(casilla == false)
		    	{
		    		posicion = c.NumeroAleatoreo();
		    		casilla = tablero.VerificarCasilla(posicion);
		    	}
		    	
		    	tablero.InsertarFicha(posicion, fcomp);
		    	
		    	System.out.println("computadora  : " + posicion);
		    	victoria = tablero.VerificarTresEnRalla(fcomp);
		    	
		    	if(victoria == true)
		        {
		    		System.out.println("gano computadora") ;
		        	break;
		        }
		    	casilla = false;
		    	System.out.println("turno del usuario");
		    	
		    	Scanner escaner = new Scanner(System.in);
		    	
		    	while(casilla == false)
		    	{	    
			        posicion = Integer.parseInt(escaner.next());
			        casilla = tablero.VerificarCasilla(posicion);
		    	}
		    	
		        tablero.InsertarFicha(posicion,fuser);
		        System.out.println("usuario : " + posicion);
		        victoria = tablero.VerificarTresEnRalla(fuser);
		        casilla = false;
		        
		        if(victoria == true)
		        {
		    		System.out.println("gano usuario") ;
		        	break;
		        }		    	
	     }
	    if(victoria == false)
	    {
    		System.out.println("empate") ;
	    }	       
	}
}