package Pruebas;

import Modelo.Sonido;

public class Pruebas_Sonido {

	public static void main(String[] args) {

 		Sonido s = new Sonido("src/Sonidos/simpsonTema.wav");
		s.start();
		int temp1=0;
		Sonido sa;
		while(true){
		if(s.ol.isRunning()){
			if(temp1<=1){
				temp1=3;
			}
			System.out.println("SoundON");
		} else { 
			if(temp1==3){
				System.out.println("SoundEND");	
				s.ol.close();
				s.interrupt();
				s = new Sonido("src/Sonidos/burro.wav");
				s.start();
				temp1=0;
			}else {
			temp1=1;
			System.out.println("SoundOFF");
			}
		}
 	}	

	}

}
