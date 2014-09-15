package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.VentanaDeIngreso;
import vista.VentanaDeJuego;
import vista.VentanaDeOpciones;
import Modelo.Partida;
import Modelo.PartidaVsJugador2;

public class Controlador implements ActionListener {

private	VentanaDeIngreso  ventanaIngreso;
private VentanaDeOpciones ventanaOpciones;
private	VentanaDeJuego    ventanaJuego;
private Partida           partida;
private String            tituloVentana = "";
private int turno=1; //es para controlar que turno preciono el boton

private int tipoDeVentanaActual; // ventana que se muestra: 1 VentanaDeIngreso; 2 VentanaDeOpciones; 3 VentanaDeJuego
	public Controlador() {
		ventanaIngreso = new VentanaDeIngreso();
	    iniciarVista();
	   
	}
	
	public void iniciarVista() {
	      ventanaIngreso.setLocationRelativeTo(null);
	      this.ventanaIngreso.btnIniciarPartida.addActionListener(this);
	      ventanaIngreso.setVisible(true);
	      tipoDeVentanaActual =1;
	        
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object boton = e.getSource();

       
        if( tipoDeVentanaActual==1 )
        {
        	controlarV1(boton);
        	
        }
        else
        {
        	if (tipoDeVentanaActual==2)
        	{
        		controlarV2(boton);
        	}
        	else
        	{
        		controlarV3(boton);
        	}
        	  
          }
  } 
       
		

	private void controlarV1(Object boton) 
	{
		if (boton == this.ventanaIngreso.btnIniciarPartida)
		{   
			tipoDeVentanaActual=2;
			ventanaIngreso.setVisible(false);
		    ventanaOpciones = new VentanaDeOpciones();
		    ventanaOpciones.setVisible(true);
		    this.ventanaOpciones.btnAceptar.addActionListener(this);
		    
		}  
		
		
	}
	
	private void controlarV2(Object boton) 
	{
		if (boton == this.ventanaOpciones.btnAceptar)
		{   
			if(ventanaOpciones.venverificarllenado())
			{
		         
		  	     
		  	    if(ventanaOpciones.getTipoDePartida()==2){
		  	    	 tipoDeVentanaActual=3;
				     ventanaOpciones.setVisible(false);
			         ventanaJuego = new VentanaDeJuego();
			         ventanaJuego.setVisible(true);
			         iniciarPartidaVsJugador2();
			           
		  	    }else{
		  	    	JOptionPane.showMessageDialog(null,"Falta Implemntar" );
		  	    }
		  	 }   
		}     
		
	
    }
	
	

	private void controlarV3(Object boton) 
	{
	 
		if( boton == this.ventanaJuego.menu_volverAtras)
         {
      	    int ax = JOptionPane.showConfirmDialog(null, "Se perderan todos los datos de la partida actual");
            if(ax == JOptionPane.YES_OPTION)
            {
            	   ventanaIngreso.setVisible(true);
                   ventanaJuego.dispose();
                   ventanaOpciones.dispose();
                   tipoDeVentanaActual=1;
                   turno=1;
                
            }
         }
		else
        {  if( boton == this.ventanaJuego.menu_Reiniciar)
         {
      	    int ax = JOptionPane.showConfirmDialog(null, "Se perderan todos los datos de la partida actual");
            if(ax == JOptionPane.YES_OPTION)
            {      
            	   turno=1;
            	   ventanaJuego.dispose();
            	   ventanaJuego = new VentanaDeJuego();
		           ventanaJuego.setVisible(true);
		           iniciarPartidaVsJugador2();
                   
                
            }
         }else{
        	if( partida.getGanador()==0)
        	{
        	   
        		if(boton == ventanaJuego.b1)
        	    {
        		    boolean estado= partida.RealizarJugada(1);
        		    if(estado==true){
        		      ventanaJuego.b1.setLabel(ventanaOpciones.getFichaJugador(turno));
        		     
        		      cambiarturno();
        		    }else
        	   	    {
        	   		  JOptionPane.showMessageDialog(null,"no puedes selecionar esta casilla!" );
        	     	}
        		
                 }
        	    if(boton == ventanaJuego.b2)
        	    {
        		    boolean estado= partida.RealizarJugada(2);
        		    if(estado==true){
        		      ventanaJuego.b2.setLabel(ventanaOpciones.getFichaJugador(turno));
        		      
        		      cambiarturno();
        		    }else
        	   	    {
        	   		  JOptionPane.showMessageDialog(null,"no puedes selecionar esta casilla!" );
        	     	}
        		
                 }
        	    if(boton == ventanaJuego.b3)
        	    {
        		    boolean estado= partida.RealizarJugada(3);
        		    if(estado==true){
        		      ventanaJuego.b3.setLabel(ventanaOpciones.getFichaJugador(turno));
        		      
        		      cambiarturno();
        		    }else
        	   	    {
        	   		  JOptionPane.showMessageDialog(null,"no puedes selecionar esta casilla!" );
        	     	}
        		
                 }
        	    if(boton == ventanaJuego.b4)
        	    {
        		    boolean estado= partida.RealizarJugada(4);
        		    if(estado==true){
        		      ventanaJuego.b4.setLabel(ventanaOpciones.getFichaJugador(turno));
        		    
        		      cambiarturno();
        		    }else
        	   	    {
        	   		  JOptionPane.showMessageDialog(null,"no puedes selecionar esta casilla!" );
        	     	}
        		
                 }
        	    if(boton == ventanaJuego.b5)
        	    {
        		    boolean estado= partida.RealizarJugada(5);
        		    if(estado==true){
        		      ventanaJuego.b5.setLabel(ventanaOpciones.getFichaJugador(turno));
        		      
        		      cambiarturno();
        		    }else
        	   	    {
        	   		  JOptionPane.showMessageDialog(null,"no puedes selecionar esta casilla!" );
        	     	}
        		
                 }
        	    if(boton == ventanaJuego.b6)
        	    {
        		    boolean estado= partida.RealizarJugada(6);
        		    if(estado==true){
        		      ventanaJuego.b6.setLabel(ventanaOpciones.getFichaJugador(turno));
        		     
        		      cambiarturno();
        		    }else
        	   	    {
        	   		  JOptionPane.showMessageDialog(null,"no puedes selecionar esta casilla!" );
        	     	}
        		
                 }
        	    if(boton == ventanaJuego.b7)
        	    {
        		    boolean estado= partida.RealizarJugada(7);
        		    if(estado==true){
        		      ventanaJuego.b7.setLabel(ventanaOpciones.getFichaJugador(turno));
        		      
        		      cambiarturno();
        		    }else
        	   	    {
        	   		  JOptionPane.showMessageDialog(null,"no puedes selecionar esta casilla!" );
        	     	}
        		
                 }
        	    if(boton == ventanaJuego.b8)
        	    {
        		    boolean estado= partida.RealizarJugada(8);
        		    if(estado==true){
        		      ventanaJuego.b8.setLabel(ventanaOpciones.getFichaJugador(turno));
        		     
        		      cambiarturno();
        		    }else
        	   	    {
        	   		  JOptionPane.showMessageDialog(null,"no puedes selecionar esta casilla!" );
        	     	}
        		
                 }
        	    if(boton == ventanaJuego.b9)
        	    {
        		    boolean estado= partida.RealizarJugada(9);
        		    if(estado==true){
        		      ventanaJuego.b9.setLabel(ventanaOpciones.getFichaJugador(turno));
        		     
        		      cambiarturno();
        		    }else
        	   	    {
        	   		  JOptionPane.showMessageDialog(null,"no puedes selecionar esta casilla!" );
        	     	}
        		
        		    
        	    }
        	    
        	    if( partida.getGanador()!=0)
            	{
        	    	if(partida.getGanador()==1){
        	    		ventanaJuego.lblMsg.setText("GANADOR : "+ventanaOpciones.getNombreJugador1());
        	    		JOptionPane.showMessageDialog(null,"Gano el Jugador"+ventanaOpciones.getNombreJugador1() );
        	    		
        	    	}else{
        	    		if(partida.getGanador()==2){
        	    			ventanaJuego.lblMsg.setText("GANADOR : "+ventanaOpciones.getNombreJugador2());
        	    			JOptionPane.showMessageDialog(null,"Gano el Jugador"+ventanaOpciones.getNombreJugador2() );
            	    	}else{
            	    		ventanaJuego.lblMsg.setText("EMPATE ");
            	    		JOptionPane.showMessageDialog(null,"SE EMPATO EL JUEGO");
            	    	}
        	    	}
        	    	
        	     }
        	   
        	    
        	    partida.imrprimirTablero();
        	    System.out.println("es el turno de "+turno); 
	        }

       }
        }
	}

	private void cambiarturno() {
		if (turno ==1)
		{
			turno=2;
		}else
	    {
			turno =1;
	    }
		ventanaJuego.lblMsg.setText(" TURNO: "+ventanaOpciones.getNombreJugador(turno));
	    
	}

			

	private void iniciarPartidaVsJugador2() {
		 this.ventanaJuego.b1.addActionListener(this);
 	     this.ventanaJuego.b2.addActionListener(this);
 	     this.ventanaJuego.b3.addActionListener(this);
 	     this.ventanaJuego.b4.addActionListener(this);
 	     this.ventanaJuego.b5.addActionListener(this);
 	     this.ventanaJuego.b6.addActionListener(this);
 	     this.ventanaJuego.b7.addActionListener(this);
 	     this.ventanaJuego.b8.addActionListener(this);
 	     this.ventanaJuego.b9.addActionListener(this);
 	     
 	     this.ventanaJuego.menu_volverAtras.addActionListener(this);
 	     this.ventanaJuego.menu_Reiniciar.addActionListener(this);	
	          
 	     partida = new PartidaVsJugador2();
	     String aux1 =ventanaOpciones.getFichaJugador1();
	     char cad1= aux1.charAt(0);//convierte a  tipo char 
	     String aux2 =ventanaOpciones.getFichaJugador2();
	     char cad2= aux2.charAt(0); //convierte a tipo char
	     ((PartidaVsJugador2) partida).CrearJugador(ventanaOpciones.getNombreJugador1(),cad1,1);
	     ((PartidaVsJugador2) partida).CrearJugador(ventanaOpciones.getNombreJugador2(),cad2,2);
	     ventanaJuego.lblMsg.setText("TURNO :"+ventanaOpciones.getNombreJugador(turno));
	     System.out.println("inicio partida");
	     System.out.println("jugador 1: nombre : "+ventanaOpciones.getNombreJugador1()+" ficha : "+cad1 );
	     System.out.println("jugador 2: nombre : "+ventanaOpciones.getNombreJugador2()+" ficha : "+cad2 );
		
	}
}
	 
