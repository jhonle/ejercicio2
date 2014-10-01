package Modelo;

import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;

public class Sonido extends Thread{

	private File sf;
	private AudioFileFormat aff;
	private AudioInputStream ais;
	private DataLine.Info info;
	public Clip ol;
	
	public Sonido(String sonido){
		try{
			File sf = new File(sonido);
			AudioFileFormat aff=AudioSystem.getAudioFileFormat(sf);
			ais=AudioSystem.getAudioInputStream(sf);

			AudioFormat af=aff.getFormat();
		
			DataLine.Info info=new DataLine.Info(Clip.class,ais.getFormat(),
((int)ais.getFrameLength()*af.getFrameSize()));

			ol=(Clip)AudioSystem.getLine(info);
				
		}
		catch(UnsupportedAudioFileException ee){
			JOptionPane.showMessageDialog(null,"No soporta Audio");
		}
		catch(IOException ea){
			JOptionPane.showMessageDialog(null,"No soporta Archivo");
		}
		catch(LineUnavailableException LUE){
			JOptionPane.showMessageDialog(null,"No soporta Linea de audio");
		}
	}

	public synchronized void run(){
		try{
			ol.open(ais);
			
			ol.loop(1); 
		}
		catch(Exception e){
		}
	}





	/*
	 	public static void main(String[] args){
	 		Sonido s = new Sonido("sonidos/simpsonTema.wav");
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
					s = new Sonido("sonidos/burro.wav");
					s.start();
					temp1=0;
				}else {
				temp1=1;
				System.out.println("SoundOFF");
				}
			}
	 	}	
	}
*/
}





