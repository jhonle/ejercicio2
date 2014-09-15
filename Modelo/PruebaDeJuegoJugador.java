package Modelo;

import java.util.Scanner;

public class PruebaDeJuegoJugador {

	public static void main(String[] args) {
		PartidaVsJugador2 modelo = new PartidaVsJugador2();
		modelo.CrearJugador("Marcelo", 'X', 1);
		modelo.CrearJugador("Juan", 'O', 2);
		modelo.imrprimirTablero();
	   int	turno=1;
   	   
	while(modelo.getGanador()==0){ 
		System.out.println("Turno de Jugador:"+turno);
		Scanner escaner = new Scanner(System.in);
	    int	posicion = Integer.parseInt(escaner.next());
	    modelo.RealizarJugada(posicion);
	    if(turno==1)turno=2;
	    else turno=1;
	    modelo.imrprimirTablero();	
	}
	if (modelo.getGanador()!=3){
	System.out.println("Gano Jugador"+modelo.getGanador());
	}else{
		System.out.println("EMPATE");
	}
	}

}
